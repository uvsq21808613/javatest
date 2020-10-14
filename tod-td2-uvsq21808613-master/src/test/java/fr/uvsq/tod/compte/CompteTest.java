package fr.uvsq.tod.compte;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompteTest {
  
@Test
  public void shouldCreateAnAccountWithTheSpecifiedBalance() throws Exception {
    Compte c = new Compte(-100);    
    assertEquals( 100 , c.getBalance());
  }
@Test 
  public void shouldCreditMyAccountWithTheSpecifiedBalance() throws Exception {
	
}
}

	 

 
 