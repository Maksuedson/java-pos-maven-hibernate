package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric<E> {
	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.persist(entidade);
		transacao.commit();						
	}
	
	public E updateMerge(E entidade) {
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.merge(entidade);
		transacao.commit();	
		
		return entidade;
	}	
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
	}	

	public E pesquisar2(Long id, Class<E> entidade) {		
		E e = (E) entityManager.find(entidade, id);		
		return e;
	}
	
	public void deletarPorId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		
		entityManager.createNativeQuery("delete from "+ entidade.getClass().getSimpleName().toLowerCase()+" where id ="+id).executeUpdate();
		transacao.commit();
	}

}
