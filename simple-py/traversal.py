from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def inorder(root: Optional[TreeNode], list: List[int]):

    if (root is None):
        return

    inorder(root.left, list)
    list.append(root.val)
    inorder(root.right, list)


def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
    list: List[int] = []

    inorder(root, list)

    return list
