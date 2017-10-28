package jmatrix;

import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

/**
 * The <code>Matrix</code> class represents immutable numerical matrices, an <code>m</code> x
 * <code>n</code> array of <code>double</code> values.
 * This implementation is currently not thread-safe.
 * @author Vasundhara Gautam
 * @version 0.0
 */
public final class Matrix implements Cloneable {

  /*
   * To be immutable from the user's POV, the set methods have been removed and
   * no references to the values array are passed to the caller
   */
  private final int m;
  private final int n;
  private final double[][] values;

  /**
   * Static factory method that returns a <code>matrix</code> given parameters
   * specifying dimensions and a 2-D array of <code>int</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 2-D array of <code>int</code> values
   * @return <code>matrix</code> of dimensions <code>m</code> x <code>n</code> containing
   * the entries <code>values</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> or a row within <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  public static Matrix createMatrix(int m, int n, int[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns a <code>matrix</code> given parameters
   * specifying dimensions and a 2-D array of <code>float</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 2-D array of <code>float</code> values
   * @return <code>matrix</code> of dimensions <code>m</code> x <code>n</code> containing
   * the entries <code>values</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> or a row within <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  public static Matrix createMatrix(int m, int n, float[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns a <code>matrix</code> given parameters
   * specifying dimensions and a 2-D array of <code>double</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 2-D array of <code>double</code> values
   * @return <code>matrix</code> of dimensions <code>m</code> x <code>n</code> containing
   * the entries <code>values</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> or a row within <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  public static Matrix createMatrix(int m, int n, double[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns a <code>matrix</code> given parameters
   * specifying dimensions and a 1-D array of <code>int</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 1-D array of <code>int</code> values
   * @return <code>matrix</code> of dimensions <code>m</code> x <code>n</code> containing
   * the entries <code>values</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  public static Matrix createMatrix(int m, int n, int[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns a <code>matrix</code> given parameters
   * specifying dimensions and a 1-D array of <code>float</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 1-D array of <code>float</code> values
   * @return <code>matrix</code> of dimensions <code>m</code> x <code>n</code> containing
   * the entries <code>values</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  public static Matrix createMatrix(int m, int n, float[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns a <code>matrix</code> given parameters
   * specifying dimensions and a 1-D array of <code>double</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 1-D array of <code>double</code> values
   * @return <code>matrix</code> of dimensions <code>m</code> x <code>n</code> containing
   * the entries <code>values</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  public static Matrix createMatrix(int m, int n, double[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns a <code>matrix</code> filled with zeroes
   * given parameters specifying dimensions
   * @param m number of rows
   * @param n number of columns
   * @return zero <code>matrix</code> of dimensions <code>m</code> x <code>n</code>
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * and <code>values</code>
   */
  public static Matrix createZeroMatrix(int m, int n) throws NegativeArraySizeException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    double[][] values = new double[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        values[i][j] = 0;
      }
    }
    return new Matrix(m, n, values);
  }

  /**
   * Static factory method that returns an <code>n</code> x <code>n</code>
   * identity <code>matrix</code>
   * @param n number of columns and columns
   * @return identity <code>matrix</code> of dimensions <code>n</code> x <code>n</code>
   * @throws NegativeArraySizeException if <code>n</code> is negative
   * and <code>values</code>
   */
  public static Matrix createIdentityMatrix(int n) throws NegativeArraySizeException {
    double[][] values = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        values[i][j] = (i == j) ? 1 : 0;
      }
    }
    return new Matrix(n, n, values);
  }

  /*
   * Constructors
   */

  /**
   * <code>Matrix</code> constructor specifying dimensions and a 2-D array of
   * <code>int</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 2-D array of <code>int</code> values
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> or a row within <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  private Matrix(int m, int n, int[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m) {
      throw new IllegalArgumentException("The number of rows of the array of matrix values does not match dimension m.");
    }
    for (int i = 0; i < m; i++) {
      if (values[i] == null) {
        throw new NullPointerException("The array of matrix values cannot contain null rows [row " + i + "].");
      }
      if (values[i].length != n) {
        throw new IllegalArgumentException("The number of columns of the array does not match dimension n [row " + i + "].");
      }
    }

    this.m = m;
    this.n = n;
    this.values = new double[m][n];
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        this.values[i][j] = (double) values[i][j];
      }
    }
  }

  /**
   * <code>Matrix</code> constructor specifying dimensions and a 2-D array of
   * <code>float</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 2-D array of <code>float</code> values
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> or a row within <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  private Matrix(int m, int n, float[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m) {
      throw new IllegalArgumentException("The number of rows of the array of matrix values does not match dimension m.");
    }
    for (int i = 0; i < m; i++) {
      if (values[i] == null) {
        throw new NullPointerException("The array of matrix values cannot contain null rows [row " + i + "].");
      }
      if (values[i].length != n) {
        throw new IllegalArgumentException("The number of columns of the array does not match dimension n [row " + i + "].");
      }
    }

    this.m = m;
    this.n = n;
    this.values = new double[m][n];
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        this.values[i][j] = (double) values[i][j];
      }
    }
  }

  /**
   * <code>Matrix</code> constructor specifying dimensions and a 2-D array of
   * <code>double</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 2-D array of <code>double</code> values
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> or a row within <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  private Matrix(int m, int n, double[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m) {
      throw new IllegalArgumentException("The number of rows of the array of matrix values does not match dimension m.");
    }
    for (int i = 0; i < m; i++) {
      if (values[i] == null) {
        throw new NullPointerException("The array of matrix values cannot contain null rows [row " + i + "].");
      }
      if (values[i].length != n) {
        throw new IllegalArgumentException("The number of columns of the array does not match dimension n [row " + i + "].");
      }
    }

    this.m = m;
    this.n = n;
    this.values = values;
  }

  /**
   * <code>Matrix</code> constructor specifying dimensions and a 1-D array of
   * <code>int</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 1-D array of <code>int</code> values
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  private Matrix(int m, int n, int[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m*n) {
      throw new IllegalArgumentException("The length of the array of matrix values does not match the dimensions.");
    }

    this.m = m;
    this.n = n;
    this.values = new double[m][n];
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        this.values[i][j] = (double) values[i*n + j];
      }
    }
  }

  /**
   * <code>Matrix</code> constructor specifying dimensions and a 1-D array of
   * <code>float</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 1-D array of <code>float</code> values
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  private Matrix(int m, int n, float[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m*n) {
      throw new IllegalArgumentException("The length of the array of matrix values does not match the dimensions.");
    }

    this.m = m;
    this.n = n;
    this.values = new double[m][n];
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        this.values[i][j] = (double) values[i*n + j];
      }
    }
  }

  /**
   * <code>Matrix</code> constructor specifying dimensions and a 1-D array of
   * <code>double</code> values.
   * @param m number of rows
   * @param n number of columns
   * @param values 1-D array of <code>double</code> values
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   * @throws NullPointerException if <code>values</code> is null
   * @throws IllegalArgumentException if there is a dimension mismatch between <code>m</code> or <code>n</code>
   * and <code>values</code>
   */
  private Matrix(int m, int n, double[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m*n) {
      throw new IllegalArgumentException("The length of the array of matrix values does not match the dimensions.");
    }

    this.m = m;
    this.n = n;
    this.values = new double[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        this.values[i][j] = values[i*n + j];
      }
    }
  }

  /**
   * Gets the <code>double</code> value at row <code>i</code> and column <code>j</code>
   * @param i row number
   * @param j column number
   * @return the value at row <code>i</code> and column <code>j</code>
   * @throws IndexOutOfBoundsException if <code>i</code> or <code>j</code>
   * are negative, or if they exceed the dimensions of the matrix
   */
  public double get(int i, int j) throws IndexOutOfBoundsException {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to get are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to get exceed matrix dimensions.");
    }
    return this.values[i][j];
  }

  /**
   * Concatenates this matrix horizontally with the argument matrix
   * @param m matrix to concatenate with this one
   * @return new concatenated matrix
   * @throws NullPointerException if the argument matrix is null
   * @throws ArithmeticException if the m dimensions of both matrices do not match
   */
  public Matrix concat(Matrix m) throws NullPointerException, ArithmeticException {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if (this.m != m.m) {
      throw new ArithmeticException("Matrices to be concatenated must have matching m dimensions.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n + m.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = this.values[i][j];
      }
      for (int j = 0; j < m.n; j++) {
        ret.values[i][this.n + j] = m.values[i][j];
      }
    }
    return ret;
  }

  /*
   * Fill matrix methods
   */

  public Matrix fill(int k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k;
      }
    }
    return ret;
  }

  public Matrix fill(float k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k;
      }
    }
    return ret;
  }

  public Matrix fill(double k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k;
      }
    }
    return ret;
  }

  public Matrix fillRandomInt() {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextInt();
      }
    }
    return ret;
  }

  public Matrix fillRandomInt(int upper) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextInt(upper);
      }
    }
    return ret;
  }

  public Matrix fillRandomInt(int lower, int upper) {
    if (lower > upper) {
      throw new IllegalArgumentException("The lower bound is greater than the upper bound.");
    }
    if (lower == upper) {
      throw new IllegalArgumentException("The lower bound is equal to the upper bound.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextInt(upper - lower) + lower;
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat() {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextDouble();
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat(float upper) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextDouble() * upper;
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat(float lower, float upper) {
    if (lower > upper) {
      throw new IllegalArgumentException("The lower bound is greater than the upper bound.");
    }
    if (lower == upper) {
      throw new IllegalArgumentException("The lower bound is equal to the upper bound.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextDouble() * (upper - lower) + lower;
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat(double upper) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextDouble() * upper;
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat(double lower, double upper) {
    if (lower > upper) {
      throw new IllegalArgumentException("The lower bound is greater than the upper bound.");
    }
    if (lower == upper) {
      throw new IllegalArgumentException("The lower bound is equal to the upper bound.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextDouble() * (upper - lower) + lower;
      }
    }
    return ret;
  }

  /*
   * Unary arithmetic
   */

  public Matrix neg() {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = - this.get(i, j);
      }
    }
    return ret;
  }

  public Matrix abs() {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = Math.abs(this.get(i, j));
      }
    }
    return ret;
  }

  /*
   * Binary arithmetic
   */

  public Matrix pow(int x) {
    if (this.m != this.n) {
      throw new ArithmeticException("Only powers of n x n matrices can be calculated.");
    }
    if (x == 0) {
      return Matrix.createIdentityMatrix(this.m);
    }
    if (x == 1) {
      return this;
    }
    if (x == 2) {
      return this.multiply(this);
    }
    return (this.pow(x-1)).multiply(this);
  }

  public Matrix add(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if ((this.m != m.m) || (this.n != m.n)) {
      throw new ArithmeticException("The dimensions of arrays being added must match.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        double entrysum = this.get(i, j) + m.get(i, j);
        ret.values[i][j] = entrysum;
      }
    }
    return ret;
  }

  public Matrix subtract(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if ((this.m != m.m) || (this.n != m.n)) {
      throw new ArithmeticException("The dimensions of arrays being added must match.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        double entrydiff = this.get(i, j) - m.get(i, j);
        ret.values[i][j] = entrydiff;
      }
    }
    return ret;
  }

  public Matrix multiply(int k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k * this.get(i, j);
      }
    }
    return ret;
  }

  public Matrix multiply(float k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k * this.get(i, j);
      }
    }
    return ret;
  }

  public Matrix multiply(double k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k * this.get(i, j);
      }
    }
    return ret;
  }

  public Matrix multiply(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if (this.n != m.m) {
      throw new ArithmeticException("The n dimension of the first matrix does not match the m dimension of the second.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, m.n);
    for (int i = 0; i < ret.m; i++) {
      for (int j = 0; j < ret.n; j++) {
        int entryprod = 0;
        for (int k = 0; k < this.n; k++) {
          entryprod += this.get(i, k) * m.get(k, j);
        }
        ret.values[i][j] = entryprod;
      }
    }
    return ret;
  }

  /*
   * Matrix operations - determinant, minor, transpose
   */

  /**
   * Returns the determinant of this matrix if it is an n x n matrix.
   * @return <code>double</code> determinant of this matrix
   * @throws ArithmeticException if m and n dimensions are not the same
   */
  public double determinant() throws ArithmeticException {
    if (this.m != this.n) {
      throw new ArithmeticException("Only determinants of n x n matrices can be calculated.");
    }
    if (this.isEmpty()) {
      return 1;
    }
    if (this.m == 1) {
      return this.values[0][0];
    }
    double determinant = 0;
    for (int j = 0; j < this.n; j++) {
      determinant += Math.pow(-1, j) * this.values[0][j] * this.minor(0, j);
    }
    return determinant;
  }

  /**
   * Returns the trace of this matrix if it is an n x n matrix. The trace of a
   * matrix is the sum of the entries along its diagonal.
   * @return <code>double</code> trace of this matrix
   * @throws ArithmeticException if m and n dimensions are not the same
   */
  public double trace() throws ArithmeticException {
    if (this.m != this.n) {
      throw new ArithmeticException("Only traces of n x n matrices can be calculated.");
    }
    double trace = 0;
    for (int i = 0; i < this.m; i++) {
      trace += this.values[i][i];
    }
    return trace;
  }

  /**
   * Returns the minor of the entry in row <code>i</code> and column <code>j</code>
   * of this matrix. The minor is the determinant of the submatrix formed when
   * row <code>i</code> and column <code>j</code> are deleted from this matrix.
   * @param i row number
   * @param j column number
   * @return <code>double</code> minor of the entry in row <code>i</code> and column <code>j</code>
   * of this matrix
   * @throws IndexOutOfBoundsException if <code>i</code> or <code>j</code> are
   * negative or exceed the dimensions of this matrix
   */
  public double minor(int i, int j) throws IndexOutOfBoundsException {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to find the minor are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to find the minor exceed matrix dimensions.");
    }
    return ((this.delRow(i)).delColumn(j)).determinant();
  }

  /**
   * Returns the integer rank of this matrix. The rank is the dimension of the
   * vector space spanned by the n m-dimensional vectors represented by this
   * matrix.
   * @return rank of this matrix
   */
  public int rank() {
    Matrix temp = this.echelonForm();
    int rank = 0;
    int min_dim = Math.min(this.m, this.n);
    for (int i = 0; i < min_dim; i++) {
      if (temp.values[i][i] != 0) {
        rank++;
      }
    }
    return rank;
  }

  /**
   * Returns the matrix transpose of this one in a new matrix.
   * @return matrix transpose of this one
   */
  public Matrix transpose() {
    Matrix ret = Matrix.createZeroMatrix(this.n, this.m);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[j][i] = this.get(i, j);
      }
    }
    return ret;
  }

  /**
   * Shortcut for <code>transpose</code> method.
   * @return matrix transpose of this one
   * @see #transpose
   */
  public Matrix T() {
    return this.transpose();
  }

  /**
   * Returns the echelon form of this matrix in a new matrix.
   * @return echelon form matrix of this one
   */
  public Matrix echelonForm() {
    Matrix ret = new Matrix(this.m, this.n, this.values);
    int min_dim = Math.min(ret.m, ret.n);
    for (int k = 0; k < min_dim; k++) {
      double max_val = 0.0;
      int max_idx = 0;
      for (int i = k; i < ret.m; i++) {
        if (Math.abs(ret.values[i][k]) > max_val) {
          max_val = ret.values[i][k];
          max_idx = i;
        }
      }
      if (max_val != 0.0) {
        ret = ret.swapRows(k, max_idx);
        for (int i = k + 1; i < ret.m; i++) {
          double scalingFactor = ret.values[i][k] / ret.values[k][k];
          for (int j = k + 1; j < ret.n; j++) {
            ret.values[i][j] = ret.values[i][j] - (ret.values[k][j] * scalingFactor);
          }
          ret.values[i][k] = 0;
        }
      }
    }
    return ret;
  }

  /**
   * Returns the reduced row echelon form of this matrix in a new matrix.
   * @return reduced row echelon form matrix of this one
   */
  public Matrix reducedRowEchelonForm() {
    Matrix ret = this.echelonForm();
    int min_dim = Math.min(ret.m, ret.n);
    for (int k = 0; k < min_dim; k++) {
      if (ret.values[k][k] != 0) {
        double scalingFactor = 1.0 / ret.values[k][k];
        ret = ret.scaleRow(k, scalingFactor);
        for (int i = 0; i < k; i++) {
          scalingFactor = - ret.values[i][k];
          if (scalingFactor != 0) {
            ret = ret.addScaledRow(k, scalingFactor, i); // rowk = rowk + rowi * scalingFactor
          }
        }
      }
    }
    return ret;
  }

  /**
   * Returns the matrix inverse of this one in a new matrix.
   * @return inverse matrix or null if this matrix is singular
   */
  public Matrix inverse() {
    if (!this.isInvertible()) {
      return null;
    }
    Matrix identity = Matrix.createIdentityMatrix(this.m);
    Matrix ret = this.concat(identity);
    ret = ret.reducedRowEchelonForm();
    // TODO: improve with slicing
    for (int i = 0; i < this.m; i++) {
      ret = ret.delColumn(0);
    }
    return ret;
  }

  /*
   * Row and column modifiers
   */

  /**
   * Returns a new matrix corresponding to this one with the values of <code>int</code>
   * array <code>column</code> added to the right.
   * @param column int array with values of column to be added
   * @return new matrix with <code>column</code> added
   * @throws NullPointerException if <code>column</code> array is null
   * @throws IllegalArgumentException if the length of the <code>column</code> array
   * does not match the rows of the matrix
   */
  public Matrix addColumn(int[] column) {
    if (column == null) {
      throw new NullPointerException("The column to be added is null.");
    }
    if (this.m != column.length) {
      throw new IllegalArgumentException("The rows of the column do not match the rows of the matrix.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = this.get(i, j);
      }
      ret.values[i][this.n] = column[i];
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one with the values of <code>float</code>
   * array <code>column</code> added to the right.
   * @param column float array with values of column to be added
   * @return new matrix with <code>column</code> added
   * @throws NullPointerException if <code>column</code> array is null
   * @throws IllegalArgumentException if the length of the <code>column</code> array
   * does not match the rows of the matrix
   */
  public Matrix addColumn(float[] column) {
    if (column == null) {
      throw new NullPointerException("The column to be added is null.");
    }
    if (this.m != column.length) {
      throw new IllegalArgumentException("The rows of the column do not match the rows of the matrix.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = this.get(i, j);
      }
      ret.values[i][this.n] = column[i];
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one with the values of <code>double</code>
   * array <code>column</code> added to the right.
   * @param column double array with values of column to be added
   * @return new matrix with <code>column</code> added
   * @throws NullPointerException if <code>column</code> array is null
   * @throws IllegalArgumentException if the length of the <code>column</code> array
   * does not match the rows of the matrix
   */
  public Matrix addColumn(double[] column) {
    if (column == null) {
      throw new NullPointerException("The column to be added is null.");
    }
    if (this.m != column.length) {
      throw new IllegalArgumentException("The rows of the column do not match the rows of the matrix.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = this.get(i, j);
      }
      ret.values[i][this.n] = column[i];
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one with a column of zeroes added.
   * @return new matrix with zero column added
   */
  public Matrix addZeroColumn() {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = this.get(i, j);
      }
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one with the values of <code>int</code>
   * array <code>row</code> added below.
   * @param row int array with values of row to be added
   * @return new matrix with <code>row</code> added
   * @throws NullPointerException if <code>row</code> array is null
   * @throws IllegalArgumentException if the length of the <code>row</code> array
   * does not match the columns of the matrix
   */
  public Matrix addRow(int[] row) throws NullPointerException, IllegalArgumentException {
    if (row == null) {
      throw new NullPointerException("The row to be added is null.");
    }
    if (this.n != row.length) {
      throw new IllegalArgumentException("The columns of the row do not match the columns of the matrix.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m + 1, this.n);
    for (int j = 0; j < this.n; j++) {
      for (int i = 0; i < this.m; i++) {
        ret.values[i][j] = this.get(i, j);
      }
      ret.values[this.m][j] = row[j];
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one with the values of <code>float</code>
   * array <code>row</code> added below.
   * @param row float array with values of row to be added
   * @return new matrix with <code>row</code> added
   * @throws NullPointerException if <code>row</code> array is null
   * @throws IllegalArgumentException if the length of the <code>row</code> array
   * does not match the columns of the matrix
   */
  public Matrix addRow(float[] row) throws NullPointerException, IllegalArgumentException {
    if (row == null) {
      throw new NullPointerException("The row to be added is null.");
    }
    if (this.n != row.length) {
      throw new IllegalArgumentException("The columns of the row do not match the columns of the matrix.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m + 1, this.n);
    for (int j = 0; j < this.n; j++) {
      for (int i = 0; i < this.m; i++) {
        ret.values[i][j] = this.get(i, j);
      }
      ret.values[this.m][j] = row[j];
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one with the values of <code>double</code>
   * array <code>row</code> added below.
   * @param row double array with values of row to be added
   * @return new matrix with <code>row</code> added
   * @throws NullPointerException if <code>row</code> array is null
   * @throws IllegalArgumentException if the length of the <code>row</code> array
   * does not match the columns of the matrix
   */
  public Matrix addRow(double[] row) throws NullPointerException, IllegalArgumentException {
    if (row == null) {
      throw new NullPointerException("The row to be added is null.");
    }
    if (this.n != row.length) {
      throw new IllegalArgumentException("The columns of the row do not match the columns of the matrix.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m + 1, this.n);
    for (int j = 0; j < this.n; j++) {
      for (int i = 0; i < this.m; i++) {
        ret.values[i][j] = this.get(i, j);
      }
      ret.values[this.m][j] = row[j];
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one without column <code>k</code>.
   * @param k column number
   * @return new matrix with column <code>k</code> deleted
   * @throws IndexOutOfBoundsException if <code>k</code> is negative or exceeds
   * n dimension of the matrix
   */
  public Matrix delColumn(int k) throws IndexOutOfBoundsException {
    if (k < 0) {
      throw new IndexOutOfBoundsException("Index for column to delete is negative.");
    }
    if (k >= this.n) {
      throw new IndexOutOfBoundsException("Index for column to delete exceeds matrix dimensions.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n - 1);
    for (int i = 0; i < ret.m; i++) {
      for (int j = 0; j < k; j++) {
        ret.values[i][j] = this.get(i, j);
      }
      for (int j = k; j < ret.n; j++) {
        ret.values[i][j] = this.get(i, j+1);
      }
    }
    return ret;
  }

  /**
   * Returns a new matrix corresponding to this one without row <code>k</code>.
   * @param k row number
   * @return new matrix with row <code>k</code> deleted
   * @throws IndexOutOfBoundsException if <code>k</code> is negative or exceeds
   * m dimension of the matrix
   */
  public Matrix delRow(int k) throws IndexOutOfBoundsException {
    if (k < 0) {
      throw new IndexOutOfBoundsException("Index for row to delete is negative.");
    }
    if (k >= this.m) {
      throw new IndexOutOfBoundsException("Index for row to delete exceeds matrix dimensions.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m - 1, this.n);
    for (int j = 0; j < ret.n; j++) {
      for (int i = 0; i < k; i++) {
        ret.values[i][j] = this.get(i, j);
      }
      for (int i = k; i < ret.m; i++) {
        ret.values[i][j] = this.get(i+1, j);
      }
    }
    return ret;
  }

  /*
   * Boolean methods
   */

  /**
   * Checks whether this matrix has either or both dimensions set to 0.
   * @return true if this matrix is empty, false otherwise
   */
  public boolean isEmpty() {
    if ((m == 0) || (n == 0)) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether this matrix is invertible.
   * @return true if this matrix is invertible, false otherwise
   */
  public boolean isInvertible() {
    if (this.m != this.n) {
      return false;
    }
    return (this.determinant() != 0);
  }

  /**
   * Checks whether this matrix is in echelon form.
   * @return true if this matrix is in echelon form, false otherwise
   */
  public boolean isInEchelonForm() {
    /*
     * A matrix is in echelon form iff
     * 1. All nonzero rows are above any rows of all zeros.
     * 2. Each leading entry of a row is in a column to the right of the leading
     *    entry of the row above
     * 3. All entries in a column below a leading entry are zeros
     */
    return (this.nonZeroRowsAboveZeroRows() && this.leadingEntriesEFCompliant());
  }

  /**
   * Shortcut for <code>isInEchelonForm</code>.
   * @return true if this matrix is in echelon form, false otherwise
   * @see #isInEchelonForm
   */
  public boolean isEF() {
    return this.isInEchelonForm();
  }

  /**
   * Checks whether this matrix is in reduced row echelon form.
   * @return true if this matrix is in reduced row echelon form, false otherwise
   */
  public boolean isInReducedRowEchelonForm() {
    if (!this.isInEchelonForm()) {
      return false;
    }
    return this.leadingEntriesRREFCompliant();
  }

  /**
   * Shortcut for <code>isInReducedRowEchelonForm</code>.
   * @return true if this matrix is in reduced row echelon form, false otherwise
   * @see #isInReducedRowEchelonForm
   */
  public boolean isRREF() {
    return this.isInReducedRowEchelonForm();
  }

  /**
   * Checks if this matrix is full rank, i.e., if its rank equals the largest
   * possible for a matrix of dimensions m x n.
   * @return true if full rank, false if not
   */
  public boolean isFullRank() {
    return (this.rank() == Math.min(this.m, this.n));
  }

  /**
   * Checks if the n m-dimensional vectors represented by this m x n matrix
   * are linearly dependent (in Rm).
   * @throws IllegalArgumentException if this matrix is empty
   * @return true if linearly dependent, false if linearly dependent
   */
  public boolean isLinearlyDependent() throws IllegalArgumentException {
    if (this.isEmpty()) {
      // TODO: find out what happens here
      throw new IllegalArgumentException();
    }
    if (this.n > this.m) {
      return true;
    }
    if (this.rank() < this.n) {
      return true;
    }
    return false;
  }

  /*
   * Overridden methods
   */

  /**
   * Returns string with the matrix split into rows and columns and entries
   * separated by commas.
   * @return string representation of matrix
   */
  @Override
  public String toString() {
    // TODO: Improve padding for negative numbers, varying digits, float
    if (this.isEmpty()) {
      return "[]";
    }
    String matrix = "[ ";
    for (int i = 0; i < m; i++) {
      String row = "";
      for (int j = 0; j < n; j++) {
        row += this.values[i][j];
        if (j < n-1) {
          row += ", ";
        }
      }
      if (i > 0) {
        matrix += "  ";
      }
      matrix += row;
      if (i < m-1) {
        matrix += "\n";
      }
    }
    return matrix + " ]";
  }

  /**
   * Checks whether this matrix is equal to <code>Object</code> argument
   * @param obj Java <code>Object</code>.
   * @return true if the <code>obj</code> is a matrix equivalent to this one,
   * false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if ((obj == null) || !(obj instanceof Matrix)) {
      return false;
    }
    return this.equals((Matrix) obj);
  }

  /**
   * Returns integer hash code of this matrix. Overridden because <code>equals</code>
   * is overridden.
   * @return hash code of this matrix
   */
  @Override
  public int hashCode() {
    return this.m * this.n * Arrays.deepHashCode(this.values);
  }

  /**
   * Returns a shallow copy of this matrix
   * @return object corresponding to a shallow copy of this matrix
   */
  @Override
  public Object clone() throws CloneNotSupportedException {
    return (Matrix) super.clone();
  }

  /*
   * Private helper methods
   */

  private boolean equals(Matrix m) {
   if (m == null) {
     return false;
   }
   if (this.m != m.m) {
     return false;
   }
   if (this.n != m.n) {
     return false;
   }
   for (int i = 0; i < this.m; i++) {
     for (int j = 0; j < this.n; j++) {
       if (this.get(i, j) != m.get(i, j)) {
         return false;
       }
     }
   }
   return true;
  }

  private boolean nonZeroRowsAboveZeroRows() {
    int firstZeroRow = 0;
    while (firstZeroRow < this.m) {
      boolean zeroRow = true;
      for (int j = 0; j < this.n; j++) {
        if (this.get(firstZeroRow, j) != 0) {
          zeroRow = false;
        }
      }
      if (zeroRow) {
        break;
      }
      firstZeroRow++;
    }
    for (int i = firstZeroRow + 1; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        if (this.get(i, j) != 0) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean leadingEntriesEFCompliant() {
    // TODO: smarter matrix slicing might optimize this method
    int leftmostLeadingEntryIndexAbove = -1;
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < leftmostLeadingEntryIndexAbove + 1; j++) {
        if (this.get(i, j) != 0) {
          // leading entry of this row not to the right of leading entry above
          return false;
        }
      }
      for (int j = leftmostLeadingEntryIndexAbove + 1; j < this.n; j++) {
        if (this.get(i, j) != 0) {
          // leading entry
          leftmostLeadingEntryIndexAbove = j;
          break;
        }
      }
    }
    return true;
  }

  private boolean leadingEntriesRREFCompliant() {
    int leftmostLeadingEntryIndexAbove = -1;
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < leftmostLeadingEntryIndexAbove + 1; j++) {
        if (this.get(i, j) != 0) {
          // leading entry of this row not to the right of leading entry above
          return false;
        }
      }
      for (int j = leftmostLeadingEntryIndexAbove + 1; j < this.n; j++) {
        if (this.get(i, j) == 1) {
          // appropriate leading entry
          leftmostLeadingEntryIndexAbove = j;
          for (int i_prev = 0; i_prev < i; i_prev++) {
            // checking entries above the leading entry
            if (this.get(i_prev, j) != 0) {
              return false;
            }
          }
          break;
        }
        else if (this.get(i, j) != 0) {
          // leading entry not 1
          return false;
        }
      }
    }
    return true;
  }

  /*
   * Elementary row operations
   * 1) Swapping two rows
   * 2) Multiplying a row by a non-zero number
   * 3) Adding a multiple of one row to another row.
   */

  private Matrix swapRows(int row_i, int row_j) {
    if ((row_i < 0) || (row_j < 0)) {
      throw new IndexOutOfBoundsException("Row index to swap is negative.");
    }
    if ((row_i >= this.m) || (row_j >= this.m)) {
      throw new IndexOutOfBoundsException("Row index to swap exceeds matrix dimensions.");
    }
    Matrix ret = new Matrix(this.m, this.n, this.values);
    for (int j = 0; j < this.n; j++) {
      double temp = ret.values[row_i][j];
      ret.values[row_i][j] = ret.values[row_j][j];
      ret.values[row_j][j] = temp;
    }
    return ret;
  }

  private Matrix scaleRow(int row_i, double const_k) {
    if (row_i < 0) {
      throw new IndexOutOfBoundsException("Row index to scale is negative.");
    }
    if (row_i >= this.m) {
      throw new IndexOutOfBoundsException("Row index to scale exceeds matrix dimensions.");
    }
    if (const_k == 0) {
      throw new IllegalArgumentException("Scaling by 0 not allowed.");
    }
    Matrix ret = new Matrix(this.m, this.n, this.values);
    for (int j = 0; j < this.n; j++) {
      ret.values[row_i][j] *= const_k;
    }
    return ret;
  }

  private Matrix addScaledRow(int row_i, double const_k, int row_j) {
    if (row_i < 0) {
      throw new IndexOutOfBoundsException("Row index to scale is negative.");
    }
    if (row_j < 0) {
      throw new IndexOutOfBoundsException("Row index to add is negative.");
    }
    if (row_i >= this.m) {
      throw new IndexOutOfBoundsException("Row index to scale exceeds matrix dimensions.");
    }
    if (row_j >= this.m) {
      throw new IndexOutOfBoundsException("Row index to add exceeds matrix dimensions.");
    }
    if (const_k == 0) {
      throw new IllegalArgumentException("Scaling by 0 not allowed.");
    }
    Matrix ret = new Matrix(this.m, this.n, this.values);
    for (int j = 0; j < this.n; j++) {
      ret.values[row_j][j] += ret.values[row_i][j] * const_k;
    }
    return ret;
  }

}
