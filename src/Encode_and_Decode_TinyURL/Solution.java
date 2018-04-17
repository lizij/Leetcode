package Encode_and_Decode_TinyURL;



import java.util.HashMap;

public class Solution {
    private static String BASE_URL = "http://tinyurl.com/";
    private static HashMap<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = randomString();
        while (map.containsKey(tinyUrl)) tinyUrl = randomString();
        map.put(tinyUrl, longUrl);
        return BASE_URL + tinyUrl;
    }

    private String randomString(){
        String dict = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int pos = (int) (Math.random() * dict.length());
            builder.append(dict.charAt(pos));
        }
        return builder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String tinyUrl = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        return map.get(tinyUrl);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String tinyUrl = s.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(tinyUrl);
        System.out.println(s.decode(tinyUrl));
    }
}
