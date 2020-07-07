package projetoPainelSenhas;

public class FilaPaciente {

	private final int INICIO_FILA = 0;
	private final int TAMANHO_FILA = 100;
	private int indice;
	private Paciente[] vetor;

	public FilaPaciente() {
		this.indice = 0;
		this.vetor = new Paciente[this.TAMANHO_FILA];
	}

	private boolean filaVazia() {
		if (this.indice == this.INICIO_FILA)
			return true;
		else
			return false;
	}

	private boolean filaCheia() {
		if (this.indice == this.TAMANHO_FILA)
			return true;
		else
			return false;
	}

	public void inserir(Paciente paciente) {
		if (this.filaCheia())
			System.out.println("A Fila esta cheia.");
		else {
			this.vetor[this.indice] = paciente;
			this.indice++;
		}
	}

	public Paciente remover() {
		Paciente paciente = null;

		if (this.filaVazia())
			System.out.println("A Fila esta vazia.");
		else {
			paciente = this.vetor[this.INICIO_FILA];

			// Reordena a fila
			if (this.indice > 1) {
				for (int i = 0; i < this.indice; ++i)
					this.vetor[i] = this.vetor[i + 1];
			}
			this.indice--;
		}
		return paciente;
	}

	public void mostrar() {
		if (this.filaVazia())
			System.out.println("A Fila esta vazia.");
		else {
			System.out.println("NOME | MATRICULA | SENHA | HORA DE ENTRADA");
			for (int i = 0; i < this.indice; i++) {
				System.out.println(this.vetor[i].getNome() + " | " + this.vetor[i].getMatricula() + " | "
						+ this.vetor[i].getSenha() + " | " + this.vetor[i].getEntrada().getHour() + ":"
						+ vetor[i].getEntrada().getMinute() + ":" + vetor[i].getEntrada().getSecond());
			}
		}
	}

}
