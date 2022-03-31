package acoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Pessoa;

public class AcoesPessoa {

	public static void cadastrar(String nome) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}

	public static void selecionar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT p FROM Pessoa AS p", Pessoa.class);
		
		List<Pessoa> pessoas = query.getResultList();
		
		System.out.println("ID - NOME");
		for (Pessoa pessoa : pessoas) {			
			System.out.println(pessoa.getId() + " - " + pessoa.getNome());
		}
		
		emf.close();
		em.close();
	}
	
	public static void alterar(int id, String nome) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		pessoa.setNome(nome);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}
	
	public static Pessoa find(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Pessoa pessoa = em.find(Pessoa.class, id);
		em.getTransaction().commit();

		emf.close();
		em.close();
		
		return pessoa;
	}
	
	public static void remover(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-hibernate");
		EntityManager em = emf.createEntityManager();
				
		em.getTransaction().begin();
		Pessoa pessoa = em.find(Pessoa.class, id);
		em.remove(pessoa);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
	}

}
