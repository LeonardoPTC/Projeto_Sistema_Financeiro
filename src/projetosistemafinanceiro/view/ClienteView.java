package projetosistemafinanceiro.view;
import java.util.Scanner;

public class ClienteView {
    private Scanner scanner = new Scanner(System.in);

    public String lerNome() {
        System.out.print("Nome do Cliente: ");
        return scanner.nextLine();
    }

    public String lerCpf() {
        System.out.print("CPF do Cliente(Sem espaços, pontuações e/ou caracteres especiais.): ");
        return scanner.nextLine();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
