package fr.uvsq.tod.fraction;

import java.math.BigInteger;

/**
 * La classe <code>Fraction</code> représente un nombre rationnel.
 *
 * @author hal
 * @version 2020
 */
public class Fraction implements Comparable<Fraction> {
  /**
   * Initialise un nombre rationnel avec un numérateur et un dénominateur.
   * @param numerator le numérateur
   * @param denominator le dénominateur
   */
	
	BigInteger numerator;
	BigInteger denominator;
  public Fraction(BigInteger numerator, BigInteger denominator) {
	  this.numerator = numerator ;
	  this.denominator = denominator;
  }


  public Fraction(BigInteger numerator) {
	  this.numerator = numerator ;
	  this.denominator = BigInteger.valueOf(1);
  }

  /**
   * Initialise un nombre rationnel avec 0 comme numérateur et 1 comme dénominateur.
   */
  public Fraction() {
	  this.numerator =  BigInteger.valueOf(0);
	  this.denominator = BigInteger.valueOf(1);

  }

  /**
   * Retourne le numérateur de la fraction.
   * @return le numérateur
   */
  public BigInteger getNumerator() {
    return this.numerator;
  }

  /**
   * Retourne le dénominateur de la fraction.
   * @return le dénominateur
   */
  public BigInteger getDenominator() {
    return this.denominator;
  }

  /**
   * Retourne la valeur de la fraction en nombre à virgule flottante.
   * @return la valeur de la fraction
   */
  public double doubleValue() {
    return this.numerator.doubleValue()/this.denominator.doubleValue();
  }

  /**
   * Retourne une fraction somme de la fraction courante et du paramètre.
   * @param aFraction la fraction à ajouter
   * @return la fraction somme
   */
  public Fraction add(Fraction aFraction) {
	Fraction tmp = new Fraction(this.numerator.multiply(aFraction.denominator).add(aFraction.numerator.multiply(this.denominator)) , this.denominator.multiply(aFraction.denominator));
    return tmp;
  }
  public String toString() {
	  return this.numerator.toString()+"/"+this.denominator.toString();
	  
  }

  /**
   * Retourn respectivement un nombre négatif, nul ou positif si l'objet courant est plus petit, égal ou plus grand que l'argument.
   * @param aFraction la fraction à comparer
   * @return un nombre négatif, nul ou positif
   */
  @Override
  public boolean equals(Object obj) { 
      if (obj != null && this.getClass().equals(obj.getClass())) { 
    	  {
    		  if(((Fraction) obj).doubleValue() == this.doubleValue() ) {
    			  return true;
    		  }
    	  } 
      } 
      return false; 
    }
  
  public int hashCode() {
	  return (""+this.doubleValue()).hashCode();
  }
  @Override
  public int compareTo(Fraction aFraction) {
	double c = this.doubleValue()/aFraction.doubleValue();
	int a = (int) c ;
	if (c > 1) {
		return (int) c ;
	}
	else if (c == 1) {
		return 0 ;
	}
	else {
		return (int) (1/c) * -1 ;
	}
    
  }
}
