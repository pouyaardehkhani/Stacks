import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        InfixToPostfixGenerator generator = new InfixToPostfixGenerator();
        Scanner scan = new Scanner(System.in);
        PostfixEvaluator evaluator = new PostfixEvaluator();

        System.out.println("Input valid infix expressions for evaluation. Hit ENTER only to quit.");
        System.out.println("Separate each token with one or more spaces");
        System.out.println("Input expression:");

        String expression = scan.nextLine();

        while (expression.length() > 0) {
            String newExpression="";
            try {
                newExpression += generator.convert(expression);
                System.out.println("Postfix: " + newExpression);
            } catch (SyntaxErrorException e) {
                System.out.println(e.getMessage());
            }

            try {
                int value = evaluator.eval(newExpression);
                System.out.println("Value = " + value);
            } catch (SyntaxErrorException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Input expression:");
            expression = scan.nextLine();
        }
        System.out.println("DONE");
    }
}
