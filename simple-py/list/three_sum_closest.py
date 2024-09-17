from typing import List


def three_sum_closest(nums: List[int], target: int) -> int:

    sorted_list = sorted(nums)
    closest_sum = float("inf")

    for i in range(len(sorted_list)):
        left, right = i + 1, len(sorted_list) - 1

        while left < right:
            current_sum = sorted_list[i] + sorted_list[left] + sorted_list[right]

            if abs(current_sum - target) < abs(closest_sum - target):
                closest_sum = current_sum

            if current_sum < target:
                left += 1
            elif current_sum > target:
                right -= 1
            else:
                return current_sum

    return closest_sum


nums = [-1, 2, 1, -4]
target = 1
three_sum_closest(nums, target)
