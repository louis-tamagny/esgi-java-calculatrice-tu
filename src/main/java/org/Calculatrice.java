package org;

import java.util.Scanner;

public class Calculatrice {
  public float addition(float a, float b) {
    return a + b;
  }

  public float soustraction(float a, float b) {
    return a - b;
  }

  public float multiplication(float a, float b) {
    return a * b;
  }

  public float division(float a, float b) throws ArithmeticException {
    if (b == 0) {
      throw new ArithmeticException("Erreur: division par zero");
    }
    return a / b;
  }

  public float operation(String operationString) throws Exception, NumberFormatException {
    String[] elements = operationString.split(" ");

    if (elements.length != 3) {
      throw new Exception("Error: 3 elements separated by spaces are needed");
    }
    float a = Float.parseFloat(elements[0]);
    float b = Float.parseFloat(elements[2]);

    float result;

    switch (elements[1]) {
      case "+":
        result = this.addition(a, b);
        break;

      case "-":
        result = this.soustraction(a, b);
        break;

      case "/":
        result = this.division(a, b);
        break;

      case "*":
        result = this.multiplication(a, b);
        break;

      default:
        throw new Exception("Error: operator not recognised");
    }

    return result;
  }

  public void getInputs() throws NumberFormatException, Exception {
    Scanner scanner = new Scanner(System.in);
    String operationString = "init";

    System.out.println("Enter operation:");
    operationString = scanner.nextLine();

    while (operationString != "") {
      try {
        System.out.println(Float.toString(this.operation(operationString)));
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
      System.out.println("Enter operation (press enter to exit):");
      operationString = scanner.nextLine();

    }
    scanner.close();
  }
}
