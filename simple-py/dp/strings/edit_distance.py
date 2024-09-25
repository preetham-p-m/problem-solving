def minDistance(word1: str, word2: str) -> int:
    N, M = len(word1), len(word2)

    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for i in range(N + 1):
        dp[i][0] = i

    for j in range(M + 1):
        dp[0][j] = j

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if word1[n - 1] == word2[m - 1]:
                dp[n][m] = dp[n - 1][m - 1]
            else:
                dp[n][m] = 1 + min(dp[n - 1][m], dp[n][m - 1], dp[n - 1][m - 1])

    return dp[N][M]
