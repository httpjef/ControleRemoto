package application;

public class ControleRemoto implements Controlador {
	//Atributos
	
	private int volume;
	private boolean ligado;
	private boolean tocando;
	
	///Métodos especiais
	
	//CONSTRUTOR
	public ControleRemoto() {
		this.volume = 50;
		this.ligado = true;
		this.tocando = false;
	}

	//GETTERS & SETTERS
	private int getVolume() {
		return volume;
	}

	private void setVolume(int volume) {
		this.volume = volume;
	}

	private boolean getLigado() {
		return ligado;
	}

	private void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public boolean getTocando() {
		return tocando;
	}

	private void setTocando(boolean tocando) {
		this.tocando = tocando;
	}

	//Métodos abstratos
	
	@Override
	public void ligar() {
		this.setLigado(true);
	}

	@Override
	public void desligar() {
		this.setLigado(false);
	}

	@Override
	public void abrirMenu() {
		System.out.println("-------MENU--------");
		System.out.println("Está ligado? " + this.getLigado());
		System.out.println("Está tocando? " + this.getTocando());
		System.out.print("Volume: " + this.getVolume());
		System.out.print(" ");
		int i;
		for (i = 0; i <= this.getVolume(); i += 10) {
			System.out.print("||");
		}
		System.out.println();
	}

	@Override
	public void fecharMenu() {
		System.out.println("Fechando Menu...");
	}

	@Override
	public void maisVolume() {
		if(this.getLigado()) {
			this.setVolume(this.getVolume() + 5);
		}
		else {
			System.out.println("Não consigo aumentar!");
		}
	}

	@Override
	public void menosVolume() {
		if(this.getLigado()) {
			this.setVolume(this.getVolume() - 5);
		}
		else {
			System.out.println("Não consigo diminuir!");
		}
	}

	@Override
	public void ligarMudo() {
		if(this.getLigado() && this.getVolume() > 0) {
			setVolume(0);
		}
		else {
			System.out.println("Não consigo mutar!");
		}
	}

	@Override
	public void desligarMudo() {
		if(this.getLigado() && this.getVolume() == 0) {
			setVolume(50);
		}
		else {
			System.out.println("Não consigo desmutar!");
		}
	}

	@Override
	public void play() {
		if(this.getLigado() && !(this.getTocando())) {
		this.setTocando(true);
		}
		else {
			System.out.println("Não consigo dar play!");
		}
	}

	@Override
	public void pause() {
		if(this.getLigado() && this.getTocando()) {
			this.setTocando(false);
		}
		else {
			System.out.println("Não consigo pausar!");
		}
	}
	
	
	
}
