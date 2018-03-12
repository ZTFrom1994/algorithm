package group.version1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class FullGroup {

    public static final int vendorSize = 10;

    public static int count = 0;

    public static void main(String[] args){

        List<HashSet<String>> containers  =  new ArrayList<HashSet<String>>();
        for (int i = 1; i <= vendorSize; i++) {
            HashSet<String> container = new HashSet<String>();
            containers.add(container);
        }
        List<String> leftNumbers = new ArrayList<String>();
        for (int i = 1; i <= vendorSize; i++) {
            leftNumbers.add(String.valueOf(i));
        }
        loop(containers,leftNumbers);
        System.out.println(count);
    }

    public static void loop(List<HashSet<String>> containers,List<String> leftNumber){
        int hasUsed = getHasUsedContainerQuantity(containers);
        String output = "";
        if(leftNumber.size() == 0 || hasUsed >= vendorSize){
            for (int i = 0;i < containers.size();i++) {
                if(!containers.get(i).isEmpty()){
                    output += "{";
                    for (String str : containers.get(i)) {
                        output += str + ",";
                    }
                    output = output.substring(0,output.length()-1);
                    if(i == containers.size() - 1){
                        output += "}";
                    }else{
                        if(containers.get(i+1).isEmpty()){
                            output += "}";
                        }else{
                            output += "},";
                        }
                    }

                }
            }
            System.out.println(output);
            count++;
            return ;
        }

        for (int j = 0; j < hasUsed + 1; j++) {
            List<HashSet<String>> clonedSetList = cloneContainers(containers);
            if(clonedSetList.get(j).size() >=5){
                continue;
            }
            clonedSetList.get(j).add(leftNumber.get(0));
            List<String> clonedLeftNumber = cloneLeftNumber(leftNumber);
            clonedLeftNumber.remove(0);
            loop(clonedSetList,clonedLeftNumber);
        }

    }

    public static int getHasUsedContainerQuantity(List<HashSet<String>> containers){
        int containerCount = 0;
        for (HashSet<String> hashSet : containers) {
            if(!hashSet.isEmpty()){
                containerCount++;
            }
        }
        return containerCount;
    }
    public static List<String> cloneLeftNumber(List<String> leftNumber){
        List<String> list = new ArrayList<String>();
        for (String string : leftNumber) {
            list.add(string);
        }
        return list;
    }
    public static List<HashSet<String>> cloneContainers(List<HashSet<String>> containers){
        List<HashSet<String>> list = new ArrayList<>();
        for (HashSet<String> hashSet : containers) {
            HashSet<String> set = new HashSet<>();
            for (String string : hashSet) {
                set.add(string);
            }
            list.add(set);
        }
        return list;
    }
}
