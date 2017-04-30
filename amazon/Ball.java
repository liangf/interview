
import java.util.*;

class Ball {
    public static int ballCount(String[] score) {
        if (score == null || score.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            String block = score[i];
            System.out.println(block);
            int val = 0;
            if (block.equals("Z")) {
                val = stack.isEmpty() ? 0 : stack.pop();
                sum -= val;
            } else if (block.equals("X")) {
                val = stack.isEmpty() ? 0 : stack.pop() * 2;
                sum += val;
                stack.push(val);
            } else if (block.equals("+")) {
                int size = stack.size();
                if (size >= 2) {
                    val = stack.get(size - 1) + stack.get(size - 2);
                } else if (size == 1) {
                    val = stack.get(size - 1);
                }
                sum += val;
                stack.push(val);
            } else {
                val = Integer.parseInt(block);
                sum += val;
                stack.push(val);
            }
            System.out.println("sum: " + sum + stack);
        }

        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hahahhahah");

        String[] s = new String[] {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.println(ballCount(s));
    }
}