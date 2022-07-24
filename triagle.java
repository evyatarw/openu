// ****************************************************************************
// *                                                                          *
// * A program that calculates the area and the perimeter of a given triangle *
// *                                                                          *
// ****************************************************************************
import java.util.Scanner;

public class Triagle

{
    
    public static void main (String [] args)
    
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the area and the perimeter of a given "
            + "triangle. ");
        System.out.println ("Plaese enter the three lengths of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double perimeter = a+b+c; // calculation of perimeter
        double s = perimeter/2.0; // variable for Heron formula
        double triangleArea = Math.sqrt(s*(s-a)*(s-b)*(s-c)); // Heron formula
        
        if ((a+b>c) && (a+c>b) && (b+c>a)) // check if the lengths can be a triagle sides
            {
             System.out.println ("The perimeter of the given triangle is: " + perimeter);
             System.out.println ("The area of the given triangle is: " + triangleArea);
             }
             else // if the lengths can't be a triagle sides
             {
             System.out.println ("Error!");
             System.out.println ("The lengths that you enter can't "
                + "be a triagle sides");
             }
    } // end of the method main
} // end of the class Triangle
