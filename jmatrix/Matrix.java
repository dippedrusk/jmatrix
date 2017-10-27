package jmatrix;

import java.util.Random;
import java.lang.Math;

/**
 * The <code>Matrix</code> class represents numerical matrices, an <code>m</code> x
 * <code>n</code> array of <code>double</code> values.
 * @author Vasundhara Gautam
 * @version 0.0
 */
public class Matrix {

  // TODO: override hashcode - but how?
  // TODO: Documentation!

  private int m;
  private int n;
  private double[][] values;

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
  public Matrix(int m, int n, int[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
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
  public Matrix(int m, int n, float[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
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
  public Matrix(int m, int n, double[][] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
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
  public Matrix(int m, int n, int[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
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
  public Matrix(int m, int n, float[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
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
  public Matrix(int m, int n, double[] values) throws NegativeArraySizeException, NullPointerException, IllegalArgumentException {
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
   * <code>Matrix</code> constructor specifying dimensions, initializes all <code>matrix</code>
   * values to 0.
   * @param m number of rows
   * @param n number of columns
   * @throws NegativeArraySizeException if <code>m</code> or <code>n</code> is negative
   */
  public Matrix(int m, int n) throws NegativeArraySizeException {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    this.m = m;
    this.n = n;
    this.values = new double[m][n];
  }

  /*
   * Setters and getters
   */

  /**
   * Sets position at row <code>i</code> and column <code>j</code> to
   * integer <code>value</code>.
   * @param i row number
   * @param j column number
   * @param value integer to set to
   * @throws IndexOutOfBoundsException if <code>i</code> or <code>j</code>
   * are negative, or if they exceed the dimensions of the matrix
   */
  public void set(int i, int j, int value) throws IndexOutOfBoundsException {
   if ((i < 0) || (j < 0)) {
     throw new IndexOutOfBoundsException("Indices to set are negative.");
   }
   if ((i >= m) || (j >= n)) {
     throw new IndexOutOfBoundsException("Indices to set exceed matrix dimensions.");
   }
   this.values[i][j] = (double) value;
  }

  /**
   * Sets position at row <code>i</code> and column <code>j</code> to
   * float <code>value</code>.
   * @param i row number
   * @param j column number
   * @param value float to set to
   * @throws IndexOutOfBoundsException if <code>i</code> or <code>j</code>
   * are negative, or if they exceed the dimensions of the matrix
   */
  public void set(int i, int j, float value) throws IndexOutOfBoundsException {
   if ((i < 0) || (j < 0)) {
     throw new IndexOutOfBoundsException("Indices to set are negative.");
   }
   if ((i >= m) || (j >= n)) {
     throw new IndexOutOfBoundsException("Indices to set exceed matrix dimensions.");
   }
   this.values[i][j] = (double) value;
  }

  /**
   * Sets position at row <code>i</code> and column <code>j</code> to
   * double <code>value</code>.
   * @param i row number
   * @param j column number
   * @param value double to set to
   * @throws IndexOutOfBoundsException if <code>i</code> or <code>j</code>
   * are negative, or if they exceed the dimensions of the matrix
   */
  public void set(int i, int j, double value) throws IndexOutOfBoundsException {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to set are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to set exceed matrix dimensions.");
    }
    this.values[i][j] = value;
  }

  /**
   * Sets this matrix to the argument matrix
   * @param m matrix to copy from
   * @throws NullPointerException if <code>matrix</code> argument is null
   */
  public void set(Matrix m) throws NullPointerException {
    if (m == null) {
      throw new NullPointerException("The matrix cannot be set to a null matrix.");
    }
    this.m = m.m;
    this.n = m.n;
    this.values = m.values;
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
    Matrix ret = new Matrix(this.m, this.n + m.n);
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
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, k);
      }
    }
    return ret;
  }

  public Matrix fill(float k) {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, k);
      }
    }
    return ret;
  }

  public Matrix fill(double k) {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, k);
      }
    }
    return ret;
  }

  public void inplaceFill(int k) {
    this.set(this.fill(k));
  }

  public void inplaceFill(float k) {
    this.set(this.fill(k));
  }

  public void inplaceFill(double k) {
    this.set(this.fill(k));
  }

