package myWork.other.calc;

import java.util.Stack;

/**
 * Created by Partizanin on 07.05.2015.
 */
public class NewCalc {
    public static void main(String[] args) {
        NewCalc nc = new NewCalc();
        System.out.println(nc.eval("12+22-10*(6/2)"));
    }
    private  boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int priority(char op) {

        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        } else {
            return -1;
        }

    }

    private void processOperator(Stack<Double> st, char op) {

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

    public double eval(String s) {
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
