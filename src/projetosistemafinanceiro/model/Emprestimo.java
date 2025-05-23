package projetosistemafinanceiro.model;

public class Emprestimo {
    private float capital;
    private float taxa;
    private int tempo;

    public Emprestimo(float capital, float taxa, int tempo) {
        this.capital = capital;
        this.taxa = taxa;
        this.tempo = tempo;
    }

    public float getCapital() {
        return capital;
    }

    public float getTaxa() {
        return taxa;
    }

    public int getTempo() {
        return tempo;
    }

    public float calcularJurosSimples() {
        return capital + (capital * (taxa / 100) * tempo);
    }

    public double calcularJurosCompostos() {
        return capital * Math.pow(1 + (taxa / 100), tempo);
    }
}
