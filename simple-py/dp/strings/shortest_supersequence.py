def shortestCommonSupersequence(str1: str, str2: str) -> str:
    N, M = len(str1), len(str2)

    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if str1[n - 1] == str2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
            else:
                dp[n][m] = max(dp[n - 1][m], dp[n][m - 1])

    n, m = N, M
    answer = ""

    while n > 0 and m > 0:
        if str1[n - 1] == str2[m - 1]:
            answer = str1[n - 1] + answer
            n -= 1
            m -= 1
        else:
            if dp[n - 1][m] > dp[n][m - 1]:
                answer = str1[n - 1] + answer
                n -= 1
            else:
                answer = str2[m - 1] + answer
                m -= 1

    while n > 0:
        answer = str1[n - 1] + answer
        n -= 1

    while m > 0:
        answer = str2[m - 1] + answer
        m -= 1

    return answer


print(shortestCommonSupersequence("abac", "cab"))
