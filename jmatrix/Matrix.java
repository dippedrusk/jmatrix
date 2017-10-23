package jmatrix;

public class Matrix {

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

  /*public Matrix(int m, int n, int[] values) {

    assertions:
    non null values unless m, n both zero
    non negative m, n
    values correct size
    values does not contain nulls unless null


    this.m = m;
    this.n = n;
    this.values = null; // TODO: fix
  }*/

  @Override
  public String toString() {
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
