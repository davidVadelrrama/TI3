package model;

public class Miniroom {

    private int idNum;
    private Organization organization;
    public static Server[] servers;
    private int serverNum;
    private double monthlyPayment;




    public Miniroom(int idNum, Organization organization, int serverNum, double monthlyPayment) {
        this.idNum = idNum;
        this.organization = organization;
        this.serverNum = serverNum;
        this.monthlyPayment = monthlyPayment;
        servers = new Server[10];
    }

    //getters y setters
    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public Server[] getServers() {
        return servers;
    }

    public void setServers(Server[] servers) {
        this.servers = servers;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getServerNum() {
        return serverNum;
    }

    public void setServerNum(int serverNum) {
        this.serverNum = serverNum;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public static void addServer(Server server){
        for (int i = 0; i < servers.length; i++) {
            if(servers[i] == null){
                servers[i] = server;
            }
        }
    }
}
