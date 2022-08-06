package br.edu.ifsp.pep.relacionamento;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("TR_PU");
        
        
    }
}
