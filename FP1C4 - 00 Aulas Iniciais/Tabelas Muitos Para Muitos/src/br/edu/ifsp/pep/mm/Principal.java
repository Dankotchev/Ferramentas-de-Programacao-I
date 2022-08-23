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

    private static final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private static final AcessorioDAO acessorioDAO = new AcessorioDAO();

    public static void main(String[] args) {
        inserirAcessorios();
        inserirVeiculos();
        incluirAcessorio();
        exibirVeiculos();
//        testesIniciais();
    }

    public static void inserirAcessorios() {
        String vetor[] = {"Rodas de Liga Leve", "Ar Condicionado", "Pintura Metalizada",
            "Sensor de Estacionamento", "Controle de Estabilidade", "Central Multimidia", "Teto Solar Panorâmico",
            "Faróis de LED", "Assentos Aquecidos", "Internet de Bordo"};

        Acessorio a = new Acessorio();

        for (String itens : vetor) {
            a.setDescricao(itens);
            acessorioDAO.inserir(a);
        }
    }

    public static void inserirVeiculos() {
        for (int i = 0; i < 10; i++) {
            Veiculo veiculo = new Veiculo();
            veiculo.setFabricante("#" + (i + 1));
            veiculo.setModelo("XFT " + (1234 / (i + 1)));
            veiculo.setAnoFabricacao(2022);
            veiculo.setAnoModelo(2022);
            veiculo.setValor(new BigDecimal(4530 * (i + 10)));
            veiculo.setTipoCombustivel("Gasolina");
            veiculo.setDataCadastro(new Date());
            veiculoDAO.inserir(veiculo);
        }
    }

    public static void incluirAcessorio() {
        List<Acessorio> listaAcessorios = acessorioDAO.buscar(); // Retornando do Banco todos os Acessorios cadstrados
        List<Veiculo> listaVeiculos = veiculoDAO.buscar();  // Retornando do banco todosos Veículos cadastrados
        List<Acessorio> itens = new ArrayList<>();
        int contador = 0;

        for (Veiculo veiculo : listaVeiculos) {
            itens.removeAll(itens);

            // Inserindo 3 itens acessórios de forma "diversa"
            for (int i = 0; i < 3; i++) {
                itens.add(listaAcessorios.get(contador + i));
                if (contador >= 7) {
                    contador = 0;
                } else {
                    contador++;
                }
            }
            veiculo.setAcessorios(itens);
            veiculoDAO.alterar(veiculo);
        }
    }

    public static void exibirVeiculos() {
        List<Veiculo> buscar = veiculoDAO.buscar();
        for (Veiculo v : buscar) {
            System.out.println("\nCódigo: " + v.getCodigo() + "\nModelo: " + v.getModelo()
                    + " - Fabricante: " + v.getFabricante());

            // Se houver acessórios incluidos, exibe:
            if (!v.getAcessorios().isEmpty()) {
                System.out.println("Lista de Acessórios: ");
                for (Acessorio a : v.getAcessorios()) {
                    System.out.println("\t- " + a.getDescricao());
                }
            }

        }
    }

    public static void testesIniciais() {
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
