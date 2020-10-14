package fr.uvsq.tod.fraction;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static java.lang.Math.signum;
import static java.math.BigInteger.*;
import static org.junit.Assert.*;

public class FractionTest {
  private static final double EPSILON = 1E-8;

  private Fraction oneTenth;
  private Fraction oneHalf;

  @Before
  public void setup() {
    oneTenth = new Fraction(ONE, TEN);
    oneHalf = new Fraction(ONE, BigInteger.valueOf(2));
  }

  @Test
  public void shouldInitializeAFractionFromTwoNumbers() {
    Fraction one = new Fraction(ONE, ONE);
    assertEquals(ONE, one.getNumerator());
    assertEquals(ONE, one.getDenominator());
  }

  @Test
  public void shouldInitializeAFractionFromOneNumber() {
    Fraction one = new Fraction(ONE);
    assertEquals(ONE, one.getNumerator());
    assertEquals(ONE, one.getDenominator());
  }

  @Test
  public void shouldInitializeAFractionWithoutParameters() {
    Fraction zero = new Fraction();
    assertEquals(ZERO, zero.getNumerator());
    assertEquals(ONE, zero.getDenominator());
  }

  @Test
  public void shouldReturnAFractionAsADouble() {
    assertEquals(0.1, oneTenth.doubleValue(), EPSILON);
  }

  @Test
  public void shouldAddTwoFractions() {
    Fraction result = oneTenth.add(oneHalf);
    Fraction expected = new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(5));
    assertEquals(expected, result);
  }

  @Test
  public void shouldReturnAStringRepresentation() {
    assertEquals("1/10", oneTenth.toString());
  }

  @Test
  public void shouldBeEquals() {
    Fraction twoTwentieth = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(20));
    assertEquals(oneTenth, twoTwentieth);
  }

  @Test
  public void shouldVerifyEqualAndHashCodeContract() {
    Fraction twoTwentieth = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(20));
    Fraction threeThirtieth = new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(30));
    // Réflexivité
    assertEquals(oneTenth, oneTenth);
    // Symétrie
    assertEquals(oneTenth, twoTwentieth);
    assertEquals(twoTwentieth, oneTenth);
    // Transitivité
    assertEquals(oneTenth, twoTwentieth);
    assertEquals(twoTwentieth, threeThirtieth);
    assertEquals(oneTenth, threeThirtieth);
    // For any non-null reference value x, x.equals(null) should return false
    assertFalse(oneTenth.equals(null));
    //If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
    assertEquals(oneTenth.hashCode(), twoTwentieth.hashCode());
  }

  @Test
  public void shouldBeLesserThan() {
    assertTrue(oneTenth.compareTo(oneHalf) < 0);
  }

  @Test
  public void shouldVerifyCompareToContract() {
    // sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y. (This implies that x.compareTo(y) must throw an exception iff y.compareTo(x) throws an exception.)
    assertEquals(signum(oneTenth.compareTo(oneHalf)), -signum(oneHalf.compareTo(oneTenth)), EPSILON);
    // the relation is transitive: (x.compareTo(y) > 0 && y.compareTo(z) > 0) implies x.compareTo(z) > 0.
    Fraction threeQuarter = new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(4));
    assertTrue(threeQuarter.compareTo(oneHalf) > 0);
    assertTrue(oneHalf.compareTo(oneTenth) > 0);
    assertTrue(threeQuarter.compareTo(oneTenth) > 0);
    // (x.compareTo(y)==0) == (x.equals(y))
    Fraction twoTwentieth = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(20));
    assertEquals(oneTenth.compareTo(twoTwentieth) == 0, oneTenth.equals(twoTwentieth));
  }
}
