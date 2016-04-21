package br.ufpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufpr.jdbc.ConnectionFactory;
import br.ufpr.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contato " + "(nome,email,endereco,dataNascimento)" + "values(?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro no adiciona contato");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public Contato buscaContato(Long id) {
		Contato contato = new Contato();
		String sql = "select * from contato where id =" + id;

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			// executa
			ResultSet resultado = stmt.executeQuery();
			// alimenta a lista
			while (resultado.next()) {
				contato.setId(resultado.getLong("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));

				Calendar dataNascimento = Calendar.getInstance();

				dataNascimento.setTime(resultado.getDate("dataNascimento"));
				contato.setDataNascimento(dataNascimento);

			}
			// fecha conexão
			resultado.close();
			stmt.close();
			return contato;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "select * from contato";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			// executa
			ResultSet resultado = stmt.executeQuery();
			// alimenta a lista
			while (resultado.next()) {
				Contato contato = new Contato();
				contato.setId(resultado.getLong("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));

				Calendar dataNascimento = Calendar.getInstance();

				dataNascimento.setTime(resultado.getDate("dataNascimento"));
				contato.setDataNascimento(dataNascimento);

				contatos.add(contato);
			}
			// fecha conexão
			resultado.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {
		String sql = "update contato set nome=?, email=?, endereco=?, dataNascimento=? where id=" + contato.getId();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro no adiciona contato");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
