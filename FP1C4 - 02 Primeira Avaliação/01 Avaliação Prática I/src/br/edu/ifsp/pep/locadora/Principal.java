package br.edu.ifsp.pep.locadora;

import br.edu.ifsp.pep.locadora.dao.CarroDAO;
import br.edu.ifsp.pep.locadora.dao.ClienteDAO;
import br.edu.ifsp.pep.locadora.dao.LocadoDAO;
import br.edu.ifsp.pep.locadora.dao.MotocicletaDAO;
import br.edu.ifsp.pep.locadora.dao.VanDAO;
import br.edu.ifsp.pep.locadora.modelo.Carro;
import br.edu.ifsp.pep.locadora.modelo.Cliente;
import br.edu.ifsp.pep.locadora.modelo.Locado;
import br.edu.ifsp.pep.locadora.modelo.Motocicleta;
import br.edu.ifsp.pep.locadora.modelo.Van;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static final CarroDAO carroDAO = new CarroDAO();
    private static final MotocicletaDAO motocicletaDAO = new MotocicletaDAO();
    private static final VanDAO vanDAO = new VanDAO();
    private static final ClienteDAO clienteDAO = new ClienteDAO();
    private static final LocadoDAO locadoDAO = new LocadoDAO();

    public static void main(String[] args) {
        inserirClientes();
        inserirInstancias();
        inserirLocacao();
    }


    private static void inserirInstancias() {
        Scanner scanner = new Scanner(System.in);
        Carro carro;
        Motocicleta motocicleta;
        Van van;

        int i = 0;

        while (i > 2) {
            System.out.println("Carro:");
            carro = new Carro();
            System.out.print("Placa: ");
            carro.setPlaca(scanner.nextLine());
            System.out.print("Cidade: ");
            carro.setCidade(scanner.nextLine());
            System.out.print("Modelo: ");
            carro.setModelo(scanner.nextLine());
            System.out.print("Ano: ");
            carro.setAnoFabricacao(scanner.nextInt());
            carro.setEstado(Boolean.TRUE);
            scanner.nextLine();

            try {
                carroDAO.inserir(carro);
                i++;
            } catch (Exception ex) {
                System.out.println("Não foi possivel incluir veiculo");
                System.out.println("");
            }
        }

        i = 0;
        while (i > 2) {
            System.out.println("Carro:");
            motocicleta = new Motocicleta();
            System.out.print("Placa: ");
            motocicleta.setPlaca(scanner.nextLine());
            System.out.print("Cidade: ");
            motocicleta.setCidade(scanner.nextLine());
            System.out.print("Modelo: ");
            motocicleta.setModelo(scanner.nextLine());
            System.out.print("Ano: ");
            motocicleta.setAnoFabricacao(scanner.nextInt());
            motocicleta.setEstado(Boolean.TRUE);
            scanner.nextLine();

            try {
                motocicletaDAO.inserir(motocicleta);
                i++;
            } catch (Exception ex) {
                System.out.println("Não foi possivel incluir veiculo");
                System.out.println("");
            }
        }

        i = 0;
        while (i > 2) {
            System.out.println("Carro:");
            van = new Van();
            System.out.print("Placa: ");
            van.setPlaca(scanner.nextLine());
            System.out.print("Cidade: ");
            van.setCidade(scanner.nextLine());
            System.out.print("Modelo: ");
            van.setModelo(scanner.nextLine());
            System.out.print("Ano: ");
            van.setAnoFabricacao(scanner.nextInt());
            System.out.print("Capacidade: ");
            van.setCapacidade(scanner.nextInt());
            van.setEstado(Boolean.TRUE);
            scanner.nextLine();

            try {
                vanDAO.inserir(van);
                i++;
            } catch (Exception ex) {
                System.out.println("Não foi possivel incluir veiculo");
                System.out.println("");
            }
        }
    }

    private static void inserirClientes() {
        for (int i = 0; i < 9; i++) {
            Cliente cliente = new Cliente("Cliente #" + i,
                    "123.456.789-1" + i, "(18) 95415-250" + i);
            try {
                clienteDAO.inserir(cliente);
            } catch (Exception ex) {
                System.out.println("Não foi possivel inserir cliente");
            }
        }
    }

    private static void inserirLocacao() {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = clienteDAO.retornarTodos();
        List<Carro> listaCarros = carroDAO.retornarTodos();
        int i;

        System.out.println("Inform um cliente e veiculo:");
        i = scanner.nextInt();

        Locado locado = new Locado();
        locado.setCliente(listaClientes.get(i));
        locado.setVeiculo(listaCarros.get(i));
        locado.setDataLocado(new Date());
        locado.setValorDiaria(listaCarros.get(i).getValorDiaria());

        try {
            locadoDAO.inserir(locado);
        } catch (Exception ex) {
            System.out.println("Erro na locação");
        }

        System.out.println("valor total: " + locado.getValorDiaria());
    }
}
