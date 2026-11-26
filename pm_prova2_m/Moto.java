package pm_prova2_m;

public class Moto extends Veiculo implements Inspecionavel {

    private int cilindrada;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int cilindrada) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public void realizarInspecao() {
        setStatus(StatusVeiculo.MANUTENCAO);
        System.out.println("Moto " + getModelo() + " inspecionada e enviada para manutenção.");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moto | Placa: " + getPlaca() + " | Modelo: " + getModelo()
                + " | Ano: " + getAnoFabricacao() + " | Diária: " + getValorDiaria()
                + " | Km: " + getQuilometragem() + " | Status: " + getStatus()
                + " | Cilindrada: " + cilindrada);
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return true;
    }
}
