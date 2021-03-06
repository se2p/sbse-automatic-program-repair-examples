/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.math.linear;

import java.io.Serializable;

/**
 * A base interface to decomposition algorithms that can solve A &times; X = B.
 * <p>This interface is the common base of decomposition algorithms like
 * {@link QRDecomposition}, {@link LUDecomposition} or {@link
 * SingularValueDecomposition}. All these algorithms decompose an A matrix has a
 * product of several specific matrices from which they can solve A &times; X = B
 * in least squares sense: they find X such that ||A &times; X - B|| is minimal.</p>
 * <p>Some solvers like {@link LUDecomposition} can only find the solution for
 * square matrices and when the solution is an exact linear solution, i.e. when
 * ||A &times; X - B|| is exactly 0. Other solvers can also find solutions
 * with non-square matrix A and with non-null minimal norm. If an exact linear
 * solution exists it is also the minimal norm solution.</p>
 *   
 * @version $Revision$ $Date$
 * @since 2.0
 */
public interface DecompositionSolver extends Serializable {

    /**
     * Decompose a matrix.
     * @param matrix
     * @exception InvalidMatrixException if matrix does not fulfill
     * the decomposition requirements (for example non-square matrix
     * for {@link LUDecomposition})
     */
    void decompose(RealMatrix matrix)
      throws InvalidMatrixException;

    /** Solve the linear equation A &times; X = B.
     * <p>The A matrix is implicit here. It <strong>must</strong> have
     * already been provided by a previous call to {@link #decompose(RealMatrix)}.</p>
     * @param b right-hand side of the equation A &times; X = B
     * @return a vector X that minimizes the two norm of A &times; X - B
     * @exception IllegalStateException if {@link #decompose(RealMatrix) decompose}
     * has not been called
     * @exception IllegalArgumentException if matrices dimensions don't match
     * @exception InvalidMatrixException if decomposed matrix is singular
     */
    double[] solve(double[] b)
      throws IllegalStateException, IllegalArgumentException, InvalidMatrixException;

    /** Solve the linear equation A &times; X = B.
     * <p>The A matrix is implicit here. It <strong>must</strong> have
     * already been provided by a previous call to {@link #decompose(RealMatrix)}.</p>
     * @param b right-hand side of the equation A &times; X = B
     * @return a vector X that minimizes the two norm of A &times; X - B
     * @exception IllegalStateException if {@link #decompose(RealMatrix) decompose}
     * has not been called
     * @exception IllegalArgumentException if matrices dimensions don't match
     * @exception InvalidMatrixException if decomposed matrix is singular
     */
    RealVector solve(RealVector b)
      throws IllegalStateException, IllegalArgumentException, InvalidMatrixException;

    /** Solve the linear equation A &times; X = B.
     * <p>The A matrix is implicit here. It <strong>must</strong> have
     * already been provided by a previous call to {@link #decompose(RealMatrix)}.</p>
     * @param b right-hand side of the equation A &times; X = B
     * @return a matrix X that minimizes the two norm of A &times; X - B
     * @exception IllegalStateException if {@link #decompose(RealMatrix) decompose}
     * has not been called
     * @exception IllegalArgumentException if matrices dimensions don't match
     * @exception InvalidMatrixException if decomposed matrix is singular
     */
    RealMatrix solve(RealMatrix b)
      throws IllegalStateException, IllegalArgumentException, InvalidMatrixException;

}
