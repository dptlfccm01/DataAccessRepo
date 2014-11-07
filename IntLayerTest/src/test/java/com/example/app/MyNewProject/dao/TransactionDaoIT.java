package com.example.app.MyNewProject.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.integration.dao.TransactionDao;
import com.integration.model.Transaction;

public class TransactionDaoIT {

	private static TransactionDao transactionDao;
	
	@BeforeClass
	public static void setUp() throws Exception{
		transactionDao = new TransactionDao();
	}
	
	@Test
	public void addTransaction(){
		Transaction t = new Transaction("Transaction_1", 22.22, "INCOME");
		transactionDao.addTransaction(t);
	}
	
	@Test
	public void getAllTransactions(){
		List<Transaction> list = transactionDao.getAllTransactions();
		for(Iterator<Transaction> it = list.iterator(); it.hasNext();){
			Transaction transaction = it.next();
			System.out.println("OUT> "+transaction.getTransactionId()+", "+transaction.getDescription()+", "+transaction.getValue()+", "+transaction.getTransactionType());
		}
	}
	
	
	
}
