/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathtech;
import java.math.BigInteger;
public class Rat{
BigInteger Numerator;
BigInteger Denominator;
public Rat(){
Numerator = new BigInteger("0");
Denominator = new BigInteger("1");
}
public Rat(BigInteger Numerator, BigInteger Denominator){
this.Numerator = Numerator;
this.Denominator = Denominator;
BigInteger gcd = this.Numerator.gcd(this.Denominator);
this.Numerator = this.Numerator.divide(gcd);
this.Denominator = this.Denominator.divide(gcd);
}
public Rat(String Numerator,String Denominator){
this.Numerator = new BigInteger(Numerator);
this.Denominator = new BigInteger(Denominator);
BigInteger gcd = this.Numerator.gcd(this.Denominator);
this.Numerator = this.Numerator.divide(gcd);
this.Denominator = this.Denominator.divide(gcd);
}
public Rat(String Numerator){
this.Numerator = new BigInteger(Numerator);
this.Denominator = new BigInteger("1");
}
public Rat mult(Rat x){
Rat product = new Rat();
product.Numerator = this.Numerator.multiply(x.Numerator);
product.Denominator = this.Denominator.multiply(x.Denominator);
BigInteger gcd = product.Numerator.gcd(product.Denominator);
product.Numerator = (product.Numerator).divide(gcd);
product.Denominator = (product.Denominator).divide(gcd);
return product;
}
public Rat div(Rat x){
Rat product = new Rat();
product.Numerator = this.Numerator.multiply(x.Denominator);
product.Denominator = this.Denominator.multiply(x.Numerator);
BigInteger gcd = product.Numerator.gcd(product.Denominator);
product.Numerator = (product.Numerator).divide(gcd);
product.Denominator = (product.Denominator).divide(gcd);
return product;
}
public Rat add(Rat x){
Rat product = new Rat();
product.Numerator = (this.Numerator.multiply(x.Denominator)).add(x.Numerator.multiply(this.Denominator));
product.Denominator = this.Denominator.multiply(x.Denominator);
BigInteger gcd = product.Numerator.gcd(product.Denominator);
product.Numerator = (product.Numerator).divide(gcd);
product.Denominator = (product.Denominator).divide(gcd);
return product;
}
public Rat sub(Rat x){
Rat product = new Rat();
product.Numerator = (this.Numerator.multiply(x.Denominator)).subtract(x.Numerator.multiply(this.Denominator));
product.Denominator = this.Denominator.multiply(x.Denominator);
BigInteger gcd = product.Numerator.gcd(product.Denominator);
product.Numerator = (product.Numerator).divide(gcd);
product.Denominator = (product.Denominator).divide(gcd);
return product;
}
public Rat mult(double x){
int doublex = (int)x;
String doubledx = Integer.toString(doublex);
Rat productor = new Rat(doubledx);
return this.mult(productor);

//return producted;
}
public Rat div(double x){
int doublex = (int)x;
String doubledx = Integer.toString(doublex);
Rat divisor = new Rat(doubledx);
return this.div(divisor);
}
public void equal(Rat x){
this.Numerator = x.Numerator;
this.Denominator = x.Denominator;
}
}
