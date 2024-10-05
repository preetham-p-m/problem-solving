def isScramble(self, s1: str, s2: str) -> bool:

    if s1 == s2:
        return True

    if sorted(s1) != sorted(s2):
        return False

    dp = {}

    def dfs(s1: str, s2: str) -> bool:

        if (s1, s2) in dp:
            return dp[(s1, s2)]

        if s1 == s2:
            dp[((s1, s2))] = True
            return True

        if sorted(s1) != sorted(s2):
            dp[((s1, s2))] = False
            return False

        n = len(s1)

        for i in range(1, n):
            if dfs(s1[:i], s2[:i]) and dfs(s1[i:], s2[i:]):
                dp[(s1, s2)] = True
                return True

            if dfs(s1[:i], s2[-i:]) and dfs(s1[i:], s2[:-i]):
                dp[(s1, s2)] = True
                return True

        dp[((s1, s2))] = False
        return False

    return dfs(s1, s2)
