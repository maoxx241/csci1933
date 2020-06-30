public class Application  {
  public static void main(String[] args){
    Complex3 num1 = new Complex3(4.0,4.0);
    Complex3 c1 = new Complex3(1.0,1.0);
    num1.addComplex(c1);
    boolean result1 = num1.getImaginaryPart() == num1.getRealPart();
    System.out.println("Test " + result1);
    num1.subtractComplex(c1);
    boolean result2 = num1.getImaginaryPart() == num1.getRealPart();
    System.out.println("Test " + result2);
    Complex3 num2 = new Complex3(3.0,4.0);
    num1.addComplex(c1);
    boolean result3 = num2.getImaginaryPart() == num2.getRealPart();
    System.out.println("Test " + result3);
    num1.subtractComplex(c1);
    boolean result4 = num2.getImaginaryPart() == num2.getRealPart();
    System.out.println("Test " + result4);
    double gpa = 0.0;
    for (int i = 0;i<args.length;i++){
      if(i%2==0){
      if(args[i].equals("a")){
        gpa=4.0*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("a-")) {
        gpa=3.667*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("b+")) {
        gpa=3.333*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("b")) {
        gpa=3.0*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("b-")) {
        gpa=2.667*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("c+")) {
        gpa=2.333*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("c")) {
        gpa=2.0*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("c-")) {
        gpa=1.667*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("d+")) {
        gpa=1.333*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("a")) {
        gpa=1.0*Double.valueOf(args[i+1])+ gpa;
      }else if (args[i].equals("f")) {
        gpa=0.0*Double.valueOf(args[i+1])+ gpa;
      }
    }
  }
  double num3 =0.0;
  for(int i = 0;i<args.length;i++){
    if(i%2==1){
      num3=Double.valueOf(args[i])+num3;
    }
  }
   System.out.println("The GPA is: "+gpa/num3);
   Rational num233 = new Rational(4.0,4.0);
   Rational c234 = new Rational(1.0,2.0);

   num233.addRational(c234);
   System.out.println("the numerator is"+num233.getnumerator()+ "the denominator is "+num233.getdenominator());
   num233.subRational(c234);

   System.out.println("the numerator is"+num233.getnumerator()+ "the denominator is "+num233.getdenominator());
   num233.mulRational(c234);

   System.out.println("the numerator is"+num233.getnumerator()+ "the denominator is "+num233.getdenominator());
   num233.divRational(c234);

   System.out.println("the numerator is"+num233.getnumerator()+ "the denominator is "+num233.getdenominator());
  }
}
