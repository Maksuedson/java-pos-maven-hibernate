package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TestHibernateUtil {
	

	
	public void testHibernateUtil() {
		//HibernateUtil.getEntityManager();
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setLogin("Teste2");
		pessoa.setNome("Roberto2");
		pessoa.setSobrenome("da Silva");
		pessoa.setEmail("roberto2@gmail.com");
		pessoa.setSenha("123");
		
		daoGeneric.salvar(pessoa);
		System.out.println("Salvo"+pessoa);
	}
	

	
	public void testBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(3L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		System.out.println("Busca: "+pessoa);
	}
	
	
	public void testBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar2(3L, UsuarioPessoa.class);
		System.out.println(pessoa);
	}	
	
	
	public void testUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar2(3L, UsuarioPessoa.class);
		pessoa.setLogin("jose");
		pessoa.setNome("Jose");
		pessoa.setSobrenome("da Silva");
		pessoa.setEmail("jose@gmail.com");
		pessoa.setSenha("102030");
		
		daoGeneric.updateMerge(pessoa);
		System.out.println("Atualizado: "+pessoa);		
	}
	

	public void testDeletarPorId() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar2(5L, UsuarioPessoa.class);
		daoGeneric.deletarPorId(pessoa);
		System.out.println("Deletado: "+pessoa);
	}	

	@Test
	public void testLista() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> lista = daoGeneric.listar(UsuarioPessoa.class);
		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println(usuarioPessoa);
		}	
	}

}
