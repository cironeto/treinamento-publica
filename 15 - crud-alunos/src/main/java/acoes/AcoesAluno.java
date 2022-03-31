package acoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Aluno;



public class AcoesAluno {

	public static void cadastrar(Aluno aluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-alunos-hibernate");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}

	public static List<Aluno> selecionar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-alunos-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT a FROM Aluno AS a", Aluno.class);
		
		List<Aluno> alunos = query.getResultList();
		
		emf.close();
		em.close();
		
		return alunos;
	}
	
	public static void alterar(int id, Aluno aluno) {
		aluno.setId(id);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-alunos-hibernate");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();

		emf.close();
		em.close();
	}
	
	public static Aluno find(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-alunos-hibernate");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Aluno aluno = em.find(Aluno.class, id);
		em.getTransaction().commit();

		emf.close();
		em.close();
		
		return aluno;
	}
	
	public static void remover(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-alunos-hibernate");
		EntityManager em = emf.createEntityManager();
				
		em.getTransaction().begin();
		Aluno aluno = em.find(Aluno.class, id);
		em.remove(aluno);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
	}

}
