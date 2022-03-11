// class Solution {
//     String[] numpad ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//     public void helper(String p, int index, String digits, List<String> ans) {
//         if(digits.length() == index) {
//             ans.add(p);
//             return;
//         }
//         int currentDigit = Character.getNumericValue(digits.charAt(index));
//         for(int i = 0; i < numpad[currentDigit].length(); i++) {
//             helper(p+numpad[currentDigit].charAt(i),index+1, digits, ans);
//         }
//     }
//     public List<String> letterCombinations(String digits) {
//         if(digits.length() == 0) {
//             return new ArrayList<>();
//         }
//         List<String> ans = new ArrayList<>();
//         helper("", 0,digits, ans);
//         return ans;
//     }
// }



class Solution 
{
    String[] help={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) 
    {
        List<String> li= new ArrayList<>();
        if(digits.length()==0)
            return li;
        return ListletterCombinations("",digits);
    }
    public List<String> ListletterCombinations(String p,String up)
    {
        if (up.isEmpty())
        {
            List<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list= new ArrayList<>();
        int digit= up.charAt(0)-'0';
        String data= help[digit];
        for (int i = 0; i < data.length(); i++)
        {
            char ch=data.charAt(i);
            list.addAll(ListletterCombinations(p+ch,up.substring(1)));
        }
        return list;
    }
}