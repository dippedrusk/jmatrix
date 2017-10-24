
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
      Matrix m2 = new ZeroMatrix(3, 4);
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

    Matrix m = new Matrix(3, 0);
    System.out.println(m);
    m = new Matrix(0, 3);
    System.out.println(m);
    Matrix m2 = new Matrix(0, 0);
    System.out.println(m2);
    System.out.println(m.multiply(m2));
  }

  public static void testDelete() {
    Matrix m = new Matrix(2, 3);
    System.out.println(m.fillRandom(5));
    m.inplaceFillRandom(3,10);
    System.out.println(m);
    System.out.println(m.delColumn(0));
    System.out.println(m.delColumn(1));
    System.out.println(m.delColumn(2));
    System.out.println(m.delRow(0));
    System.out.println(m.delRow(1));
    try {
      System.out.println(m.delRow(2));
    }
    catch (RuntimeException e) {
      System.err.println("DeleteException: " + e.getMessage());
    }
  }

  public static void testPow() {
    Matrix m = new IdentityMatrix(3);
    m.inplaceFillRandom(-5,5);
    System.out.println(m.pow(0));
    System.out.println(m.pow(1));
    System.out.println(m.pow(2));
    m = new Matrix(3, 2);
    try {
      System.out.println(m.pow(0));
    }
    catch (RuntimeException e) {
      System.err.println("PowException: " + e.getMessage());
    }
    Matrix empty = new IdentityMatrix(0);
    try {
      System.out.println(empty.pow(0));
    }
    catch (RuntimeException e) {
      System.err.println("PowException: " + e.getMessage());
    }
    try {
      System.out.println(empty.pow(1));
    }
    catch (RuntimeException e) {
      System.err.println("PowException: " + e.getMessage());
    }
    try {
      System.out.println(empty.pow(2));
    }
    catch (RuntimeException e) {
      System.err.println("PowException: " + e.getMessage());
    }
  }

  public static void testDeterminant() {
    int[][] detvals = {{2, 0, 7, 0, 8}, {0, 3, 0, 0, 0}, {0, 4, 1, 0, 0}, {0, 8, 9, 10, 2}, {1, 1, 3, 2, 5}};
    Matrix m = new Matrix(5, 5, detvals);
    System.out.println(m);
    System.out.println(m.determinant());

    Matrix m2 = new Matrix(0, 0);
    System.out.println(m2);
    try {
      System.out.println(m2.determinant());
    }
    catch (RuntimeException e) {
      System.err.println("DeterminantException: " + e.getMessage());
    }
  }

  public static void testAbs() {
    Matrix m = new IdentityMatrix(3);
    m.inplaceFillRandom(-5,5);
    System.out.println(m);
    System.out.println(m.abs());
  }

  public static void main(String[] args) {
    //transposed.set(neg);
    // test for shallow / deep copying with set

    /*
    Test.testMatrixInput();
    Test.testTranspose();
    Test.testNeg();
    Test.testMultiply();
    Test.testDelete();
    Test.testPow();
    Test.testDeterminant();
    Test.testAbs();
    */

  }

}
