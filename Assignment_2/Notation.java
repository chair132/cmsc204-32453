
public class Notation {
	public Notation() {
	}
	
	//stubs
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		
		MyStack<String> expressionStack = new MyStack<>(); 
		
		for (int i = 0; i < postfixExpr.length(); i++) {
			
			//if it is a whitespace/space
			if (Character.isWhitespace(postfixExpr.charAt(i))) {
				continue;
			
			//if it is an operand/digit or a left parenthesis
			} else if (Character.isDigit(postfixExpr.charAt(i)) || postfixExpr.charAt(i) == '(') {
				
				expressionStack.push(Character.toString(postfixExpr.charAt(i)));
				 
			//if it is an operator
			} else if (getPrecedence(postfixExpr.charAt(i)) != 0) {
				if (expressionStack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				
				double value1 = Double.parseDouble(expressionStack.pop());
				double value2 = Double.parseDouble(expressionStack.pop());
				
				double result;
				
				switch(postfixExpr.charAt(i)) {
					case '^':
						result = Math.pow(value2, value1);
						break;
					case '*':
						result = value2 * value1;
						break;
					case '/':
						result = value2 / value1;
						break;
					case '+':
						result = value2 + value1;
						break;
					default:
						result = value2 - value1;
						break;
				}
				expressionStack.push(Double.toString(result));
				
				
				
			}
			
		}
		
		//after it loops through the string
		if (expressionStack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		
		return Double.parseDouble(expressionStack.pop());
		
	}
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		//notice how infixStack is a string 
		MyStack<String> infixStack = new MyStack<>();
		
		for(int i = 0; i < postfix.length(); i++) {

			//if it is a whitespace/space
			if (Character.isWhitespace(postfix.charAt(i))){
				continue;
				
			//if it is an operand/digit
			} else if (Character.isDigit(postfix.charAt(i))) {
				infixStack.push(Character.toString(postfix.charAt(i)));
				
			//if it is an operator
			} else if (getPrecedence(postfix.charAt(i)) != 0) {
				//check if there are enough values in the stack
				if (infixStack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				
				String value1 = infixStack.pop();
				String value2 = infixStack.pop();
				String result = "(" + value2 + " " + postfix.charAt(i) + " " + value1 + ")";
				
				infixStack.push(result);				
			}
		}
		
		//after it loops through the string
		if (infixStack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return infixStack.top();
		
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		//notice how postfixQueue and postfixStacks are character types
		MyQueue<Character> postfixQueue = new MyQueue<>();
		MyStack<Character> postfixStack = new MyStack<>();
		
		
		for(int i = 0; i < infix.length(); i++) {
			if(Character.isWhitespace(infix.charAt(i))) {
				continue;
			
			} else if (Character.isDigit(infix.charAt(i))) {
				postfixQueue.enqueue(infix.charAt(i));
			
			} else if (infix.charAt(i) == '(') {
				postfixStack.push(infix.charAt(i));
				
			
				//if the character at the index is an operator (not 0)
			} else if (getPrecedence(infix.charAt(i)) != 0 ) {
				
				//while the precedence at the top of the stack has equal or higher precedence of current operator
				//also avoids the StackUnderflowException by checking if it is not empty 
				
				while(!postfixStack.isEmpty() && getPrecedence(postfixStack.top()) >= getPrecedence(infix.charAt(i))) {
					postfixQueue.enqueue(postfixStack.pop());
				}
				
				postfixStack.push(infix.charAt(i));
			
			} else if (infix.charAt(i) == ')'){
				
				//avoids the StackUnderflowException by checking if it's not empty
				//while the top of the stack is not a left parenthesis
				while(!postfixStack.isEmpty() && postfixStack.top() != '(') {
					postfixQueue.enqueue(postfixStack.pop());
					
				}
				
				
				//if the stack is empty and there is not left parenthesis, throw an InvalidNotationFormatException
				if(postfixStack.isEmpty()) {
					throw new InvalidNotationFormatException();
				}
				
				//pops the left parenthesis
				postfixStack.pop();
			}
			
		}
		
		while(!postfixStack.isEmpty()) {
			postfixQueue.enqueue(postfixStack.pop());
		}
		
		return postfixQueue.toString();
	}

	
	
	//a private method to get the precedence of the operator (returns 0 if non operator)
	private static int getPrecedence(char currentChar) {
		switch(currentChar) {
			case '^':
				return 3;
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				return 0;
		}
	 
	}
}
