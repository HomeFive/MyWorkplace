package myClass;

import java.io.File;
import java.util.Map;

public class StringUtils {
    /**
     * @Description 统计指定文件夹内所有文件的后缀类型和数量，访问权限不足的不纳入统计
     * @Param file 文件或文件夹
     * @Param countMap 用于结果统计记录
     */
    public static void countFileType(File file, Map<String,Integer> countMap){
        if (!file.exists()){
            System.out.println("不存在的文件或文件夹："+file.getName());
            return;
        }
        if (file.isFile()){
            String name = file.getName();
            int i = name.indexOf(".");
            int pref = -1;
            while (i!=-1){
                if (pref==-1)
                    pref = 0;
                pref=pref+i+1;
                name = name.substring(i+1);
                i= name.indexOf(".");
            }
            if (pref!=-1){
                String endWith = file.getName().substring(pref);
                countMap.put(endWith,countMap.containsKey(endWith)?countMap.get(endWith)+1:1);
            }else if (file.getName().indexOf(".")==-1){
                countMap.put(file.getName(),1);
            }
        }else {
            File[] files = file.listFiles();
            if (files!=null)
                for (File f : files)
                    countFileType(f, countMap);
        }
    }
}
