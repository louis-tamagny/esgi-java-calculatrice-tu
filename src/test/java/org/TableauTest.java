package org;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TableauTest {
  @Test
  public void testTri(){
    int[] intTableau = {2, 0, -2, 6, 7, 10, 1};
    int[] expectedTableau = { -2, 0, 1,  2, 6, 7, 10};

    Tableau tableau = new Tableau(intTableau);

    tableau.bubbleSort();

    assertArrayEquals(expectedTableau, tableau.tableau);

    tableau.bubbleSort();

    assertArrayEquals(expectedTableau, tableau.tableau);

    int[] intTableauVide = {};
    Tableau tableauVide = new Tableau(intTableauVide);
    tableauVide.bubbleSort();
    assertArrayEquals(intTableauVide, tableauVide.tableau);
  }

}
