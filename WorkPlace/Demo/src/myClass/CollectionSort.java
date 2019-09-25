package myClass;

import java.util.*;

public class CollectionSort {
    public static <T> void bubbleSort(List<T> list, int a, int b, Comparator<T> c){
        if (a==b)
            return;
        if (a>list.size()-1 || b>list.size()-1)
            return;
        T tmp;
        for (int i = 0, l = list.size(); i < l-2; i++) {
            for (int j = 0; j < l-1-i; j++) {
                if (c.compare(list.get(j+1),list.get(j))>0){
                    tmp = list.get(j+1);
                    list.set(j+1,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
    }
    public static <T> void selectionSort(List<T> list, int a, int b, Comparator<T> c){
        if (a==b)
            return;
        if (a>list.size()-1 || b>list.size()-1)
            return;
        T tmp;
        for (int i = 0, l = list.size(); i < l-1; i++) {
            for (int j = i+1; j < l-1; j++) {
                if (c.compare(list.get(j),list.get(i))>0){
                    tmp = list.get(j);
                    list.set(j,list.get(i));
                    list.set(i,tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,2,4,7,1,-5,1,6,5,12,5,3,1,7,3,33,2,53,64,22,77,64);
        bubbleSort(list, 3, 5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2)
                    return 1;
                else if (o2>o1)
                    return -1;
                else
                    return 0;
            }
        });
        Collections.shuffle(list);
        selectionSort(list, 3, 5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2)
                    return 1;
                else if (o2>o1)
                    return -1;
                else
                    return 0;
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
    }
}
