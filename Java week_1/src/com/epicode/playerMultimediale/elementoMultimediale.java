package com.epicode.playerMultimediale;

public abstract class elementoMultimediale {			//classe astratta principale
	private int tipo;
	private String titolo;
	
	public elementoMultimediale(String titolo,int tipo) {
		this.titolo = titolo;
		this.tipo = tipo;
	}
	
	

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public abstract void play();
	protected abstract void show();

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
