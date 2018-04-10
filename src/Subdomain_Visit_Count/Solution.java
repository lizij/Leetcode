package Subdomain_Visit_Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null || cpdomains.length == 0) {
            return null;
        }
        /**
         * Split string and use map to count
         * 27ms
         */

        Map<String, Integer> domainsCount = new HashMap<>();
        for (String cpdomain: cpdomains) {
            String[] words = cpdomain.split(" ");
            int count = Integer.valueOf(words[0]);
            String[] domains = words[1].split("\\.");
            String cur = null;
            for (int i = domains.length - 1; i >= 0; i--) {
                cur = cur == null ? domains[i] : domains[i] + "." + cur;
                domainsCount.put(cur, domainsCount.getOrDefault(cur, 0) + count);
            }
        }

        List<String> res = new ArrayList<>();
        for (String key: domainsCount.keySet()) {
            res.add(domainsCount.get(key) + " " + key);
        }

        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.subdomainVisits(new String[]{"9001 discuss.leetcode.com"})); // ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
		System.out.println(s.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})); // ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    }
}