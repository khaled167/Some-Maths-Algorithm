package mathtech;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
public class Differentiaon_Equations {
    public static void _1stOrder(String equation, double h, double initX,double initY,double edge){
    double x = initX;
    int counter = 0;
    String euler_Formula = "y"+"+"+Double.toString(h)+"("+equation+")";
    euler_Formula = paperForm(euler_Formula);
    System.out.println("euler formula = "+euler_Formula);
    String Yn = Double.toString(initY);
    for(x = initX  ; x < edge+0.0001 ; x+=h,counter++){
    Yn = function(Yn);
    System.out.println("At X ="+x+" | Y"+counter+" = "+Yn);
    Yn = (euler_Formula.replaceAll("x",Double.toString(x))).replaceAll("y",Yn);
    }
    }
    public static void _1stOrder(String equation, double h, double initX,double initY,double edge,String Exact){
    double x = initX;
    int counter = 0;
    String error;
    String euler_Formula = "y"+"+"+Double.toString(h)+"("+equation+")";
    euler_Formula = paperForm(euler_Formula);
    System.out.println("euler formula = "+euler_Formula);
    String Yn = Double.toString(initY);
    Exact = paperForm(Exact);
    String Ex = paperForm(Exact);
    //Ex  = paperForm(Ex);
    System.out.println("Ex = "+Ex);
    for(x = initX  ; x < edge ; x+=h,counter++){
    Yn = function(Yn);
    Ex = function(Exact.replaceAll("x",Double.toString(x)));
    if(Yn.equals(Ex))
        error = "0";
    else
     error = "("+Ex+"-"+Yn+")/"+Ex+"*100";
   
      System.out.println("at x = "+x+" error = "+Math.abs(-Double.parseDouble(Yn)+Double.parseDouble(Ex))/Double.parseDouble(Ex)*100);
    //System.out.println("At i = "+x+" Exact = "+Ex);
    //System.out.println("At X ="+x+" | Y"+counter+" = "+Yn);                       -1.4788027000273483
    Yn = (euler_Formula.replaceAll("x",Double.toString(x))).replaceAll("y",Yn);   //-1.5809988486278084
    }
    }
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
    
    return exponentiation
                
        (simplify(equation,justPreBracket(equation,i)+"^"+justPostBracket(equation,i),in));
    }    
    }
    return simplifyBrackets(equation);
}   
    public static String product(String equation){
    
     for(int i = 0 ; i<equation.length() ; i++){
    if(equation.charAt(i) == '-' && equation.charAt(i+1)=='-'){
    return Arithmetic(product(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"+")));
    }
    else if(equation.charAt(i) == '+' && equation.charAt(i+1)=='-'){
    return Arithmetic(product(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"-")));
    }
    else if(equation.charAt(i) == '-' && equation.charAt(i+1)=='+'){
    return Arithmetic(product(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"-")));
    }
    else if(equation.charAt(i) == '+' && equation.charAt(i+1)=='+'){
    return Arithmetic(product(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"+")));
    }
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
   
    
        
    for(int i = 0 ; i<equation.length() ; i++){
    if(equation.charAt(i) == '-' && equation.charAt(i+1)=='-'){
    return Arithmetic(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"+"));
    }
    else if(equation.charAt(i) == '+' && equation.charAt(i+1)=='-'){
    return Arithmetic(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"-"));
    }
    else if(equation.charAt(i) == '-' && equation.charAt(i+1)=='+'){
    return Arithmetic(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"-"));
    }
    else if(equation.charAt(i) == '+' && equation.charAt(i+1)=='+'){
    return Arithmetic(simplify(equation,equation.charAt(i)+""+equation.charAt(i+1),"+"));
    }
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
}
