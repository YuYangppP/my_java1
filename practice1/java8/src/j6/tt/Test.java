package j6.tt;

public class Test {
    int Add(int num1, int num2) {//将加法分为进位的部分和不进位的部分，和为两部分之和
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;

    }
    public static void main (String args[]){

        Test t = new Test();
        System.out.println(t.Add(6,14));

    }
}