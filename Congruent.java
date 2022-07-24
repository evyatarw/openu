    // ****************************************************************************
    // *                                                                          *
    // *   A program that checks if a two given triagles is congruent             *
    // *                                                                          *
    // ****************************************************************************
    

    import java.util.Scanner;
    
    public class Congruent
    
    {
        
        public static void main (String [] args)
        
        {
            Scanner scan = new Scanner (System.in);
            System.out.println ("This program checks if a two given triagles is congruent.\n");
          
            	// input of the first triangle Vertexes
            System.out.println ("Plaese describe the first triagle by entering its 3 Vertex "
                + "points (x,y).\n" + "enter x value first and then y value.");
            int x11 = scan.nextInt(); 
            int y11 = scan.nextInt();
            int x12 = scan.nextInt();
            int y12 = scan.nextInt();
            int x13 = scan.nextInt();
            int y13 = scan.nextInt();
          
				// input of the second triangle Vertexes
            System.out.println ("excellent. Now describe the second triagle at the same way ");
            int x21 = scan.nextInt(); 
            int y21 = scan.nextInt();
            int x22 = scan.nextInt();
            int y22 = scan.nextInt();
            int x23 = scan.nextInt();
            int y23 = scan.nextInt();
				// calculation of the first triangle lengths
            double a1 = Math.sqrt((Math.pow((x11-x12),2.0) + (Math.pow((y11-y12),2.0))));
            double b1 = Math.sqrt((Math.pow((x11-x13),2.0) + (Math.pow((y11-y13),2.0))));
            double c1 = Math.sqrt((Math.pow((x12-x13),2.0) + (Math.pow((y12-y13),2.0))));
				 // calculation of the second triangle lengths
            double a2 = Math.sqrt((Math.pow((x21-x22),2.0) + (Math.pow((y21-y22),2.0))));
            double b2 = Math.sqrt((Math.pow((x21-x23),2.0) + (Math.pow((y21-y23),2.0))));
            double c2 = Math.sqrt((Math.pow((x22-x23),2.0) + (Math.pow((y22-y23),2.0))));
            System.out.println ("The first triangle is ("+x11+", "+y11+") ("+x12+", "+y12+") ("
                +x13+", "+y13+").");
            System.out.println ("Its lengths are "+a1+", "+b1+", "+c1+".");
            System.out.println ("The second triangle is ("+x21+", "+y21+") ("+x22+", "+y22+") ("
                +x23+", "+y23+").");
            System.out.println ("Its lengths are "+a2+", "+b2+", "+c2+".");
            if(a1==a2) // check if the lengths of the triangles are Equals
                if(b1==b2)
                    if(c1==c2)
                        System.out.println ("The triangles are congruent");
                    else
                        System.out.println ("The triangles are not congruent");
                else if(b1==c2)
                        if(c1==b2)
                            System.out.println ("The triangles are congruent");
                        else
                            System.out.println ("The triangles are not congruent");
                     else
                         System.out.println ("The triangles are not congruent");
            else if(a1==b2)
                    if(b1==a2)
                        if(c1==c2)
                            System.out.println ("The triangles are congruent");
                        else
                            System.out.println ("The triangles are not congruent");
                    else if(b1==c2)
                            if(c1==a2)
                                System.out.println ("The triangles are congruent");
                            else
                                System.out.println ("The triangles are not congruent");
                         else
                             System.out.println ("The triangles are not congruent");
                 else if(a1==c2)
                        if(b1==a2)
                            if(c1==b2)
                                System.out.println ("The triangles are congruent");
                            else
                                System.out.println ("The triangles are not congruent");
                        else if(b1==b2)
                                if(c1==a2)
                                    System.out.println ("The triangles are congruent");
                                else
                                    System.out.println ("The triangles are not congruent");
                             else
                                 System.out.println ("The triangles are not congruent");
                      else
                          System.out.println ("The triangles are not congruent");
    } // end of the method main
} // end of the class Congruent
