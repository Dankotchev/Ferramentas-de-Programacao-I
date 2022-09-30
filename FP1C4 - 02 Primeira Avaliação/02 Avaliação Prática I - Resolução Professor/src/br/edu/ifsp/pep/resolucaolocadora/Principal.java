package br.edu.ifsp.pep.resolucaolocadora;

import br.edu.ifsp.pep.resolucaolocadora.dao.ClienteDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.LocacaoDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.TipoVeiculoDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.VeiculoDAO;
import br.edu.ifsp.pep.resolucaolocadora.modelo.Cliente;
import br.edu.ifsp.pep.resolucaolocadora.modelo.Locacao;
import br.edu.ifsp.pep.resolucaolocadora.modelo.TipoVeiculo;
import br.edu.ifsp.pep.resolucaolocadora.modelo.Veiculo;
import br.edu.ifsp.pep.resolucaolocadora.modelo.VeiculoLocado;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {

    private static final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    private static final LocacaoDAO locacaoDAO = new LocacaoDAO();

    public static void main(String[] args) {
        adicionarVeiculo();
        adicionarClientes();
    }

    private static void inserirVeiculo(Veiculo veiculo) {
        try {
            veiculoDAO.inserir(veiculo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void adicionarVeiculo() {
        TipoVeiculoDAO tipoVeiculoDAO = new TipoVeiculoDAO();
        TipoVeiculo tipoCarro = new TipoVeiculo("Carro", new BigDecimal(300));
        TipoVeiculo tipoMoto = new TipoVeiculo("Motocicleta", new BigDecimal(140));
        TipoVeiculo tipoVan = new TipoVeiculo("Van", new BigDecimal(500));

        try {
            tipoVeiculoDAO.inserir(tipoCarro);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            tipoVeiculoDAO.inserir(tipoMoto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            tipoVeiculoDAO.inserir(tipoVan);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Veiculo veiculo1 = new Veiculo("ASD-1234", "Epitácio", "Gol", 2004, tipoCarro);
        Veiculo veiculo2 = new Veiculo("DEF-1254", "Epitácio", "Celta", 2022, tipoCarro);

        inserirVeiculo(veiculo1);
        inserirVeiculo(veiculo2);

        veiculo1 = new Veiculo("LJK-6542", "Caiua", "Van Grande", 2010, tipoVan);
        veiculo2 = new Veiculo("GHT-9876", "Epitácio", "Fazer", 2015, tipoMoto);

        inserirVeiculo(veiculo1);
        inserirVeiculo(veiculo2);

        veiculo1 = new Veiculo("LJK-0987", "Epitácio", "RE Meteor 350", 2022, tipoMoto);
        veiculo2 = new Veiculo("GHT-9876", "Epitácio", "Van Pequena", 2015, tipoVan);

        inserirVeiculo(veiculo1);
        inserirVeiculo(veiculo2);
    }

    private static void adicionarClientes() {
        for (int i = 0; i < 10; i++) {
            try {
                clienteDAO.inserir(new Cliente("Cliente #" + i, "123.432.543-0" + i));
            } catch (Exception ex) {
                System.out.println("Cliente já cadastrado");
            }
        }
    }

    private static void locarVeiculo() {
        // Localizar Cliente
        Cliente cliente = clienteDAO.procurarPorID(1);

        // Buscar todos os veículos registrados
        List<Veiculo> listaVeiculos = veiculoDAO.buscarTodos();

        // Objeto locado
        Locacao locacao = new Locacao(new Date(), cliente);

        List<VeiculoLocado> veiculosLocados = new ArrayList<>();

        VeiculoLocado veiculoLocado = new VeiculoLocado(
                listaVeiculos.get(0), locacao, 5);
        veiculosLocados.add(veiculoLocado);

        veiculoLocado = new VeiculoLocado(listaVeiculos.get(1), locacao, 7);
        veiculosLocados.add(veiculoLocado);

        locacao.setVeiculosLocados(listaVeiculos);

        try {
            locacaoDAO.inserir(locacao);
            double diariaVeiculo0 = listaVeiculos.get(0)
                    .getTipo().getValorDiaria().doubleValue() * 5;

            double diariaVeiculo1 = listaVeiculos.get(1)
                    .getTipo().getValorDiaria().doubleValue() * 7;

            System.out.println("Valor da locação do veículo 1: "
                    + diariaVeiculo0);
            System.out.println("Valor da locação do veículo 2: "
                    + diariaVeiculo1);
            System.out.println("Total da locação: "
                    + (diariaVeiculo0 + diariaVeiculo1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void exibirVeiculosDisponiveisParaLocacao() {
        List<Veiculo> listaVeiculos = veiculoDAO
                .buscarVeiculosDisponiveisParaLocacao();
        
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo);
        }
    }
}
