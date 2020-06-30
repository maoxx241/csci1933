public class Rational{

  private double numerator = 0.0;
  private double denominator = 0.0;
  public Rational(double a, double b) {
      numerator = a;
      denominator = b;
  }
  public void setnumerator(double value) {
      numerator = value;
  }

  public void setdenominator(double value) {
      denominator = value;
  }

  public double getnumerator() {
      return numerator;
  }

  public double getdenominator() {
      return denominator;
  }
  public void addRational(Rational r){
    numerator= (numerator*r.denominator+denominator*r.numerator);
    denominator=(denominator*r.denominator);
  }
  public void subRational(Rational r){
    numerator= (numerator*r.denominator+denominator*r.numerator);
    denominator=(denominator*r.denominator);
  }
  public void mulRational(Rational r){
    numerator =numerator*r.numerator;
    denominator=(denominator*r.denominator);
  }
  public void divRational(Rational r){
    numerator= numerator*r.denominator;
    denominator=(denominator*r.numerator);
  }
}
