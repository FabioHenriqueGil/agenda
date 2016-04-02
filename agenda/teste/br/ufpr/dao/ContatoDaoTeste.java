package br.ufpr.dao;

import java.time.ZonedDateTime;

import org.junit.Test;

import br.ufpr.modelo.Contato;

public class ContatoDaoTeste {

	@Test
	public void test() {
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato("Fabio", "fabio.gil@ufpr.br", "Palotina", ZonedDateTime.now());
		contatoDao.adiciona(contato);
	}

}
