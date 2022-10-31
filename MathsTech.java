/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathstech;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.math.BigDecimal;
import DRAWDIAMOND2.*;
import drawdiamond2.tri;
/**
 *
 * @author vv
 */
public class MathsTech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        tri t = new tri();
//        System.out.println(t.i);
           //_1stOrder("2-E^(-4x)-2y",0.001d,0,1,5,("1+(1/2)E^(-4x)-(1/2)E^(-2x)"));
           // _1stOrder("x+y+x*y",0.025,0,1,0.11);
            
         //  _1stOrder("y-(1/2)E^(0.5 x)sin(5x)+5 E^(0.5x)cos(5x)",0.0001d,0,0,0.5,"E^(0.5x)sin(5x)");
         // Trapezoidal("cos(x)",0,Math.PI/6,52); "festok.FXMLDocumentController"
         
           
        // TODO code application logic here     result = 0.4999957754539403 0.693126390392016.
//            String QQ = "-1/(abs(x)* SQRT (x^2-1))";
            //QQ = paperForm(QQ);
           // System.out.println(Simpson(QQ,-30,-5,6));
          //  System.out.println(Trapezoidal(QQ,-30,-5,6));
           
         // System.out.println(function(paperForm("2.996741282138415+0.1(ln(2.996741282138415)2.996741282138415/2.2)")));
          //System.out.println(Math.pow(Math.E,2.3/2));
//          System.out.println(function(paperForm("1/3-1-PI/4")));
//          System.out.println(function("SQRT(2)"));
         // _1stOrder("(x+y)sin(x*y)",0.1,0,1,2);
    //    System.out.println(Math.pow(Math.E,2));
//    String eqn = "(1/5)tan(x)^5 - ((1/3)tan(x)^3 - (tan(x) - x)) + Constant";
//     eqn = simplify(eqn,"+ Constant","");
//     eqn = eqn.replaceAll(" ","");
    
     String function = "3*(9*1-5+(5-3+1^(5+4*2^(5-3+1*2))))";
        System.out.println(function(paperForm(function)));
//     System.out.println(eqn);
     
//String p1 = (function(paperForm(eqn.replaceAll("x","(PI/4)"))));
//String p2 = (function(paperForm(eqn.replaceAll("x","(PI/6)"))));
//System.out.println(p1);
//System.out.println(p2);

//System.out.println(function(p1+"-"+p2));

