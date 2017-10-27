
import jmatrix.*;
import java.util.Random;
import java.lang.Math;

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
    try {
      System.out.println(m.multiply(m2));
    }
    catch (RuntimeException e) {
      System.err.println("MultiplyException: " + e.getMessage());
    }

  }

  public static void testDelete() {
    Matrix m = new Matrix(2, 3);
    System.out.println(m.fillRandomInt(5));
    m.inplaceFillRandomInt(3,10);
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
    m.inplaceFillRandomInt(-5,5);
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
    m.inplaceFillRandomInt(-5,5);
    System.out.println(m);
    System.out.println(m.abs());
  }

  public static void testEF() {
   /*
    * Condition 1 test cases: empty matrix, zero matrix, identity matrix (pass),
    * no non zero rows matrix, zero rows above nonzero rows,
    * non zero rows above zero rows (pass), mixed
    */
    Matrix m = new IdentityMatrix(3);
    System.out.println(m);
    System.out.println(m.isEF());

    m = new ZeroMatrix(3, 4);
    System.out.println(m);
    System.out.println(m.isEF());

    m = new ZeroMatrix(0, 0);
    System.out.println(m);
    System.out.println(m.isEF());

    m = new Matrix(5, 4);
    m.inplaceFillRandomInt(2,17);
    System.out.println(m);
    System.out.println(m.isEF());

    int[] row = {0, 0, 0, 0};
    m.inplaceAddRow(row);
    System.out.println(m);
    System.out.println(m.isEF());

    m.inplaceAddRow(row);
    System.out.println(m);
    System.out.println(m.isEF());

    int[] nonzerorow = {2, 0, 0, 0};
    m.inplaceAddRow(nonzerorow);
    System.out.println(m);
    System.out.println(m.isEF());

    int[] nonzerorow2 = {0, 0, 0, 2};
    m.inplaceAddRow(nonzerorow2);
    System.out.println(m);
    System.out.println(m.isEF());

    /*
     * Condition 2, 3 test cases
     */
    m = new IdentityMatrix(3);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isEF());

    m = new IdentityMatrix(3);
    m.set(1, 1, 0);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isEF());

    m = new ZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    System.out.println(m);
    System.out.println(m.isEF());

    m = new ZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    m.set(2, 2, 1);
    System.out.println(m);
    System.out.println(m.isEF());
  }

  public static void testRREF() {
    Matrix m = new IdentityMatrix(3);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new ZeroMatrix(3, 4);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new ZeroMatrix(0, 0);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new IdentityMatrix(3);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new IdentityMatrix(3);
    m.set(1, 1, 0);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new ZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new ZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    m.set(0, 2, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = new ZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(0, 1, 1);
    m.set(1, 2, 1);
    System.out.println(m);
    System.out.println(m.isRREF());
  }

  public static void testEchelonForm() {
    Matrix m = new Matrix(3, 4);
    m.inplaceFillRandomInt(2, 9);
    System.out.println(m);
    m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values = {{7,6,5}, {6,4,4}, {6,8,5}};
    m = new Matrix(3, 3, values);
    System.out.println(m);
    m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values2 = {{3,3,7}, {7,3,2}, {3,3,7}};
    m = new Matrix(3, 3, values2);
    System.out.println(m);
    m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values3 = {{4,2,6}, {4,4,8}, {6,7,3}};
    m = new Matrix(3, 3, values3);
    System.out.println(m);
    m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values4 = {{6,8,8}, {6,3,4}, {6,2,4}};
    m = new Matrix(3, 3, values4);
    System.out.println(m);
    m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());
  }

  public static void testInverse() {
    // preliminary testing with pre-augmented matrices
    int[][] values3 = {{4,2,6}, {4,4,8}, {6,7,3}};
    Matrix m = new Matrix(3, 3, values3);
    System.out.println(m);
    System.out.println(m.inverse());

    int[][] values4 = {{6,8,8}, {6,3,4}, {6,2,4}};
    m = new Matrix(3, 3, values4);
    System.out.println(m);
    System.out.println(m.inverse());
    System.out.println();

    for (int i = 0; i < 200; i++) {
      Random rand = new Random();
      int dim = rand.nextInt(10);
      m = new Matrix(dim, dim);
      m.inplaceFillRandomInt(-5, 5);
      System.out.println(m);
      Matrix inverse = null;
      try {
        inverse = m.inverse();
      }
      catch (RuntimeException e) {
        System.err.println("InversionException: " + e.getMessage());
      }
      if (inverse != null) {
        System.out.println(inverse);
      }
      else {
        System.out.println("The matrix is singular.");
      }
      System.out.println();
    }
  }

  public static void testRank() {
    double[][] values =  {{2.0, 0.0, 4.0},
                        {-5.0, 2.0, -2.0},
                        {-2.0, 1.0, 2.0},
                        {1.0, -4.0, 0.0},
                        {-1.0, -2.0, 2.0},
                        {-5.0, 2.0, 0.0},
                        {-4.0, 4.0, -1.0},
                        {2.0, -4.0, -1.0}};
    Matrix ma = new Matrix(8, 3, values);
    System.out.println(ma);
    System.out.println(ma.rank());


    for (int i = 0; i < 200; i++) {
      Random rand = new Random();
      Matrix m = new Matrix(rand.nextInt(10), rand.nextInt(10));
      m.inplaceFillRandomInt(-5, 5);
      System.out.println(m);
      System.out.format("The rank of m is %d.%n", m.rank());
    }
  }

  public static void main(String[] args) {
    //transposed.set(neg);
    // test for shallow / deep copying with set

    /*Test.testMatrixInput();
    Test.testTranspose();
    Test.testNeg();
    Test.testMultiply();
    Test.testDelete();
    Test.testPow();
    Test.testDeterminant();
    Test.testAbs();
    Test.testEF();
    Test.testRREF();
    Test.testEchelonForm();
    Test.testInverse();
    Test.testRank();*/

    /*
    double[][] values = {{1/Math.sqrt(2), 1/Math.sqrt(2)}, {-1/Math.sqrt(2), 1/Math.sqrt(2)}};
      //{0,1,0}, {1,0,0}, {0,0,1}};
    Matrix m = new Matrix(2,2,values);
    System.out.println(m);
    System.out.println(m.determinant());
    */
  }

}
