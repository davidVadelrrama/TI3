package model;


public class Controladora {

    public int valor = 5000;
    public static Miniroom[][] rooms = new Miniroom[8][50];





    public void list(){
        double pagoMensual = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == null){
                    if (i  == 0 || j == 0 || i == rooms.length-1 || j == rooms[0].length-1){
                        pagoMensual = valor-(valor*0.1);
                    }else if (i-1==7){
                        pagoMensual = valor-(valor*0.15);
                    }else{
                        pagoMensual = valor+(valor*0.25);
                    }
                    System.out.println("Minirooms available: " + (i+1) + "," + (j+1) + " the monthly payment of the room is: $" + pagoMensual);
                }
            }
        }
    }

    public String addMiniroom(int x, int y, int idNum, String nit, String name, String[][] serverInfo, int serverNum){
        String out = "";
        double pagoMensual;
        if (x -1 == 0 || y-1 == 0 || x-1 == rooms.length || y-1 == rooms[0].length){
            pagoMensual = valor-(valor*0.1);
        }else if (x-1==7){
            pagoMensual = valor-(valor*0.15);
        }else{
            pagoMensual = valor+(valor*0.25);
        }
        if (serverNum<4){
            pagoMensual = pagoMensual+(valor*0.15);
        }
        Organization newOrg = new Organization(nit, name);
        Miniroom miniroom = new Miniroom(idNum, newOrg, serverNum, pagoMensual);
        for (int i = 0; i < serverInfo[0].length; i++) {
            Server server = new Server(Integer.parseInt(serverInfo[0][i]),Integer.parseInt(serverInfo[1][i]),serverInfo[2][i],
                    Integer.parseInt(serverInfo[3][i]), Integer.parseInt(serverInfo[4][i]),Integer.parseInt(serverInfo[5][i]));
            Miniroom.addServer(server);
        }
        rooms[x-1][y-1] = miniroom;


        out = "Miniroom succesfully rented and your montlhy payment is: " + pagoMensual;

        return out;
    }

    public String terminateOneMiniroom(int x, int y){
        String out = "";
        int out2 = 0, out3 = 0;

        for (int i = 0; i < rooms[x-1][y-1].servers.length; i++) {
            if (rooms[x-1][y-1].servers[i] != null){
                if (i < rooms[x-1][y-1].getServerNum()) {
                    out2 += rooms[x - 1][y - 1].servers[i].getCantHardDrive();
                    out3 += rooms[x - 1][y - 1].servers[i].getCantRAM();
                }
            }
        }
        if (rooms[x-1][y-1] != null){
            rooms[x-1][y-1] = null;
        }else{
            System.out.println("there is nothing to terminate");
        }

        out = "ram capacity was: " + out3 + "GB and hard drive capacity was: " + out2 + "Tb, service successfully terminated";

        return out;
    }

    public String terminateAllMinirooms(String name){
        String out = "";
        int out2 = 0, out3 = 0;

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] != null){
                    if (name.equals(rooms[i][j].getOrganization().getName())){
                        for (int k = 0; k < rooms[i][j].servers.length; k++) {
                            if (rooms[i][j].servers[k] != null){
                                if (k < rooms[i][j].getServerNum()){
                                    out2 += rooms[i][j].servers[k].getCantHardDrive();
                                    out3 += rooms[i][j].servers[k].getCantRAM();
                                }
                            }
                        }
                        rooms[i][j] = null;

                    }
                }
            }
        }
        out = "ram capacity was: " + out3 + "GB and hard drive capacity was: " + out2 + "Tb miniroom services succesfully terminated";
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
    public void simulacionEncendido(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print("[on]");
            }
            System.out.println("");
        }
    }

    public void simularApagadoLetraL(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (i == 0 || j == 0 ) {
                    System.out.print("[off]");
                }else {
                    System.out.print("[on]");
                }


            }
            System.out.println("");
        }

    }
    public void simularApagadoLetraZ(){
        int cont = 7, temp = 0, temp2 = 1;
        for (int i = rooms.length; i >= 0; i--) {
            for (int j = rooms[0].length; j >= 0; j--) {
                if (i == 0 || i == rooms.length) {
                    System.out.print("[off]");
                }else if (j == (cont)){
                    System.out.print("[off]");
                    cont--;
                    if (cont == temp){
                        temp = (temp + 7);
                        cont = temp+7;
                    }
                }else{
                    System.out.print("[on]");
                }


            }
            System.out.println("");
        }

    }

    public void simularApagadoLetraH(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (i%2 == 0){
                    System.out.print("[off]");
                }else{
                    System.out.print("[on]");
                }

            }
            System.out.println("");
        }
    }

    public void simularApagadoLetraO(){
        for (int i = 0; i <= rooms.length; i++) {
            for (int j = 0; j <= rooms[0].length; j++) {
                if (i == 0 || i == rooms.length || j == 0 ||  j == rooms[0].length) {
                    System.out.print("[off]");
                }else {
                    System.out.print("[on]");
                }


            }
            System.out.println("");
        }

    }

    public void simularApagadoLetraM(int y){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (j==(y-1)){
                    System.out.print("[off]");
                }else {
                    System.out.print("[on]");
                }
            }
            System.out.println("");

        }
    }

    public void simularApagadoLetraP(int x){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (i==(x-1)){
                    System.out.print("[off]");
                }else {
                    System.out.print("[on]");
                }
            }
            System.out.println("");
        }
    }

}
