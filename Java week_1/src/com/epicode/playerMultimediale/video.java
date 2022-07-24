package com.epicode.playerMultimediale;
import com.epicode.playerMultimediale.interfacce.IcontrolliVolume;
import com.epicode.playerMultimediale.interfacce.IcontrolliLuminosità;

public class video extends riproducibile implements IcontrolliLuminosità,IcontrolliVolume {

	private int volume;
	private int luminosita;
	
	public video(String titolo, int tipo,int durata,  int luminosita,int volume ) {
		super(titolo, tipo,durata  );
		this.volume = volume;
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

	@Override
	public void play() {
		for(int x = 0;x<this.getDurata();x++) {
			String barraVolume;
			String barraLuminosita;
			barraVolume = new String(new char[volume]).replace("\0", "!");
			barraLuminosita = new String(new char[luminosita]).replace("\0", "*");
			System.out.println("File video = "+getTitolo()+ "   vol:" + barraVolume+ "   lum:" + barraLuminosita);
		}
		
	}

	@Override
	public void alzaVolume() {
		if(volume<10) {
			this.volume++;
			System.out.println("Nuovo volume = "+volume);
		}else {
			
			System.out.println("Volume max raggiunto");
		}
	}

	@Override
	public void abbassaVolume() {
		if(volume>0) {
			this.volume--;
			System.out.println("Nuovo volume = "+volume);
		}else {
			System.out.println("Volume minimo raggiunto");
		}
		
	}

	@Override
	public int getVolume() {
		return this.volume;
		
	}

	@Override
	protected void show() {
		// TODO Auto-generated method stub
		
	}
	
	
}
