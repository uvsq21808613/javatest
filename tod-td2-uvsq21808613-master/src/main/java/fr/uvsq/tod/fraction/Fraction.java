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
  public Fraction(BigInteger numerator, BigInteger denominator) {

  }

  /**
   * Initialise un nombre rationnel avec un numérateur et le dénominateur fixé à 1.
   * @param numerator le numérateur
   */
  public Fraction(BigInteger numerator) {

  }

  /**
   * Initialise un nombre rationnel avec 0 comme numérateur et 1 comme dénominateur.
   */
  public Fraction() {

  }

  /**
   * Retourne le numérateur de la fraction.
   * @return le numérateur
   */
  public BigInteger getNumerator() {
    return null;
  }

  /**
   * Retourne le dénominateur de la fraction.
   * @return le dénominateur
   */
  public BigInteger getDenominator() {
    return null;
  }

  /**
   * Retourne la valeur de la fraction en nombre à virgule flottante.
   * @return la valeur de la fraction
   */
  public double doubleValue() {
    return 0.0;
  }

  /**
   * Retourne une fraction somme de la fraction courante et du paramètre.
   * @param aFraction la fraction à ajouter
   * @return la fraction somme
   */
  public Fraction add(Fraction aFraction) {
    return null;
  }

  /**
   * Retourn respectivement un nombre négatif, nul ou positif si l'objet courant est plus petit, égal ou plus grand que l'argument.
   * @param aFraction la fraction à comparer
   * @return un nombre négatif, nul ou positif
   */
  @Override
  public int compareTo(Fraction aFraction) {
    return 0;
  }
}
