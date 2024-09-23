def longestCommonSubstring(text1: str, text2: str) -> int:
    N, M = len(text1), len(text2)

    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if text1[n - 1] == text2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
            else:
                dp[n][m] = 0

    return dp[N][M]
