package com.epicode.playerMultimediale;

import java.util.Scanner;

import com.epicode.playerMultimediale.interfacce.IcontrolliVolume;

public class Main {

	public static void main(String[] args) {

		elementoMultimediale[] fileMultimediali = creaArray();
		Player(fileMultimediali);

	}

	public static elementoMultimediale[] creaArray() {
		elementoMultimediale[] fileMultimediali = new elementoMultimediale[5]; // istanzio un array di 5 elementi
		Scanner file = new Scanner(System.in); 
		for (int x = 0; x < 5; x++) {
			System.out.println("enter type of file"); // creo un "menu" di creazione
			System.out.println("press 0 for img");
			System.out.println("press 1 for video");
			System.out.println("press 2 for audio");
			int n = file.nextInt();
			if (n == 0) {        // creazione immagine
				System.out.println("Write the title and the initial luminosity");
				String t = file.next();
				int lum = file.nextInt();
				int tipo= n+1;
				fileMultimediali[x] = new immagine(t, tipo, lum);
				
			} else if (n == 1) {		// creazione video
				System.out.println("Write the title, the durata, the initial volume and the initial luminosity");
				String t = file.next();
				int durata = file.nextInt();
				System.out.println(durata);
				int volume = file.nextInt();
				int lum = file.nextInt();
				fileMultimediali[x] = new video(t,  n+1,durata, lum,volume );
				
			} else if (n == 2) {		// creazione audio
				System.out.println("Write the title, the durata and the initial volume ");
				String t = file.next();
				int durata = file.nextInt();
				int volume = file.nextInt();

				fileMultimediali[x] = new audio(t, durata, volume,n+1 );
			} else {
				x--;
				System.out.println("Error !select a valid file!");
			}
		}
		return fileMultimediali;

	}

	public static void Player(elementoMultimediale[] array) {		//funzione Mediaplayer
		Scanner file = new Scanner(System.in);
		boolean fineProgramma = false; //variabile di controllo
		for (int x = 0; fineProgramma == false; x++) {
			System.out.println("press a number from 1 to 5 to select a file or 0 to stop the programm"); //selezione elemento array
			int n = file.nextInt();
			if (n == 0) {
				fineProgramma = true;		//chiusura programma
				System.out.println("-- sessione terminata --");
			} else {
				System.out.println("you have selected : " + array[n-1].getTitolo());
				
				
				boolean dentroMenu = true;		//variabile controllo
				
				while (dentroMenu == true) {
					
					if (array[n-1].getTipo() == 2) {	//controllo che tipo di file è
						int n1;
						System.out.println("===============================");			//menu se è un video
						System.out.println("PRESS 0 to go back");
						System.out.println("PRESS 1 to play");
						System.out.println("PRESS 2 to increase volume");
						System.out.println("PRESS 3 to decrease volume");
						System.out.println("PRESS 4 to increase luminosity");
						System.out.println("PRESS 5 to decrease luminosity");

						System.out.println("===============================");
						 n1 = file.nextInt();				
						if (n1 == 0) {					//comando uscita menu file
							dentroMenu = false;
						} else if (n1 == 1) {
							array[n-1].play();			//azioni che può compiere
							
							
						} else if (n1 == 2) {
							((video) array[n-1]).alzaVolume();
						} else if (n1 == 3) {
							((video) array[n-1]).abbassaVolume();
						} else if (n1 == 4) {
							((video) array[n-1]).alzaLuminosita();
						}else if (n1 == 5) {
							((video) array[n-1]).abbassaLuminosita();
						}else {
							System.out.println("not valid selection! error!");

						}
					}else if(array[n-1].getTipo() == 1) {//menu se è una immagine
						int n1;
						System.out.println("===============================");
						System.out.println("PRESS 0 to go back");
						System.out.println("PRESS 1 to show");
						
						System.out.println("PRESS 2 to increase luminosity");
						System.out.println("PRESS 3 to decrease luminosity");

						System.out.println("===============================");
						n1 = file.nextInt();
						if (n1 == 0) {
							dentroMenu = false;
						} else if (n1 == 1) {
							array[n-1].show();
							
						} else if (n1 == 2) {
							((immagine) array[n-1]).alzaLuminosita();
						} else if (n1 == 3) {
							((immagine) array[n-1]).abbassaLuminosita();
						}else {
							System.out.println("not valid selection! error!");

						}
					}else if(array[n-1].getTipo() == 3) {//menu se è un audio
						int n1;
						System.out.println("===============================");
						System.out.println("PRESS 0 to go back");
						System.out.println("PRESS 1 to play");
						System.out.println("PRESS 2 to increase volume");
						System.out.println("PRESS 3 to decrease volume");
						System.out.println("===============================");
						n1 = file.nextInt();
						if (n1 == 0) {
							dentroMenu = false;
						} else if (n1 == 1) {
							array[n-1].play();
							
						} else if (n1 == 2) {
							(  (IcontrolliVolume) array[n-1]).alzaVolume();
						} else if (n1 == 3) {
							( (IcontrolliVolume) array[n-1]).abbassaVolume();
						}else {
							System.out.println("not valid selection! error!");

						}
					}else {
						System.out.println("!ERRORE!");
						dentroMenu = false;
					}

				}
			}

		}
	}

}