//System.out.println(1/3*(Math.pow(Math.tan(Math.PI/4),3)-Math.tan(Math.PI/4)-Math.PI/4));
    }
    //Finds the exact solution in Simpson or Trapezoidal.
    public static double exact(String exactEQN , double limit1,double limit2){
        exactEQN = paperForm(exactEQN);
        double exact1 = Double.parseDouble(function(exactEQN.replaceAll("x","("+Double.toString(limit1)+")")));
        double exact2 = Double.parseDouble(function(exactEQN.replaceAll("x","("+Double.toString(limit2)+")")));
        if(limit1 == limit2)
            return 0;
        else if(limit1 > limit2)
            return exact1-exact2;
        else
            return exact2-exact1;
    }
    //Finds the error in Trapezoidal.
    public static double trapezoidalError(String equation,double limit1,double limit2,int N,String exact){
        exact = paperForm(exact);
        double exactAtLimit1 = Double.parseDouble(function(exact.replaceAll("x","("+Double.toString(limit1)+")")));
        double exactAtLimit2 = Double.parseDouble(function(exact.replaceAll("x","("+Double.toString(limit2)+")")));
        System.out.println("exact1 = "+exactAtLimit1);
        System.out.println("exact2 = "+exactAtLimit2);
        System.out.println("Trap = "+Trapezoidal(equation , limit1,limit2,N));
        
        if(limit1 == limit2)
            return 0;
        else if(limit1 > limit2){
          return ((Trapezoidal(equation,limit1,limit2,N) + (exactAtLimit1-exactAtLimit2))/(exactAtLimit1-exactAtLimit2))*100;
                }
        else return (((exactAtLimit2-exactAtLimit1)-(Trapezoidal(equation,limit1,limit2,N)))/((exactAtLimit2-exactAtLimit1)))*100;
    }
    //Finds the error in Simpson.
    public static double simpsonError(String equation,double limit1,double limit2,int N,String exact){
        exact = paperForm(exact);
        double exactAtLimit1 = Double.parseDouble(function(exact.replaceAll("x","("+Double.toString(limit1)+")")));
        double exactAtLimit2 = Double.parseDouble(function(exact.replaceAll("x","("+Double.toString(limit2)+")")));
        System.out.println("exact1 = "+exactAtLimit1);
        System.out.println("exact2 = "+exactAtLimit2);
        System.out.println("Trap = "+Simpson(equation , limit1,limit2,N));
        
        if(limit1 == limit2)
            return 0;
        else if(limit1 > limit2){
          return ((Simpson(equation,limit1,limit2,N) + (exactAtLimit1-exactAtLimit2))/(exactAtLimit1-exactAtLimit2))*100;
                }
        else return (((exactAtLimit2-exactAtLimit1)-(Simpson(equation,limit1,limit2,N)))/((exactAtLimit2-exactAtLimit1)))*100;
    }
    //Finds Trapezoidal integration.
    public static double Trapezoidal(String equation , double limit1,double limit2,int N){
        equation = paperForm(equation);
        if(limit1 == limit2)
            return 0;
        if(limit1 > limit2){
           double temp = limit1;
           limit1 = limit2;
           limit2 = temp;
             double h = (limit2 - limit1)/N;
    double sum = 0;
    for(double i = limit1+h;i<=limit2-h+0.01;i+=h){
     //System.out.println(2*Double.parseDouble(function(equation.replaceAll("x",Double.toString(i)))));
     sum+= Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(i)+")")));
    
    }
    sum = (h/2)*(Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit1)+")")))+Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit2)+")")))+2*(sum));
   // System.out.println("result = "+sum);
   
    return -sum;
        }
    equation = paperForm(equation);
    double h = (limit2 - limit1)/N;
    double sum = 0;
    for(double i = limit1+h;i<=limit2-h+0.01;i+=h){
     //System.out.println(2*Double.parseDouble(function(equation.replaceAll("x",Double.toString(i)))));
     sum+= Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(i)+")")));
    
    }
    sum = (h/2)*(Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit1)+")")))+Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit2)+")")))+2*(sum));
   // System.out.println("result = "+sum);
   
    return sum;
    }
    //Finds Simpson integration.
    public static double Simpson(String equation,double limit1,double limit2,int N){
     equation = paperForm(equation);
     if(limit1 == limit2)
      return 0;
     if(limit1 > limit2){
       double temp = limit1;
       limit1 = limit2;
       limit2 = temp;
       double h = (limit2 - limit1)/N;
    double sumOdd = 0;
    double sumEven = 0;
    double sum;
    int counter = 1;
   for(double i = limit1+h;i<=limit2-h+0.01;i+=h,counter++){
    if(counter%2==0)
      sumEven+=Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(i)+")")));
    else
      sumOdd+=Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(i)+")")));
     }
    sum = (h/3)*(Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit1)+")")))+Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit2)+")")))+2*sumEven+4*sumOdd);
  //d  System.out.println(sum);
    return -sum;
     }
    equation = paperForm(equation);
    double h = (limit2 - limit1)/N;
    double sumOdd = 0;
    double sumEven = 0;
    double sum;
    int counter = 1;
   for(double i = limit1+h;i<=limit2-h+0.01;i+=h,counter++){
    if(counter%2==0)
      sumEven+=Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(i)+")")));
    else
      sumOdd+=Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(i)+")")));
     }
    sum = (h/3)*(Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit1)+")")))+Double.parseDouble(function(equation.replaceAll("x","("+Double.toString(limit2)+")")))+2*sumEven+4*sumOdd);
  //d  System.out.println(sum);
    return sum;
    }
    //Solve First order differential equation without error.
    public static void _1stOrder(String equation, double h, double initX,double initY,double edge){
      DecimalFormat df = new DecimalFormat("###.############");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList((h))){
    Double d = n.doubleValue();
    h = Double.parseDouble(df.format(d));}  
    double x = initX;
    int counter = 0;
    String euler_Formula = "y"+"+"+Double.toString(h)+"("+equation+")";
    euler_Formula = paperForm(euler_Formula);
    System.out.println("euler formula = "+euler_Formula);
    String Yn = Double.toString(initY);
    for(x = initX  ; x <= edge+h ; x+=h,counter++){
    Yn = function(Yn);
    System.out.println("At X ="+x+" | Y"+counter+" = "+Yn);
    Yn = (euler_Formula.replaceAll("x","("+Double.toString(x)+")")).replaceAll("y","("+Yn+")");
    }
    }
    //Solve First order differential equation with error.
    public static void _1stOrderExact(String equation, double h, double initX,double initY,double edge,String Exact){
    BigDecimal H = new BigDecimal(Double.toString(h));
    String nH = H.toPlainString();
    
    System.out.println("h = "+nH);
    System.out.println("Given differential equation = "+equation);
    System.out.println("Exact formula = "+Exact);
    System.out.println("Euler general formula : Yn+1 = Yn + hf(Xn,Yn)");
    System.out.println("Hence, Yn+1 = Yn + "+nH+"("+equation+")");
    System.out.println("------------------------------------------------------------------");
    double x = initX;
    int counter = 0;
    double ERROR;
    String euler_Formula = "y"+"+"+nH+"("+equation+")";
    euler_Formula = paperForm(euler_Formula);
    String Yn = Double.toString(initY);
    Exact = paperForm(Exact);
    String Ex = paperForm(Exact);
    for(x = initX  ; x <= edge+h ; x+=h,counter++){
    Yn = function(Yn);
    Ex = function(Exact.replaceAll("x",Double.toString(x)));
     if(Double.parseDouble(function(Yn)) == Double.parseDouble(Ex)){
      ERROR = 0 ;
    }
    else{
    ERROR = Math.abs(-Double.parseDouble(Yn)+Double.parseDouble(Ex))/Double.parseDouble(Ex)*100;
    DecimalFormat df1 = new DecimalFormat("###.##");
    df1.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList((ERROR))){
    Double d = n.doubleValue();
    ERROR = Double.parseDouble(df1.format(d));}
    }
   System.out.println("At x = "+(new BigDecimal(Double.toString(x)).toPlainString()));
   System.out.println("Approximate Soln = "+Yn);
   System.out.println("Exact Soln = "+Ex);
   System.out.println("Error = "+ERROR+"%");
   Yn = (euler_Formula.replaceAll("x","("+Double.toString(x)+")")).replaceAll("y","("+Yn+")");
   //System.out.println("Next Euler formula will be : "+Yn);
   System.out.println("------------------------------------------------------------------");
    }
    }
    //These methods are used to make the user input his desired function.
    public static String paperForm(String equation){
        if(equation.contains(" ")){
     return paperForm(equation.replaceAll(" ",""));
        }
    if(equation.contains(")("))
      return paperForm(simplify(equation,")(" , ")*("));
    for(int i = 0 ; i < equation.length()-1 ; i++){
      
        if(isDigit(equation.charAt(i)) && isLetter(equation.charAt(i+1))){
          
          return paperForm(equation.substring(0,i+1)+"*"+equation.substring(i+1));
        }
    }
       for(int i = 1 ; i < equation.length() && i >= 0 ; i++){
        if(equation.charAt(i) == '(' && ( isDigit(equation.charAt(i-1))))
          return paperForm(equation.substring(0,i)+"*"+equation.substring(i));

   }
          for(int i = 0 ; i < equation.length()-1 ; i++){
        if(equation.charAt(i) == ')' && (isLetter(equation.charAt(i+1)) || isDigit(equation.charAt(i+1))))
          return paperForm(equation.substring(0,i+1)+"*"+equation.substring(i+1));

   }
       if(equation.contains("PI")){
       return paperForm(equation.replaceAll("PI", Double.toString(Math.PI)));
      }
       if(equation.contains("E")){
      return paperForm(equation.replaceAll("E", Double.toString(Math.E)));
       }
        return equation;
    }
    public static String exponentiation(String equation){
   //     System.out.println("expo = "+equation);
    for(int i = 0 ; i<equation.length();i++){
    if(equation.charAt(i)=='^'){
    String in = Double.toString((Math.pow(Double.parseDouble(((exponentiation(preBracket(equation,i))))),Double.parseDouble(((exponentiation(postBracket(equation,i))))))));
    DecimalFormat df = new DecimalFormat("#.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return exponentiation(simplify(equation,justPreBracket(equation,i)+"^"+justPostBracket(equation,i),in));
    }    
    }
    return simplifyBrackets(equation);
}   
    public static String product(String equation){
     for(int i = 0 ; i<equation.length()-1;i++){
     if(equation.contains("+-"))
         equation = simplify(equation,"+-","-");
     if(equation.contains("--"))
         equation = simplify(equation,"--","+");
     if(equation.contains("++"))
         equation = simplify(equation,"++","+");
     if(equation.contains("+-"))
         equation = simplify(equation,"+-","-");
     }
    
    for(int i = 1 ; i<equation.length();i++){
    if(equation.charAt(i) == '/'){
    
    String out =((findReverseNumber(equation,i))+"/"+(findFrontNumber(equation,i)));
    String in = Double.toString(Double.parseDouble(findReverseNumber(equation,i))/Double.parseDouble(findFrontNumber(equation,i)));
    DecimalFormat df = new DecimalFormat("#.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
   if(Double.parseDouble(in) >= 0)
    equation = simplify(equation,out,"+"+in);
   
    
    else
     equation = simplify(equation,out,in);
    return product(equation);

    }
     if(equation.charAt(i) == '*'){
    
    String out =((findReverseNumber(equation,i))+"*"+(findFrontNumber(equation,i)));
    String in = Double.toString(Double.parseDouble(findReverseNumber(equation,i))*Double.parseDouble(findFrontNumber(equation,i)));
    DecimalFormat df = new DecimalFormat("#.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    if(Double.parseDouble(in) >= 0)
    equation = simplify(equation,out,"+"+in);
    else
    equation = simplify(equation,out,in);

     return product(equation);

    }
    }
    return equation;
    
    
    }
    public static String Arithmetic(String equation){
   for(int i = 0 ; i<equation.length()-1;i++){
     if(equation.contains("+-"))
         equation = simplify(equation,"+-","-");
     if(equation.contains("--"))
         equation = simplify(equation,"--","+");
     if(equation.contains("++"))
         equation = simplify(equation,"++","+");
     if(equation.contains("+-"))
         equation = simplify(equation,"+-","-");
     }
    for(int i = 1 ; i<equation.length();i++){
    if(equation.charAt(i) == '-'){
    
    String out =((findReverseNumber(equation,i))+"-"+(findFrontNumber(equation,i)));
    String in = Double.toString(Double.parseDouble(findReverseNumber(equation,i))-Double.parseDouble(findFrontNumber(equation,i)));
    DecimalFormat df = new DecimalFormat("#.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    
    equation = simplify(equation,out,in);
    return Arithmetic(equation);
    
    }
    if(equation.charAt(i) == '+'){
    
    String out =((findReverseNumber(equation,i))+"+"+(findFrontNumber(equation,i)));
    String in = Double.toString(Double.parseDouble(findReverseNumber(equation,i))+Double.parseDouble(findFrontNumber(equation,i)));
    DecimalFormat df = new DecimalFormat("#.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    equation = simplify(equation,out,in);
    return Arithmetic(equation);

    }
    }
    return (equation);
    }
    public static String frontBracket(String equation,int index){
    int parentheser=0;
     
    for(int i =index ; i<equation.length();i++){ 
    
    if(equation.charAt(i)=='(' ){
    for(int j = i;j<equation.length();j++){
    if(equation.charAt(j)=='(' ){
    ++parentheser;
    }
    else if(equation.charAt(j)==')')--parentheser;
    if(parentheser == 0)
    return equation.substring(i+1,j);
    }
    }
    }
    return findFrontNumber(equation,index);
}
    public static String reverseBracket(String equation,int index){
    int parentheser = 0;
    boolean bracket = false ;
    for(int i = index-1 ; i<equation.length() && i >=0;i--){
    if(equation.charAt(i) == ')'){
    ++parentheser;
    bracket = true;
    }
    else if(equation.charAt(i) == '(')
    --parentheser;
    if(parentheser == 0 && bracket)
    return equation.substring(i,index);
    }
    return unsignedREVNumber(equation,index);
    }
    public static String findFrontNumber(String equation,int index){
    int start;
    if(equation.length() == 1)
     return equation;
    if(equation.charAt(index+1)=='-' || equation.charAt(index+1) == '+'){
     start = index+2;
    }
    else{
     start = index+1;
     
    }
    for(int i = start ;i<equation.length();i++){
    
     if((!isDigit(equation.charAt(i)) && equation.charAt(i)!='.')){
     return equation.substring(index+1,i);
     }
     }
    return equation.substring(index+1);
    }
    public static String findReverseNumber(String equation,int index){
  
      int i;

    for(i = index-1 ;i<index && i>=0 ;i--){
    
     if((!isDigit(equation.charAt(i)) && equation.charAt(i)!='.')){
      if(equation.charAt(i) == '-' || equation.charAt(i) == '+')
     return equation.substring(i,index);
       else
         return equation.substring(i+1,index);
     }
     }
    return equation.substring(i+1,index);
    }
    public static String findJustREVNumber(String equation,int index){
        
      int i;

    for(i = index-1 ; i>=0 ;--i){
    

     if((!isDigit(equation.charAt(i)) && equation.charAt(i)!='.')){
         if(equation.substring(i,index).equals("")){
         return "0";
         } else {
             return equation.substring(i,index);
         }
     }
     }
    ++i;
 
    if(equation.substring(i,index).equals("")){
         return "0";
         } else {
      
             return equation.substring(i,index);
         }
}
    public static String simplify(String original,String out,String in){

   return original.substring(0, original.indexOf(out))+in+original.substring(out.length()+original.substring(0, original.indexOf(out)).length());}
    public static String justReverseBracket(String equation,int index){
      int parentheser = 0;
    boolean bracket = false ;
    for(int i = index-1 ; i<equation.length() && i >=0;i--){
    if(equation.charAt(i) == ')'){
    ++parentheser;
    bracket = true;
    }
    else if(equation.charAt(i) == '(')
    --parentheser;
    if(parentheser == 0 && bracket)
    return equation.substring(i,index);
    }
    return unsignedREVNumber(equation,index);
    }
    public static String justFrontBracket(String equation,int index){
     int parentheser=0;
    for(int i =index ; i<equation.length();i++){
    if(equation.charAt(i) == ')') break;
    if(equation.charAt(i)=='(' ){
    for(int j = i;j<equation.length();j++){
    if(equation.charAt(j)=='(' ){
    ++parentheser;
    }
    else if(equation.charAt(j)==')')--parentheser;
    if(parentheser == 0)
    return equation.substring(i,j+1);
    }
    }
    }
    return findFrontNumber(equation,index);
}
    public static String unsignedREVNumber(String equation , int index){
       int i;

    for(i = index-1 ;i<index && i>=0 ;i--){
    
     if((!isDigit(equation.charAt(i)) && equation.charAt(i)!='.')){
     
     return equation.substring(i+1,index);
     }
     }
    return equation.substring(i+1,index);
    }
    public static String simplifyBrackets(String equation){
   
    if(!equation.contains("("))
    return Arithmetic(product(equation));
    else{
      
    equation = simplify(equation,justFrontBracket(equation,0),simplifyBrackets(frontBracket(equation,0)));
    
    
    return simplifyBrackets(equation);
    }
    }
    public static String postBracket(String equation,int indexOfPowerSign){
     int parentheser=0; 
    for(int i =indexOfPowerSign ; i<equation.length();i++){ 
    if(equation.charAt(indexOfPowerSign +1)!='(' )break;
    if(equation.charAt(i)=='(' ){
    for(int j = i;j<equation.length();j++){
    if(equation.charAt(j)=='(' ){
    ++parentheser;
    }
    else if(equation.charAt(j)==')')--parentheser;
    if(parentheser == 0)
    return equation.substring(i+1,j);
    }
    }
    }
    return findFrontNumber(equation,indexOfPowerSign);
        
        
    }
    public static String justPostBracket(String equation,int indexOfPowerSign){
    int parentheser=0; 
    for(int i =indexOfPowerSign ; i<equation.length();i++){ 
    if(equation.charAt(indexOfPowerSign +1)!='(' )break;
    if(equation.charAt(i)=='(' ){
    for(int j = i;j<equation.length();j++){
    if(equation.charAt(j)=='(' ){
    ++parentheser;
    }
    else if(equation.charAt(j)==')')--parentheser;
    if(parentheser == 0)
    return equation.substring(i,j+1);
    }
    }
    }
    return findFrontNumber(equation,indexOfPowerSign);
    }
    public static String preBracket(String equation,int indexOfPowerSign){
    int parentheser = 0;
    boolean isBracketed = true;
    if(equation.charAt(indexOfPowerSign-1) != ')') isBracketed = false;
    for(int i = indexOfPowerSign-1 ;i >=0 && isBracketed;i--){
    if(equation.charAt(i) == ')'){
    ++parentheser;
    }
    else if(equation.charAt(i) == '(')
    --parentheser;
    if(parentheser == 0)
    return equation.substring(i+1,indexOfPowerSign-1);
    }
    return unsignedREVNumber(equation,indexOfPowerSign);
    }
    public static String justPreBracket(String equation,int indexOfPowerSign){
    int parentheser = 0;
    boolean isBracketed = true;
    if(equation.charAt(indexOfPowerSign-1) != ')') isBracketed = false;
    for(int i = indexOfPowerSign-1 ;i >=0 && isBracketed;i--){
    if(equation.charAt(i) == ')'){
    ++parentheser;
    }
    else if(equation.charAt(i) == '(')
    --parentheser;
    if(parentheser == 0)
    return equation.substring(i,indexOfPowerSign);
    }
    return unsignedREVNumber(equation,indexOfPowerSign);
    }
    public static String function(String equation){
    if(equation.contains("E")){
   return function(equation.replaceAll("E","*10^"));
    }
    for(int i = 0 ; i<equation.length() && equation.contains("abs"); i++){
    if(equation.contains("abs")){
    String in = Double.toString(Math.abs((Double.parseDouble(function(postBracket(equation,equation.indexOf("abs")+2))))));
    String out = "abs"+justPostBracket(equation,equation.indexOf("abs")+2);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
    for(int i = 0 ; i<equation.length() && equation.contains("CBRT"); i++){
    if(equation.contains("CBRT")){
    String in = Double.toString(Math.cbrt((Double.parseDouble(function(postBracket(equation,equation.indexOf("CBRT")+3))))));
    String out = "CBRT"+justPostBracket(equation,equation.indexOf("CBRT")+3);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
    for(int i = 0 ; i<equation.length() && equation.contains("SQRT"); i++){
    if(equation.contains("SQRT")){
    String in = Double.toString(Math.sqrt((Double.parseDouble(function(postBracket(equation,equation.indexOf("SQRT")+3))))));
    String out = "SQRT"+justPostBracket(equation,equation.indexOf("SQRT")+3);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
    for(int i = 0 ; i<equation.length() && equation.contains("log"); i++){
    if(equation.contains("log")){
    String in = Double.toString(Math.log((Double.parseDouble(function(postBracket(equation,equation.indexOf("log")+2))))));
    String out = "log"+justPostBracket(equation,equation.indexOf("log")+2);
  
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
     for(int i = 0 ; i<equation.length() && equation.contains("ln"); i++){
    if(equation.contains("ln")){
    String in = Double.toString(Math.log((Double.parseDouble(function(postBracket(equation,equation.indexOf("ln")+1))))));
    String out = "ln"+justPostBracket(equation,equation.indexOf("ln")+1);
  
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
        
    for(int i = 0 ; i<equation.length() && equation.contains("sinh"); i++){
    if(equation.contains("sinh")){
    String in = Double.toString(Math.sinh((Double.parseDouble(function(postBracket(equation,equation.indexOf("sinh")+3))))));
    String out = "sinh"+justPostBracket(equation,equation.indexOf("sinh")+3);
   
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
      for(int i = 0 ; i<equation.length() && equation.contains("cosh"); i++){
    
    if(equation.contains("cosh")){
    String in = Double.toString(Math.cosh((Double.parseDouble(function(postBracket(equation,equation.indexOf("cosh")+3))))));
    String out = "cosh"+justPostBracket(equation,equation.indexOf("cosh")+3);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
    for(int i = 0 ; i<equation.length()&& equation.contains("tanh"); i++){   
    if(equation.contains("tanh")){
    String in = Double.toString(Math.tanh((Double.parseDouble(function(postBracket(equation,equation.indexOf("tanh")+3))))));
    String out = "tanh"+justPostBracket(equation,equation.indexOf("tanh")+3);
  
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
     for(int i = 0 ; i<equation.length()&& equation.contains("sech"); i++){   
     if(equation.contains("sech")){
    String in = Double.toString(sech((Double.parseDouble(function(postBracket(equation,equation.indexOf("sech")+3))))));
    String out = "sech"+justPostBracket(equation,equation.indexOf("sech")+3);
     
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    } 
      for(int i = 0 ; i<equation.length()&& equation.contains("csch"); i++){   
    if(equation.contains("csch")){
    String in = Double.toString(csch((Double.parseDouble(function(postBracket(equation,equation.indexOf("csch")+3))))));
    String out = "csch"+justPostBracket(equation,equation.indexOf("csch")+3);
 
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    } 
       for(int i = 0 ; i<equation.length()&& equation.contains("coth"); i++){   
    if(equation.contains("coth")){
    String in = Double.toString(coth((Double.parseDouble(function(postBracket(equation,equation.indexOf("coth")+3))))));
    String out = "coth"+justPostBracket(equation,equation.indexOf("coth")+3);
     
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    } 
    for(int i = 0 ; i<equation.length()&& equation.contains("asin"); i++){
    if(equation.contains("asin")){
    String in = Double.toString(Math.asin((Double.parseDouble(function(postBracket(equation,equation.indexOf("asin")+3))))));
    String out = "asin"+justPostBracket(equation,equation.indexOf("asin")+3);
     
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  for(int i = 0 ; i<equation.length()&& equation.contains("acos"); i++){
    
    if(equation.contains("acos")){
    String in = Double.toString(Math.acos((Double.parseDouble(function(postBracket(equation,equation.indexOf("acos")+3))))));
    String out = "acos"+justPostBracket(equation,equation.indexOf("acos")+3);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  
    for(int i = 0 ; i<equation.length()&& equation.contains("atan"); i++){
    if(equation.contains("atan")){
    String in = Double.toString(Math.atan((Double.parseDouble(function(postBracket(equation,equation.indexOf("atan")+3))))));
    String out = "atan"+justPostBracket(equation,equation.indexOf("atan")+3);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
        for(int i = 0 ; i<equation.length()&& equation.contains("asec"); i++){
    if(equation.contains("asec")){
    String in = Double.toString(asec((Double.parseDouble(function(postBracket(equation,equation.indexOf("asec")+3))))));
    String out = "asec"+justPostBracket(equation,equation.indexOf("asec")+3);
   
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    } 
            for(int i = 0 ; i<equation.length()&& equation.contains("acsc"); i++){
    if(equation.contains("acsc")){
    String in = Double.toString(acsc((Double.parseDouble(function(postBracket(equation,equation.indexOf("acsc")+3))))));
    String out = "acsc"+justPostBracket(equation,equation.indexOf("acsc")+3);
   
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    } 
                for(int i = 0 ; i<equation.length() && equation.contains("acot"); i++){
    if(equation.contains("acot")){
    String in = Double.toString(acot((Double.parseDouble(function(postBracket(equation,equation.indexOf("acot")+3))))));
    String out = "acot"+justPostBracket(equation,equation.indexOf("acot")+3);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    } 
    for(int i = 0 ; i<equation.length()&& equation.contains("sin"); i++){
    if(equation.contains("sin")){
    String in = Double.toString(Math.sin((Double.parseDouble(function(postBracket(equation,equation.indexOf("sin")+2))))));
    String out = "sin"+justPostBracket(equation,equation.indexOf("sin")+2);

    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  
    for(int i = 0 ; i<equation.length()&& equation.contains("cos"); i++){
    if(equation.contains("cos")){
    String in = Double.toString(Math.cos((Double.parseDouble(function(postBracket(equation,equation.indexOf("cos")+2))))));
    String out = "cos"+justPostBracket(equation,equation.indexOf("cos")+2);
  
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  for(int i = 0 ; i<equation.length()&& equation.contains("tan"); i++){
    
    if(equation.contains("tan")){
    String in = Double.toString(Math.tan((Double.parseDouble(function(postBracket(equation,equation.indexOf("tan")+2))))));
    String out = "tan"+justPostBracket(equation,equation.indexOf("tan")+2);
    
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  for(int i = 0 ; i<equation.length()&& equation.contains("sec"); i++){
    
    if(equation.contains("sec")){
    String in = Double.toString(sec((Double.parseDouble(function(postBracket(equation,equation.indexOf("sec")+2))))));
    String out = "sec"+justPostBracket(equation,equation.indexOf("sec")+2);
  
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  for(int i = 0 ; i<equation.length()&& equation.contains("csc"); i++){
    
    if(equation.contains("csc")){
    String in = Double.toString(csc((Double.parseDouble(function(postBracket(equation,equation.indexOf("csc")+2))))));
    String out = "csc"+justPostBracket(equation,equation.indexOf("csc")+2);
     
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }  for(int i = 0 ; i<equation.length()&& equation.contains("cot"); i++){
    
    if(equation.contains("cot")){
    String in = Double.toString(cot((Double.parseDouble(function(postBracket(equation,equation.indexOf("cot")+2))))));
    String out = "cot"+justPostBracket(equation,equation.indexOf("cot")+2);
 
    DecimalFormat df = new DecimalFormat("##.####################");
    df.setRoundingMode(RoundingMode.CEILING);
    for (Number n : Arrays.asList(Double.parseDouble(in))){
    Double d = n.doubleValue();
    in = df.format(d);
    }
    return function(simplify(equation,out,"("+in+")"));
    }
    }
        
        
       
    return exponentiation
                
        (equation);
    }
    //This is additional trigonometric function that has not been built in Java.
    public static double sec(double angle){
    return 1/(Math.cos(angle));
    }
    public static double csc(double angle){
    return 1/(Math.sin(angle));
    }
    public static double cot(double angle){
    return 1/(Math.tan(angle));
    }
    public static double sech(double angle){
    return 1/(Math.cosh(angle));
    } 
    public static double csch(double angle){
    return 1/(Math.sinh(angle));
    } 
    public static double coth(double angle){
     return 1/(Math.tanh(angle));
    }
    public static double asec(double angle){
    return Math.acos(1/angle);
    }
    public static double acsc(double angle){
    return Math.asin(1/angle);
    }
    public static double acot(double angle){
    return Math.atan(1/angle);
    }
    public static long   gcd(long x, long y){
    return y == 0 ? x : gcd(y, x % y);}
}
