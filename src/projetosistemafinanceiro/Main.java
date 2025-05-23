package projetosistemafinanceiro;

import projetosistemafinanceiro.controller.ClienteController;
import projetosistemafinanceiro.view.ClienteView;
import projetosistemafinanceiro.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ClienteController clienteController = new ClienteController();
		MenuView menuview = new MenuView();
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			try {
				menuview.exibirmenu();
				opcao = scanner.nextInt();

				scanner.nextLine();

				switch (opcao) {
				case 1:
					clienteController.adicionarCliente();
					break;
				case 2:
					System.out.println("\nClientes Cadastrados:\n");
					clienteController.listarClientes();
					System.out.println("----------------------------------");
					break;
				case 3:
					clienteController.editarCliente();
					break;
				case 4:
					clienteController.removerCliente();
					break;
				case 5:
					System.out.print("CPF do cliente(Sem espaços e pontuações): ");
					String cpfEmprestimo = scanner.nextLine();
					System.out.print("Capital: ");
					float capital = scanner.nextFloat();
					System.out.print("Taxa (% ao ano): ");
					float taxa = scanner.nextFloat();
					System.out.print("Tempo (anos): ");
					int tempo = scanner.nextInt();
					scanner.nextLine();
					clienteController.cadastrarEmprestimo(cpfEmprestimo, capital, taxa, tempo);
					break;
				case 6:
					System.out.print("Capital: ");
					float capitalSimples = scanner.nextFloat();
					System.out.print("Taxa (% ao ano): ");
					float taxaSimples = scanner.nextFloat();
					System.out.print("Tempo (anos): ");
					int tempoSimples = scanner.nextInt();
					scanner.nextLine();
					float resultadoSimples = clienteController.calcularJurosSimples(capitalSimples, taxaSimples, tempoSimples);
					System.out.printf("Valor a pagar (Juros Simples): R$ %.2f\n", resultadoSimples);
					break;
				case 7:
					System.out.print("Capital: ");
					float capitalComposto = scanner.nextFloat();
					System.out.print("Taxa (% ao ano): ");
					float taxaComposto = scanner.nextFloat();
					System.out.print("Tempo (anos): ");
					int tempoComposto = scanner.nextInt();
					scanner.nextLine();
			        double resultadoComposto = clienteController.calcularJurosCompostos(capitalComposto, taxaComposto, tempoComposto);
			        System.out.printf("Valor a pagar (Juros Compostos): R$ %.2f\n", resultadoComposto);
			        break;
					
				case 8:
					System.out.print("CPF do cliente: ");
					String cpfQuitar = scanner.nextLine();
					clienteController.quitarEmprestimo(cpfQuitar);
					break;
				case 0:
					System.out.println("Finalizando programa...");
					break;
				default:
					System.out.println("Opção inválida.");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Opção inválida");
				scanner.nextLine();
				opcao = -1;
			}

		} while (opcao != 0);

		scanner.close();

	}
}
