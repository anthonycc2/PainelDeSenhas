package projetoPainelSenhas;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		int opcao, senha, matricula;
		Paciente paciente;
		RepositorioPaciente repPaciente = new RepositorioPaciente();
		RepositorioPacienteVetor repPacienteAtendido = new RepositorioPacienteVetor();
		FilaPaciente fila = new FilaPaciente();
		Scanner scanner = new Scanner(System.in);

		senha = 0;
		Paciente paciente1 = new Paciente("Dick Vigarista", 101);
		Paciente paciente2 = new Paciente("Penelope Charmosa", 502);
		Paciente paciente3 = new Paciente("Rabugento", 630);
		Paciente paciente4 = new Paciente("Fred Flinstone", 251);
		Paciente paciente5 = new Paciente("Capitao Caverna", 705);
		repPaciente.inserir(paciente1);
		repPaciente.inserir(paciente2);
		repPaciente.inserir(paciente3);
		repPaciente.inserir(paciente4);
		repPaciente.inserir(paciente5);

		do {
			System.out.println("\n");
			System.out.println("SISTEMA DE GERENCIAMENTO DE ATENDIMENTO");
			System.out.println("\n");
			System.out.println("-------------- Menu de opcoes --------------");
			System.out.println("-- 1. Exibir lista de pacientes");
			System.out.println("-- 2. Procurar paciente por matricula");
			System.out.println("-- 3. Gerar senha de atendimento");
			System.out.println("-- 4. Chamar senha de atendimento");
			System.out.println("-- 5. Exibir fila de espera");
			System.out.println("-- 6. Exibir relatorio de pacientes atendidos");
			System.out.println("-- 7. Sair");
			System.out.println("\n");
			System.out.println("-- Digite sua opcao:");

			opcao = scanner.nextInt();

			switch (opcao) {
			case 1: // lista de paciente
				repPaciente.mostrar();
				break;
			case 2: // Procurar paciente por matrícula
				System.out.println("-- Digite a matricula do paciente:");
				matricula = scanner.nextInt();
				paciente = repPaciente.procurar(matricula);
				if (paciente == null)
					System.out.println("Paciente nao encontrado.");
				else
					paciente.mostrar();
				break;
			case 3: // Gerar senha de atendimento
				System.out.println("-- Digite a matricula do paciente:");
				matricula = scanner.nextInt();
				paciente = repPaciente.procurar(matricula);
				if (paciente == null)
					System.out.println("Paciente nao encontrado.");
				else {
					senha++;
					paciente.setSenha(senha);
					paciente.setEntrada(LocalDateTime.now());
					fila.inserir(paciente);
					System.out.println("-- Gerada a senha " + senha + " para o paciente " + paciente.getNome());
				}
				break;
			case 4: // Chamar senha de atendimento
				paciente = fila.remover();
				if (paciente != null) {
					paciente.setChamada(LocalDateTime.now());
					repPacienteAtendido.inserir(paciente);
					System.out.println("-- EXIBINDO NO PAINEL >> Senha " + paciente.getSenha() + ", "
							+ paciente.getNome() + ": dirija-se ao consultorio.");
				}
				break;
			case 5: // Exibir fila de espera
				fila.mostrar();
				break;
			case 6: // Exibir relatorio de pacientes atendidos
				repPacienteAtendido.mostrar();
				break;
			case 7: // Sair
				System.out.println("-- Programa finalizado.");
				break;
			default: // erro de opcao
				System.out.println("-- Opcao invalida.");
				break;
			}

		} while (opcao != 7);

		scanner.close();

	}
}