package br.edu.ifsp.pep.mm;

import br.edu.ifsp.pep.mm.dao.AcessorioDAO;
import br.edu.ifsp.pep.mm.modelo.Acessorio;
import br.edu.ifsp.pep.mm.modelo.Veiculo;
import br.edu.ifsp.pep.mm.dao.VeiculoDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {
    
    public static void main(String[] args) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        AcessorioDAO acessorioDAO = new AcessorioDAO();
        
        Acessorio roda = new Acessorio();
        roda.setDescricao("Rodas de liga leve");
        acessorioDAO.inserir(roda);
        
        Acessorio sensor = new Acessorio();
        sensor.setDescricao("Sensores de estacionamento");
        acessorioDAO.inserir(sensor);
        
        Acessorio mp3 = new Acessorio();
        mp3.setDescricao("MP3 Player");
        acessorioDAO.inserir(mp3);
        
        Acessorio pintura = new Acessorio();
        pintura.setDescricao("Pintura metalizada");
        acessorioDAO.inserir(pintura);
        
        Veiculo veiculo1 = new Veiculo();
        List<Acessorio> listaAcesssorio = new ArrayList<>();
        veiculo1.setFabricante("VW");
        veiculo1.setModelo("Gol");
        veiculo1.setAnoFabricacao(2018);
        veiculo1.setAnoModelo(2018);
        veiculo1.setValor(new BigDecimal(17200));
        veiculo1.setTipoCombustivel("Biocombustivel");
        veiculo1.setDataCadastro(new Date());
        listaAcesssorio.add(roda);
        listaAcesssorio.add(mp3);
        veiculo1.setAcessorios(listaAcesssorio);
        
        veiculoDAO.inserir(veiculo1);
        
//        veiculo1.getAcessorios().add(roda);
//        veiculo1.getAcessorios().add(mp3);

        listaAcesssorio.removeAll(listaAcesssorio);
        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("Hyundai");
        veiculo2.setModelo("i30");
        veiculo2.setAnoFabricacao(2019);
        veiculo2.setAnoModelo(2019);
        veiculo2.setValor(new BigDecimal(53500));
        veiculo2.setTipoCombustivel("Gasolina");
        veiculo2.setDataCadastro(new Date());
        listaAcesssorio.add(roda);
        listaAcesssorio.add(sensor);
        listaAcesssorio.add(mp3);
        listaAcesssorio.add(pintura);
        veiculo2.setAcessorios(listaAcesssorio);
        
//        veiculo2.getAcessorios().add(roda);
//        veiculo2.getAcessorios().add(sensor);
//        veiculo2.getAcessorios().add(mp3);
//        veiculo2.getAcessorios().add(pintura);

        veiculoDAO.inserir(veiculo2);
    }
    
}
