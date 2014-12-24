



public class PostfixExpression extends Expression {

	public PostfixExpression(String expr)
    {
        super(expr);
    }
	public boolean verify()
    {
		if(tokens.size() <= 0 || tokens.size() % 2 == 0 || !isInteger(tokens.get(0))){
			return false;
		}
        for (int i = 2; i < tokens.size(); i++) {
            if ((i % 2 == 1 && !isInteger(tokens.get(i))) ||
                (i % 2 == 0 && !isOperator(tokens.get(i)))) {
                    return false;
            }
        }
        return (tokens.size() > 0 && tokens.size() % 2 == 1);
    }

	/**
	 * Evaluates the infix expression and return its value.
	 *   @return the integer value represented by the expression
	 */
	//Change evaluate to properly push and pop tokens from stack, then apply operations. 
	//Need proper stack methods for this.
	public int evaluate()
	{
		StackExpression myStack = new StackExpression();
		int value = Integer.parseInt(tokens.get(0));
		myStack.push(value);
		
		for (int i = 1; i< tokens.size(); i++){
			if (isInteger(tokens.get(i))){
				myStack.push(Integer.parseInt(tokens.get(i)));
			}else if(isOperator(tokens.get(i))){
				if(myStack.getStackSize() >= 2){
					int operand2 = myStack.pop();
					int operand1 = myStack.pop();
					value = apply(tokens.get(i), operand1, operand2);
					myStack.push(value);
				}
			}
		}
		
	    return value;
	}
	    
	public class EmptyStackException extends RuntimeException
	{
		public EmptyStackException(String err)
		{
			super(err);
		}
	}
	public class StackExpression
	{
		protected int stackElements[];
		
		
		public StackExpression()
		{
			stackElements = new int[0];
		}
		public boolean isEmpty(){
			return stackElements.length <= 0;
		}
		
		public int getStackSize(){
			return stackElements.length;
		}
		public void push(int newElement){
		//provision larger array
		int[] largerStackElements = new int[stackElements.length + 1];
		
		//copy elements into larger array
	    for (int i = 0; i < stackElements.length; i++)
	    	largerStackElements[i] = stackElements[i];
	    
	    //add new element to array
	    largerStackElements[stackElements.length] = newElement;
	    
	    //set new array as stack
	    stackElements = largerStackElements;
		}
		public int pop() throws EmptyStackException{			
			if(stackElements.length <= 0){
				throw new EmptyStackException("Stack is Empty");
			}
			
			//provision smaller array
			int[] smallerStackElements = new int[stackElements.length - 1];
						
			//copy elements into larger array
		    for (int i = 0; i < smallerStackElements.length; i++)
		    	smallerStackElements[i] = stackElements[i];
		   
		    //grab return value from stack 
		    int returnElement = stackElements[stackElements.length-1];
		    
		    //set new array as stack
		    stackElements = smallerStackElements;
		    
		    return returnElement;
		}
		}
	
	}
