# jmatrix

In the process of being built - use at your own risk.

## Running
Running `./run.sh` will compile the code and run the top-level driver file I am
using for testing.

## Features
* Initialize a matrix from
  * two-dimensional arrays
  * one-dimensional arrays
  * strings**
  * files**
* Unary matrix operations
  * abs
  * negative
  * transpose
* Binary matrix operations
  * addition
  * subtraction
  * scalar multiplication
  * matrix multiplication
* Other
  * trace
  * determinant
  * minor
  * inverse**
  * reduction to echelon form / rref**
* Boolean
  * echelon form
  * reduced row echelon form
  * invertible
* Potentially also
  * fill with random values
  * shuffle**
  * resize**
  * sparse matrices with sparsify/densify functions**
  * flexible numerical types
  * smart slicing**

** not yet implemented

## Learning log
* All about Java exceptions (checked and unchecked)
* Wrote my first custom exception (then deleted it because I found better pre-existing ones)
* Bundling Java classes++ into a package / accessing package members
* MATH!
* Realized that Java generics are somewhat restrictive - since I needed my underlying
  matrix representation to have a 2D array of double values, I had to duplicate a lot of code
  to allow flexibility at the user end in instantiating matrices with int or float array values
