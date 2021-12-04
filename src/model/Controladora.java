package model;


public class Controladora {

    public int valor = 5000;
    public static Miniroom[][] rooms = new Miniroom[8][50];




    /*
     *
     * el metodo imprime la lista de los minicuartos disponibles y calcula de cada una el valor mensual
     *
     */
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
                    System.out.println("Minirooms available: " + (i+1) + "," + (j+1) + " the monthly payment of the room " +
                            "is: $" + pagoMensual);
                }
            }
        }
    }
    /*
     *
     * el metodo crea el miniroom con los servidores y la organizacion, además de que calcula el valor del pago mensual.
     * @param integer x, ubicacion vertical en la matriz
     * @param integer y, ubicacion horizontal en la matriz
     * @param integer idNum, es el numero de identificacion del minicuarto
     * @param String nit, nit de la empresa o numero de registro del proyecto
     * @param String name, nombre de la empresa que alquila el minicuarto
     * @param String[][] serverInfo, guarda la informacion de los servidores
     * @param integer serverNum, numero de servidores que se van a poner en el rack
     * @return String out, retorna la confirmación de la creacion del servicio más el alquiler mensual
     *
     */
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
    /*
     *
     * el metodo crea el miniroom con los servidores y la organizacion, además de que calcula el valor del pago mensual.
     * @param integer x, ubicacion vertical en la matriz
     * @param integer y, ubicacion horizontal en la matriz
     * @return String out, retorna la confirmacion de la eliminacion del servicio más la cantidad total de capacidad de
     * los servidores del rack
     *
     */
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
    /*
     *
     * el metodo crea el miniroom con los servidores y la organizacion, además de que calcula el valor del pago mensual.
     * @param String name, nombre de la empresa
     * @return String out, retorna la confirmacion de la eliminacion del servicio más la cantidad total de capacidad de
     * los servidores del rack
     *
     */
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
    /*
    *
    * el metodo muestra un mapa de la sala con los minicuartos que estan alquilados y los que no
    *
     */
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

    /*
     *
     * el metodo simula el encendido de todos los minicuartos
     *
     */
    public void simulacionEncendido(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print("[on]");
            }
            System.out.println("");
        }
    }
    /*
     *
     * el metodo simula el apagado de todos los minicuartos de la primera fila y primera columna
     *
     */
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
    /*
     *
     * el metodo simula el apagado de los minicuartos del primer y último corredor, junto con los minicuartos de la diagonal inversa
     *
     */
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
    /*
     *
     * el metodo simula el apagado de los minicuartos ubicados en los corredores impares
     *
     */
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
    /*
     *
     * el metodo simula el apagado los minicuartos ubicados en las ventanas
     *
     */
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
    /*
     *
     * el metodo pregunta al usuario una columna N y  apaga todos los minicuartos en la columna N
     *
     */
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
    /*
     *
     * el metodo pregunta al usuario un corredor N y  apaga todos los minicuartos en el corredor N
     *
     */
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
