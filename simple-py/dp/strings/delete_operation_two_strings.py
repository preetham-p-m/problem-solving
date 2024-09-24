def minDistance(word1: str, word2: str) -> int:
    N, M = len(word1), len(word2)

    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if word1[n - 1] == word2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
            else:
                dp[n][m] = max(dp[n - 1][m], dp[n][m - 1])

    number_of_deletions = N - dp[N][M]
    number_of_insertions = M - dp[n][M]

    return number_of_insertions + number_of_deletions
