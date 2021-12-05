package ui;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import model.*;


import java.util.Scanner;

public class Main{
	
	private static Scanner sc;
	public static Controladora controladora;


	public Main(){
		controladora = new Controladora();
		sc = new Scanner(System.in);

	}

	public static void main(String[]args){
		new Main();
		int option = 7;
		do {
			option = menu1();
			switchMenu1(option);
		}while(option != 0);
	}

	/*
	*
	* el metodo solo muestra un menu
	* @return out, retrona el menu.
	*
	 */
	public static int menu1(){

		System.out.println("0. to exit" +
				"\n1. List of available minirooms" +
				"\n2. To rent a miniroom" +
				"\n3. To terminate rent of miniroom" +
				"\n4. Datacenter map" +
				"\n5. Simulate switched on minirooms" +
				"\n6. Simulate sitched off minirooms by letters");
		int out = sc.nextInt();
		return out;
	}
	/*
	 *
	 * el metodo al pasarle un entero selecciona la opcion que quiere hacer el usuario.
	 * @param option, es la opcion del usuario
	 *
	 */
	public static void switchMenu1(int option){

		switch (option){
			case 1:
				controladora.list();
				break;
			case 2:
				addMiniroom();
				break;
			case 3:
				System.out.println("1. To terminate one miniroom service" +
						"\n2. To terminate all miniroom services asociated to one organization");
				int option2 = sc.nextInt();
				switchMenu2(option2);
				break;
			case 4:
				controladora.mostrarMapa();
				break;
			case 5:
				controladora.simulacionEncendido();
				break;
			case 6:
				menu3();
				break;


		}
	}
	/*
	 *
	 * el metodo al pasarle un entero selecciona la opcion que quiere hacer el usuario.
	 * @param option2, es la opcion del usuario
	 *
	 */
	public static void switchMenu2(int option2){

		switch (option2){

			case 1:
				System.out.println("Corridor where the miniroom is");
				int x = sc.nextInt();
				System.out.println("row where the miniroom is");
				int y = sc.nextInt();
				System.out.println(controladora.terminateOneMiniroom(x,y));
				break;
			case 2:
				System.out.println("Enter name of your Organization(example: fundacion valle del lili(only lower case))");
				sc.nextLine();
				String name = sc.nextLine();
				if(!name.equals("universidad icesi")){
					System.out.println(controladora.terminateAllMinirooms(name));
				}else{
					System.out.println("You cant terminate all UIcesi minirooms at once");
				}

				break;
		}
	}
	/*
	 *
	 * el metodo solo muestra un menu
	 *
	 */
	public static void menu3(){
		System.out.println("Enter the letter of the simulation that you want to try" +
				"\nSimulate turn off by letter L" +
				"\nSimulate turn off by letter Z" +
				"\nSimulate turn off by letter H" +
				"\nSimulate turn off by letter O" +
				"\nSimulate turn off by letter M" +
				"\nSimulate turn off by letter P");
		sc.nextLine();
		String option = sc.nextLine();
		int option2 = 0;
		if (option.equalsIgnoreCase("l")){
			option2 = 1;
		}
		if (option.equalsIgnoreCase("z")){
			option2 = 2;
		}
		if (option.equalsIgnoreCase("h")){
			option2 = 3;
		}
		if (option.equalsIgnoreCase("o")){
			option2 = 4;
		}
		if (option.equalsIgnoreCase("m")){
			option2 = 5;
		}
		if (option.equalsIgnoreCase("p")){
			option2 = 6;
		}
		switchMenu3(option2);
	}

	/*
	 *
	 * el metodo al pasarle un entero selecciona la opcion que quiere hacer el usuario.
	 * @param option2, es la opcion del usuario
	 *
	 */
	public static void switchMenu3(int option){
		switch (option){
			case 1:
				controladora.simularApagadoLetraL();
				break;
			case 2:
				controladora.simularApagadoLetraZ();
				break;
			case 3:
				controladora.simularApagadoLetraH();
				break;
			case 4:
				controladora.simularApagadoLetraO();
				break;
			case 5:
				System.out.println("What column do you want to shut down");
				int y = sc.nextInt();
				controladora.simularApagadoLetraM(y);
				break;
			case 6:
				System.out.println("What corridor do you want to shut down");
				int x = sc.nextInt();
				controladora.simularApagadoLetraP(x);
				break;
		}
	}
	/*
	 *
	 * el metodo solo pide la informacion para crear un minicuarto
	 *
	 */
	public static void addMiniroom(){
		int cacheMem, processorNum, ramMem, cantHardDrive, hdMem;
		String processorBrand;
		String[][] serverInfo;
		System.out.println("Insert corridor of the room you want to rent");
		int x = sc.nextInt();
		System.out.println("Insert row of the room you want to rent");
		int y = sc.nextInt();
		System.out.println("Insert miniroom id");
		int idNum = sc.nextInt();
		sc.nextLine();
		System.out.println("nit of the organization");
		String nit = sc.nextLine();
		System.out.println("name of the organization tha wants to rent(example: fundacion valle del lili)");
		String orgName = sc.nextLine();
		System.out.println("¿How many servers do you want to put in the rack?");
		int serverNum = sc.nextInt();
		serverInfo = new String[6][serverNum];
		for (int i = 0; i < serverNum; i++) {
			System.out.println("cache memory in GB");
			cacheMem = sc.nextInt();
			System.out.println("number of processors");
			processorNum = sc.nextInt();
			sc.nextLine();
			System.out.println("brand of the processors (INTEL OR AMD)");
			processorBrand = sc.nextLine();
			System.out.println("ram memory in gb");
			ramMem = sc.nextInt();
			System.out.println("number of hard drives");
			cantHardDrive = sc.nextInt();
			System.out.println("hard drive memory in teras");
			hdMem = sc.nextInt();
			serverInfo[0][i] = cacheMem + "";
			serverInfo[1][i] = processorNum + "";
			serverInfo[2][i] = processorBrand + "";
			serverInfo[3][i] = ramMem + "";
			serverInfo[4][i] = cantHardDrive + "";
			serverInfo[5][i] = hdMem + "";
		}
		System.out.println(controladora.addMiniroom(x,y,idNum,nit,orgName,serverInfo,serverNum));
	}


}