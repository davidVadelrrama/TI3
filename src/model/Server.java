package model;

public class Server {


    private int cacheMemory;
    private int processorNum;
    private int cantRAM;
    private int cantHardDrive;
    private int hardDriveCapacity;
    private String processor;

    //constructor
    public Server(int cacheMemory, int processorNum, String processor, int cantRAM, int hardDriveCapacity, int cantHardDrive) {
        this.cacheMemory = cacheMemory;
        this.processorNum = processorNum;
        this.cantHardDrive = cantHardDrive;
        this.cantRAM = cantRAM;
        this.hardDriveCapacity = hardDriveCapacity;
        this.processor = processor;
    }

    //getters y setters
    public int getCacheMemory() {
        return cacheMemory;
    }

    public void setCacheMemory(int cacheMemory) {
        this.cacheMemory = cacheMemory;
    }

    public int getProcessorNum() {
        return processorNum;
    }

    public void setProcessorNum(int processorNum) {
        this.processorNum = processorNum;
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

    public int getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(int hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}
