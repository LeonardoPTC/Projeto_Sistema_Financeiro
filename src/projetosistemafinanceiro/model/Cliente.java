package projetosistemafinanceiro.model;

public class Cliente extends Pessoa {
    private Emprestimo emprestimo;

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.emprestimo = null;
    }

    public void cadastrarEmprestimo(float capital, float taxa, int tempo) {
        this.emprestimo = new Emprestimo(capital, taxa, tempo);
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void quitarEmprestimo() {
        this.emprestimo = null;
    }

    public boolean temEmprestimo() {
        return emprestimo != null;
    }
    
    @Override
    public void exibirDados() {
        super.exibirDados();
        if (emprestimo != null) {
            System.out.println("Status do empréstimo: ATIVO\n");
        } else {
            System.out.println("Status do empréstimo: SEM EMPRÉSTIMO\n");
        }
    }
}