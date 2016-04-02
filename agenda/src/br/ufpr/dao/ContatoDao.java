package br.ufpr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.ufpr.jdbc.ConnectionFactory;
import br.ufpr.modelo.Contato;
import sun.util.calendar.ZoneInfo;

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
			stmt.setDate(4, new Date(contato.getDataNascimento().toEpochSecond() * 1000));

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql ="select * from contato";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			//executa
			ResultSet resultado = stmt.executeQuery();
			//alimenta a lista
			while (resultado.next()) {
				Contato contato = new Contato();
				contato.setId(resultado.getLong("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));

				
				//não consegui fazer a data ainda.... :/
				// Date dataNascimento = resultado.getDate("dataNascimento");
				// ZonedDateTime dataZoned =
				// ZonedDateTime.parse(dataNascimento.toString());
				// contato.setDataNascimento(dataZoned );
				//

				contatos.add(contato);
			}
			//fecha conexão
			resultado.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
