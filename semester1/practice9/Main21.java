package practice9;


public class Main21 {
    public static void main(String[] args) {
        DataCenterCluster cluster = new DataCenterCluster("Київ", 3);
        cluster.addNode(new ServerNode("10.0.0.1", 16, true));
        cluster.addNode(new ServerNode("10.0.0.2", 32, true));
        cluster.addNode(new ServerNode("10.0.0.3", 64, false));
        System.out.println("Деплой 12 ГБ: " + cluster.deployContainer(12));
        System.out.println("Деплой 10 ГБ: " + cluster.deployContainer(10));
        System.out.println("Деплой 30 ГБ: " + cluster.deployContainer(30));
        System.out.println("Деплой 4 ГБ: " + cluster.deployContainer(4));
        System.out.println();
        System.out.println(cluster);
    }
}

