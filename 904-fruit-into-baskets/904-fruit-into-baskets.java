class Solution {
    public int totalFruit(int[] fruits) {
        HashSet<Integer> fruitType = new HashSet<>();
        fruitType.add(fruits[0]);
        int start = 0;
        int end = 1;
        int size = 1;
        while(end < fruits.length) {
            
            if(!fruitType.add(fruits[end])) {
                end++;
                size = Math.max(size, end-start);
                continue;
            } 
            if(fruitType.size() >2) {
                int included = fruits[end-1];
                int i = end-1;
                while(fruits[i] == included) {
                    i--;
                }
                fruitType.remove(fruits[i]);
                start = i+1;
            
            }
            
            
            
        }
        
        return size;
    }
}