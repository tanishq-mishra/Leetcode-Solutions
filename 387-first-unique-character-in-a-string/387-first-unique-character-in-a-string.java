// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character, List<Integer>> freqMap = new HashMap<>();
        
        
//         for(int i = 0; i<s.length(); i++) {
//             char current = s.charAt(i);
//             if(freqMap.containsKey(current)) {
//                 List<Integer> temp = freqMap.get(current);
//                 temp.set(1, temp.get(1)+1);
//             } else {
//                 List<Integer> temp = new ArrayList<>();
                
//                 temp.add(i);
//                 temp.add(1);
//                 freqMap.put(current, temp);
//             }
//         }
//         int minIndex = s.length()+1;
//         for(Map.Entry<Character, List<Integer>> entry: freqMap.entrySet()) {
//             if(entry.getValue().get(1) == 1){
//                 minIndex = Math.min(minIndex, entry.getValue().get(0));
//             }
//         }
        
        
//         return minIndex == s.length()+1 ? -1: minIndex;
        
//     }
// }

class Solution {
     public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }   
}