from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def in_order(root: Optional[TreeNode], list: List[int]):

    if root is None:
        return

    in_order(root.left, list)
    list.append(root.val)
    in_order(root.right, list)


def in_orderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    list: List[int] = []

    in_order(root, list)

    return list
