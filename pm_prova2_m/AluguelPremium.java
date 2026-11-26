package pm_prova2_m;

public class AluguelPremium extends Aluguel {

    public AluguelPremium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Aluguel Premium | Cliente: " + getNomeCliente() + " | Dias: " + getQuantidadeDias()
                + " | Total: " + getValorTotal() + " | Status: " + getStatus()
                + " | Km ilimitada | Seguro: Sim");
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }
}
