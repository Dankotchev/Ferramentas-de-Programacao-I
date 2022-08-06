package br.edu.ifsp.pep.aulainaugural;

import br.edu.ifsp.pep.aulainaugural.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("FP1C4AulaInauguralPU");

        // Pessoas sendo criadas para os testes ::
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setDataNascimento(new Date());
        pessoa1.setNome("Danilo");
        pessoa1.setSalario(new BigDecimal(3000.5689));   // 0000.d pois o valor é um Double
        pessoa1.setEmail("danilo@email.com");
        pessoa1.setLogradouro("Rua Natal");
        pessoa1.setNumero(1657);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento(new Date());
        pessoa2.setNome("Daniele");
        pessoa2.setSalario(new BigDecimal(8989.8989));
        pessoa2.setEmail("daniele@email.com");
        pessoa2.setLogradouro("Rua Natal");
        pessoa2.setNumero(5716);

        // Criando
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();                                            // Iniciar uma transação

        em.persist(pessoa1);     // Insert (lá no Banco de Dados)
        em.persist(pessoa2);
//        em.merge(pessoa1);        // Update se objeto existir, senão Insert

        em.getTransaction().commit();                                           // Finaliza uma transação
    }
}
