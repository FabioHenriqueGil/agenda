package br.ufpr.dao;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Test;

import br.ufpr.modelo.Contato;

public class ContatoDaoTeste {

	@Test
	public void test() {
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato("Fabio", "fabio.gil@ufpr.br", "Palotina", ZonedDateTime.now());
		contatoDao.adiciona(contato);

		List<Contato> lista = contatoDao.getLista();
		for (Contato c : lista) {
			System.out.println("ID="+ c.getId()+ " NOME="+ c.getNome()+ " EMAIL="+ c.getEmail()+ " ENDERECO="+
					c.getEndereco()+ " DATA NASC="+ c.getDataNascimento());
		}
	}

}
