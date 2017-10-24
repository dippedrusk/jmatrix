
package jmatrix;

public class IdentityMatrix extends Matrix {

  public IdentityMatrix(int n) {
    super(n, n);
    for (int i = 0; i < n; i++) {
      super.set(i, i, 1);
    }
  }

}
