#!/bin/bash

javac Test.java jmatrix/*.java
java Test jmatrix/Matrix jmatrix/IdentityMatrix jmatrix/ZeroMatrix
