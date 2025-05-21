package org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {
    private Calculatrice calculatrice;

    @BeforeEach
    public void setUp(){
        this.calculatrice = new Calculatrice();
    }

    @Test
    public void testAddition() {
        assertEquals(3, this.calculatrice.addition(1, 2));
        assertEquals(10, this.calculatrice.addition(5, 5));
    }

    @Test
    public void testSoustraction(){
        assertEquals(-1, this.calculatrice.soustraction(1, 2));
        assertEquals(2, this.calculatrice.soustraction(-10, -12));
    }

    @Test
    public void testMultiplication(){
      assertEquals(2, this.calculatrice.multiplication(1, 2));
      assertEquals(0, this.calculatrice.multiplication(0, 2));
      assertEquals(-15, this.calculatrice.multiplication(-5, 3));
      assertEquals(15, this.calculatrice.multiplication(-5, -3));

    }

    @Test
    public void testDivision(){
      assertEquals(0.5, this.calculatrice.division(1, 2));
      assertEquals(5, this.calculatrice.division(10, 2));
      assertEquals(0, this.calculatrice.division(0, 10));

      ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {calculatrice.division(3, 0);});
      assertEquals("Erreur: division par zero", exception.getMessage());
    }

    @Test
    public void testOperation() throws NumberFormatException, Exception{
      assertEquals(3, this.calculatrice.operation("1 + 2"));
      assertEquals(-1, this.calculatrice.operation("9 - 10"));

      assertThrows(NumberFormatException.class, () -> {this.calculatrice.operation("2 + aze");});

      Exception exc = assertThrows(Exception.class, () -> {this.calculatrice.operation("1+2");});
      assertEquals("Error: 3 elements separated by spaces are needed", exc.getMessage());

      exc = assertThrows(Exception.class, () -> {this.calculatrice.operation("1 % 2");});
      assertEquals("Error: operator not recognised", exc.getMessage());

    }
}
