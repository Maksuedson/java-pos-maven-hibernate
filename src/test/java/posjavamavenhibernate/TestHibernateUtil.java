package posjavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TestHibernateUtil {
	
	@Test
	public void testHibernateUtil() {
		//HibernateUtil.getEntityManager();
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setLogin("Teste");
		pessoa.setNome("Roberto");
		pessoa.setSobrenome("da Silva");
		pessoa.setEmail("roberto@gmail.com");
		pessoa.setSenha("123");
		
		daoGeneric.salvar(pessoa);
	}

}
