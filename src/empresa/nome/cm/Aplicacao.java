package empresa.nome.cm;

import empresa.nome.cm.modelo.Tabuleiro;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		tabuleiro.marcar(4, 4);
		tabuleiro.marcar(4, 5);
		tabuleiro.abrir(3, 3);
		
		System.out.println(tabuleiro);
	}

}
