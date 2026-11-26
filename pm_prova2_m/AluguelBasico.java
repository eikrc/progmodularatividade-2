package pm_prova2_m;

public class AluguelBasico extends Aluguel {

    private int limiteKmPorDia = 100;

    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Aluguel Básico | Cliente: " + getNomeCliente() + " | Dias: " + getQuantidadeDias()
                + " | Total: " + getValorTotal() + " | Status: " + getStatus()
                + " | Limite: " + limiteKmPorDia + " km por dia | Seguro: Não");
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }
}
