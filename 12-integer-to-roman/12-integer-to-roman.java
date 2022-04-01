class Solution {
    public String intToRoman(int num) {
        StringBuilder theAnswer = new StringBuilder();        
        String[] latin = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] arabic = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        
        for(int i=latin.length-1; i>=0; i--){
            while(num>=arabic[i]){
                num -= arabic[i];
                theAnswer.append(latin[i]);
            }
        }
        
        return theAnswer.toString();
    }
}