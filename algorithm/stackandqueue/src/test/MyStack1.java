package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MyStack1.java
 * @Description TODO
 * @Date 2020/4/8 17:49
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your Stack is empty");
        }

        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your Stack is empty");
        }
        return this.stackMin.peek();
    }

    /*public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1(1,2);
        myStack1.push(5);
        myStack1.push(4);
        myStack1.push(6);
        myStack1.push(7);
        myStack1.push(3);

        int min = myStack1.getMin();
        System.out.println(min);

    }*/


    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1(new Stack<Integer>(),new Stack<Integer>());
        int[] a = {7,5,4,6,3};
        for (int i = 0; i < a.length; i++) {
            myStack1.push(a[i]);
        }
        int min = myStack1.getMin();
        System.out.println(min);

    }
}
