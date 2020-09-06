class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        keyboard = (set('qwertyuiop'), set('asdfghjkl'), set('zxcvbnm'))
        res = []
        for word in words:
            lower_word = word.lower()
            charset = set(lower_word)
            if charset <= keyboard[0] or charset <= keyboard[1] or charset <= keyboard[2]:
                res.append(word)
        
        return res
                    
            