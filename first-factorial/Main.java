import java.util.*; 
import java.io.*;

class Main {

  public static long FirstFactorial(int num) {
    // code goes here  
    long result = 1;
    for (long i = 1; i <= num; i++) {
      result = result * i;
    }

    return result;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(FirstFactorial(s.nextLine())); 
  }

}