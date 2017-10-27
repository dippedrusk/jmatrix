
package jmatrix;

public class OneMatrix extends Matrix {

  public OneMatrix(int m, int n) {
    super(m, n);
    super.inplaceFill(1);  
  }

}
