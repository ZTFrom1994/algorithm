package test;

/**
 * @author theozhang on 7/26/18
 */
public class Son extends Father{
    @Override
    public void say(){
        System.out.println("I'm son");
    }
    public void sonSay(){
        super.fatherSay();
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.fatherSay();
    }
}
