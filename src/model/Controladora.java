package model;


public class Controladora {

    public static Miniroom[][] rooms = new Miniroom[8][50];





    public void list(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == null){
                    System.out.println("Minirooms available: " + (i+1) + "," + (j+1));
                }
            }
        }
    }

    public String addMiniroom(int x, int y, int idNum, String nit, String name, String[][] serverInfo){
        String out = "";
        Organization newOrg = new Organization(nit, name);
        Miniroom miniroom = new Miniroom(idNum, newOrg);
        for (int i = 0; i < serverInfo[0].length; i++) {
            Server server = new Server(Integer.parseInt(serverInfo[0][i]),Integer.parseInt(serverInfo[1][i]),serverInfo[2][i],
                    Integer.parseInt(serverInfo[3][i]), Integer.parseInt(serverInfo[4][i]),Integer.parseInt(serverInfo[5][i]));
            Miniroom.addServer(server);
        }
        rooms[x-1][y-1] = miniroom;

        out = "Miniroom succesfully rented";

        return out;
    }

    public String terminateOneMiniroom(int x, int y){
        String out = "";
        rooms[x-1][y-1] = null;
        out = "miniroom service succsefully terminated";

        return out;
    }

    public String terminateAllMinirooms(String name){
        String out = "";
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] != null){
                    if (name.equals(rooms[i][j].getOrganization().getName())){
                        rooms[i][j] = null;
                        out = "miniroom services succesfully terminated";
                    }
                }
            }
        }
        return out;
    }

    public void mostrarMapa(){

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] != null){
                    System.out.print("[on]");
                }else{
                    System.out.print("[off]");
                }
            }
            System.out.println("");
        }

    }
    public void simulacionEncendidoApagado(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == null){
                    System.out.print("[on]");
                }else{
                    System.out.print("[on]");
                }

            }
            System.out.println("");
        }

    }
}
