package projetosistemafinanceiro.view;

public class MenuView {
	
	String menu = "\n --- MENU ---\n"
			+ "1 - Adicionar cliente\n"
			+ "2 - Listar clientes\n"
			+ "3 - Editar cliente\n"
			+ "4 - Remover cliente\n"
			+ "5 - Cadastrar empréstimo\n"
			+ "6 - Calcular juros simples\n"
			+ "7 - Calcular juros compostos\n"
			+ "8 - Quitar empréstimo\n"
			+ "0 - Sair\n"
			+ "Escolha uma opção: ";
	
	public void exibirmenu () {
		System.out.print(menu);
	}
}
