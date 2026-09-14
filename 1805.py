class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        parts = re.split(r'[a-z]', word)
        cleaned = {re.sub(r'^0+(?!$)', '', part) for part in parts if part}
        return len(cleaned)