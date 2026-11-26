package pm_prova2_m;

import java.util.ArrayList;

public abstract class Aluguel {

    private String nomeCliente;
    private int quantidadeDias;
    private double valorTotal;
    private StatusAluguel status;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Aluguel(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {

        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    // Associa o veículo e soma ao valor total (diária x dias)
    public void associarVeiculo(Veiculo v) {
        veiculos.add(v);
        valorTotal += v.getValorDiaria() * quantidadeDias;
    }

    // Remove o veículo e desconta do valor total
    public void removerVeiculo(Veiculo v) {
        if (veiculos.remove(v)) {
            valorTotal -= v.getValorDiaria() * quantidadeDias;
        }
    }

    public abstract void exibirDetalhes();

    public abstract boolean possuiSeguroIncluso();
    
}
