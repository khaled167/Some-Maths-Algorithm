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
public class Integration {
//DEFINITE INTEGRALS
public  double definiteIntegralSEC(double n,double x1,double x2){
if(n < 0 ){return definiteIntegralCOS(Math.abs(n),x1,x2);}     
double sum=0;
int Start;
if(n%2==0){
Start =2;}
else{
sum=Math.log(Math.tan(Math.toRadians(x2))+(1/(Math.cos(Math.toRadians(x2)))));
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = (1/(i*1.0-1))*Math.tan(Math.toRadians( x2 ))*Math.pow((1/Math.cos(Math.toRadians(x2))),i-2);
sum = UV_Term+((i*1.0-2)/(i*1.0-1))*sum;
}
double sum1=0;
if(n%2==0){

Start =2;}
else{
sum1=Math.log(Math.tan(Math.toRadians(x1))+(1/(Math.cos(Math.toRadians(x1)))));
Start =3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = (1/(i*1.0-1))*Math.tan(Math.toRadians( x1 ))*Math.pow((1/Math.cos(Math.toRadians(x1))),i-2);
sum1 = UV_Term+((i*1.0-2)/(i*1.0-1))*sum1;
} 
return sum-sum1;
}
public  double definiteIntegralCSC(double n,double x1,double x2){
if(n < 0 ){return definiteIntegralSIN(Math.abs(n),x1,x2);}
double sum=0;
int Start;
if(n%2==0){
Start =2;}
else{
sum = -Math.log(cot(Math.toRadians(x2))+((csc(Math.toRadians(x2)))));
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = -(1/(i*1.0-1))*cot(Math.toRadians( x2 ))*Math.pow((csc(Math.toRadians(x2))),i-2);
sum = UV_Term+((i*1.0-2)/(i*1.0-1))*sum;
}
double sum1=0;
if(n%2==0){
Start =2;}
else{
sum1=-Math.log(cot(Math.toRadians(x1))+((csc(Math.toRadians(x1)))));
Start =3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = -(1/(i*1.0-1))*cot(Math.toRadians( x1 ))*Math.pow((csc(Math.toRadians(x1))),i-2);
sum1 = UV_Term+((i*1.0-2)/(i*1.0-1))*sum1;
} 
return sum-sum1;
}
public  double definiteIntegralSIN(double n , double x1,double x2){
if(n < 0 ){return definiteIntegralCSC(Math.abs(n),x1,x2);}
x1 = Math.toRadians(x1);
x2 = Math.toRadians(x2);
double sum=0;
int Start;
if(n%2==0){
sum = x2;
Start =2;}
else{
sum = -Math.cos(x2);
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = -(1/(i*1.0))*Math.cos(x2)*Math.pow((Math.sin(x2)),i-1);
sum = UV_Term+((i*1.0-1)/(i*1.0))*sum;
}
double sum1=0;
if(n%2==0){
sum1 = x1;
Start =2;}
else{
sum1 = -Math.cos(x1);
Start =3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = -(1/(i*1.0))*Math.cos(x1)*Math.pow((Math.sin(x1)),i-1);
sum1 = UV_Term+((i*1.0-1)/(i*1.0))*sum1;
} 
return sum-sum1;

}
public  double definiteIntegralCOS(double n , double x1,double x2){
if(n < 0 ){return definiteIntegralSEC(Math.abs(n),x1,x2);}
x1 = Math.toRadians(x1);
x2 = Math.toRadians(x2);
double sum=0;
int Start;
if(n%2==0){
sum = x2;
Start =2;}
else{
sum = Math.sin(x2);
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = (1/(i*1.0))*Math.sin(x2)*Math.pow((Math.cos(x2)),i-1);
sum = UV_Term+((i*1.0-1)/(i*1.0))*sum;
}
double sum1=0;
if(n%2==0){
sum1 = x1;
Start =2;}
else{
sum1 = Math.sin(x1);
Start =3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = (1/(i*1.0))*Math.sin(x1)*Math.pow((Math.cos(x1)),i-1);
sum1 = UV_Term+((i*1.0-1)/(i*1.0))*sum1;
} 
return sum-sum1;
}
public  double definiteIntegralTAN(double n , double x1,double x2){
if(n < 0 ){return definiteIntegralCOTAN(Math.abs(n),x1,x2);}
x1 = Math.toRadians(x1);
x2 = Math.toRadians(x2);
double sum=0;
int Start;
if(n%2==0){
sum = x2;
Start =2;}
else{
sum = Math.log(sec(x2));
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = (1/(i*1.0-1))*Math.pow((Math.tan(x2)),i-1);
sum = UV_Term-sum;
}
double sum1=0;
if(n%2==0){
sum1 = x1;
Start =2;}
else{
sum1 = Math.log(sec(x1));
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = (1/(i*1.0-1))*Math.pow((Math.tan(x1)),i-1);
sum1 = UV_Term-sum1;
} 
return sum-sum1;
}
public  double definiteIntegralCOTAN(double n , double x1,double x2){
if(n < 0 ){return definiteIntegralTAN(Math.abs(n),x1,x2);}
x1 = Math.toRadians(x1);
x2 = Math.toRadians(x2);
double sum=0;
int Start;
if(n%2==0){
sum = x2;
Start =2;}
else{
sum = -Math.log(csc(x2));
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = -(1/(i*1.0-1))*Math.pow((cot(x2)),i-1);
sum = UV_Term-sum;
}
double sum1=0;
if(n%2==0){
sum1 = x1;
Start =2;}
else{
sum1 = -Math.log(csc(x1));
Start=3;
}
for(int i=Start;i<=n;i+=2){
double UV_Term = -(1/(i*1.0-1))*Math.pow((cot(x1)),i-1);
sum1 = UV_Term-sum1;
} 
return sum-sum1;
}
//INDEFINITE INTEGRALS
public  Object indefiniteIntegralSEC(int n){
if(n==1){
return "ln|sec(x)+tan(x)| + Constant";
}

Object result;
int Start;
if(n==0){
return "x + Constant";
}
if(n==2){
return "tan(x) + Constant";
}
if(n%2==0){
result="tan(x)";
Start=4;
}
else{
result = "(1/2)tan(x)sec(x) + (1/2)ln|sec(x)+tan(x)|";
Start =5;
}   
for(int i=Start;i<=n;i+=2){
int powers=i-2;
Object factorOfIntegral=termFactor(i-2,i-1);
Object UV_term=termFactor(1,i-1)+"tan(x)"+"sec(x)^"+(powers);    
result = UV_term+" + "+factorOfIntegral+"*("+result+")";
}
return result+" + Constant";
}
public  Object indefiniteIntegralByTan(int n){
if(n < 0)
 return indefiniteIntegralBySin(Math.abs(n));
if(n%2!=0){
return indefiniteIntegralSEC(n);
}
if(n==0){
return "x + Constant";
}
Object Term="";
int noPower=3;
for(int i=1;i<n/2;i++){
Term += termFactor(comb((n/2)-1,i),noPower)+"tan(x)^"+noPower+" + ";
noPower+=2;
}
return "tan(x) + "+Term+"Constant";
}
public  Object indefiniteIntegralByCotan(int n){
    if(n < 0){
        return indefiniteIntegralByCos(Math.abs(n));
    }
if(n%2!=0){
return indefiniteIntegralCSC(n);
}
if(n==0){
return "x + Constant";
}
Object Term="";
int noPower=3;
for(int i=1;i<n/2;i++){
Term += termFactor(comb((n/2)-1,i),noPower)+"cotan(x)^"+noPower+" - ";
noPower+=2;
}
return "-cotan(x) - "+Term+"Constant";
}
public  Object indefiniteIntegralCSC(int n){
Object result;
int Start;
if(n==1){
return "-ln|cosec(x)+cotan(x) + Constant";
}
if(n==0){
return "-x + Constant";
}
if(n==2){
return "cotan(x) + Constant";
}
if(n%2==0){
result="cotan(x)";
Start=4;
}
else{
result = "(1/2)cotan(x)cosec(x) - (1/2)*ln|cosec(x)+cotan(x)|";
Start =5;
}   
for(int i=Start;i<=n;i+=2){
int powers=i-2;
Object factorOfIntegral=termFactor(i-2,i-1);
Object UV_term=termFactor(1,i-1)+"cotan(x)"+"cosec(x)^"+(powers);    
result = UV_term+" - "+factorOfIntegral+"*("+result+")";
}
return "-"+result+" + Constant";
}
public  Object indefiniteIntegralSIN(int n){


Object result;
int Start;
if(n==0){
return "x + Constant";
}
if(n==1){
return "-cos(x) + Constant";
}
if(n%2!=0){
result="cos(x)";
Start=3;
}
else{
result = "x";
Start =2;
}   
for(int i=Start;i<=n;i+=2){
int powers=i-1;
Object factorOfIntegral=termFactor(i-1,i);
Object UV_term=termFactor(-1,i)+"cos(x)"+"sin(x)^"+(powers);    
result = UV_term+" + "+factorOfIntegral+"*("+result+")";
}
return result+" + Constant";

}
public  Object indefiniteIntegralByCos(int n ){
    if(n < 0)
        return indefiniteIntegralByCotan(Math.abs(n));
    if(n==1)
        return "-Cos(x) + Constant";
n+=2;
if(n==3)
   return "(1/3)cos(x)^3-cos(x)+Constant";
if(n%2==0)
return indefiniteIntegralSIN(n);
 Object Term="";
int noPower=3;
for(int i=1;i<n/2;i++){
Term += termFactor(Math.pow(-1,i+1)*comb((n/2)-1,i),noPower)+"cos(x)^"+noPower+" + ";

noPower+=2;
}
return "-cos(x) + "+Term+"Constant";
 
}
public  Object indefiniteIntegralCOS(int n){



Object result;
int Start;
if(n==0){
return "x + Constant";
}
if(n==1){
return "Sin(x) + Constant";
}
if(n%2!=0){
result="Sin(x)";
Start=3;
}
else{
result = "x";
Start =2;
}   
for(int i=Start;i<=n;i+=2){
int powers=i-1;
Object factorOfIntegral=termFactor(i-1,i);
Object UV_term=termFactor(1,i)+"Sin(x)"+"Cos(x)^"+(powers);    
result = UV_term+" + "+factorOfIntegral+"*("+result+")";
}
return result+" + Constant";

}
public  Object indefiniteIntegralBySin(int n ){
    if(n < 0)
        return indefiniteIntegralByTan(Math.abs(n));
    if(n==1)
        return "Sin(x) + Constant";
n+=2;
if(n==3)
 return "Sin(x)-(1/3)Sin(x)^3 + Constant";
if(n%2==0)
return indefiniteIntegralCOS(n);
 Object Term="";
int noPower=3;
for(int i=1;i<n/2;i++){
Term += termFactor(Math.pow(-1,i)*comb((n/2)-1,i),noPower)+"Sin(x)^"+noPower+" + ";

noPower+=2;
}
return "Sin(x) + "+Term+"Constant";
 
}
public  Object indefiniteIntegralTAN(int n){
    if(n < 0)
        return indefiniteIntegralCOTAN(Math.abs(n));
if(n==1){
return "ln|sec(x)| + Constant";
}

Object result;
int Start;
if(n==0){
return "x + Constant";
}

if(n%2==0){
result="tan(x) - x";
Start=4;
}
else{
result = "(1/2)tan(x)^2 - ln|sec(x)|";
Start =5;
}   
for(int i=Start;i<=n;i+=2){
int powers=i-1;

Object UV_term=termFactor(1,i-1)+"tan(x)^"+(powers);    
result = UV_term+" - "+"("+result+")";
}
return result+" + Constant";
}
public  Object indefiniteIntegralCOTAN(int n){
    if(n < 0)
     return indefiniteIntegralTAN(Math.abs(n));
    if(n==1){
return "-ln|sec(x)| + Constant";
}

Object result;
int Start;
if(n==0){
return "x + Constant";
}

if(n%2==0){
result="Cot(x) - x";
Start=4;
}
else{
result = "(1/2)Cot(x)^2 + ln|sec(x)|";
Start =5;
}   
for(int i=Start;i<=n;i+=2){
int powers=i-1;

Object UV_term=termFactor(1,i-1)+"Cot(x)^"+(powers);    
result = UV_term+" - "+"("+result+")";
}
return "-("+result+")"+" + Constant";
}
public  Object indefiniteIntegralSinSin(double n,double m){
double sum=n+m;
double dif=n-m;
if(n == 0 && m == 0){
    return "Constant";
}
if(n+m == 0){
 return "-(1/2)x"+"+"+termFactor(1,2*Math.abs(dif))+"Sin("+Math.abs(dif)+"x)";
}
 if(n-m == 0 ){
 return "-"+termFactor(1,2*Math.abs(sum))+"Sin("+Math.abs(sum)+"x)"+"+(1/2)x";
}
return termFactor(1,2*Math.abs(dif))+"Sin("+Math.abs(dif)+"x)"+" - "+termFactor(1,2*Math.abs(sum))+"Sin("+Math.abs(sum)+"x)";
}
public  Object indefiniteIntegralCosCos(double n,double m){
double sum=n+m;
double dif=n-m;
if(n == 0 && m == 0){
    return "Constant";
}
if(n+m == 0){
 return "(1/2)x"+"+"+termFactor(1,2*Math.abs(dif))+"Sin("+Math.abs(dif)+"x)";
}
 if(n-m == 0 ){
 return termFactor(1,2*Math.abs(sum))+"Sin("+Math.abs(sum)+"x)"+"+(1/2)x";
}
return termFactor(1,2*Math.abs(dif))+"Sin("+Math.abs(dif)+"x)"+" + "+termFactor(1,2*Math.abs(sum))+"Sin("+Math.abs(sum)+"x)";
}
public  Object indefiniteIntegralSinCos(double n,double m){
double sum=n+m;
double dif=m-n;
if(sum==0 && dif == 0){
return "Constant";
}
if(dif == 0){
if(sum < 0){
return termFactor(1,2*Math.abs(sum))+"cos("+Math.abs(sum)+"x)";
}
return "-"+termFactor(1,2*sum)+"cos("+Math.abs(sum)+"x)";
}
if(sum == 0)
    return termFactor(1,2*dif)+"Cos("+Math.abs(dif)+"x)";
if(sum < 0){
return termFactor(1,2*dif)+"Cos("+Math.abs(dif)+"x)"+termFactor(1,2*Math.abs(sum))+"cos("+Math.abs(sum)+"x)";
}
return termFactor(1,2*dif)+"Cos("+Math.abs(dif)+"x)"+" - "+termFactor(1,2*sum)+"cos("+Math.abs(sum)+"x)";

}
//OPERATORS..
public  Object termFactor(double x,double y){
if(y==0){
return "Error you cannot divide by zero.";
}
if((x/y)==(int)(x/y)){
if(x/y==1){
return "";
}
return (int)(x/y);
}
else
return "("+(int)x+"/"+(int)y+")";
}
public  int factorial(int n){
if(n==0){
return 1;
}
int factorial =1;
for(int i=n;i>0;i--){
factorial = factorial*i;
}
return factorial;
}
public  int comb(int n,int r){
return factorial(n)/((factorial(n-r))*factorial(r));
}
public  double sec(double angle){
    return 1/(Math.cos(angle));
    }
public  double csc(double angle){
    return 1/(Math.sin(angle));
    }
public  double cot(double angle){
    return 1/(Math.tan(angle));
    }
}
