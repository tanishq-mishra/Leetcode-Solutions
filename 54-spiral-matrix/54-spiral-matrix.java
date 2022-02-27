class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
         int i = 0;
         int j = 0;
         int k = 0;
         boolean right = true;
         boolean down = false;
         boolean left = false;
         boolean up = false;
         int counter = 1;
         
         while(counter <= (r*c)  ) {
                //System.out.print(matrix[i][j]+" ");
                ans.add(matrix[i][j]);
                if(right) {
                    if(j == c-k-1) {
                        right = false;
                        down = true;
                        i++;
                    } else {
                        j++;
                        
                    }
                    
                } 
                
                else if(down) {
                    if(i == r-k-1) {
                        down = false;
                        left = true;
                        j--;
                    } else {
                        i++;
                        
                    }
                    
                } 
                else if(left) {
                    if(j == k) {
                        left = false;
                        up = true;
                        i--;
                    } else {
                       j--;
                       
                    }
                    
                } else if(up) {
                    if(i == k+1) {
                        up = false;
                        right = true;
                        j++;
                        k++;
                    } else {
                        i--;
                        
                    }
                }
            counter++;
         }
         return ans;
    }
}