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

//        Pessoa pessoa = new Pessoa();
//        pessoa.setDataNascimento(new Date());
//        pessoa.setNome("Danilo");
//        pessoa.setSalario(3000.656);                                            // 0000.d pois o valor é um Double
        Pessoa pessoa = new Pessoa("Danilo", new BigDecimal(3520.6589), new Date());

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();                                            // Iniciar uma transação

//        em.persist(pessoa);     // Insert (lá no Banco de Dados)
        em.merge(pessoa);       // Update se objeto existir, senão Insert

        em.getTransaction().commit();                                           // Finaliza uma transação
    }
}
