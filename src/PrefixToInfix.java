import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args){
        String str = "*-A/BC-/AKL";
        String result = convert(str);
        System.out.println(result);

    }
    static String convert(String exp){
        Stack<String> stack = new Stack<>();
        int length = exp.length();
        for(int i = length-1; i >= 0; i--){
            char character = exp.charAt(i);
            if(isOperator(character)){
                String s1 = stack.pop();
                String s2 = stack.pop();

                String temp_string = "(" + s1 + character + s2 +")";
                stack.push(temp_string);
            }else {
                stack.push(character+"");
            }
        }
        return stack.pop();
    }
    static boolean isOperator(char c){
        return switch (c) {
            case '+', '-', '*', '/', '%', '^' -> true;
            default -> false;
        };
    }
}
