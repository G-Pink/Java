

import java.util.Scanner;


/**
 * Simple calculator that reads infix expressions and evaluates them.
 *   @author
 *   @version
 */

public class Calculator
{
	public static void main(String[] args)
	{
	    Scanner input = new Scanner(System.in);
	    
	    System.out.print("Would you like to use Infix or Outfix Expression Calculation? (Enter 1 or 2): ");
	    String fix = input.nextLine();  
	  
	    //Determine whether the user wants Infix or Postfix Calculation.
	   
	    Integer f = Integer.valueOf(fix);
	    if(f == 1)
	   {
	        System.out.print("Enter an Infix expression (or hit RETURN to stop): ");
		    String line = input.nextLine();
	
		    while (line.length() > 0) {
		        Expression expr = new InfixExpression(line);
	
		        if (expr.verify()) {
		            System.out.println(expr.evaluate());
		        }
		        else {
		            System.out.println("INVALID EXPRESSION");
		        }
	
		        System.out.print("Enter an Infix expression (or hit RETURN to stop): ");
		        line = input.nextLine();
		     }
	     }
		 else if(f==2)
		 {
			 System.out.print("Enter a Postfix expression (or hit RETURN to stop): ");
			    String line = input.nextLine();
		
			    while (line.length() > 0) {
			        Expression expr = new PostfixExpression(line);
		
			        if (expr.verify()) {
			            System.out.println(expr.evaluate());
			        }
			        else {
			            System.out.println("INVALID EXPRESSION");
			        }
		
			        System.out.print("Enter a Postfix expression (or hit RETURN to stop): ");
			        line = input.nextLine();
			    }
		 }
	   else 
	    {
	    	throw new RuntimeException();
	    }
	    
	    System.out.println("DONE");
	}
}
