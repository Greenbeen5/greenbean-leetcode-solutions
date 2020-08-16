class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        target = image[sr][sc]
        self.dfs(image, sr, sc, target)
        for i in range(len(image)):
            for j in range(len(image[0])):
                if image[i][j] == None:
                    image[i][j] = newColor
        return image
    def dfs(self, image: List[List[int]], sr: int, sc: int,target :int):
        if sr in range(len(image)) and sc in range(len(image[0])):
            if image[sr][sc] == target:
                image[sr][sc] = None
                self.dfs(image, sr + 1, sc, target)
                self.dfs(image, sr - 1, sc, target)
                self.dfs(image, sr, sc + 1, target)
                self.dfs(image, sr, sc - 1, target)
        return