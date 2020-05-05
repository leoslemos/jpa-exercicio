package br.senai.sc.dao;

import br.senai.sc.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpresaDAOTest {

    public static EntityManagerFactory factory;
    public static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Exercicio");
        entityManager = factory.createEntityManager();

        insertEmpresa();

        entityManager.close();
        factory.close();
    }

    public static void insertEmpresa(){

        entityManager.getTransaction().begin();

        Empresa newEmpresa = new Empresa();
        newEmpresa.setNome("AWS");

        entityManager.persist(newEmpresa);
        entityManager.getTransaction().commit();
    }
}
