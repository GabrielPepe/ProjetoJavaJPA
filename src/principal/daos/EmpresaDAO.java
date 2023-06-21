package principal.daos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import principal.models.Empresa;

public class EmpresaDAO implements DAO <Empresa> {

	EntityManagerFactory emf;
	EntityManager em;
	
	public EmpresaDAO() {
		emf = Persistence.createEntityManagerFactory("testeaula");
		em = emf.createEntityManager();
	}
	
	
	@Override
	public Empresa buscarPorId(Integer id) {
		Empresa empresa = em.find(Empresa.class, id);
		return empresa;
	}

	@Override
	public List<Empresa> listar() {
		List <Empresa> empresas = em.createQuery("From Empresa", Empresa.class).getResultList();
		return empresas;
	}

	@Override
	public Empresa salvar(Empresa entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		return entidade;
	}

	@Override
	public Empresa atualizar(Empresa entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		return entidade;
	}

	@Override
	public void excluir(Integer id) {
		excluir(buscarPorId(id));
	}
	
	public void excluir(Empresa empresa) {
		em.getTransaction().begin();
		em.remove(empresa);
		em.getTransaction().commit();
	}

	public void close() {
		em.close();
		emf.close();
	}
}
