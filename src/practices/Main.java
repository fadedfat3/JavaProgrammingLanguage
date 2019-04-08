package practices;

import java.io.IOException;

public class Main  {

    public static void main(String[] args) {
	// write your code here

        BinaryIO io = new BinaryIO();
        try{
            io.run();
        }catch (IOException e){
            System.out.println(e);
            System.exit(1);
        }
    }




}
