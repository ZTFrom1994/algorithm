package test;

/**
 * @author theozhang on 8/7/18
 */
public class Main {
    public String name ;
    public Main(String name){
        name = name;
    }

    public static void main(String[] args) {
        Sub sub = new Sub("1");
        System.out.println(sub.name);
    }
}

class Sub extends Main{
    public String name;

    public Sub(String name){
        super(name);
    }
}