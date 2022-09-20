package br.edu.ifsp.pep.resolucaolocadora;

import br.edu.ifsp.pep.resolucaolocadora.dao.TipoVeiculoDAO;
import br.edu.ifsp.pep.resolucaolocadora.dao.VeiculoDAO;
import br.edu.ifsp.pep.resolucaolocadora.modelo.TipoVeiculo;
import br.edu.ifsp.pep.resolucaolocadora.modelo.Veiculo;
import java.math.BigDecimal;

public class Principal {

    private static final VeiculoDAO veiculoDAO = new VeiculoDAO();

    public static void main(String[] args) {
        adicionarVeiculo();
    }

    private static void adicionarVeiculo() {
        TipoVeiculoDAO tipoVeiculoDAO = new TipoVeiculoDAO();
        TipoVeiculo tipoCarro = new TipoVeiculo("Carro", new BigDecimal(300));
        TipoVeiculo tipoMoto = new TipoVeiculo("Motocicleta", new BigDecimal(140));
        TipoVeiculo tipoVan = new TipoVeiculo("Van", new BigDecimal(500));

        tipoVeiculoDAO.inserir(tipoCarro);
        tipoVeiculoDAO.inserir(tipoMoto);
        tipoVeiculoDAO.inserir(tipoVan);

        Veiculo veiculo1 = new Veiculo("ASD-1234", "Epitácio", "Gol", 2004, tipoCarro);
        Veiculo veiculo2 = new Veiculo("DEF-1254", "Epitácio", "Celta", 2022, tipoCarro);

        veiculoDAO.inserir(veiculo1);
        veiculoDAO.inserir(veiculo2);

        veiculo1 = new Veiculo("LJK-6542", "Caiua", "Van Grande", 2010, tipoVan);
        veiculo2 = new Veiculo("GHT-9876", "Epitácio", "Fazer", 2015, tipoMoto);

        veiculoDAO.inserir(veiculo1);
        veiculoDAO.inserir(veiculo2);
        
        veiculo1 = new Veiculo("LJK-0987", "Epitácio", "RE Meteor 350", 2022, tipoMoto);
//        veiculo2 = new Veiculo("GHT-9876", "Epitácio", "Van Pequena", 2015, tipoVan);

        veiculoDAO.inserir(veiculo1);
//        veiculoDAO.inserir(veiculo2);

    }
}
