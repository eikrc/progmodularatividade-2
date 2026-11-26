package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int portas;
    private int nota;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int portas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.portas = portas;
    }

    public int getPortas() {
        return portas;
    }

    @Override
    public void avaliar(int nota) {
        this.nota = nota;
        System.out.println("Carro " + getModelo() + " avaliado com nota " + nota);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Carro | Placa: " + getPlaca() + " | Modelo: " + getModelo()
                + " | Ano: " + getAnoFabricacao() + " | Diária: " + getValorDiaria()
                + " | Km: " + getQuilometragem() + " | Status: " + getStatus()
                + " | Portas: " + portas + " | Nota: " + nota);
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }
}
