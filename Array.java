
import java.util.*;
public class Array
{
    public static void main(String[]args)
   {
      Scanner input = new Scanner(System.in);
       int[]x = new int[10];
       int[]y = new int[10];
      System.out.println ("What are the numbers you want in the array");
      for(int i = 0; i<10; i++){
          x[i]=input.nextInt();
        }
        System.out.println ("List in reverse: ");
        for(int i = 9; i>=0; i--){
            System.out.println(x[i]+"");
            System.out.println();
    
      
}
}
}