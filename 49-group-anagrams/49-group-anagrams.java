class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupsMap = new HashMap<>();
        for(int i = 0; i<strs.length; i++) {
            
            char[] anagram = strs[i].toCharArray();
            Arrays.sort(anagram);
            String anagramStr = new String(anagram);
            List<String> group = groupsMap.getOrDefault(anagramStr, new ArrayList<>());
            group.add(strs[i]);
            groupsMap.put(anagramStr, group);
            
        }
        
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : groupsMap.entrySet()) {
            res.add(e.getValue());
        }
        
        
        return res;
    }
}