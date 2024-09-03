# Set Matrix to Zero

### Brute Force

Traverse through the matrix and when we find the zero traverse again and mark row and column to -1 only if the value is not zero. During second Traversal mark -1 to 0.

TC: ~O(n^3) due to extra traversal inside to mark -1

### Better

Take a extra array of 1xm and nx1 and mark row and column that need to be made zero during first traversal. During second traversal mark it as zero based on the value in the extra array.

TC: O(n^2)

SC: O(m) + O(n) for array

### Optimal

Same as the Second Approach but instead of taking new array use 1st row and 1 column and for overlap take 1 byte.

```
public void run(int[][] matrix) {
    boolean col0 = false;
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                if (j == 0)
                    col0 = true;
                else
                    matrix[0][j] = 0;
            }
        }
    }

    <!-- Remember the reverse traversal -->
    for (int i = matrix.length-1; i >= 0; i--) {
        for (int j = matrix[0].length-1; j >= 1; j--) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
        if (col0) {
            matrix[i][0] = 0;
        }
    }
}
```

# Pascal Triangle

### Print Element for given row and column

Use (n-1)C(r-1) formula to calculate the value

### Print Row

First element will be aloways 1. We need to multiply by (row-col) and divide by (col). Do some calculation using pen and paper for understanding. Check the `getRow` method.

### Print Entire Pascal Triangle

```
public List<List<Integer>> run(int numberOfRows) {
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 1; i <= numberOfRows; i++) {
        list.add(getRow(i));
    }

    return list;
}

public List<Integer> getRow(int row) {
    List<Integer> ansRow = new ArrayList<>();

    int temp = 1;
    ansRow.add(temp);

    for (int col = 1; col < row; col++) {
        temp = temp * (row - col);
        temp = temp / col;
        ansRow.add(temp);
    }

    return ansRow;
}
```

# Next Permutation

Video Link: https://www.youtube.com/watch?v=JDOXKqF60RQ&t=682s

```
public int[] run(int[] array) {
    int lenght = array.length;
    int index = -1;

    for (int i = lenght - 2; i >= 0; i--) {
        if (array[i] < array[i + 1]) {
            index = i;
            break;
        }
    }

    for (int i = lenght - 1; i >= index; i--) {
        if (array[index] < array[i]) {
            Array.swap(array, index, i);
            break;
        }
    }

    Array.reverse(array, index+1, array.length - 1);

    return array;
}
```

# Sort 0's, 1's and 2's in given array

```
public void run(int[] array) {
    int low = 0;
    int mid = 0;
    int high = array.length - 1;

    while (mid <= high) {
        switch (array[mid]) {
            case 0:
                Array.swap(array, mid++, low++);
                break;

            case 1:
                mid++;
                break;

            default:
                Array.swap(array, mid, high--);
                break;
        }
    }
}
```

# Best Time To Buy & Sell Stock

```
public int run(int[] prices) {
    int min = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
        if (prices[i] < min) {
            min = prices[i];
        } else {
            int profit = prices[i] - min;

            if (profit > maxProfit)
                maxProfit = profit;
        }
    }

    return maxProfit;
}
```

# Rotate Matrix

```
public int[][] rotate(int[][] matrix) {
    matrix = Matrix.transpose(matrix);

    int size = matrix.length;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size / 2; j++) {
            Matrix.swap(matrix, new int[] { i, j }, new int[] { i, size - j - 1 });
        }
    }

    return matrix;
}

public static int[][] transpose(int[][] matrix) {
    int[][] result = new int[matrix[0].length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            result[j][i] = matrix[i][j];
        }
    }

    return result;
}

public static void swap(int[][] matrix, int[] source, int[] destination) {
    int temp = matrix[source[0]][source[1]];
    matrix[source[0]][source[1]] = matrix[destination[0]][destination[1]];
    matrix[destination[0]][destination[1]] = temp;
}
```

# Merge Overlapping interval

```
public int[][] run(int[][] intervals) {
    if (intervals == null || intervals.length <= 1) {
        return intervals;
    }

    Arrays.sort(intervals, (i, j) -> i[0] - j[0]);

    List<int[]> result = new ArrayList<>();

    int start = intervals[0][0];
    int end = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] <= end) {
            end = intervals[i][1];
        } else {
            result.add(new int[] { start, end });
            start = intervals[i][0];
            end = intervals[i][1];
        }
    }

    result.add(new int[] { start, end });

    return result.toArray(new int[0][]);
}
```

# Merge Sorted Array

1. https://www.youtube.com/watch?v=n7uwj04E0I4

```
// Given nums1 length = m+n
public static void run(int[] nums1, int m, int[] nums2, int n) {
    int left = m - 1;
    int right = n - 1;
    int index = m + n - 1;

    while (index >= 0 && left >= 0 && right >= 0) {
        if (nums1[left] > nums2[right]) {
            nums1[index--] = nums1[left--];
        } else {
            nums1[index--] = nums2[right--];
        }
    }

    while (right >= 0 && index >= 0) {
        nums1[index--] = nums2[right--];
    }
}
```

# Find Duplicate in Array

```
public static int start(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];

    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);

    fast = nums[0];

    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }

    return slow;
}
```
