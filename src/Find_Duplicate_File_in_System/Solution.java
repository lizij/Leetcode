package Find_Duplicate_File_in_System;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: paths){
            String[] files = str.split(" ");
            String rootPath = files[0];
            for (int i = 1; i < files.length; i++) {
                String[] words = files[i].split("[()]");
                String path = rootPath + "/" + words[0];
                String content = words[1];
                if (map.containsKey(content)){
                    map.get(content).add(path);
                }
                else{
                    List<String> list = new ArrayList<>();
                    list.add(path);
                    map.put(content, list);
                }
            }
        }
        List<List<String>> fileList = new ArrayList<>();
        for (List<String> list: map.values()){
            if (list.size() > 1) fileList.add(list);
        }
        return fileList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (List<String> list: s.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"})){
            for (String str: list){
                StdOut.print(str + " ");
            }
            StdOut.println();
        }
    }
}
