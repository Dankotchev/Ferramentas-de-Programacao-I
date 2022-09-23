package br.edu.ifsp.pep.resolucaolocadora;

import br.edu.ifsp.pep.resolucaolocadora.dao.ClienteDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.LocacaoDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.TipoVeiculoDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.VeiculoDAO;
import br.edu.ifsp.pep.resolucaolocadora.modelo.Cliente;
import br.edu.ifsp.pep.resolucaolocadora.modelo.TipoVeiculo;
import br.edu.ifsp.pep.resolucaolocadora.modelo.Veiculo;
import java.math.BigDecimal;

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
    
//    private static void locarVeiculo(){
//        Locacao locacao = new Locacao();
//        // Localizar Cliente
//        Cliente cliente = clienteDAO.procurarPorID(1);
//        
//        List<Veiculo> listaVeiculos = veiculoDAO.buscarTodos();
//        
//        List<VeiculoLocado> veiculosLocados = new ArrayList<>();
//        
//        
//        
//        
//    }
}
