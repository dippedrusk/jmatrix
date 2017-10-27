#!/bin/bash

javac Test.java jmatrix/*.java
javadoc -d docs jmatrix/*.java
java Test jmatrix/Matrix jmatrix/IdentityMatrix jmatrix/ZeroMatrix jmatrix/OneMatrix
