package empresa.nome.cm;

import empresa.nome.cm.modelo.Tabuleiro;
import empresa.nome.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(12, 12, 12);
		new TabuleiroConsole(tabuleiro);
	}
}
