package pm_prova2_m;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private int nota;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public void avaliar(int nota) {
        this.nota = nota;
        System.out.println("Aluguel de " + getNomeCliente() + " avaliado com nota " + nota);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Aluguel Executivo | Cliente: " + getNomeCliente() + " | Dias: " + getQuantidadeDias()
                + " | Total: " + getValorTotal() + " | Status: " + getStatus()
                + " | Km ilimitada | Motorista particular | Nota: " + nota);
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }
}
