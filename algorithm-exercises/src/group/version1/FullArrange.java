package group.version1;

import java.util.ArrayList;
import java.util.List;


public class FullArrange {
    public static int total = 0;
    public static List<String> list = new ArrayList<String>();
    public static void swap(String[] str, int i, int j)
    {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void arrange (String[] str, int st, int len)
    {
        if (st == len - 1)
        {
            String s = "";
            for (int i = 0; i < len; i ++)
            {
                s += str[i];
            }
            list.add(s);
            total++;
        }
        else
        {
            for (int i = st; i < len; i ++)
            {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }

    }
    public static List<String>  getFullArrange(String[] strArray){
        arrange(strArray, 0, strArray.length);
        return list;
    }
}
