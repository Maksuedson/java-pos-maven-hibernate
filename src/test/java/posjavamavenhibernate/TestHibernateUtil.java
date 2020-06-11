package posjavamavenhibernate;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TestHibernateUtil {
	

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
	

	public void testBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(3L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		System.out.println(pessoa);
	}
	
	@Test
	public void testBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar2(3L, UsuarioPessoa.class);
		System.out.println(pessoa);
	}	
	


}
