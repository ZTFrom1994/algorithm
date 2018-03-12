package group.version1;


import java.util.List;



public class FullInsert {
    private static int count = 0;
    public static void main(String[] args) {
        List<String> list = FullArrange.getFullArrange(new String[]{"1","2","3","4","5","6","7","8"});
        for (int i = 0; i < list.size(); i++) {
            fullInsert(list.get(i),0,0);
        }
        System.out.println(count);
    }
    public static void fullInsert(String str ,int hasInsert,int frontIndex){
        if(hasInsert == str.length()-1 ){
            return ;
        }
        int i = 1;
        while((frontIndex + i + hasInsert) != str.length()){
            String s = str.substring(0,frontIndex + i + hasInsert)+"|"+str.substring(frontIndex + i + hasInsert );

            fullInsert(s, hasInsert + 1,frontIndex + i );
            i++;
            count++;
        }

    }
}
