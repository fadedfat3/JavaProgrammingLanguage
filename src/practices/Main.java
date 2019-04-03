package practices;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int x =5, y = -6;
        test(x, 1);
        test(y, 1);
    }
    public static void test(int nums, int offset){

        System.out.println(nums << offset);
        System.out.println(nums >> offset);
        System.out.println(nums >>> offset);
    }
}
