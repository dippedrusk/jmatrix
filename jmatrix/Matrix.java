package jmatrix;

public class Matrix {

  // TODO: check for null Matrix input -> throw null pointer exception

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

    this.m = m;
    this.n = n;
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

    this.m = m;
    this.n = n;
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
    this.m = m;
    this.n = n;
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

  public static Matrix zero(int m, int n) {
    return new Matrix(m, n);
  }

  public Matrix neg() {
    Matrix ret = zero(this.m, this.n);
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

  public Matrix add(Matrix m) {
    if ((this.m != m.m) || (this.n != m.n)) {
      throw new IllegalArgumentException("The dimensions of arrays being added must match.");
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
    if ((this.m != m.m) || (this.n != m.n)) {
      throw new IllegalArgumentException("The dimensions of arrays being added must match.");
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
    if (this.n != m.m) {
      // TODO: reword this exception message?
      throw new IllegalArgumentException("The n dimension of the first matrix does not match the m dimension of the second.");
    }
    Matrix ret = new Matrix(this.m, m.n);
    // TODO: the actual math
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

}
