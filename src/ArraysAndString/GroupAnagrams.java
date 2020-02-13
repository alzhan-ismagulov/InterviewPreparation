/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
* */
package ArraysAndString;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));//[[ate, eat, tea], [bat], [nat, tan]]
    }
        public static List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> rst = new ArrayList<List<String>>();
            if (strs == null || strs.length == 0) {
                return rst;
            }
            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

            for (int i = 0; i < strs.length; i++) {
                char[] arr = strs[i].toCharArray();
                Arrays.sort(arr);
                String str = new String(arr);
                if (!map.containsKey(str)) {
                    map.put(str, new ArrayList<String>());
                }
                map.get(str).add(strs[i]);
            }
            for(String key: map.keySet()){
                Collections.sort(map.get(key));
                rst.add(map.get(key));
            }
            return rst;
        }
}