  public Matrix fillRandomInt() {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextInt());
      }
    }
    return ret;
  }

  public Matrix fillRandomInt(int upper) {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextInt(upper));
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
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextInt(upper - lower) + lower);
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat() {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextDouble());
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat(float upper) {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextDouble() * upper);
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
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextDouble() * (upper - lower) + lower);
      }
    }
    return ret;
  }

  public Matrix fillRandomFloat(double upper) {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextDouble() * upper);
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
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextDouble() * (upper - lower) + lower);
      }
    }
    return ret;
  }

  public void inplaceFillRandomInt() {
    this.set(this.fillRandomInt());
  }

  public void inplaceFillRandomInt(int upper) {
    this.set(this.fillRandomInt(upper));
  }

  public void inplaceFillRandomInt(int lower, int upper) {
    this.set(this.fillRandomInt(lower, upper));
  }

  public void inplaceFillRandomFloat() {
    this.set(this.fillRandomFloat());
  }

  public void inplaceFillRandomFloat(float upper) {
    this.set(this.fillRandomFloat(upper));
  }

  public void inplaceFillRandomFloat(float lower, float upper) {
    this.set(this.fillRandomFloat(lower, upper));
  }

  public void inplaceFillRandomFloat(double upper) {
    this.set(this.fillRandomFloat(upper));
  }

  public void inplaceFillRandomFloat(double lower, double upper) {
    this.set(this.fillRandomFloat(lower, upper));
  }

  /*
   * Unary arithmetic
   */

  public Matrix neg() {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, - this.get(i, j));
      }
    }
    return ret;
  }

  public void inplaceNeg() {
    this.set(this.neg());
  }

  public Matrix abs() {
    Matrix ret = new Matrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, Math.abs(this.get(i, j)));
      }
    }
    return ret;
  }

  public void inplaceAbs() {
    this.set(this.abs());
  }

  /*
   * Binary arithmetic
   */

  public Matrix pow(int x) {
    if (this.m != this.n) {
      throw new ArithmeticException("Only powers of n x n matrices can be calculated.");
    }
    if (x == 0) {
      return new IdentityMatrix(this.m);
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
    Matrix ret = new Matrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        double entrysum = this.get(i, j) + m.get(i, j);
        ret.set(i, j, entrysum);
      }
    }
    return ret;
  }

  public void inplaceAdd(Matrix m) {
    this.set(this.add(m));
  }

  public Matrix sub(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if ((this.m != m.m) || (this.n != m.n)) {
      throw new ArithmeticException("The dimensions of arrays being added must match.");
    }
    Matrix ret = new Matrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        double entrydiff = this.get(i, j) - m.get(i, j);
        ret.set(i, j, entrydiff);
      }
    }
    return ret;
  }

  public void inplaceSub(Matrix m) {
    this.set(this.sub(m));
  }

  public Matrix multiply(int k) {
    Matrix ret = new Matrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, k * this.get(i, j));
      }
    }
    return ret;
  }

  public Matrix multiply(float k) {
    Matrix ret = new Matrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, k * this.get(i, j));
      }
    }
    return ret;
  }

  public Matrix multiply(double k) {
    Matrix ret = new Matrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, k * this.get(i, j));
      }
    }
    return ret;
  }

  public void inplaceMultiply(int k) {
    this.set(this.multiply(k));
  }

  public void inplaceMultiply(float k) {
    this.set(this.multiply(k));
  }

  public void inplaceMultiply(double k) {
    this.set(this.multiply(k));
  }

  public Matrix multiply(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if (this.n != m.m) {
      throw new ArithmeticException("The n dimension of the first matrix does not match the m dimension of the second.");
    }
    Matrix ret = new Matrix(this.m, m.n);
    for (int i = 0; i < ret.m; i++) {
      for (int j = 0; j < ret.n; j++) {
        int entryprod = 0;
        for (int k = 0; k < this.n; k++) {
          entryprod += this.get(i, k) * m.get(k, j);
        }
        ret.set(i, j, entryprod);
      }
    }
    return ret;
  }

  public void inplaceMultiply(Matrix m) {
    this.set(this.multiply(m));
  }

  /*
   * Matrix operations - determinant, minor, transpose
   */

  public double determinant() {
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

  public double trace() {
    if (this.m != this.n) {
      throw new ArithmeticException("Only traces of n x n matrices can be calculated.");
    }
    double trace = 0;
    for (int i = 0; i < this.m; i++) {
      trace += this.values[i][i];
    }
    return trace;
  }

  public double minor(int i, int j) {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to find the minor are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to find the minor exceed matrix dimensions.");
    }
    return ((this.delRow(i)).delColumn(j)).determinant();
  }

  public int rank() {
    Matrix temp = new Matrix(this.m, this.n, this.values);
    temp.reducedRowEchelonForm();
    int rank = 0;
    int min_dim = Math.min(this.m, this.n);
    for (int i = 0; i < min_dim; i++) {
      if (temp.values[i][i] == 1) {
        rank++;
      }
    }
    return rank;
    //TODO: make more efficient
  }

  public Matrix transpose() {
    Matrix ret = new Matrix(this.n, this.m);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(j, i, this.get(i, j));
      }
    }
    return ret;
  }

  public Matrix T() {
    return this.transpose();
  }

  public void inplaceTranspose() {
    this.set(this.transpose());
  }

  public void echelonForm() {
    int min_dim = Math.min(this.m, this.n);
    for (int k = 0; k < min_dim; k++) {
      double max_val = 0.0;
      int max_idx = 0;
      for (int i = k; i < this.m; i++) {
        if (Math.abs(this.values[i][k]) > max_val) {
          max_val = this.values[i][k];
          max_idx = i;
        }
      }
      if (max_val != 0.0) {
        swapRows(k, max_idx);
        for (int i = k + 1; i < this.m; i++) {
          double scalingFactor = this.values[i][k] / this.values[k][k];
          for (int j = k + 1; j < this.n; j++) {
            this.values[i][j] = this.values[i][j] - (this.values[k][j] * scalingFactor);
          }
          this.values[i][k] = 0;
        }
      }
    }
  }

  public void reducedRowEchelonForm() {
    this.echelonForm();
    int min_dim = Math.min(this.m, this.n);
    for (int k = 0; k < min_dim; k++) {
      if (this.values[k][k] != 0) {
        double scalingFactor = 1.0 / this.values[k][k];
        this.scaleRow(k, scalingFactor);
        for (int i = 0; i < k; i++) {
          scalingFactor = - this.values[i][k];
          if (scalingFactor != 0) {
            this.addScaledRow(k, scalingFactor, i); // rowk = rowk + rowi * scalingFactor
          }
        }
      }
    }
  }

  public Matrix inverse() {
    if (!this.isInvertible()) {
      return null;
    }
    Matrix identity = new IdentityMatrix(this.m);
    Matrix ret = this.concat(identity);
    ret.reducedRowEchelonForm();
    // TODO: improve with slicing
    for (int i = 0; i < this.m; i++) {
      ret.inplaceDelColumn(i);
    }
    return ret;
  }

  /*
   * Row and column modifiers
   */

  public Matrix addColumn(int[] column) {
    if (column == null) {
      throw new NullPointerException("The column to be added is null.");
    }
    if (this.m != column.length) {
      throw new IllegalArgumentException("The rows of the column do not match the rows of the matrix.");
    }
    Matrix ret = new Matrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, this.get(i, j));
      }
      ret.set(i, this.n, column[i]);
    }
    return ret;
  }

  public Matrix addColumn(float[] column) {
    if (column == null) {
      throw new NullPointerException("The column to be added is null.");
    }
    if (this.m != column.length) {
      throw new IllegalArgumentException("The rows of the column do not match the rows of the matrix.");
    }
    Matrix ret = new Matrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, this.get(i, j));
      }
      ret.set(i, this.n, column[i]);
    }
    return ret;
  }

  public Matrix addColumn(double[] column) {
    if (column == null) {
      throw new NullPointerException("The column to be added is null.");
    }
    if (this.m != column.length) {
      throw new IllegalArgumentException("The rows of the column do not match the rows of the matrix.");
    }
    Matrix ret = new Matrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, this.get(i, j));
      }
      ret.set(i, this.n, column[i]);
    }
    return ret;
  }

  public Matrix addColumn() {
    Matrix ret = new Matrix(this.m, this.n + 1);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        ret.set(i, j, this.get(i, j));
      }
    }
    return ret;
  }

  public void inplaceAddColumn(int[] column) {
    this.set(this.addColumn(column));
  }

  public void inplaceAddColumn(float[] column) {
    this.set(this.addColumn(column));
  }

  public void inplaceAddColumn(double[] column) {
    this.set(this.addColumn(column));
  }

  public void inplaceAddColumn() {
    this.set(this.addColumn());
  }

  public Matrix addRow(int[] row) {
    if (row == null) {
      throw new NullPointerException("The row to be added is null.");
    }
    if (this.n != row.length) {
      throw new IllegalArgumentException("The columns of the row do not match the columns of the matrix.");
    }
    Matrix ret = new Matrix(this.m + 1, this.n);
    for (int j = 0; j < this.n; j++) {
      for (int i = 0; i < this.m; i++) {
        ret.set(i, j, this.get(i, j));
      }
      ret.set(this.m, j, row[j]);
    }
    return ret;
  }

  public Matrix addRow(float[] row) {
    if (row == null) {
      throw new NullPointerException("The row to be added is null.");
    }
    if (this.n != row.length) {
      throw new IllegalArgumentException("The columns of the row do not match the columns of the matrix.");
    }
    Matrix ret = new Matrix(this.m + 1, this.n);
    for (int j = 0; j < this.n; j++) {
      for (int i = 0; i < this.m; i++) {
        ret.set(i, j, this.get(i, j));
      }
      ret.set(this.m, j, row[j]);
    }
    return ret;
  }

  public Matrix addRow(double[] row) {
    if (row == null) {
      throw new NullPointerException("The row to be added is null.");
    }
    if (this.n != row.length) {
      throw new IllegalArgumentException("The columns of the row do not match the columns of the matrix.");
    }
    Matrix ret = new Matrix(this.m + 1, this.n);
    for (int j = 0; j < this.n; j++) {
      for (int i = 0; i < this.m; i++) {
        ret.set(i, j, this.get(i, j));
      }
      ret.set(this.m, j, row[j]);
    }
    return ret;
  }

  public void inplaceAddRow(int[] row) {
    this.set(this.addRow(row));
  }

  public void inplaceAddRow(float[] row) {
    this.set(this.addRow(row));
  }

  public void inplaceAddRow(double[] row) {
    this.set(this.addRow(row));
  }

  public Matrix delColumn(int k) {
    if (k < 0) {
      throw new IndexOutOfBoundsException("Index for column to delete is negative.");
    }
    if (k >= this.n) {
      throw new IndexOutOfBoundsException("Index for column to delete exceeds matrix dimensions.");
    }
    Matrix ret = new Matrix(this.m, this.n - 1);
    for (int i = 0; i < ret.m; i++) {
      for (int j = 0; j < k; j++) {
        ret.set(i, j, this.get(i, j));
      }
      for (int j = k; j < ret.n; j++) {
        ret.set(i, j, this.get(i, j+1));
      }
    }
    return ret;
  }

  public void inplaceDelColumn(int k) {
    this.set(this.delColumn(k));
  }

  public Matrix delRow(int k) {
    if (k < 0) {
      throw new IndexOutOfBoundsException("Index for row to delete is negative.");
    }
    if (k >= this.m) {
      throw new IndexOutOfBoundsException("Index for row to delete exceeds matrix dimensions.");
    }
    Matrix ret = new Matrix(this.m - 1, this.n);
    for (int j = 0; j < ret.n; j++) {
      for (int i = 0; i < k; i++) {
        ret.set(i, j, this.get(i, j));
      }
      for (int i = k; i < ret.m; i++) {
        ret.set(i, j, this.get(i+1, j));
      }
    }
    return ret;
  }

  public void inplaceDelRow(int i) {
    this.set(this.delRow(i));
  }

  /*
   * Boolean methods
   */

  public boolean isEmpty() {
    if ((m == 0) || (n == 0)) {
      return true;
    }
    return false;
  }

  public boolean isInvertible() {
    if (this.m != this.n) {
      return false;
    }
    return (this.determinant() != 0);
  }

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

  public boolean isEF() {
    return this.isInEchelonForm();
  }

  public boolean isInReducedRowEchelonForm() {
    if (!this.isInEchelonForm()) {
      return false;
    }
    return this.leadingEntriesRREFCompliant();
  }

  public boolean isRREF() {
    return this.isInReducedRowEchelonForm();
  }

  public boolean isFullRank() {
    return (this.rank() == Math.min(this.m, this.n));
  }

  public boolean isLinearlyDependent() {
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

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Matrix)
      return this.equals((Matrix) obj);
    else
      return false;
  }

  public boolean equals(Matrix m) {
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

  /*
   * Private helper methods
   */

  private boolean nonZeroRowsAboveZeroRows() {
    /*
     * Test cases: empty matrix, zero matrix, identity matrix (pass),
     * no non zero rows matrix, zero rows above nonzero rows,
     * non zero rows above zero rows (pass), mixed
     */
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
    // TODO: smarter matrix slicing might help make this method more efficient?
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

  private void swapRows(int row_i, int row_j) {
    if ((row_i < 0) || (row_j < 0)) {
      throw new IndexOutOfBoundsException("Row index to swap is negative.");
    }
    if ((row_i >= this.m) || (row_j >= this.m)) {
      throw new IndexOutOfBoundsException("Row index to swap exceeds matrix dimensions.");
    }
    for (int j = 0; j < this.n; j++) {
      double temp = this.values[row_i][j];
      this.values[row_i][j] = this.values[row_j][j];
      this.values[row_j][j] = temp;
    }
  }

  private void scaleRow(int row_i, double const_k) {
    if (row_i < 0) {
      throw new IndexOutOfBoundsException("Row index to scale is negative.");
    }
    if (row_i >= this.m) {
      throw new IndexOutOfBoundsException("Row index to scale exceeds matrix dimensions.");
    }
    if (const_k == 0) {
      throw new IllegalArgumentException("Scaling by 0 not allowed.");
    }
    for (int j = 0; j < this.n; j++) {
      this.values[row_i][j] *= const_k;
    }
  }

  private void addScaledRow(int row_i, double const_k, int row_j) {
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
    for (int j = 0; j < this.n; j++) {
      this.values[row_j][j] += this.values[row_i][j] * const_k;
    }
  }

}
