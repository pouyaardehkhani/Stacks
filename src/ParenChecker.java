public class ParenChecker {
    public static boolean CheckParen(String expr) {

        StudentStack<Character> stack = new StudentStack<>();

        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = (char) stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = (char) stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = (char) stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
    public static void main(String[] args){
        String ex1=new String("()]");
        String ex2=new String("{([])}");

        System.out.println(ParenChecker.CheckParen(ex1));
        System.out.println(ParenChecker.CheckParen(ex2));
    }
}