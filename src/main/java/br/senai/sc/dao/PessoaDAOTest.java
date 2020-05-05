package br.senai.sc.dao;

import br.senai.sc.model.Empresa;
import br.senai.sc.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Exercicio");
        entityManager = factory.createEntityManager();

        insertPessoa();

        entityManager.close();
        factory.close();
    }

    public static void insertPessoa(){

        entityManager.getTransaction().begin();

        Pessoa newPessoa = new Pessoa();
        newPessoa.setNome("Rolando");
        newPessoa.setSobrenome("Escadabaixo");

        Empresa newEmpresa = entityManager.find(Empresa.class,1);
        newPessoa.setEmpesa(newEmpresa);

        entityManager.persist(newPessoa);
        entityManager.getTransaction().commit();
    }

}
