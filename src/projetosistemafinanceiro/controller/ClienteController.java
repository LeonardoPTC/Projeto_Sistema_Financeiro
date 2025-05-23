package projetosistemafinanceiro.controller;

import java.util.ArrayList;
import projetosistemafinanceiro.model.Cliente;
import projetosistemafinanceiro.view.ClienteView;
import projetosistemafinanceiro.view.EmprestimoView;

public class ClienteController {
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ClienteView clienteView = new ClienteView();
	private EmprestimoView emprestimoView = new EmprestimoView();

	public void adicionarCliente() {
		String nome = clienteView.lerNome();
		if (nome.isBlank()) {
			System.out.println("Não pode haver campos vazios. Por Favor, Tente Novamente!");
			return;
		} 

		String cpf = clienteView.lerCpf();
		cpf = cpf.trim();
		
		if (cpf.isBlank()) {
			System.out.println("Não pode haver campos vazios. Por Favor, Tente Novamente!");
			return;
		} else if (!cpf.matches("\\d{11}")) {
			System.out.println("CPF inválido! Digite exatamente 11 números sem espaços, pontuações e/ou caracteres especiais.");
			return;
		} 
		
		if (buscarPorCpf(cpf) == null){
			Cliente cliente = new Cliente(nome, cpf);
			clientes.add(cliente);
			clienteView.mostrarMensagem("Cliente adicionado.");
		} else {
			System.out.println("CPF já cadastrado!");
			return;
		}
	}

	public void listarClientes() {
		for (Cliente cliente : clientes) {
			cliente.exibirDados();
		}
	}

	public Cliente buscarPorCpf(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

	public void editarCliente() {
		String cpf = clienteView.lerCpf();
		Cliente cliente = buscarPorCpf(cpf);
		if (cliente != null) {
			String novoNome = clienteView.lerNome();
			cliente.setNome(novoNome);
			clienteView.mostrarMensagem("Cliente atualizado.");
		} else {
			clienteView.mostrarMensagem("Cliente não encontrado.");
		}
	}

	public void removerCliente() {
		String cpf = clienteView.lerCpf();
		Cliente cliente = buscarPorCpf(cpf);
		if (cliente != null) {
			clientes.remove(cliente);
			clienteView.mostrarMensagem("Cliente removido.");
		} else {
			clienteView.mostrarMensagem("Cliente não encontrado.");
		}
	}

	public void cadastrarEmprestimo(String cpf, float capital, float taxa, int tempo) {
		Cliente cliente = buscarPorCpf(cpf);
		if (cliente != null) {
			cliente.cadastrarEmprestimo(capital, taxa, tempo);
			emprestimoView.mostrarMensagem("Empréstimo cadastrado.");
		} else {
			emprestimoView.mostrarMensagem("Cliente não encontrado.");
		}
	}

	public float calcularJurosSimples(float capital, float taxa, int tempo) {
	    return capital + (capital * (taxa / 100) * tempo);
	}
	

	public double calcularJurosCompostos(float capital, float taxa, int tempo) {
	    return capital * Math.pow(1 + (taxa / 100), tempo);
	}

	public void quitarEmprestimo(String cpf) {
		Cliente cliente = buscarPorCpf(cpf);
		if (cliente != null && cliente.temEmprestimo()) {
			cliente.quitarEmprestimo();
			emprestimoView.mostrarMensagem("Empréstimo quitado.");
		} else {
			emprestimoView.mostrarMensagem("Cliente não encontrado ou sem empréstimo.");
		}
	}
}
