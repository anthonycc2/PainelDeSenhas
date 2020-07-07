package projetoPainelSenhas;

import java.time.LocalDateTime;

public class Paciente {

	private String nome;
	private int matricula;
	private int senha;
	private LocalDateTime entrada;
	private LocalDateTime chamada;

	public Paciente(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setCodigo(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getChamada() {
		return chamada;
	}

	public void setChamada(LocalDateTime chamada) {
		this.chamada = chamada;
	}

	public void mostrar() {
		System.out.println("Nome: " + this.getNome() + " | Matricula: " + this.getMatricula());
	}
}
