package lesson0901;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day1719 {
    public static void main(String[] args) {
        File f = new File(new Scanner(System.in).next());
        Map<String,Integer> map = new HashMap<>();
        count(f,map);
        for (Map.Entry<String,Integer> en: map.entrySet())
            System.out.println(en.getKey()+" 类型的文件有 "+en.getValue()+"个");
    }
    public static void count(File file,Map<String,Integer> map){
        if (!file.exists()){
            System.out.println("不存在的文件或文件夹："+file.getName());
            return;
        }
        if (file.isFile()){
            try{
                String name = file.getName();
                int i = name.indexOf(".");
                int pref = -1;
                while (i!=-1){
                    if (pref==-1) {
                        pref = 0;
                    }
                    pref=pref+i+1;
                    name = name.substring(i+1);
                    i= name.indexOf(".");
                }
                if (pref!=-1){
                    String endWith = file.getName().substring(pref);
                    map.put(endWith,map.containsKey(endWith)?map.get(endWith)+1:1);
                }else if (file.getName().indexOf(".")==-1){
                    map.put(file.getName(),1);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            File[] files = file.listFiles();
            if (files!=null)
                for (File f : files)
                    count(f, map);
        }
    }
}
