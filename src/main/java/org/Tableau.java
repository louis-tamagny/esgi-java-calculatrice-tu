package org;

public class Tableau {
  public int[] tableau;

  public Tableau(int[] nouveauTableau){
    this.tableau = nouveauTableau;
  }

  public void bubbleSort(){
    int taille = this.tableau.length;
    int temporary;

    while (taille > 0) {
      for (int i = 0; i < taille - 1; i++) {
        if (this.tableau[i] > this.tableau[i+1]) {
          temporary = this.tableau[i];
          this.tableau[i] = this.tableau[i+1];
          this.tableau[i+1] = temporary;
        }
      }
      taille--;
    }
  }
}
