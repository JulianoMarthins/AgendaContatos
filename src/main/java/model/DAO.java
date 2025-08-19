package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// Módulo de Conexão

	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "poabruce";

	// Métodos de conexão
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println("Error: " + e);
			return null;
		}
	}
	
	
	// CRUD CREATE
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos(nome, fone, cpf, rg)"
				+ "values(?, ?, ?, ?)";
		try {
			
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getCpf());
			pst.setString(4, contato.getRg());
					
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
