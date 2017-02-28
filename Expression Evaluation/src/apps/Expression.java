package apps;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;

import structures.Stack;

public class Expression {

	/**
	 * Expression to be evaluated
	 */
	String expr;                
    
	/**
	 * Scalar symbols in the expression 
	 */
	ArrayList<ScalarSymbol> scalars;   
	
	/**
	 * Array symbols in the expression
	 */
	ArrayList<ArraySymbol> arrays;
    
    /**
     * String containing all delimiters (characters other than variables and constants), 
     * to be used with StringTokenizer
     */
    public static final String delims = " \t*+-/()[]";
    
    /**
     * Initializes this Expression object with an input expression. Sets all other
     * fields to null.
     * 
     * @param expr Expression
     */
    public Expression(String expr) {
        this.expr = expr;
    }

    /**
     * Populates the scalars and arrays lists with symbols for scalar and array
     * variables in the expression. For every variable, a SINGLE symbol is created and stored,
     * even if it appears more than once in the expression.
     * At this time, values for all variables are set to
     * zero - they will be loaded from a file in the loadSymbolValues method.
     */
    public void buildSymbols() {
        scalars = new ArrayList <ScalarSymbol>();
        arrays = new ArrayList <ArraySymbol>();
        Stack <String> stack = new Stack <String>();
        StringTokenizer tokenizerString = new StringTokenizer(expr, delims, true);

        while (tokenizerString.hasMoreTokens()) {
            String token = tokenizerString.nextToken();
            System.out.println(token);
            if (isCharacter(token) || token.equals("[")) {
                stack.push(token);
            }
        }
        
        while (!stack.isEmpty()) {
            String item = stack.pop();
            if (item.equals("[")) {
                item = stack.pop();
                ArraySymbol arraySymbol = new ArraySymbol(item);
                if (!arrays.contains(arraySymbol)) {
                    arrays.add(arraySymbol);
                }
            } else {
                ScalarSymbol scalarSymbol = new ScalarSymbol(item);
                if (!scalars.contains(scalarSymbol)) {
                    scalars.add(scalarSymbol);
                }
            }
        }
        System.out.println("Arrays: ");
        printArrays();
        System.out.println("Scalars: ");
        printScalars();
    }

    private boolean isCharacter(String token) {
        return (token.charAt(0) >= 'a' && token.charAt(0) <= 'z') || (token.charAt(0) >= 'A' && token.charAt(0) <= 'Z');
    }

    private boolean isOperation(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    /**
     * Loads values for symbols in the expression
     * 
     * @param sc Scanner for values input
     * @throws IOException If there is a problem with the input 
     */
    public void loadSymbolValues(Scanner sc) 
    throws IOException {
        while (sc.hasNextLine()) {
            StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
            int numTokens = st.countTokens();
            String sym = st.nextToken();
            ScalarSymbol ssymbol = new ScalarSymbol(sym);
            ArraySymbol asymbol = new ArraySymbol(sym);
            int ssi = scalars.indexOf(ssymbol);
            int asi = arrays.indexOf(asymbol);
            if (ssi == -1 && asi == -1) {
            	continue;
            }
            int num = Integer.parseInt(st.nextToken());
            if (numTokens == 2) { // scalar symbol
                scalars.get(ssi).value = num;
            } else { // array symbol
            	asymbol = arrays.get(asi);
            	asymbol.values = new int[num];
                // following are (index,val) pairs
                while (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    StringTokenizer stt = new StringTokenizer(tok," (,)");
                    int index = Integer.parseInt(stt.nextToken());
                    int val = Integer.parseInt(stt.nextToken());
                    asymbol.values[index] = val;              
                }
            }
        }
    }
    
    
    /**
     * Evaluates the expression, using RECURSION to evaluate subexpressions and to evaluate array 
     * subscript expressions.
     * 
     * @return Result of evaluation
     */

    private float eval(String string) {
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException exception) {
            ScalarSymbol scaSymbol = findScalar(string);
            return scaSymbol.value;
        }
    }

    public float evaluate() {
        expr = expr.replaceAll("\\s+","");
        System.out.println("Expression: " + expr);
        return evaluate(expr);
    }

    private float evaluate(String expr) throws IllegalArgumentException {
        System.out.println();
        System.out.println("Evaluating: " + expr);

        StringTokenizer tokenizer = new StringTokenizer(expr, delims, true);
        String lhsExpression = tokenizer.nextToken();
        float lhs = eval(lhsExpression);
        System.out.println("Evaluated lhs '" + lhsExpression + "' to " + lhs);

        if (tokenizer.hasMoreTokens()) {
            String operation = tokenizer.nextToken();
            String rhsExpression = expr.substring(lhsExpression.length() + 1, expr.length());
            float rhs = evaluate(rhsExpression);
            return performOperation(lhs, rhs, operation);
        }
        return lhs;
    }

    private ScalarSymbol findScalar(String name) {
        for (ScalarSymbol symbol : scalars) {
            if (symbol.name.equals(name)) {
                return symbol;
            }
        }
        return null;
    }

    /**
     * Utility method, prints the symbols in the scalars list
     */
    public void printScalars() {
        for (ScalarSymbol ss: scalars) {
            System.out.println(ss);
        }
    }
    
    /**
     * Utility method, prints the symbols in the arrays list
     */
    public void printArrays() {
    		for (ArraySymbol as: arrays) {
    			System.out.println(as);
    		}
    }

    private float performOperation(float first, float second, String operator)  throws IllegalArgumentException {
        float result;
        if (operator.equals("+")) {
            result = first + second;
            System.out.println("Adding " + first + " and " + second + " = " + result);
        } else if (operator.equals("-")) {
            result = first  - second;
            System.out.println("Subtrating " + first + " and " + second + " = " + result);
        } else if (operator.equals("*")) {
            result = first * second;
            System.out.println("Multiplying " + first + " and " + second + " = " + result);
        } else if (operator.equals("/")) {
           if (second == 0) {
               throw new IllegalArgumentException("Cannot divide by zero");
           }
            result = first / second;
            System.out.println("Dividing " + first + " and " + second + " = " + result);
        } else {
            throw new IllegalArgumentException(operator + " is not a valid operator");
        }
        return result;
    }
}
