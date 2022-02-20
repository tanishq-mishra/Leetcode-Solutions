from math import comb
class Solution:
    def climbStairs(self, n: int) -> int:
        ones = n
        twos = 0
        steps = 0
        while( ones >= 0) :
            n = ones + twos
            r = twos
            steps += comb(n,r)
            ones -=2
            twos +=1
        
        
        return steps
            
            