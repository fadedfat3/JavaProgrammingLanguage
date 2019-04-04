package practices;
import practices.Test;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Person p1 = new Person();
        Student p2 = new Student();
        p1.printInfo();
        p2.printInfo();
        new GStudent().printInfo();
        p2.f();
        new GStudent().f();
    }
}
    class GStudent extends Student{
        @Override
        public String getInfo(){
            return "Good Student";
        }
    }
    class Student extends Person{

        public String getInfo(){
            return "Student";
        }
        public void f(){
            System.out.println(getInfo());
        }
    }

    class Person {
        private String getInfo(){
            return "Person";
        }
        public void printInfo(){
            System.out.println(getInfo());
        }
    }



