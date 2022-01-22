package empresa.nome.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empresa.nome.cm.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1Cima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1Baixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia2Diagonal() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}

	@Test
	void testeValorPadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAlternar2xMarcacao() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}

	@Test
	void testeAbrirComVizinhos() {
		Campo vizinho1 = new Campo(2, 2);
		Campo vizinhoDoVizinho1 = new Campo(1, 1);

		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		campo.adicionarVizinho(vizinho1);
		campo.abrir();
		assertTrue(campo.isAberto() && vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
	}

	@Test
	void testeAbrirComVizinhos2() {
		Campo vizinho1 = new Campo(2, 2);
		Campo vizinhoDoVizinho1 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		vizinho1.adicionarVizinho(campo12);
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		campo.adicionarVizinho(vizinho1);
		campo.abrir();
		assertTrue(campo.isAberto() && vizinho1.isAberto() && vizinhoDoVizinho1.isFechado());

	}

}
