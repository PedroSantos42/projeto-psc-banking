package dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaCorrenteDAO;
import model.Pessoa;
import model.conta.ContaCorrente;
import util.UtilJPA;

public class ContaCorrenteDAOTests {

	private ContaCorrenteDAO _dao = new ContaCorrenteDAO();
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Starting Conta DAO Tests...");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing Conta DAO Tests...");
//		UtilJPA.closeEntityManagerFactory();
	}
	
	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		int id = 1; 
		int numeroConta = 1;
		double saldo = 100.0;
		String situacao = "a";
		
		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());
		
		ContaCorrente conta = new ContaCorrente(id, numeroConta, saldo, situacao, p);
		
		// act
		_dao.add(conta);
		
		ContaCorrente conta2 = (ContaCorrente) _dao.listByObject(conta);
		
		// assert
		assertEquals(conta.toString(), conta2.toString());
	}
	
	@Test
	public void add_SecondAccountToSamePerson_MaintainSinglePessoaRecord() {
		// arrange
		int id = 2;
		int numeroConta = 2;
		double saldo = 250;
		String situacao = "b";
		
		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());
		
		ContaCorrente conta = new ContaCorrente(id, numeroConta, saldo, situacao, p);
		
		// act
		_dao.add(conta);
		
		ContaCorrente conta2 = (ContaCorrente) _dao.listByObject(conta);
		// assert
		assertEquals(conta.toString(), conta2.toString());
	}
}
