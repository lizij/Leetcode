package Replace_Words;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < dict.size(); j++) {
                if (words[i].startsWith(dict.get(j))) words[i] = dict.get(j);
            }
        }
        return String.join(" ", words);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        List<String> dict1 = new ArrayList<>();
//        dict1.addAll(Arrays.asList("cat", "bat", "rat"));
//        System.out.println(s.replaceWords(dict1, "the cattle was rattled by the battery"));
        List<String> dict2 = new ArrayList<>();
        dict2.addAll(Arrays.asList("a", "aa", "aaa", "aaaa"));
        System.out.println(s.replaceWords(dict2,"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
	}
}