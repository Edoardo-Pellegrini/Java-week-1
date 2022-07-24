package com.epicode.playerMultimediale;

import com.epicode.playerMultimediale.interfacce.IcontrolliVolume;

public class audio extends riproducibile implements IcontrolliVolume{
	int volume;
	public audio(String titolo, int durata, int volume, int tipo) {
		super(titolo, durata, tipo);
		this.volume = volume;
		
		
		
	}

	
	public void play() {
		for(int x = 0;x<getDurata();x++) {
			String barraVolume;
			barraVolume = new String(new char[volume]).replace("\0", "!");
			System.out.println("File audio = "+getTitolo()+"    vol:"+ barraVolume);
		}
		
	}
	

	public void alzaVolume() {
		if(volume<10) {
			this.volume++;
			System.out.println(volume);
		}else {
			System.out.println(volume);
			System.out.println("Volume max raggiunto");
		}
		
		
		
	}

	
	public void abbassaVolume() {
		if(volume>0) {
			this.volume--;
			System.out.println(volume);
		}else {
			System.out.println(volume);
		}
		
		
	}


	
	public int getVolume() {
		return this.volume;
	
	}


	@Override
	protected void show() {
		// TODO Auto-generated method stub
		
	}

}
