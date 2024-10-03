from typing import List


def minCut(s: str) -> int:
    def is_palindrome(s: str, start: int, end: int):
        return s[start : end + 1] == s[start : end + 1][::-1]

    def cut(s: str, start: int, end: int, dp: List[List[int]]):
        if start >= end:
            return 0

        if dp[start][end] != -1:
            return dp[start][end]

        if is_palindrome(s, start, end):
            return 0

        minValue: int = float("infinity")

        for k in range(start, end):
            left = dp[start][k] if dp[start][k] != -1 else cut(s, start, k, dp)
            dp[start][k] = left

            right = dp[k + 1][end] if dp[k + 1][end] != -1 else cut(s, k + 1, end, dp)
            dp[k + 1][end] = right

            temp = left + right + 1
            minValue = min(temp, minValue)

        dp[start][end] = minValue
        return dp[start][end]

    N = len(s)
    dp = [[-1 for _ in range(N + 1)] for _ in range(N + 1)]

    return cut(s, 0, N, dp)


print(minCut("aab"))
