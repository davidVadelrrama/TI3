package ui;
import model.Controladora;

import java.util.Scanner;

public class Main{
	
	private static Scanner sc;
	public static Controladora controladora;

	public Main(){

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

	public static void switchMenu1(int option){

		switch (option){
			case 1:
				controladora.list();
				break;
			case 2:
				break;
			case 3:
				System.out.println("1. To terminate one miniroom service" +
						"\n2. To terminate all miniroom services asociated to one org");
				int option2 = sc.nextInt();
				switchMenu2(option2);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;

		}
	}

	public static void switchMenu2(int option2){

		switch (option2){

		}
	}

	public static void addMiniroom(){

	}

}