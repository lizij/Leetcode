package Longest_Absolute_File_Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        /**
         * Stack solution
         * Use lastIndexOf('\t') to decide the level of a file or dir
         * Use stack to restore the parent directories
         * The key is to generate a dir path string based on values in stack. Thus I implement a FileStack.
         * 5ms
         */

        String[] lines = input.split("\n");

        if (lines[0].contains(".")) {
            // root path is a file, no sub directory
            return lines[0].length();
        }

        int res = 0;
        FileStack stack = new FileStack();
        stack.push(lines[0]);
        for (int i = 1; i < lines.length; i++) {
            int countOfTab = lines[i].lastIndexOf('\t') + 1;
            while (countOfTab < stack.size()) {
                stack.pop();
            }
            stack.push(lines[i].substring(countOfTab));
            if (lines[i].contains(".")) {
                res = Math.max(res, stack.toString().length() - 1);
            }

        }
        return res;
    }

    class FileStack {
        List<String> data;

        public FileStack() {
            data = new ArrayList<>();
        }

        public void push(String s) {
            data.add(s);
        }

        public String pop() {
            String res = data.get(data.size() - 1);
            data.remove(data.size() - 1);
            return res;
        }

        public int size() {
            return data.size();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (String s: data) {
                builder.append(s).append('/');
            }
            return builder.toString();
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")); // 20, dir/subdir2/file.ext
		System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")); // 32, dir/subdir2/subsubdir2/file2.ext
	}
}