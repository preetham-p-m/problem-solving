from typing import List


def longestCommonSubsequenceHelper(
    text1: str, text2: str, n: int, m: int, dp: List[List[int]]
) -> int:
    if n == 0 or m == 0:
        return 0

    if dp[n][m] != -1:
        return dp[n][m]

    if text1[n - 1] == text2[m - 1]:
        dp[n][m] = 1 + longestCommonSubsequenceHelper(text1, text2, n - 1, m - 1, dp)
        return dp[n][m]

    dp[n][m] = max(
        longestCommonSubsequenceHelper(text1, text2, n - 1, m, dp),
        longestCommonSubsequenceHelper(text1, text2, n, m - 1, dp),
    )

    return dp[n][m]


def longestCommonSubsequence(self, text1: str, text2: str) -> int:
    dp = [[-1 for _ in range(len(text2) + 1)] for _ in range(len(text1) + 1)]
    return longestCommonSubsequenceHelper(text1, text2, len(text1), len(text2), dp)


def longestCommonSubsequenceUsingTabulation(text1: str, text2: str) -> int:
    N, M = len(text1), len(text2)

    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if text1[n - 1] == text2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
            else:
                dp[n][m] = max(dp[n][m - 1], dp[n - 1][m])

    return dp[N][M]


def printLongestCommonSubsequence(text1: str, text2: str) -> int:
    N, M = len(text1), len(text2)

    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if text1[n - 1] == text2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
            else:
                dp[n][m] = max(dp[n - 1][m], dp[n][m - 1])

    n, m = N, M
    answer = ""

    while n > 0 and m > 0:
        if text1[n - 1] == text2[m - 1]:
            answer = text1[n - 1] + answer
            n -= 1
            m -= 1
        else:
            if dp[n - 1][m] > dp[n][m - 1]:
                n -= 1
            else:
                m -= 1

    if len(answer) == 0:
        raise RuntimeError("No common sub-sequence found.")

    return answer


print(printLongestCommonSubsequence("abc", "abc"))
