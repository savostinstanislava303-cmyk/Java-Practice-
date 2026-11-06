package practice9;

public class ServerNode {
    private final String ipAddress;
    private final int totalRamGb;
    private int usedRamGb;
    private boolean online;
    public ServerNode(String ipAddress, int totalRamGb, boolean online) {
        if (ipAddress == null || ipAddress.isBlank()) {
            throw new IllegalArgumentException("IP-адреса не може бути порожньою");
        }
        if (totalRamGb <= 0) {
            throw new IllegalArgumentException("Обсяг пам'яті має бути додатним");
        }
        this.ipAddress = ipAddress;
        this.totalRamGb = totalRamGb;
        this.usedRamGb = 0;
        this.online = online;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public int getTotalRamGb() {
        return totalRamGb;
    }
    public int getUsedRamGb() {
        return usedRamGb;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public int getFreeRamGb() {
        return totalRamGb - usedRamGb;
    }
    public boolean allocateRam(int amountGb) {
        if (!online || amountGb <= 0 || amountGb > getFreeRamGb()) {
            return false;
        }
        usedRamGb += amountGb;
        return true;
    }
    @Override
    public String toString() {
        return ipAddress + (online ? " [ONLINE]  " : " [OFFLINE] ")
                + usedRamGb + "/" + totalRamGb + " ГБ (вільно " + getFreeRamGb() + ")";
    }
}

