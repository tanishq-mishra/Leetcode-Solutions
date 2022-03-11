class Solution {
    String[] numpad ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void helper(String p, String digits, List<String> ans) {
        if(digits.length() == 0) {
            ans.add(p);
            return;
        }
        int currentDigit = Character.getNumericValue(digits.charAt(0));
        List<String> fromBelowCalls = new ArrayList<>();
        for(int i = 0; i < numpad[currentDigit].length(); i++) {
            helper(p+numpad[currentDigit].charAt(i), digits.substring(1), ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        helper("", digits, ans);
        return ans;
    }
}