package br.senai.sc.dao;

import br.senai.sc.model.Empresa;
import br.senai.sc.model.Pessoa;
import org.hibernate.collection.internal.PersistentSortedMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAOTest {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        factory = Persistence.createEntityManagerFactory("Jpa_Exercicio");
        entityManager = factory.createEntityManager();

        inserirPessoa();
//        editarPessoa();
//        apagarPessoa();
        localizarPessoa();

        entityManager.close();
        factory.close();
    }

    public static void inserirPessoa(){

        entityManager.getTransaction().begin();

        Pessoa nPessoa = new Pessoa();
        nPessoa.setNome("Rolando");
        nPessoa.setSobrenome("Escadabaixo");
        nPessoa.setCpf("12345678912");

        Empresa nEmpresa = entityManager.find(Empresa.class,1);
        nPessoa.setEmpesa(nEmpresa);

        entityManager.persist(nPessoa);
        entityManager.getTransaction().commit();
    }

    public static void editarPessoa(){

        entityManager.getTransaction().begin();

        Pessoa nPessoa = entityManager.find(Pessoa.class, 1);
        nPessoa.setSobrenome("Escadacima");

        entityManager.merge(nPessoa);
        entityManager.getTransaction().commit();
    }

    public static void apagarPessoa(){

        entityManager.getTransaction().begin();

        Pessoa nPessoa = entityManager.find(Pessoa.class,1);

        entityManager.remove(nPessoa);
        entityManager.getTransaction().commit();
    }

    public static void localizarPessoa(){

        entityManager.getTransaction().begin();

        Pessoa nPessoa = entityManager.find(Pessoa.class, 1);

        System.out.println("Nome: " + nPessoa.getNome());
        System.out.println("Sobrenome: " + nPessoa.getSobrenome());
        System.out.println("CPF: " + nPessoa.getCpf());
        System.out.println("Empresa: " + nPessoa.getEmpesa().getNome());
    }
}