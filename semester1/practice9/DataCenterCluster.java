package practice9;

public class DataCenterCluster {
    private final String clusterLocation;
    private final ServerNode[] nodes;
    private int nodeCount;
    public DataCenterCluster(String clusterLocation, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість має бути додатною");
        }
        this.clusterLocation = clusterLocation;
        this.nodes = new ServerNode[capacity];
        this.nodeCount = 0;
    }
    public String getClusterLocation() {
        return clusterLocation;
    }
    public int getNodeCount() {
        return nodeCount;
    }
    public boolean addNode(ServerNode node) {
        if (node == null || nodeCount >= nodes.length) {
            return false;
        }
        nodes[nodeCount++] = node;
        return true;
    }
    public boolean deployContainer(int requiredRamGb) {
        if (requiredRamGb <= 0) {
            return false;
        }
        for (int i = 0; i < nodeCount; i++) {
            ServerNode node = nodes[i];
            if (node.isOnline() && node.getFreeRamGb() >= requiredRamGb) {
                return node.allocateRam(requiredRamGb);
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Кластер: ").append(clusterLocation).append('\n');
        if (nodeCount == 0) {
            sb.append("(вузлів немає)");
            return sb.toString();
        }
        for (int i = 0; i < nodeCount; i++) {
            sb.append(nodes[i]);
            if (i < nodeCount - 1) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}

