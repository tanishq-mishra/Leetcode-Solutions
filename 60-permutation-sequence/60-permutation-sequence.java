class Solution {
   int[] facts = new int[10];
    public int getFact(int n) {
        if(facts[n] != 0) {
            return facts[n];
        }
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        facts[n] = n * getFact(n-1);
        return facts[n];
    }
    public String getPermutation(int n, int k) {
        k = k-1;
        List<Character> set = new ArrayList<>();
        char c = '1';
        for(int i = 0; i<n; i++) {
            set.add(c);
            c++;
        }
        
        // for(char ch : set) {
        //     System.out.println(ch);
        // }
        String res = "";
        int currentLevel = n;
        while(currentLevel >1) {
            int fact = getFact(currentLevel-1);
            int index = k/fact;
            res += set.get(index);
            k = k%fact;
            set.remove(set.get(index));
            currentLevel--;
            
        }
        res += set.get(0);
        
        
        return res;
    }
}