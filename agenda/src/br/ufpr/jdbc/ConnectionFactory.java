package br.ufpr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "impossível carregar o Driver.");
			System.exit(0);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
