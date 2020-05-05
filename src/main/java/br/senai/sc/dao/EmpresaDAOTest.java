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

//        insertEmpresa();
//        editarEmpresa();
//        apagarEmpresa();
        localizarEmpresa();

        entityManager.close();
        factory.close();
    }

    public static void insertEmpresa(){

        entityManager.getTransaction().begin();

        Empresa nEmpresa = new Empresa();
        nEmpresa.setNome("AWS");

        entityManager.persist(nEmpresa);
        entityManager.getTransaction().commit();
    }


    public static void editarEmpresa(){
        
        entityManager.getTransaction().begin();
        
        Empresa nEmpresa = entityManager.find(Empresa.class,1);
        
        nEmpresa.setNome("AWS Solutions");

        entityManager.merge(nEmpresa);
        entityManager.getTransaction().commit();
    }

    public static void apagarEmpresa(){

        entityManager.getTransaction().begin();

        Empresa nEmpresa = entityManager.find(Empresa.class, 1);

        entityManager.remove(nEmpresa);
        entityManager.getTransaction().commit();
    }

    public static void localizarEmpresa(){

        entityManager.getTransaction().begin();

        Empresa nEmpresa = entityManager.find(Empresa.class, 1);

        System.out.println("Empresa Nome: " + nEmpresa.getNome());
    }
}
