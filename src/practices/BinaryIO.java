package practices;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class BinaryIO {
    public void run() throws IOException {
        try(PrintWriter out = new PrintWriter(new FileOutputStream("test.txt"))){
            out.println("123");
            out.println(45);
            out.println(new Date());

        }
        try(Scanner in = new Scanner(new FileInputStream("test.txt"))){
            System.out.println(in.nextLine());
            System.out.println(in.nextInt());
            System.out.println(in.nextLine());
            System.out.println(in.nextLine());
        }
    }
}
