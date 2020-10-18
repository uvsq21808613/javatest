package fr.uvsq.tod.compte;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompteTest {
  
@Test
  public void shouldCreateAnAccountWithTheSpecifiedBalance() throws Exception {
    Compte c = new Compte(100);    
    assertEquals( 100 , c.getBalance());
}

    
  
@Test 
  public void shouldCreditMyAccountWithTheSpecifiedBalance() throws Exception {
    Compte c = new Compte(100);    
    assertTrue (c.Debit(50));
  };;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
@Test 
 public void shouldWithdrawMyAccountWithTheSpecifiedBalance()throws Exception {
	Compte c =new Compte (100);
	assertTrue (c.Credit (40));
	}
@Test 
	public void shouldSendMoneyWithTheSpecifiedBalance() throws Exception {
	Compte c =new Compte (100);
	assertTrue (c.versement(50, c, c));
	assertEquals( 100 , c.getBalance());
}

}

	 

 
 