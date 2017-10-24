
import jmatrix.*;

public class Test {

  public static void testMatrixInput() {
    System.out.println("Testing matrix input.");

    int[][] values = new int[3][2];
    values[0][0] = 1;
    values[0][1] = 2;
    values[1][0] = 1;
    values[1][1] = 0;
    values[2][0] = 1;
    values[2][1] = 7;

    int[][] nullvalues2d = null;
    int[] nullvalues1d = null;

    Matrix m = new Matrix(3, 2, values);
    System.out.println(m);

    try {
      Matrix m2 = new Matrix(2, 2, nullvalues2d);
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

    try {
      Matrix m2 = new Matrix(3, 2, nullvalues1d);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = Matrix.zero(3, 4);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

  }

  public static void testTranspose() {
    int[][] values = new int[3][2];
    values[0][0] = 1;
    values[0][1] = 2;
    values[1][0] = -1;
    values[1][1] = 0;
    values[2][0] = 11;
    values[2][1] = 7;

    Matrix m = new Matrix(3, 2, values);
    System.out.println(m);
    Matrix transposed = m.T();
    System.out.println(transposed);
    transposed.inplaceTranspose();
    System.out.println(transposed);
  }

  public static void testNeg() {
    int[][] values = new int[3][2];
    values[0][0] = 1;
    values[0][1] = 2;
    values[1][0] = -1;
    values[1][1] = 0;
    values[2][0] = 11;
    values[2][1] = 7;

    Matrix m = new Matrix(3, 2, values);
    System.out.println(m);
    Matrix transposed = m.T();
    System.out.println(transposed);
    transposed.inplaceTranspose();
    System.out.println(transposed);
    Matrix neg = transposed.neg();
    System.out.println(neg);
  }

  public static void testMultiply() {
    int[] m1vals = {-1, 3, -4};
    Matrix matrix1 = new Matrix(1, 3, m1vals);
    System.out.println(matrix1);

    int[][] m2vals = {{4, -6}, {7, 1}, {3, 2}};
    Matrix matrix2 = new Matrix(3, 2, m2vals);
    System.out.println(matrix2);

    System.out.println(matrix1.multiply(matrix2));
  }

  public static void main(String[] args) {
    //Test.testMatrixInput();
    //Test.testTranspose();
    //Test.testNeg();

    //transposed.set(neg);
    // test for shallow / deep copying with set

    Test.testMultiply();

  }

}
