package model;

public class JavaBeans {

	private String idCliente;
	private String nome;
	private String fone;
	private String cpf;
	private String rg;
	

	// Constructions
	public JavaBeans() {
		super();
	}

	public JavaBeans(String idCliente, String nome, String cpf, String rg, String fone) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.fone = fone;
	}

	// Getters & Setters
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
