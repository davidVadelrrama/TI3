package model;

public class Server {

    public OnOff status;
    private String cacheMemory;
    private int processorNum;
    private int cantRAM;
    private int cantHardDrive;
    private String hardDriveCapacity;
    private Processor processorType;

    //constructor
    public Server(String cacheMemory, int processorNum, int cantHardDrive, int cantRAM, String hardDriveCapacity) {
        this.cacheMemory = cacheMemory;
        this.processorNum = processorNum;
        this.cantHardDrive = cantHardDrive;
        this.cantRAM = cantRAM;
        this.hardDriveCapacity = hardDriveCapacity;
    }

    //getters y setters
    public String getCacheMemory() {
        return cacheMemory;
    }

    public void setCacheMemory(String cacheMemory) {
        this.cacheMemory = cacheMemory;
    }

    public int getProcessorNum() {
        return processorNum;
    }

    public void setProcessorNum(int processorNum) {
        this.processorNum = processorNum;
    }

    public OnOff getStatus() {
        return status;
    }

    public void setStatus(OnOff status) {
        this.status = status;
    }

    public int getCantRAM() {
        return cantRAM;
    }

    public void setCantRAM(int cantRAM) {
        this.cantRAM = cantRAM;
    }

    public int getCantHardDrive() {
        return cantHardDrive;
    }

    public void setCantHardDrive(int cantHardDrive) {
        this.cantHardDrive = cantHardDrive;
    }

    public String getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(String hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }
}
