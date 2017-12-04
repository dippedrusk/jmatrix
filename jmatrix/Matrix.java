package jmatrix;

import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

/**
 * The <code>Matrix</code> class represents immutable numerical matrices, an <code>m</code> x
 * <code>n</code> array of <code>double</code> values.
 * This implementation is currently not thread-safe.
 * @author Vasundhara Gautam
 * @version 1.0.0
 */
public final class Matrix implements Cloneable {

  // TODO: check that every method returns modified deep copies of matrices
  // TODO: standardize [][] notation for accessing values array
  // TODO: think about precision, BigDecimals, etc.

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
   * Gets the <code>double</code> value at row <code>i</code> and column <code>j</code>.
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
   * Concatenates this matrix horizontally with the argument matrix.
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

  /**
   * Returns a matrix of this one's dimensions with every entry set to the value
   * of <code>int</code> <code>k</code>.
   * @param k <code>int</code> to fill the matrix with
   * @return copy of this matrix filled with <code>k</code>
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

  /**
   * Returns a matrix of this one's dimensions with every entry set to the value
   * of <code>float</code> <code>k</code>.
   * @param k <code>float</code> to fill the matrix with
   * @return copy of this matrix filled with <code>k</code>
   */
  public Matrix fill(float k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k;
      }
    }
    return ret;
  }

  /**
   * Returns a matrix of this one's dimensions with every entry set to the value
   * of <code>double</code> <code>k</code>.
   * @param k <code>double</code> to fill the matrix with
   * @return copy of this matrix filled with <code>k</code>
   */
  public Matrix fill(double k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k;
      }
    }
    return ret;
  }

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom integer
   * values.
   * @return copy of this matrix filled with pseudorandom integer values
   */
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

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom integer
   * values between 0 (inclusive) and the specified upper bound (exclusive).
   * @param upper positive integer upper bound
   * @return copy of this matrix filled with pseudorandom integer values between
   * 0 (inclusive) and <code>upper</code> (exclusive)
   * @throws IllegalArgumentException if upper bound is non-positive
   */
  public Matrix fillRandomInt(int upper) throws IllegalArgumentException {
    if (upper <= 0) {
      throw new IllegalArgumentException("The upper bound must be positive as the default lower bound is 0.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextInt(upper);
      }
    }
    return ret;
  }

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom integer
   * values between the specified lower (inclusive) and upper (exclusive) bounds.
   * @param lower integer lower bound
   * @param upper integer upper bound
   * @return copy of this matrix filled with pseudorandom integer values between
   * <code>lower</code> (inclusive) and <code>upper</code> (exclusive)
   * @throws IllegalArgumentException if the lower bound is greater than or equal
   * to the upper bound
   */
  public Matrix fillRandomInt(int lower, int upper) throws IllegalArgumentException {
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

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom floating
   * point values between 0.0 (inclusive) and 1.0 (exclusive).
   * @return copy of this matrix filled with pseudorandom floating point values
   */
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

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom floating
   * point values between 0.0 (inclusive) and the specified upper bound (exclusive).
   * @param upper positive <code>float</code> upper bound
   * @return copy of this matrix filled with pseudorandom floating point values between
   * 0.0 (inclusive) and <code>upper</code> (exclusive)
   * @throws IllegalArgumentException if upper bound is non-positive
   */
  public Matrix fillRandomFloat(float upper) throws IllegalArgumentException {
    if (upper <= 0.0) {
      throw new IllegalArgumentException("The upper bound must be positive as the default lower bound is 0.0.");
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.values[i][j] = rand.nextDouble() * upper;
      }
    }
    return ret;
  }

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom floating
   * point values between the specified lower (inclusive) and upper (exclusive) bounds.
   * @param lower positive <code>float</code> lower bound
   * @param upper positive <code>float</code> upper bound
   * @return copy of this matrix filled with pseudorandom floating point values between
   * <code>lower</code> (inclusive) and <code>upper</code> (exclusive)
   * @throws IllegalArgumentException if the lower bound is greater than or equal
   * to the upper bound
   */
  public Matrix fillRandomFloat(float lower, float upper) throws IllegalArgumentException {
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

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom floating
   * point values between 0.0 (inclusive) and the specified upper bound (exclusive).
   * @param upper positive <code>double</code> upper bound
   * @return copy of this matrix filled with pseudorandom floating point values between
   * 0.0 (inclusive) and <code>upper</code> (exclusive)
   * @throws IllegalArgumentException if upper bound is non-positive
   */
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

  /**
   * Returns a matrix of this one's dimensions, filled with pseudorandom floating
   * point values between the specified lower (inclusive) and upper (exclusive) bounds.
   * @param lower positive <code>double</code> lower bound
   * @param upper positive <code>double</code> upper bound
   * @return copy of this matrix filled with pseudorandom floating point values between
   * <code>lower</code> (inclusive) and <code>upper</code> (exclusive)
   * @throws IllegalArgumentException if the lower bound is greater than or equal
   * to the upper bound
   */
  public Matrix fillRandomFloat(double lower, double upper) throws IllegalArgumentException {
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

  /**
   * Returns a copy of this matrix with every entry negated.
   * @return copy of this matrix with every entry negated
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

  /**
   * Returns a copy of this matrix with the absolute value of every entry.
   * @return copy of this matrix with the absolute value of every entry
   */
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

  /**
   * Returns the matrix corresponding to the n-th power of this one.
   * @param n power to raise this matrix to
   * @return this matrix raised to the n-th power
   * @throws ArithmeticException if the m and n dimensions of this matrix
   * do not match
   */
  public Matrix pow(int n) throws ArithmeticException {
    if (this.m != this.n) {
      throw new ArithmeticException("Only powers of n x n matrices can be calculated.");
    }
    if (n == 0) {
      return Matrix.createIdentityMatrix(this.m);
    }
    if (n == 1) {
      return this;
    }
    if (n == 2) {
      return this.multiply(this);
    }
    return (this.pow(n-1)).multiply(this);
  }

  /**
   * Adds this matrix to the argument matrix <code>m</code>.
   * @param m matrix to add to this one
   * @return matrix sum of this one and the argument matrix <code>m</code>
   * @throws NullPointerException if the matrix to be added is null
   * @throws ArithmeticException if the dimensions of both matrices are not
   * identical
   */
  public Matrix add(Matrix m) throws NullPointerException, ArithmeticException {
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

  /**
   * Subtracts the argument matrix <code>m</code> from this one.
   * @param m matrix to subtract from this one
   * @return matrix sum of this one and the argument matrix <code>m</code>
   * @throws NullPointerException if the matrix to be subtracted is null
   * @throws ArithmeticException if the dimensions of both matrices are not
   * identical
   */
  public Matrix subtract(Matrix m) throws NullPointerException, ArithmeticException {
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

  /**
   * Scales every entry in this matrix by the <code>int</code> argument <code>k</code>
   * @param k <code>int</code> value to scale every matrix entry by
   * @return copy of this matrix with every entry scaled by <code>k</code>
   */
  public Matrix scale(int k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k * this.get(i, j);
      }
    }
    return ret;
  }

  /**
   * Scales every entry in this matrix by the <code>float</code> argument <code>k</code>
   * @param k <code>float</code> value to scale every matrix entry by
   * @return copy of this matrix with every entry scaled by <code>k</code>
   */
  public Matrix scale(float k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k * this.get(i, j);
      }
    }
    return ret;
  }

  /**
   * Scales every entry in this matrix by the <code>double</code> argument <code>k</code>
   * @param k <code>double</code> value to scale every matrix entry by
   * @return copy of this matrix with every entry scaled by <code>k</code>
   */
  public Matrix scale(double k) {
    Matrix ret = Matrix.createZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i][j] = k * this.get(i, j);
      }
    }
    return ret;
  }

  /**
   * Multiplies this matrix by the argument matrix <code>m</code>.
   * @param m matrix to multiply this one with
   * @return matrix product of this one and the argument matrix <code>m</code>
   * @throws NullPointerException if the matrix to be multiplied is null
   * @throws ArithmeticException if the n dimension of this matrix does not
   * match the m dimension of the argument matrix
   */
  public Matrix multiply(Matrix m) throws NullPointerException, ArithmeticException {
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
    if (!this.isEmpty()) {
      return ret.sliceColumns(this.n, ret.n);
    }
    return Matrix.createZeroMatrix(0,0);
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
  public Matrix addColumn(int[] column) throws NullPointerException, IllegalArgumentException {
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
  public Matrix addColumn(float[] column) throws NullPointerException, IllegalArgumentException {
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
  public Matrix addColumn(double[] column) throws NullPointerException, IllegalArgumentException {
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

  /**
   * Returns a matrix with the specified rows and columns from this one.
   * @param i1 first row of slice (inclusive)
   * @param i2 last row of slice (exclusive)
   * @param j1 first column of slice (inclusive)
   * @param j2 last column of slice (exclusive)
   * @return matrix constructed from rows <code>i1</code> to <code>i2</code>
   * and columns <code>j1</code> to <code>j2</code> of this matrix
   * @throws IndexOutOfBoundsException if any of the parameters are negative or
   * if i1 exceeds the m dimension or j1 exceeds the n dimension
   * @throws IllegalArgumentException if the slicing bound between i1 and i2 or
   * between j1 and j2 is negative
   */
  public Matrix slice(int i1, int i2, int j1, int j2) throws IndexOutOfBoundsException, IllegalArgumentException {
    if ((i1 < 0) || (i2 < 0) || (j1 < 0) || (j2 < 0)) {
      throw new IndexOutOfBoundsException("Slicing index is negative.");
    }
    if ((i1 >= this.m) || (j1 >= this.n)) {
      throw new IndexOutOfBoundsException("Slicing index exceeds matrix dimensions.");
    }
    if ((i1 > i2) || (j1 > j2)) {
      throw new IllegalArgumentException("Slicing bound is negative.");
    }
    if ((i2 > this.m) || (j2 > this.n)) {
      i2 = this.m;
      j2 = this.n;
    }
    Matrix ret = Matrix.createZeroMatrix(i2-i1, j2-j1);
    for (int i = i1; i < i2; i++) {
      for (int j = j1; j < j2; j++) {
        ret.values[i - i1][j - j1] = this.values[i][j];
      }
    }
    return ret;
  }

  /**
   * Returns a matrix with the specified rows and all columns from this one.
   * @param i1 first row of slice (inclusive)
   * @param i2 last row of slice (exclusive)
   * @return matrix constructed from rows <code>i1</code> to <code>i2</code>
   * of this matrix
   * @throws IndexOutOfBoundsException if either of the parameters are negative or
   * if i1 exceeds the m dimension
   * @throws IllegalArgumentException if the slicing bound between i1 and i2 is
   * negative
   */
  public Matrix sliceRows(int i1, int i2) throws IndexOutOfBoundsException, IllegalArgumentException {
    if ((i1 < 0) || (i2 < 0)) {
      throw new IndexOutOfBoundsException("Slicing index is negative.");
    }
    if (i1 >= this.m) {
      throw new IndexOutOfBoundsException("Slicing index exceeds matrix dimensions.");
    }
    if (i1 > i2) {
      throw new IllegalArgumentException("Slicing bound is negative.");
    }
    if (i2 > this.m) {
      i2 = this.m;
    }
    Matrix ret = Matrix.createZeroMatrix(i2-i1, this.n);
    for (int i = i1; i < i2; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.values[i - i1][j] = this.values[i][j];
      }
    }
    return ret;
  }

  /**
   * Returns a matrix with the specified columns and all rows from this one.
   * @param j1 first column of slice (inclusive)
   * @param j2 last column of slice (exclusive)
   * @return matrix constructed from columns <code>j1</code> to <code>j2</code>
   * of this matrix
   * @throws IndexOutOfBoundsException if either of the parameters are negative or
   * if j1 exceeds the n dimension
   * @throws IllegalArgumentException if the slicing bound between j1 and j2 is
   * negative
   */
  public Matrix sliceColumns(int j1, int j2) throws IndexOutOfBoundsException, IllegalArgumentException {
    if ((j1 < 0) || (j2 < 0)) {
      throw new IndexOutOfBoundsException("Slicing index is negative.");
    }
    if (j1 >= this.n) {
      throw new IndexOutOfBoundsException("Slicing index exceeds matrix dimensions.");
    }
    if (j1 > j2) {
      throw new IllegalArgumentException("Slicing bound is negative.");
    }
    if (j2 > this.n) {
      j2 = this.n;
    }
    Matrix ret = Matrix.createZeroMatrix(this.m, j2-j1);
    for (int i = 0; i < this.m; i++) {
      for (int j = j1; j < j2; j++) {
        ret.values[i][j - j1] = this.values[i][j];
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
    return (this.nonZeroRowsAboveZeroRows() && this.isUpperTriangular());
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
    return (this.areLeadingEntriesOnes() && this.areLeadingEntriesBelowZeroes());
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
   * @return true if linearly dependent, false if linearly dependent
   */
  public boolean isLinearlyDependent() {
    if (this.isEmpty()) {
      return false;
    }
    if (this.n > this.m) {
      return true;
    }
    if (this.rank() < this.n) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether all the entries below the main diagonal are 0.
   * @return true if this matrix is upper triangular, false otherwise
   */
  public boolean isUpperTriangular() {
    if (this.isEmpty()) {
      return true; // TODO: verify
    }
    int min_dim = Math.min(this.m, this.n);
    for (int i = 0; i < min_dim; i++) {
      for (int j = 0; j < i; j++) {
        if (this.values[i][j] != 0.0) {
          return false;
        }
      }
    }
    for (int i = min_dim; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        if (this.values[i][j] != 0.0) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Checks whether all entries above the main diagonal are 0.
   * @return true if this matrix is lower triangular, false otherwise
   */
  public boolean isLowerTriangular() {
    if (this.isEmpty()) {
      return true; // TODO: verify
    }
    int min_dim = Math.min(this.m, this.n);
    for (int i = 0; i < min_dim; i++) {
      for (int j = i+1; j < this.n; j++) {
        if (this.values[i][j] != 0.0) {
          return false;
        }
      }
    }
    return true;
  }

  /*
   * Overridden methods
   */

  /**
   * Returns string with the matrix split into rows and columns, with entries
   * separated by commas and rows separated by semicolons.
   * @return string representation of matrix
   */
  @Override
  public String toString() {
    String matrix = "[ ";
    double max_val = 0.0;
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        if (Math.abs(this.values[i][j]) > max_val) {
          max_val = Math.abs(this.values[i][j]);
        }
      }
    }
    int max_digits = (max_val < 10.0) ? 1 : (int) Math.floor(Math.log10(max_val) + 1);
    for (int i = 0; i < m; i++) {
      String row = "";
      for (int j = 0; j < n; j++) {
        double entry = this.values[i][j];
        double entry_abs = Math.abs(entry);
        int this_digits = (entry_abs < 10.0) ? 1 : (int) Math.floor(Math.log10(entry_abs) + 1);
        int padding = max_digits - this_digits;
        for (int k = 0; k < padding; k++) {
          row += " ";
        }
        if (1 / entry > 0.0) {
          row += String.format(" %.3f", entry);
        }
        else {
          row += String.format("%.3f", entry);
        }
        if (j < n-1) {
          row += ", ";
        }
      }
      if (i > 0) {
        matrix += "  ";
      }
      matrix += row + ";";
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

  /**
   * Checks whether this matrix deeply equals the argument matrix object
   * <code>m</code>.
   * @param m argument matrix to test equality
   * @return true if the two matrices are non-null and deeply equal, false
   * otherwise
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
   //TODO: find the correct method: return (this.values).deepEquals(m.values);
   for (int i = 0; i < this.m; i++) {
     for (int j = 0; j < this.n; j++) {
       if (this.get(i, j) != m.get(i, j)) {
         return false;
       }
     }
   }
   return true;
  }

  /**
   * Checks whether all rows containing non-zero entries are above all rows
   * containing only zeroes in this matrix.
   * @return true if all non-zero rows (if they exist) are above all zero rows
   * (if they exist)
   */
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

  private boolean areLeadingEntriesOnes() {
    int min_dim = Math.min(this.m, this.n);
    for (int i = 0; i < min_dim; i++) {
      if (1.0 - this.values[i][i] > 0.00000000001) {
        return false;
      }
    }
    return true;
  }
  // TODO: fix precision issues in RREF and EF methods before changing these
  private boolean areLeadingEntriesBelowZeroes() {
    int min_dim = Math.min(this.m, this.n);
    for (int i = 0; i < min_dim; i++) {
      if ((Math.abs(this.values[i][i])) != 0.0) { // pivot
        for (int j = 0; j < i; j++) {
          if (Math.abs(this.values[j][i]) > 0.00000000001) {
            return false;
          }
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

  private Matrix swapRows(int row_i, int row_j) throws IndexOutOfBoundsException {
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

  private Matrix scaleRow(int row_i, double const_k) throws IndexOutOfBoundsException, IllegalArgumentException {
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

  private Matrix addScaledRow(int row_i, double const_k, int row_j) throws IndexOutOfBoundsException, IllegalArgumentException {
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
