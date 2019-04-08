package practices;

import java.io.*;
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

    public void binaryRun() throws IOException, ClassNotFoundException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("binary.dat"))){
            out.writeUTF("123");
            out.writeInt(45);
            out.writeObject(new Date());

        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"))){
            System.out.println(in.readUTF());
            System.out.println(in.readInt());
            System.out.println(in.readObject());
        }
    }
}
