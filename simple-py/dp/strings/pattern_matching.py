def isMatch(self, s: str, p: str) -> bool:
    N, M = len(s), len(p)

    dp = [[False for _ in range(M + 1)] for _ in range(N + 1)]

    dp[0][0] = True

    for j in range(1, M + 1):
        if p[j - 1] == "*":
            dp[0][j] = dp[0][j - 1]

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if s[n - 1] == p[m - 1] or p[m - 1] == "?":
                dp[n][m] = dp[n - 1][m - 1]
            elif p[m - 1] == "*":
                dp[n][m] = dp[n - 1][m] or dp[n][m - 1]

    return dp[N][M]
