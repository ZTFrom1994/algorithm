package test;

/**
 * @author theozhang on 7/26/18
 */
public class Father {
    public void say(){
        System.out.println("I'm father");
    }

    public void fatherSay(){
        this.say();
    }
}
