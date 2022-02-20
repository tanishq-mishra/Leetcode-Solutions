class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        prefixes = list()
        maxLength = 0;
        for c in s:
            if( len(prefixes) == 0):
                maxLength+=1
                prefixes.append(c)
            else:
                lastPrefix = prefixes[-1]
                indexToSlice = lastPrefix.rfind(c)
                prefixes.append(lastPrefix[indexToSlice+1:] + c)
                maxLength = max(len(prefixes[-1]), maxLength)
        return maxLength
        