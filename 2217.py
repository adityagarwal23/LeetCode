class Solution:
    def kthPalindrome(self, queries: List[int], intLength: int) -> List[int]:
        h = (intLength + 1 ) // 2
        start = 10 ** (h - 1)
        return [
            -1 if q > 9 * start else 
            int ((s := str(start + q - 1)) + s[::-1][intLength % 2:])
            for q in queries 
        ]