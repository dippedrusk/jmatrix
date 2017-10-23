
import jmatrix.*;

public class Test {

  public static void main(String[] args) {
    int[][] values = new int[3][2];
    values[0][0] = 1;
    values[0][1] = 2;
    values[1][0] = 1;
    values[1][1] = 0;
    values[2][0] = 1;
    values[2][1] = 7;

    Matrix m = new Matrix(3, 2, values);
    System.out.println(m);

    try {
      Matrix m2 = new Matrix(2, 2, null);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m3 = new Matrix(-1, 2, values);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = new Matrix(1, 3, values);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = new Matrix(3, 3, values);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = new Matrix(3, 2, new int [3][]);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }
  }

}
