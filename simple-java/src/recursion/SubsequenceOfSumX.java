package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfSumX {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 1 };
        var result = start(array, 2);

        var result2 = uniqeSubsequnece(array);
        System.out.println(result2.toString());

        System.out.println(result.toString());
    }

    public static List<List<Integer>> start(int[] array, int target) {
        var list = new ArrayList<List<Integer>>();
        var tempList = new ArrayList<Integer>();
        subSequence(array, target, 0, tempList, 0, list);
        return list;
    }

    public static void subSequence(int[] array, int target, int index, List<Integer> tempList, int tempSum,
            List<List<Integer>> list) {

        if (index >= array.length) {
            if (tempSum == target) {
                list.add(new ArrayList<>(tempList));
            }

            return;
        }

        // // Want any one subsequence
        // if (!list.isEmpty()) {
        // return;
        // }

        subSequence(array, target, index + 1, tempList, tempSum, list);
        tempList.add(array[index]);
        subSequence(array, target, index + 1, tempList, tempSum + array[index], list);
        tempList.removeLast();
    }

    // #region subSequenceToMatchTargetCanPickSameItemNTimes
    public static void subSequenceToMatchTargetCanPickSameItemNTimes(int[] array, int target, int index,
            List<Integer> tempList,
            int tempSum,
            List<List<Integer>> list) {

        if (tempSum >= target || index >= array.length) {
            if (tempSum == target) {
                list.add(new ArrayList<>(tempList));
            }

            return;
        }

        tempList.add(array[index]);
        subSequence(array, target, index, tempList, tempSum + array[index], list);
        tempList.removeLast();
        subSequence(array, target, index + 1, tempList, tempSum, list);

    }
    // #endregion

    // #region subsetSums
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        var list = new ArrayList<Integer>();

        runSubsetSums(arr, N, 0, 0, list);

        return list;
    }

    public static void runSubsetSums(ArrayList<Integer> arrayList, int N, int index, int sum, ArrayList<Integer> list) {
        if (index >= N) {
            list.add(sum);
            return;
        }

        runSubsetSums(arrayList, N, index + 1, sum + arrayList.get(index), list);
        runSubsetSums(arrayList, N, index + 1, sum, list);
    }
    // #endregion

    // #region Unique SubSequence
    public static List<List<Integer>> uniqeSubsequnece(int[] array) {
        var list = new ArrayList<List<Integer>>();
        var temp = new ArrayList<Integer>();

        uniqeSubsequnece(array, 0, temp, list);

        return list;
    }

    public static void uniqeSubsequnece(int[] array, int index, List<Integer> tempList, List<List<Integer>> list) {
        list.add(new ArrayList<>(tempList));

        for (int i = index; i < array.length; i++) {
            if (i != index && array[i - 1] == array[i]) {
                continue;
            }

            tempList.add(array[i]);
            uniqeSubsequnece(array, i + 1, tempList, list);
            tempList.removeLast();
        }
    }
    // #endregion

}
