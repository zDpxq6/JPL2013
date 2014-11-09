public class Ex09_01{
  public static void main(String[] args){
    double a = Double.POSITIVE_INFINITY;
    double b = Double.NEGATIVE_INFINITY;

    System.out.println("(+∞) + (+∞) = " + (a + a));
    System.out.println("(+∞) - (+∞) = " + (a - a));
    System.out.println("(+∞) * (+∞) = " + a * a);
    System.out.println("(+∞) / (+∞) = " + a / a);
    System.out.println();

    System.out.println("(-∞) + (-∞) = " + (b + b));
    System.out.println("(-∞) - (-∞) = " + (b - b));
    System.out.println("(-∞) * (-∞) = " + b * b);
    System.out.println("(-∞) + (-∞) = " + b / b);
    System.out.println();

    System.out.println("(+∞) + (-∞) = " + (a + b));
    System.out.println("(+∞) - (-∞) = " + (a - b));
    System.out.println("(+∞) - (-∞) = " + a * b);
    System.out.println("(+∞) - (-∞) = " + a / b);
    System.out.println();

    System.out.println("(-∞) + (+∞) = " + (b + a));
    System.out.println("(-∞) - (+∞) = " + (b - a));
    System.out.println("(-∞) * (+∞) = " + b * a);
    System.out.println("(-∞) + (+∞) = " + b / a);
    System.out.println();
  }
}