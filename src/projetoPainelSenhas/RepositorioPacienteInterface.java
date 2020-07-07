package projetoPainelSenhas;

public interface RepositorioPacienteInterface {

	public void inserir(Paciente pacientes);

	public Paciente procurar(int matricula);

	public void mostrar();

}
