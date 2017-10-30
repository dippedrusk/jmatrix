import jmatrix.*;
import java.util.Random;
import java.lang.Math;

import java.text.DecimalFormat;

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

    Matrix m = Matrix.createMatrix(3, 2, values);
    System.out.println(m);

    try {
      Matrix m2 = Matrix.createMatrix(2, 2, nullvalues2d);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m3 = Matrix.createMatrix(-1, 2, values);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = Matrix.createMatrix(1, 3, values);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = Matrix.createMatrix(3, 3, values);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = Matrix.createMatrix(3, 2, new int [3][]);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = Matrix.createMatrix(3, 2, nullvalues1d);
    }
    catch (RuntimeException e) {
      System.err.println("InputException: " + e.getMessage());
    }

    try {
      Matrix m2 = Matrix.createZeroMatrix(3, 4);
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

    Matrix m = Matrix.createMatrix(3, 2, values);
    System.out.println(m);
    Matrix transposed = m.T();
    System.out.println(transposed);
    System.out.println(transposed.T());
  }

  public static void testNeg() {
    int[][] values = new int[3][2];
    values[0][0] = 1;
    values[0][1] = 2;
    values[1][0] = -1;
    values[1][1] = 0;
    values[2][0] = 11;
    values[2][1] = 7;

    Matrix m = Matrix.createMatrix(3, 2, values);
    System.out.println(m);
    Matrix transposed = m.T();
    System.out.println(transposed);
    transposed = transposed.transpose();
    System.out.println(transposed);
    Matrix neg = transposed.neg();
    System.out.println(neg);
  }

  public static void testMultiply() {
    int[] m1vals = {-1, 3, -4};
    Matrix matrix1 = Matrix.createMatrix(1, 3, m1vals);
    System.out.println(matrix1);

    int[][] m2vals = {{4, -6}, {7, 1}, {3, 2}};
    Matrix matrix2 = Matrix.createMatrix(3, 2, m2vals);
    System.out.println(matrix2);

    System.out.println(matrix1.multiply(matrix2));

    Matrix m = Matrix.createZeroMatrix(3, 0);
    System.out.println(m);
    m = Matrix.createZeroMatrix(0, 3);
    System.out.println(m);
    Matrix m2 = Matrix.createZeroMatrix(0, 0);
    System.out.println(m2);
    try {
      System.out.println(m.multiply(m2));
    }
    catch (RuntimeException e) {
      System.err.println("MultiplyException: " + e.getMessage());
    }

  }

  public static void testDelete() {
    Matrix m = Matrix.createZeroMatrix(2, 3);
    System.out.println(m.fillRandomInt(5));
    m = m.fillRandomInt(3,10);
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
    Matrix m = Matrix.createIdentityMatrix(3);
    m = m.fillRandomInt(-5,5);
    System.out.println(m.pow(0));
    System.out.println(m.pow(1));
    System.out.println(m.pow(2));
    m = Matrix.createZeroMatrix(3, 2);
    try {
      System.out.println(m.pow(0));
    }
    catch (RuntimeException e) {
      System.err.println("PowException: " + e.getMessage());
    }
    Matrix empty = Matrix.createIdentityMatrix(0);
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
    Matrix m = Matrix.createMatrix(5, 5, detvals);
    System.out.println(m);
    System.out.println(m.determinant());

    Matrix m2 = Matrix.createZeroMatrix(0, 0);
    System.out.println(m2);
    try {
      System.out.println(m2.determinant());
    }
    catch (RuntimeException e) {
      System.err.println("DeterminantException: " + e.getMessage());
    }
  }

  public static void testAbs() {
    Matrix m = Matrix.createIdentityMatrix(3);
    m = m.fillRandomInt(-5,5);
    System.out.println(m);
    System.out.println(m.abs());
  }

  public static void testEF() {
   /*
    * Condition 1 test cases: empty matrix, zero matrix, identity matrix (pass),
    * no non zero rows matrix, zero rows above nonzero rows,
    * non zero rows above zero rows (pass), mixed
    */
    Matrix m = Matrix.createIdentityMatrix(3);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(3, 4);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(0, 0);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(5, 4);
    m = m.fillRandomInt(2,17);
    System.out.println(m);
    System.out.println(m.isEF());

    int[] row = {0, 0, 0, 0};
    m = m.addRow(row);
    System.out.println(m);
    System.out.println(m.isEF());

    m = m.addRow(row);
    System.out.println(m);
    System.out.println(m.isEF());

    int[] nonzerorow = {2, 0, 0, 0};
    m = m.addRow(nonzerorow);
    System.out.println(m);
    System.out.println(m.isEF());

    int[] nonzerorow2 = {0, 0, 0, 2};
    m = m.addRow(nonzerorow2);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(0, 3);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(0, 0);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(3, 0);
    System.out.println(m);
    System.out.println(m.isEF());

    /*
     * Condition 2, 3 test cases
     */

    /*
    m = Matrix.createIdentityMatrix(3);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createIdentityMatrix(3);
    m.set(1, 1, 0);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    System.out.println(m);
    System.out.println(m.isEF());

    m = Matrix.createZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    m.set(2, 2, 1);
    System.out.println(m);
    System.out.println(m.isEF());
    */
  }

  public static void testRREF() {
    Matrix m = Matrix.createIdentityMatrix(3);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = Matrix.createZeroMatrix(3, 4);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = Matrix.createZeroMatrix(0, 0);
    System.out.println(m);
    System.out.println(m.isRREF());

    double[] vals = {1, 2, 3};
    m = Matrix.createMatrix(1,3,vals);
    System.out.println(m);
    System.out.println(m.isRREF());
    m = Matrix.createMatrix(3,1,vals);
    System.out.println(m);
    System.out.println(m.isRREF());

    double[] vals2 = {2, 2, 3};
    m = Matrix.createMatrix(1,3,vals2);
    System.out.println(m);
    System.out.println(m.isRREF());
    m = Matrix.createMatrix(3,1,vals2);
    System.out.println(m);
    System.out.println(m.isRREF());

    /*
    m = Matrix.createIdentityMatrix(3);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = Matrix.createIdentityMatrix(3);
    m.set(1, 1, 0);
    m.set(2, 0, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = Matrix.createZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = Matrix.createZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(1, 2, 1);
    m.set(0, 2, 1);
    System.out.println(m);
    System.out.println(m.isRREF());

    m = Matrix.createZeroMatrix(3, 3);
    m.set(0, 0, 1);
    m.set(0, 1, 1);
    m.set(1, 2, 1);
    System.out.println(m);
    System.out.println(m.isRREF());
    */
  }

  public static void testEchelonForm() {
    Matrix m = Matrix.createZeroMatrix(3, 4);
    m = m.fillRandomInt(2, 9);
    System.out.println(m);
    m = m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m = m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values = {{7,6,5}, {6,4,4}, {6,8,5}};
    m = Matrix.createMatrix(3, 3, values);
    System.out.println(m);
    m = m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m = m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values2 = {{3,3,7}, {7,3,2}, {3,3,7}};
    m = Matrix.createMatrix(3, 3, values2);
    System.out.println(m);
    m = m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m = m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values3 = {{4,2,6}, {4,4,8}, {6,7,3}};
    m = Matrix.createMatrix(3, 3, values3);
    System.out.println(m);
    m = m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m = m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());

    int[][] values4 = {{6,8,8}, {6,3,4}, {6,2,4}};
    m = Matrix.createMatrix(3, 3, values4);
    System.out.println(m);
    m.echelonForm();
    System.out.println(m);
    System.out.println(m.isEF());

    m = m.reducedRowEchelonForm();
    System.out.println(m);
    System.out.println(m.isRREF());
  }

  public static void testInverse() {
    // preliminary testing with pre-augmented matrices
    int[][] values3 = {{4,2,6}, {4,4,8}, {6,7,3}};
    Matrix m = Matrix.createMatrix(3, 3, values3);
    System.out.println(m);
    System.out.println(m.inverse());

    int[][] values4 = {{6,8,8}, {6,3,4}, {6,2,4}};
    m = Matrix.createMatrix(3, 3, values4);
    System.out.println(m);
    System.out.println(m.inverse());
    System.out.println();

    for (int i = 0; i < 200; i++) {
      Random rand = new Random();
      int dim = rand.nextInt(10);
      m = Matrix.createZeroMatrix(dim, dim);
      m = m.fillRandomInt(-5, 5);
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
    Matrix ma = Matrix.createMatrix(8, 3, values);
    System.out.println(ma);
    System.out.println(ma.rank());


    for (int i = 0; i < 200; i++) {
      Random rand = new Random();
      Matrix m = Matrix.createZeroMatrix(rand.nextInt(10), rand.nextInt(10));
      m = m.fillRandomInt(-5, 5);
      System.out.println(m);
      System.out.format("The rank of m is %d.%n", m.rank());
    }
  }

  public static void testClone() {
    Matrix m = Matrix.createZeroMatrix(1, 3);
    Object l = null;
    try {
       l = m.clone();
    }
    catch (CloneNotSupportedException e) {}
    if (l != null) {
      System.out.println(l != m);
      System.out.println(l.getClass() == m.getClass());
      System.out.println(l.equals(m));
    }
  }

  public static void testPrint() {
    int[][] values = new int[3][2];
    values[0][0] = 1;
    values[0][1] = 2;
    values[1][0] = -1;
    values[1][1] = 0;
    values[2][0] = 11;
    values[2][1] = -32456;
    Matrix m = Matrix.createMatrix(3, 2, values);
    System.out.println(m);

    m = Matrix.createZeroMatrix(3, 3);
    System.out.println(m);

    m = Matrix.createIdentityMatrix(3);
    System.out.println(m);
  }

  public static void testSlice() {
    Matrix m = Matrix.createIdentityMatrix(4);
    System.out.println(m);
    System.out.println(m.slice(0,2,0,2));
    System.out.println(m.slice(1,1,2,2));
    System.out.println(m.slice(1,4,2,2));
    try {
      System.out.println(m.slice(-1,2,0,2));
    }
    catch (RuntimeException e) {
      System.err.println("SliceException: " + e.getMessage());
    }
    try {
      System.out.println(m.slice(0,2,16,19));
    }
    catch (RuntimeException e) {
      System.err.println("SliceException: " + e.getMessage());
    }
    try {
      System.out.println(m.slice(1,2,3,1));
    }
    catch (RuntimeException e) {
      System.err.println("SliceException: " + e.getMessage());
    }
    System.out.println(m.sliceRows(0,100));
    System.out.println(m.sliceRows(3,100));
    System.out.println(m.sliceRows(1,4));
    try {
      System.out.println(m.sliceRows(4,4));
    }
    catch (RuntimeException e) {
      System.err.println("SliceException: " + e.getMessage());
    }
    System.out.println(m.sliceColumns(0,1000));
    System.out.println(m.sliceColumns(3,99));
    System.out.println(m.sliceColumns(2,2));
    System.out.println(m.sliceColumns(2,3));
  }

  public static void automatedTesting() {
    DecimalFormat formatter = new DecimalFormat("000000000000000000000");

    /*
    System.out.printf("Testing echelon form...%n%n");
    for (int i = 0; i < 10000; i++) {
      String test = "Test ";
      test += formatter.format(i);
      Random rand = new Random();
      Matrix m = Matrix.createZeroMatrix(rand.nextInt(10), rand.nextInt(10));
      if (rand.nextInt() % 2 == 0) {
        m = m.fillRandomFloat();
      }
      else {
        m = m.fillRandomInt();
      }
      Matrix echelonForm = null;
      try {
        echelonForm = m.echelonForm();
      }
      catch (RuntimeException e) {
        System.err.println(m);
        System.err.println("EF CONVERSION BUG!!! " + e.getMessage());
      }
      boolean EF = false;
      try {
        EF = echelonForm.isInEchelonForm();
        if (EF) {
          test += ": PASS";
        }
        else {
          System.out.println(m);
          System.out.println(m.echelonForm());
          throw new RuntimeException("BUG!!!");
        }
      }
      catch (RuntimeException e) {
        System.err.println(m);
        System.err.println(echelonForm);
        System.err.println("EF BOOLEAN BUG!!! " + e.getMessage());
      }
      System.out.println(test);
    } */

    System.out.printf("Testing reduced row echelon form...%n%n");
    for (int i = 0;; i++) {
      String test = "Test ";
      test += formatter.format(i);
      Random rand = new Random();
      Matrix m = Matrix.createZeroMatrix(rand.nextInt(10), rand.nextInt(10));
      if (rand.nextInt() % 2 == 0) {
        m = m.fillRandomFloat();
      }
      else {
        m = m.fillRandomInt();
      }
      Matrix RREF = null;
      try {
        RREF = m.reducedRowEchelonForm();
      }
      catch (RuntimeException e) {
        System.err.println(m);
        System.err.println("RREF CONVERSION BUG!!! " + e.getMessage());
      }
      boolean rref = false;
      try {
        rref = RREF.isRREF();
      }
      catch (RuntimeException e) {
        System.err.println(m);
        System.err.println(RREF);
        System.err.println("RREF BOOLEAN BUG!!! " + e.getMessage());
      }
      if (rref) {
        test += ": PASS";
      }
      else {
        System.err.println(RREF);
        test += ": FAIL";
        //throw new RuntimeException("There's a problem here.");
      }
      System.out.println(test);
    }
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
    Test.testRank();
    Test.testClone();
    Test.testPrint();
    Test.testSlice();
    Test.testEF();
    Test.testRREF();
    Test.testEchelonForm();
    Test.testInverse();
    */

    //Test.automatedTesting();

    /*
    double[][] values = {{1/Math.sqrt(2), 1/Math.sqrt(2)}, {-1/Math.sqrt(2), 1/Math.sqrt(2)}};
      //{0,1,0}, {1,0,0}, {0,0,1}};
    Matrix m = Matrix.createMatrix(2,2,values);
    System.out.println(m);
    System.out.println(m.determinant());
    */
  }

}
