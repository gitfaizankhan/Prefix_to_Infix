import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args){
        String str = "*-A/BC-/AKL";
        String result = convert(str);
        System.out.println(result);
    }
    static String convert(String str){
        int length = str.length();
        Stack<String> stack = new Stack<>();

        for(int i = length-1; i >= 0; i--){
            char c = str.charAt(i);
            if(isOperator(c)){
                String opt1 = stack.pop();
                String opt2 = stack.pop();
                String temp = "("+opt1+c+opt2+")";
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        return stack.pop();
    }
    static boolean isOperator(char c){
        switch (c){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
}
