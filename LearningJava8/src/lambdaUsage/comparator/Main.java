package lambdaUsage.comparator;

import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import java.util.*;

public class Main {
    /*public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(13);
        list.add(25);
        list.add(20);
        list.add(22);
        list.add(17);
        list.add(11);
        Collections.sort(list, (a, b) -> b - a);
        System.out.println(list);
    }*/
    /*public static void main(String[] args){
        Set<Integer> s = new TreeSet<>();
        s.add(21);
        s.add(1);
        s.add(13);
        System.out.println("Before Sorting " + s);
        Set<Integer> ss = new TreeSet<>((a,b) -> b - a);
        ss.add(21);
        ss.add(1);
        ss.add(13);
        System.out.println("After Sorting " + ss);
    }*/
    public static void main(String[] args){
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "z");
        map.put(3, "f");
        map.put(1, "y");
        System.out.println(map);
        Map<Integer, String> smap = new TreeMap<>((a, b) -> b - a);
        smap.put(2, "z");
        smap.put(3, "f");
        smap.put(1, "y");
        System.out.println(smap);
    }
}
