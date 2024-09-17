from typing import List


def letter_combinations(digits: str) -> List[str]:
    if digits == "":
        return []

    ans, sol = [], []
    n = len(digits)

    letter_map = {
        "2": "abc",
        "3": "def",
        "4": "ghi",
        "5": "jkl",
        "6": "mno",
        "7": "pqrs",
        "8": "tuv",
        "9": "wxyz",
    }

    def backtrack(i=0):

        if len(sol) == n:
            ans.append("".join(sol[:]))
            return

        for num in letter_map[digits[i]]:
            sol.append(num)
            backtrack(i + 1)
            sol.pop()

    backtrack()
    return ans


letter_combinations("23")
