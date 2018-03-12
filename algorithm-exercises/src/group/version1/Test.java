package group.version1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by theozhang on 9/19/17.
 */
public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }
        System.out.println(a.toString());
    }

}
