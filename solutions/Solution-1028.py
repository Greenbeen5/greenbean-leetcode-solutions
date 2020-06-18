# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def recoverFromPreorder(self, S: str) -> TreeNode:
        depth_val_pair = [(len(match[0]),int(match[1])) for match in re.findall(r'(-*)([1-9][0-9]*)', S)]
        root = TreeNode(depth_val_pair[0][1])
        parent = root
        stack = [(0,root)]
        for i in range(1, len(depth_val_pair)):
            parent_depth = stack[-1][0]
            cur_depth = depth_val_pair[i][0]
            cur_val = depth_val_pair[i][1]
            if cur_depth > parent_depth:
                parent.left = TreeNode(cur_val)
                parent = parent.left
                stack.append((cur_depth, parent))
            else:
                while stack[-1][0] >= cur_depth:
                    stack.pop()
                parent = stack.pop()[1]
                parent.right = TreeNode(cur_val)
                parent = parent.right
                stack.append((cur_depth, parent))
        return root
                
                