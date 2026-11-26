package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PM_Prova2_M {

    static final Scanner sc = new Scanner(System.in);
    static final ArrayList<Veiculo> veiculos = new ArrayList<>();
    static final ArrayList<Aluguel> alugueis = new ArrayList<>();

    // ---------- Entrada e exibição auxiliares ----------

    static int lerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void exibir(Object o) {
        if (o instanceof Veiculo) {
            ((Veiculo) o).exibirDetalhes();
        } else if (o instanceof Aluguel) {
            ((Aluguel) o).exibirDetalhes();
        }
    }

    static void listarComIndice(List<?> itens) {
        for (int i = 0; i < itens.size(); i++) {
            System.out.print(i + " - ");
            exibir(itens.get(i));
        }
    }

    // Mostra a lista e devolve o índice escolhido (-1 se vazio ou inválido)
    static int escolherIndice(List<?> itens, String titulo, String vazio) {
        if (itens.isEmpty()) {
            System.out.println(vazio);
            return -1;
        }
        System.out.println(titulo);
        listarComIndice(itens);
        System.out.print("Escolha: ");
        int i = lerInt();
        if (i < 0 || i >= itens.size()) {
            System.out.println("Opção inválida!");
            return -1;
        }
        return i;
    }

    static List<Veiculo> veiculosComStatus(StatusVeiculo status) {
        List<Veiculo> lista = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == status) {
                lista.add(v);
            }
        }
        return lista;
    }

    // ---------- Programa ----------

    public static void main(String[] args) {
        criarDados();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Associar veículos a um aluguel");
            System.out.println("2 - Exibir todos os veículos");
            System.out.println("3 - Exibir todos os aluguéis");
            System.out.println("4 - Exibir veículos disponíveis");
            System.out.println("5 - Avaliar");
            System.out.println("6 - Realizar inspeção");
            System.out.println("7 - Remover veículos em manutenção");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInt();

            switch (opcao) {
                case 1 -> associarVeiculo();
                case 2 -> exibirVeiculos();
                case 3 -> exibirAlugueis();
                case 4 -> exibirDisponiveis();
                case 5 -> avaliar();
                case 6 -> inspecionar();
                case 7 -> removerEmManutencao();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void criarDados() {
        veiculos.add(new Carro("ABC1D23", "Onix", 2022, 150.0, 15000, StatusVeiculo.DISPONIVEL, 4));
        veiculos.add(new Moto("XYZ9K88", "CG 160", 2021, 80.0, 22000, StatusVeiculo.DISPONIVEL, 160));
        veiculos.add(new Van("VAN4E56", "Sprinter", 2020, 300.0, 48000, StatusVeiculo.DISPONIVEL, 15));

        alugueis.add(new AluguelBasico("Maria", 3, 0, StatusAluguel.ATIVO));
        alugueis.add(new AluguelExecutivo("João", 5, 0, StatusAluguel.ATIVO));
    }

    // 1 - Associar veículos a um aluguel
    static void associarVeiculo() {
        List<Aluguel> ativos = new ArrayList<>();
        for (Aluguel a : alugueis) {
            if (a.getStatus() == StatusAluguel.ATIVO) {
                ativos.add(a);
            }
        }
        List<Veiculo> disponiveis = veiculosComStatus(StatusVeiculo.DISPONIVEL);

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
            return;
        }
        int a = escolherIndice(ativos, "Aluguéis ativos:", "Nenhum aluguel ativo.");
        if (a < 0) {
            return;
        }
        int v = escolherIndice(disponiveis, "Veículos disponíveis:", "Nenhum veículo disponível.");
        if (v < 0) {
            return;
        }

        Veiculo veiculo = disponiveis.get(v);
        ativos.get(a).associarVeiculo(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        System.out.println("Veículo associado!");
    }

    // 2 - Exibir todos os veículos
    static void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        veiculos.forEach(Veiculo::exibirDetalhes);
    }

    // 3 - Exibir todos os aluguéis
    static void exibirAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        for (Aluguel a : alugueis) {
            a.exibirDetalhes();
            for (Veiculo v : a.getVeiculos()) {
                System.out.print("    -> ");
                v.exibirDetalhes();
            }
        }
    }

    // 4 - Exibir apenas veículos disponíveis
    static void exibirDisponiveis() {
        List<Veiculo> disponiveis = veiculosComStatus(StatusVeiculo.DISPONIVEL);
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
            return;
        }
        disponiveis.forEach(Veiculo::exibirDetalhes);
    }

    // 5 - Avaliar objetos que implementam Avaliavel (veículos e aluguéis)
    static void avaliar() {
        List<Object> itens = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v instanceof Avaliavel) {
                itens.add(v);
            }
        }
        for (Aluguel a : alugueis) {
            if (a instanceof Avaliavel) {
                itens.add(a);
            }
        }

        int esc = escolherIndice(itens, "Itens avaliáveis:", "Nada para avaliar.");
        if (esc < 0) {
            return;
        }
        System.out.print("Nota (0 a 10): ");
        int nota = lerInt();
        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida!");
            return;
        }
        ((Avaliavel) itens.get(esc)).avaliar(nota);
    }

    // 6 - Realizar inspeção em veículos Inspecionavel
    static void inspecionar() {
        List<Veiculo> inspecionaveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v instanceof Inspecionavel) {
                inspecionaveis.add(v);
            }
        }

        int esc = escolherIndice(inspecionaveis, "Veículos inspecionáveis:", "Nenhum veículo para inspecionar.");
        if (esc >= 0) {
            ((Inspecionavel) inspecionaveis.get(esc)).realizarInspecao();
        }
    }

    // 7 - Remover veículos em manutenção
    static void removerEmManutencao() {
        List<Veiculo> emManutencao = veiculosComStatus(StatusVeiculo.MANUTENCAO);
        for (Veiculo v : emManutencao) {
            for (Aluguel a : alugueis) {
                a.removerVeiculo(v);
            }
        }
        veiculos.removeAll(emManutencao);
        System.out.println(emManutencao.size() + " veículo(s) removido(s).");
    }
}
