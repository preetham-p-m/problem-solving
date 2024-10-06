from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:

    list = [0]

    def solve(root: Optional[TreeNode], list: List[int]) -> int:
        if root is None:
            return 0

        left = solve(root.left, list)
        right = solve(root.right, list)

        list[0] = max(list[0], left + right)
        return max(left, right) + 1

    solve(root, list)

    return list[0]
