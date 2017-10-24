package jmatrix;

import java.util.Random;
import java.lang.Math;

public class Matrix {

  // TODO: check for n = 0 in nxn matrices
  // TODO: addColumn and addRow should work on empty matrices
  // TODO: override hashcode - but how?

  private int m;
  private int n;
  private int[][] values;

  /**
  * TODO: Documentation!
  */
  public Matrix(int m, int n, int[][] values) {
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

    this.m = (n == 0) ? 0 : m;
    this.n = (m == 0) ? 0 : n;
    this.values = values;
  }

  public Matrix(int m, int n, int[] values) {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    if (values == null) {
      throw new NullPointerException("The array of matrix values cannot be null.");
    }
    if (values.length != m*n) {
      throw new IllegalArgumentException("The length of the array of matrix values does not match the dimensions.");
    }

    this.m = (n == 0) ? 0 : m;
    this.n = (m == 0) ? 0 : n;
    this.values = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        this.values[i][j] = values[i*n + j];
      }
    }
  }

  public Matrix(int m, int n) {
    if ((m < 0) || (n < 0)) {
      throw new NegativeArraySizeException("The dimensions of a matrix cannot be negative.");
    }
    this.m = (n == 0) ? 0 : m;
    this.n = (m == 0) ? 0 : n;
    this.values = new int[m][n];
  }

  public void set(int i, int j, int value) {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to set are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to set exceed matrix dimensions.");
    }
    this.values[i][j] = value;
  }

  public void set(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix cannot be set to a null matrix.");
    }
    this.m = m.m;
    this.n = m.n;
    this.values = m.values;
  }

  public int get(int i, int j) {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to get are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to get exceed matrix dimensions.");
    }
    return this.values[i][j];
  }

  public Matrix fill(int k) {
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

  public Matrix fillRandom() {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextInt());
      }
    }
    return ret;
  }

  public Matrix fillRandom(int upper) {
    Matrix ret = new ZeroMatrix(this.m, this.n);
    for (int i = 0; i < this.m; i++) {
      for (int j = 0; j < this.n; j++) {
        Random rand = new Random();
        ret.set(i, j, rand.nextInt(upper));
      }
    }
    return ret;
  }

  public Matrix fillRandom(int lower, int upper) {
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

  public void inplaceFillRandom() {
    this.set(this.fillRandom());
  }

  public void inplaceFillRandom(int upper) {
    this.set(this.fillRandom(upper));
  }

  public void inplaceFillRandom(int lower, int upper) {
    this.set(this.fillRandom(lower, upper));
  }

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

  public int determinant() {
    if (this.m != this.n) {
      throw new ArithmeticException("Only determinants of n x n matrices can be calculated.");
    }
    if (m == 0) {
      throw new IllegalArgumentException("Determinants of empty matrices cannot be calculated.");
    }
    if (m == 1) {
      return values[0][0];
    }
    int determinant = 0;
    for (int j = 0; j < n; j++) {
      determinant += Math.pow(-1, j) * values[0][j] * this.minor(0, j);
    }
    return determinant;
  }

  public int minor(int i, int j) {
    if ((i < 0) || (j < 0)) {
      throw new IndexOutOfBoundsException("Indices to find the minor are negative.");
    }
    if ((i >= m) || (j >= n)) {
      throw new IndexOutOfBoundsException("Indices to find the minor exceed matrix dimensions.");
    }
    return ((this.delRow(i)).delColumn(j)).determinant();
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
        int entrysum = this.get(i, j) + m.get(i, j);
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
        int entrydiff = this.get(i, j) - m.get(i, j);
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

  public void inplaceMultiply(int k) {
    this.set(this.multiply(k));
  }

  public Matrix multiply(Matrix m) {
    if (m == null) {
      throw new NullPointerException("The matrix to be added cannot be null.");
    }
    if (this.n != m.m) {
      // TODO: reword this exception message?
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

  public void inplaceAddRow(int[] row) {
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

  public boolean isEmpty() {
    if ((m == 0) || (n == 0)) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    // TODO: Improve padding for negative numbers and varying digits
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

}
