package fr.uvsq.tod.compte;

/**
 * La classe <code>Compte</code> repr√©sente un compte bancaire.
 *
 * @author hal
 * @version 2020
 */
public class Compte {
	public int  solde ;
	public Compte(int initialBalance) throws Exception { 
		
	// verification si le solde est positif 	
	  if  ( initialBalance < 0) {
		  throw new Exception("solde negatif");
	  }
	  
	  this.solde = initialBalance ;
  }
	
	public boolean    Debit (int  Somme ) throws Exception  { 
		
		
		if(Somme < 0) {
			throw new Exception("OpÈration echouÈe la somme mise est negative ");
		}
			
		this.solde = solde + Somme ;	
		return true ;
		
	}
	
	
	public boolean Credit (int  Money) throws Exception  {
		if ( (Money >solde ) || (Money <0) ) {
			throw new Exception ( "le solde du compte est insufisant  ");
			}
			
			this.solde =solde -Money ;
			return true ;
	}
	
	public boolean versement (int montant ,Compte  Binificaire ,Compte  Crediteur  ) throws Exception   {
		if (montant > solde ) {
			throw new Exception ( " verifiez votre solde ");
			
		}
		Binificaire.solde = Binificaire.solde +montant ;
		Crediteur.solde = Crediteur.solde -montant ;
		System.out.println("versement effectuer  ,votre solde est " + this.solde );
		return true ;
	}
	
 
  public int  getBalance(  ) {

	  return solde ;
	  
  }
}
