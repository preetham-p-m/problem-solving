package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    public static void main(String[] args) {
        var list = start("abc");

        System.out.println(list.toString());
    }

    public static List<String> start(String str) {
        var list = new ArrayList<String>();

        substring(str, 0, "", list);

        return list;
    }

    public static void substring(String str, int index, String temp, List<String> list) {
        if (index >= str.length()) {
            list.add(temp.length() == 0 ? "empty" : temp);
            return;
        }

        substring(str, index + 1, temp, list);
        substring(str, index + 1, temp + str.charAt(index), list);
    }
}
