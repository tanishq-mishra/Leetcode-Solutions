class Solution {
    String[] numpad ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void helper(String p, int index, String digits, List<String> ans) {
        if(digits.length() == index) {
            ans.add(p);
            return;
        }
        int currentDigit = Character.getNumericValue(digits.charAt(index));
        for(int i = 0; i < numpad[currentDigit].length(); i++) {
            helper(p+numpad[currentDigit].charAt(i),index+1, digits, ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        helper("", 0,digits, ans);
        return ans;
    }
}


