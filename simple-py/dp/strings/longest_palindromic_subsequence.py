def longestPalindromeSubsequence(s: str) -> str:
    s2 = s[::-1]
    N = len(s)

    dp = [[0 for _ in range(N + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for m in range(1, N + 1):
            if s[n - 1] == s2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
            else:
                dp[n][m] = max(dp[n - 1][m], dp[n][m - 1])

    return dp[N][N]


print(longestPalindromeSubsequence("abcdef"))
