package practices;

import java.io.IOException;

public class Main  {

    public static void main(String[] args) {
	// write your code here


        int[] test = new int[10];
        test[0] = 15;
        test[1] = 0;
        test[2] = 1;
        test[3] = 8;
        test[4] = 35;
        for (int t:test) {
            System.out.println((int)Math.pow(2, (int)Math.ceil(Math.log(t))));
        }
    }




}
