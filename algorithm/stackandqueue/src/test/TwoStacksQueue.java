package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TwoStacksQueue.java
 * @Description TODO
 * @Date 2020/4/9 14:47
 */
public class TwoStacksQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int n){
        stackPush.push(n);
        pushToPop();
    }

    private void pushToPop(){
        if (stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    private int poll(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    private int peek(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        /*TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        System.out.println(twoStacksQueue.poll());

        twoStacksQueue.add(2);
        twoStacksQueue.add(7);

        System.out.println(twoStacksQueue.poll());
        twoStacksQueue.add(5);
        System.out.println(twoStacksQueue.poll());
*/
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String string;
        for (int i = 0; i < n; i++) {
            string = scanner.nextLine();
            if (string.equals("poll")) {
                twoStacksQueue.poll();
            } else if (string.equals("peek")) {
                System.out.println(twoStacksQueue.peek());
            } else {
                twoStacksQueue.add(Integer.valueOf(string.split(" ")[1]));
            }
        }

    }
}
