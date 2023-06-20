import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManager;

public class AlunoController {
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoController() {
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
	}
	
	public void salvar(Aluno _aluno) {
		em.getTransaction().begin();		
		em.merge(_aluno);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Aluno _aluno) {
		em.getTransaction().begin();		
		Query q = em.createNamedQuery("delete aluno from aluno where matricula =" +_aluno.getMatricula());
		em.getTransaction().commit();
		emf.close();
	}
	
	
}
