package projetoPainelSenhas;

import java.util.ArrayList;

public class RepositorioPaciente implements RepositorioPacienteInterface {

	ArrayList<Paciente> arrayList;

	public RepositorioPaciente() {
		this.arrayList = new ArrayList<Paciente>();
	}

	public void inserir(Paciente paciente) {
		this.arrayList.add(paciente);
	}

	// Procurar paciente por matricula
	public Paciente procurar(int matricula) {
		Paciente pacienteBuscado = null;

		for (Paciente paciente : this.arrayList)
			if (paciente.getMatricula() == matricula) {
				pacienteBuscado = paciente;
				break;
			}
		return pacienteBuscado;
	}

	public void mostrar() {
		if (!(arrayList.isEmpty())) {
			System.out.println("NOME | MATRICULA");

			for (Paciente paciente : this.arrayList)
				System.out.println(paciente.getNome() + " | " + paciente.getMatricula());
		} else
			System.out.println("O repositorio esta vazio.");
	}

}
