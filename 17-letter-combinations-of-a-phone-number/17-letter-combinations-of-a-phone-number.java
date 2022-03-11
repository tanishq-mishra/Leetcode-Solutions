class Solution {
    String[] numpad ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void helper(StringBuilder p, int index, String digits, List<String> ans) {
        if(digits.length() == index) {
            ans.add(p.toString());
            return;
        }
        int currentDigit = Character.getNumericValue(digits.charAt(index));
        for(int i = 0; i < numpad[currentDigit].length(); i++) {
            helper(p.append(numpad[currentDigit].charAt(i)),index+1, digits, ans);
            p.deleteCharAt(p.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, 0,digits, ans);
        return ans;
    }
}


