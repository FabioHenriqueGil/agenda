package br.ufpr.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionFactoryTeste {

	@Test
	public void test() {
		ConnectionFactory factory = new ConnectionFactory();
		assertNotNull(factory.getConnection());
	}

}
