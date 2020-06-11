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

}
