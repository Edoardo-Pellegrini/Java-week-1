package com.epicode.playerMultimediale;

import com.epicode.playerMultimediale.interfacce.IcontrolliLuminosità;

public class immagine extends elementoMultimediale implements IcontrolliLuminosità{
	private int luminosita;
	public immagine(String titolo, int luminosita, int tipo ) {
		super(titolo, luminosita );
		this.luminosita = luminosita;
		
	}

	@Override
	public void alzaLuminosita() {
		if(luminosita<10) {
			this.luminosita++;
			System.out.println("Nuova luminosità = "+luminosita);
		}else {
			System.out.println("luminosita max raggiunta");
		}
		
	}

	@Override
	public void abbassaLuminosita() {
		if(luminosita>0) {
			this.luminosita--;
			System.out.println("Nuova luminosità = "+luminosita);
		}else {
			System.out.println("luminosita minima raggiunta");
		}
		
	}

	@Override
	public int getLuminosita() {
		return this.luminosita;
	}
	
	public void show() {
		
			
			String barraLuminosita;
			
			barraLuminosita = new String(new char[luminosita]).replace("\0", "*");
			System.out.println("File img = "+getTitolo()+ "   lum:" + barraLuminosita);
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

}
