import java.util.*; 
import java.io.*;

class Main {

  public static int[] makeBucket(String s) {
    int bucket[] = new int[26];
    for(int i=0; i< 26; i++) {
      bucket[ i ] = 0;
    }
    for(int i=0; i<s.length(); i++) {
      bucket[ s.codePointAt(i) - 97 ] += 1;
    }

    return bucket;
  }

  public static void printBucket(int[] bucket) {
    for (int i = 0; i < 26; i++) {
      if ( bucket[i] != 0 ) {
        char letter = (char)(i + 97);
        //System.out.print(letter + ":" + bucket[i] + ",");
      }
    }
    //System.out.println(";");
  }

  public static boolean containsSubString(String A, String s) {
    int[] bucket_A = makeBucket(A);
    int[] bucket_s = makeBucket(s);
    printBucket(bucket_A);
    printBucket(bucket_s);
    boolean result = true;
    // compare all letters 
    for (int c = 0; c < 26; c++) {
      if (bucket_s[c] > bucket_A[c]) {
        result = false;
        char letter = (char)(c + 97);
        //System.out.println("Not equal because: " + letter + ":" + bucket_s[c] + " vs. " + bucket_A[c]);
        break;
      }
    }
    //System.out.println("Checking: " + A + " - " + s + ": " + result);
    
    return result;
  }

  public static boolean isRangeSmaller(int a_start, int a_end, int b_start, int b_end) {
    int length_a = (a_end - a_start); 
    int length_b = (b_end - b_start);

    if (length_a != length_b) {
      return length_a < length_b;
    }
    return a_start < b_start;
  }

  public static String MinWindowSubstring(String[] strArr) {
    // code goes here
    String N = strArr[0];
    String K = strArr[1];
    int startRange = -1, endRange = -1;
    int minStartRange = 0, minEndRange = 999999;
    String minSubstring = "", currentSubstring = "";

    // build the buckt
    int[] bucket = new int[26];
    for (int b = 0; b < K.length(); b++) {
      bucket [ K.codePointAt(b) - 97 ] = 1;
    }

    for (int i = 0; i < N.length() - K.length() + 1; i++) {
      startRange = i;
      for (endRange = i + K.length(); endRange < N.length() + 1; endRange++) {
        currentSubstring = N.substring(startRange, endRange);
        // Check if all are within same range
        if ( containsSubString(currentSubstring, K) ) {
          if ( isRangeSmaller(startRange, endRange, minStartRange, minEndRange) ) {
            minStartRange = startRange;
            minEndRange = endRange;
            minSubstring = currentSubstring;
            //System.out.println("Picking up: " + minSubstring);
          }
        }
      }      
    }

    return minSubstring;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(MinWindowSubstring(s.nextLine())); 
  }

}