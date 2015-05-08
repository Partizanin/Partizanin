package myWork.other.calc;

import java.util.Stack;

/**
 * Created by Partizanin on 07.05.2015.
 */
public class NewCalc {
    public static void main(String[] args) {

        System.out.println(eval("12+22-10*4/2"));
    }
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int priority(char op) {

        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        } else {
            return -1;
        }

    }

    public static void processOperator(Stack<Double> st, char op) {

        double r = st.pop();
        double l = st.pop();

        if (op == '+') {
            st.push(l + r);
        }
        if (op == '-') {
            st.push(l - r);
        }
        if (op == '*') {
            st.push(l * r);
        }
        if (op == '/') {
            st.push(l / r);
        }

    }

    public static double eval(String s) {
        Stack<Double> st = new Stack<Double>();
        Stack<Character> op = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                op.push('(');
            } else if (c == ')') {
                while (op.lastElement() != '(') {
                    processOperator(st, op.pop());
                }
                op.pop();

            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.lastElement()) >= priority(c)) 			{
                    processOperator(st, op.pop());
                }
                op.push(c);

            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))
                        || i < s.length() && s.charAt(i) == '.') {
                    operand += s.charAt(i++);
                }
                --i;
                st.push(Double.parseDouble(operand));

            }
        }

        while (!op.isEmpty()) {
            processOperator(st, op.pop());
        }
        return st.get(0);

    }
}
