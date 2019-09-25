package lesson0831;

import java.util.*;

public class Day1609 {
    public static void main(String[] args) {
        List<Integer> is1 = new ArrayList<>();
        Collections.addAll(is1,2,3,4,5,6,7,8,8);
        Set<Integer> is2 = new HashSet<>();
        is2.addAll(is1);
        Map<Integer,Integer> is3 = new HashMap<>();
        is3.put(1,2);
        is3.put(3,4);
        is3.put(5,6);
        is1.stream().forEach((s)-> System.out.print(s+"`"));
        System.out.println();
        is2.stream().forEach((s)-> System.out.println(s));
        is3.forEach((k,v)-> System.out.println(k+v));
    }
}
