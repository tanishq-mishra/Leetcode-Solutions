class Solution {
    public int characterReplacement(String s, int k) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        int start =0;
        int end = 0;
        int maxFrequency = -1;
        int maxLen = 1;
        while(end < c.length) {
            count.put(c[end], count.getOrDefault(c[end], 0) +1);
            maxFrequency = Math.max(maxFrequency, count.get(c[end]));
            while(end-start +1 -maxFrequency > k) {
                count.put(c[start], count.get(c[start]) -1);
                if(count.get(c[start]) == 0) {
                    count.remove(c[start]);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end-start +1);
            end++;
        }
        
        return maxLen;
    }
}