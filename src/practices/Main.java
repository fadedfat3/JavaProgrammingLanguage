package practices;
import practices.Person;
import practices.Manager;
import practices.TalkInterface;
public class Main  implements TalkInterface{

    public static void main(String[] args) {
	// write your code here
        Person p = new Manager();
        System.out.println(p instanceof Manager);
        System.out.println(p instanceof Employee);
        System.out.println(p instanceof Person);
        System.out.println(p.add("123"));
        System.out.println(p.remove("1234"));

    }

    public void talk(){
        System.out.println("talk");
    }


}
