package projetoPainelSenhas;

public class RepositorioPacienteVetor {

	private Paciente[] vetor;

	public RepositorioPacienteVetor() {
		this.vetor = new Paciente[100];
	}

	public Paciente procurar(int matricula) {
		Paciente pacienteBuscado = null;

		for (int i = 0; i < vetor.length; i++)
			if (this.vetor[i].getMatricula() == matricula) {
				pacienteBuscado = this.vetor[i];
			}
		return pacienteBuscado;
	}

	public void inserir(Paciente paciente) {
		boolean adicionou = false;

		for (int i = 0; i < this.vetor.length; i++) {
			if (this.vetor[i] == null) {
				this.vetor[i] = paciente;
				adicionou = true;
				break;
			}
		}
		if (!adicionou)
			System.out.println("ERRO: repositorio cheio.");
	}

	public void mostrar() {
		System.out.println("MATRICULA | NOME | SENHA | HORA DE ENTRADA | HORA DE CHAMADA");
		this.ordenar();

		for (int i = 0; i < this.vetor.length; i++)
			if (this.vetor[i] != null)
				System.out.println(this.vetor[i].getMatricula() + " | " + this.vetor[i].getNome() + " | "
						+ this.vetor[i].getSenha() + " | " + this.vetor[i].getEntrada().getHour() + ":"
						+ this.vetor[i].getEntrada().getMinute() + ":" + this.vetor[i].getEntrada().getSecond() + " | "
						+ this.vetor[i].getChamada().getHour() + ":" + this.vetor[i].getChamada().getMinute() + ":"
						+ this.vetor[i].getChamada().getSecond());
	}

	// Algoritmo de ordenacao Bubble Sort.
	public void ordenar() {
		boolean trocou = false;
		Paciente aux = null;

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 1; j < vetor.length - i; j++) {
				if (vetor[j] != null)
					if (vetor[j - 1].getMatricula() > vetor[j].getMatricula()) {
						aux = vetor[j - 1];
						vetor[j - 1] = vetor[j];
						vetor[j] = aux;
						trocou = true;
					}
			}

			// Se nao houve troca, o vetor ja esta ordenado.
			if (!(trocou))
				break;
		}
	}

}
