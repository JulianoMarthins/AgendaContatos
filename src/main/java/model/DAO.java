package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

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

	// CRUD Inserir contato ao banco de dados
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos(nome, fone, cpf, rg)" + "values(?, ?, ?, ?)";
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

	// CRUD Listar os contatos por nome
	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select * from contatos order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String cpf = rs.getString(4);
				String rg = rs.getString(5);
			
				
				contatos.add(new JavaBeans(idcon, nome, cpf, rg, fone));
			}

			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD - Atualizar contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idCliente = ?";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);

			pst.setString(1, contato.getIdCliente());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contato.setIdCliente(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setCpf(rs.getString(4));
				contato.setRg(rs.getString(5));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?, fone=?, cpf=?, rg=? where idCliente=?";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getCpf());
			pst.setString(4, contato.getRg());
			pst.setString(5, contato.getIdCliente());
			
			pst.executeUpdate();
			
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
