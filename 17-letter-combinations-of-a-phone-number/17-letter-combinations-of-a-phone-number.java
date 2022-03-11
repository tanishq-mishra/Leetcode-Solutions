class Solution {
    String[] numpad ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> helper(String p, String digits) {
        if(digits.length() == 0) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        int currentDigit = Character.getNumericValue(digits.charAt(0));
        List<String> fromBelowCalls = new ArrayList<>();
        for(int i = 0; i < numpad[currentDigit].length(); i++) {
            fromBelowCalls.addAll(helper(p+numpad[currentDigit].charAt(i), digits.substring(1)));
        }
        
        return fromBelowCalls;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        return helper("", digits);
    }
}