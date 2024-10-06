from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def maxPathSum(root: Optional[TreeNode]) -> int:
    ans = [float("-infinity")]

    def solve(root: Optional[TreeNode], ans: List[int]) -> int:
        if root is None:
            return 0

        left: int = max(0, solve(root.left, ans))
        right: int = max(0, solve(root.right, ans))

        ans[0] = max(ans[0], left + right + root.val)
        return root.val + max(left, right)

    solve(root, ans)
    return ans[0]
