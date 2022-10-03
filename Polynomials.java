package mathtech;
 public class Polynomials {
    public Polynomials(){
    }
      public  double[][] quotient(double[][]Numerator,double[][]Denominator){
      double[][]arrayOfResult = new double[2][Numerator[0].length-Denominator[0].length+2];
      double[][]Reduced = new double[Numerator.length][Numerator[0].length];
      copyArray(Reduced,Numerator);
      for(int i=0;i<Numerator[0].length-Denominator[0].length+1;i++){   
      if(pivot(Reduced)[1][0] < Denominator[1][0] && pivot(Reduced)[0][0]!=0){
      break;
      }
      arrayOfResult[0][i] = (pivot(Reduced)[0][0]*1.0)/(Denominator[0][0]*1.0);
      arrayOfResult[1][i] = pivot(Reduced)[1][0]-Denominator[1][0];  
      copyArray(Reduced,subArrays(Reduced,multiplyTermByPolynomial(arrayOfResult[0][i],arrayOfResult[1][i],Denominator)));
      arrayOfResult[0][arrayOfResult[0].length-1]=Reduced[0][Reduced[0].length-1];
      }
      return arrayOfResult;
      }
      //Returns the quotient of the division.
      public  double[][] remainder(double[][]Numerator,double[][]Denominator){
    double FoundedCoeff;
    double FoundedPower;
    double[][]Reduced = new double[Numerator.length][Numerator[0].length];
    double[][]Remainder = new double[2][(int)Denominator[1][0]+1];
    copyArray(Reduced,Numerator);
    for(int i=0;i<Numerator[0].length-Denominator[0].length+1;i++){
    if(pivot(Reduced)[1][0] < Denominator[1][0]){
    copySubArray(Reduced,Remainder,pivotIndex(Reduced));
    break;
       }
    FoundedCoeff = (pivot(Reduced)[0][0]*1.0)/(Denominator[0][0]*1.0);
    FoundedPower = pivot(Reduced)[1][0]-Denominator[1][0];        
    copyArray(Reduced,subArrays(Reduced,multiplyTermByPolynomial(FoundedCoeff,FoundedPower,Denominator)));
   
    }
    return Remainder;
    }
      //Returns the remainder of the division.
      public  double[][] subArrays(double[][]x,double[][]y){
    double[][]z = new double[x.length][x[0].length];
    copyArray(z,x);
    for(int i=0;i<x[1].length;i++){
    for(int j=0;j<y[1].length;j++){
    if(x[1][i]==y[1][j]){
    z[0][i]=x[0][i]-y[0][j];
    }
    }
    }
    return z;
    }
      //Substracts two polynomials (x-y).
      public  double[][] multiplyTermByPolynomial(double coeff,double power,double[][]z){
    double[][]q=new double[z.length][z[0].length];
    copyArray(q,z);
    for(int i=0;i<z[0].length;i++){
    q[0][i] *= coeff;
    }
    for(int k=0;k<z[1].length;k++){
    q[1][k] += power;
    }
    return q;
    }
      //Multiplies a variable or value to a polynomial.
      public  double[][] pivot(double[][]reduced){
      double[][] pivot = new double[2][1];
      for(int i = 0 ;i < reduced[0].length ; i ++){
      if(reduced[0][i] != 0){
      pivot[0][0] = reduced[0][i];
      pivot[1][0] = reduced[1][i];
  break;
  } 
  else if(i == reduced[0].length-1 && reduced[0][i] == 0 ){
  pivot[0][0] = 0;
  pivot[1][0] = 0;
  }
  }
  return pivot;
  }
      //returns the first non-zero element in the Reduced polynomial.
      public  int pivotIndex(double[][]reduced){
  
  int index;
  for(index = 0 ;index < reduced[0].length ; index++){
  if(reduced[0][index] != 0){
  break;
  } 
  else if(index == reduced[0].length-1 && reduced[0][index] == 0 ){
  return reduced[0].length-1;
  }
  }
  return index;
  }
      //returns the index of the pivot.
      public  void copySubArray(double[][]Source,double[][]copied,int indexOfSource){
      for(int i = indexOfSource , j=0 ; i<Source[0].length;i++,j++){
      copied[0][j]=Source[0][i];
      copied[1][j]=Source[1][i];
      }
    }
      //Copies a subset array into another.
      public  void copyArray(double[][]x,double[][]y){
      for(int i=0;i<y[0].length;i++){
      x[0][i]=y[0][i];
      }
      for(int j=0;j<y[1].length;j++){
      x[1][j]=y[1][j];
      }
      }
      //Copies the whole array into another.
      public  Object termFactor(double x,double y){
      if(y==0){
      return "Error you cannot divide by zero.";
              }
      if((x/y)==(int)(x/y)){

return (int)(x/y);
}
else
return "("+(int)x+"/"+(int)y+")";
}
      //Returns the simplest form of a rational operation.
      public  void printInPolynomialForm(double[][]Matrix){
  for(int i=0 ; i<Matrix[0].length-1;i++){
  if(Matrix[0][i]==0){
  continue;
  }
  if(i==Matrix[0].length-1){
  System.out.print(termFactor(Matrix[0][i],1)+"x^"+termFactor(Matrix[1][i],1));
  }
  else if(i!=Matrix[0].length-1) System.out.print(termFactor(Matrix[0][i],1)+"x^"+termFactor(Matrix[1][i],1)+" + ");
  }
  System.out.println();
  }
      //Prints an array in the form of polynomial.
      public  double[][] partialFraction(double[][]Numerator,double[][]Denominator){
      return null;
      }
      public  double substitute(double[][]function,double value){
      double result=0;
      for(int i = 0 ; i<function[0].length;i++){
      result += (function[0][i])*(Math.pow(value, function[1][i]));
      }
      return result;
      }
}
