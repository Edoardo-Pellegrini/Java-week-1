package com.epicode.playerMultimediale;

public abstract  class riproducibile extends elementoMultimediale{			//classe astratta per video ed audio
	private int durata;
	
	
	public  riproducibile(String titolo,int tipo,int durata){
		super(titolo, durata);
		this.durata = durata;
	}
	
	


	public int getDurata() {
		return durata;
	}



	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	public abstract void play();

}
