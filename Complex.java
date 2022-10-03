/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathtech;

/**
 *
 * @author vv
 */
public class Complex {
    long real;
    long imaginary;
    public Complex(){
        this(0,0);
    }
    public Complex(long real , long imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex mult(Complex i){
     Complex newI = new Complex();
     newI.real = this.real* i.real - (this.imaginary*i.imaginary);
     newI.imaginary = this.real*i.imaginary + this.imaginary*i.real;
     return newI;
    }
    public Complex add(Complex i){
      Complex newI = new Complex();
      newI.real = this.real + i.real;
      newI.imaginary = this.imaginary + i.imaginary;
      return newI;
    }
    public Complex subtract(Complex i){
        return this.add(i.mult(-1));
    }
    public Complex mult(long z){
        Complex newI = new Complex();
        newI.real = this.real*z;
        newI.imaginary = this.imaginary*z;
        return newI;
    }
    public Complex div(long z){
     return this.mult(1/z);
    }
    public Complex div(Complex i){
    return (this.mult(i.conjugate())).div(i.real*i.real+i.imaginary*i.imaginary);
    }
    public Complex conjugate(){
     return new Complex(this.real,-1*this.imaginary);
    }
    public Complex exponentiation(long Degree){
        Complex newI = this;
      for(int i = 0;i<=Degree;i++)
       newI = this.mult(this);
      return newI;
    }
   
}
