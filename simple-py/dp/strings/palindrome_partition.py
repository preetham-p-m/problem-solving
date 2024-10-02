from typing import List


def isPalindrome(s: str, start: int, end: int):
    return s[start : end + 1] == s[start : end + 1][::-1]


def partition_helper(
    start: int, s: str, ansList: List[List[str]], currentList: List[str]
):
    if start == len(s):
        ansList.append(currentList.copy())
        return

    for end in range(start, len(s)):
        if isPalindrome(s, start, end):
            currentList.append(s[start : end + 1])
            partition_helper(end + 1, s, ansList, currentList)
            currentList.pop()


def partition(self, s: str) -> List[List[str]]:
    ans: List[List[str]] = []
    partition_helper(0, s, ans, [])
    return ans
