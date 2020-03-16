class Solution:
    def intToRoman(self, num: int) -> str:
        ans = ""
        qian = num // 1000
        num = num - 1000 * qian
        ans += {0:"", 1:"M", 2:"MM", 3:"MMM"}[qian]
        bai = num // 100
        num = num - 100 * bai
        ans += {0:"", 1:"C", 2:"CC", 3:"CCC", 4:"CD", 5:"D", 6:"DC", 7:"DCC", 8:"DCCC", 9:"CM"}[bai]
        shi = num // 10
        num = num - 10 * shi
        ans += {0:"", 1:"X", 2:"XX", 3:"XXX", 4:"XL", 5:"L", 6:"LX", 7:"LXX", 8:"LXXX", 9:"XC"}[shi]
        ans += {0:"", 1:"I", 2:"II", 3:"III", 4:"IV", 5:"V", 6:"VI", 7:"VII", 8:"VIII", 9:"IX"}[num]
        return ans