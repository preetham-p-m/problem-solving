def boolean_parenthesization(string: str) -> int:
    def calculate_combination(
        string: str, start: int, end: int, validateTo: bool
    ) -> int:
        if start > end:
            return 0

        if start == end:
            if validateTo == True:
                return 1 if string[start] == "T" else 0
            else:
                return 1 if string[start] == "F" else 0

        ans: int = 0

        for k in range(start + 1, end, 2):
            left_true = calculate_combination(string, start, k - 1, True)
            left_false = calculate_combination(string, start, k - 1, False)

            right_true = calculate_combination(string, k + 1, end, True)
            right_false = calculate_combination(string, k + 1, end, False)

            if string[k] == "&":
                ans += (
                    (left_true * right_true)
                    if validateTo
                    else (
                        left_false * right_true
                        + left_true * right_false
                        + left_false * right_false
                    )
                )
            elif string[k] == "|":
                ans += (
                    (
                        left_false * right_true
                        + left_true * right_false
                        + left_true * right_true
                    )
                    if validateTo
                    else (left_false * right_false)
                )
            elif string[k] == "^":
                ans += (
                    (left_false * right_true + left_true * right_false)
                    if validateTo
                    else left_true * right_true + left_false * right_false
                )

        return ans

    return calculate_combination(string, 0, len(string) - 1, True)


print(boolean_parenthesization("T&T"))
