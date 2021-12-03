package model;

public class Miniroom {

    private int idNum;
    private Organization organization;
    private static Server[] servers;




    public Miniroom(int idNum, Organization organization) {
        this.idNum = idNum;
        this.organization = organization;
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


    public static void addServer(Server server){
        for (int i = 0; i < servers.length; i++) {
            if(servers[i] == null){
                servers[i] = server;
            }
        }
    }
}
