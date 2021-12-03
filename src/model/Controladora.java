package model;


public class Controladora {

    public static Miniroom[][] rooms = new Miniroom[8][50];
    public Miniroom miniroom;

    public void list(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == null){
                    System.out.println("Minirooms available: " + i + "," + j);
                }
            }
        }
    }

    public String addMiniroom(int idNum, String nit, String name, String type){
        String out = "";
        Organization newOrg = new Organization(nit, name, type);
        miniroom = new Miniroom(idNum, newOrg);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {

            }
        }
        out = "Miniroom succesfully created";

        return out;
    }

}
