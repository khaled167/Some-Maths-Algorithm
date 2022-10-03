    package mathtech;
    public class Matrices {
    //Solve the system of a linear equations.
    public static double[][] SystemOfLinearEqn(double[][]matrix,double[][]results){
    return (multiplyMatrix(invert(matrix),results));

    }
    //Finds the determinant of a matrix.
    public static double determinant(double[][]matrix){
    double sum = 0;
    if(matrix.length == 2 && matrix[0].length == 2){
    return (matrix[0][0]*1.0*matrix[1][1]*1.0)-(matrix[0][1]*1.0*matrix[1][0]*1.0);
    }
    else
    {
    for(int i = 0 ; i < matrix[0].length;i++){
    sum += (Math.pow(-1, i))*matrix[0][i]*determinant(subDet(matrix,0,i));
    }
    return sum;  
    }
    }
    //Useless function.
    public static   int fib(int k){
    if(k<2){
    return k;
    }
    else{
    return fib(k-1)+fib(k-2);
    }
    }
    //Finds the sub determinant of a matrix.
    public static double[][] subDet(double[][]matrix,int row,int column){
    double[][]reduced = new double[matrix.length-1][matrix[0].length-1];
    for(int i=0,l=0 ; i<reduced.length;i++,l++){
    for(int j=0,k=0;j<reduced[0].length;j++,k++){
    if(j==column){
    k++;
    }
    if(l==row){
    l++;
    }
    reduced[i][j] = matrix[l][k];
    }
    }
    return reduced;
    }
    //Pritns the array.
    public static void printArray(double[][]ar){   
    for(int i=0;i<ar.length;i++){
    for(int j=0 ; j<ar[i].length;j++){
    System.out.print(ar[i][j]+" , ");
    }
    System.out.println();
    }
    }
    //Finds the matrix of minors
    public static double[][] matrixOfMinors(double[][]matrix){
    double[][] matrixOfMinors = new double[matrix.length][matrix[0].length];
    for(int i = 0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
    matrixOfMinors[i][j]=determinant(subDet(matrix,i,j));
    }
    }
    return matrixOfMinors;
    }
    //Finds the matrix of Cofactors.
    public static double[][] matrixOfCofactors(double[][]matrix){
    double[][] matrixOfCofactors = new double[matrix.length][matrix[0].length];
    for(int i = 0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
    matrixOfCofactors[i][j] = Math.pow(-1,i+j)*matrix[i][j];
    }
    }
    return matrixOfCofactors;
    }
    //Transpose the matrix.
    public static double[][] transpose(double[][]matrix){
    double[][] transpose = new double[matrix[0].length][matrix.length];
    for(int i=0;i<matrix[0].length;i++){
    for(int j=0;j<matrix.length;j++){
    transpose[i][j]=matrix[j][i];
    }
    }
    return transpose;
    }
    //Invert the matrix.
    public static double[][] invert(double[][]matrix){
    return  multiplyTermByMatrix(1.0/determinant(matrix),transpose(matrixOfCofactors(matrixOfMinors(matrix))));}
    //Multiplies a matrix by a scalar.
    public static double[][] multiplyTermByMatrix(double term,double[][]matrix){
    double[][] newMat = new double[matrix.length][matrix[0].length];
    for(int i =0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
    newMat[i][j] = matrix[i][j] * term;   
    }
    }
    return newMat;
    }
    //Finds the specific column
    public static double[] column(int indexOfColumn,double[][] matrix){
    double[] column = new double[matrix.length];
    for(int i=0; i<column.length; i++){
    column[i] = matrix[i][indexOfColumn];
    }
    return column;
    }
    //Multiplies two dimensions matrices.
    public static double[][] multiplyMatrix(double[][]matrix1,double[][]matrix2){   //matrix1 * matrix2
    double[][] product = new double[matrix1.length][matrix2[0].length];
    for(int i = 0 ;i<product.length;i++){
    for(int j=0;j<product[0].length;j++){
    product[i][j] = multiplyMatrix(matrix1[i],column(j,matrix2));
    }
    }
    return product;
    }
    //Multiplies one dimensions matrices.
    public static double multiplyMatrix(double[]matrix1,double[]matrix2){    
    double product = 0;
    for(int i =0 ; i<matrix1.length;i++){
    product += matrix1[i]*matrix2[i];
    }
    return product;
    }
    }