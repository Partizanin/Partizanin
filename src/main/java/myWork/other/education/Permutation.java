package myWork.other.education;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 14.11.2014.
 * Time:  12:10.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class Permutation {

    private static int count = 1;
    private static int count2 = 1;

    public static void main(String[] args) throws java.lang.Exception {
        String s = "123";
        Set<Character> set = new HashSet<>();
        dfs(s, "", set);
        System.out.println("------------ permutation2");
        permutation2("", s);
    }

    static void dfs(String s, String sol, Set<Character> set) {
        if (sol.length() == s.length()) {
            System.out.println(sol + ": " + count);
            count++;
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                dfs(s, sol + String.valueOf(ch), set);
                set.remove(ch);
            }
        }
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix + ": " + count2);
            count2++;
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    private static void permutation2(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix + ": " + count2);
            count2++;
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}

