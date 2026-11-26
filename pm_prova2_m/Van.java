package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int maxPassageiros;
    private int nota;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int maxPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    @Override
    public void avaliar(int nota) {
        this.nota = nota;
        System.out.println("Van " + getModelo() + " avaliada com nota " + nota);
    }

    @Override
    public void realizarInspecao() {
        setStatus(StatusVeiculo.MANUTENCAO);
        System.out.println("Van " + getModelo() + " inspecionada e enviada para manutenção.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Van | Placa: " + getPlaca() + " | Modelo: " + getModelo()
                + " | Ano: " + getAnoFabricacao() + " | Diária: " + getValorDiaria()
                + " | Km: " + getQuilometragem() + " | Status: " + getStatus()
                + " | Máx. passageiros: " + maxPassageiros + " | Nota: " + nota);
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return true;
    }
}
