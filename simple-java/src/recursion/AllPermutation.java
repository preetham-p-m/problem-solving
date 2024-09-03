package recursion;

import java.util.ArrayList;
import java.util.List;

import util.Array;

public class AllPermutation {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3 };

        AllPermutation allPermutation = new AllPermutation();

        System.out.println(allPermutation.getPermutationWithSpace(array).toString());

        System.out.println(allPermutation.getPermutationWithoutSpace(array).toString());
    }

    // #region With extra space
    public List<List<Integer>> getPermutationWithSpace(int[] array) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[array.length];

        recursivePermutationWithSpace(array, ds, freq, ansList);

        return ansList;
    }

    private void recursivePermutationWithSpace(int[] array, List<Integer> ds, boolean[] freq,
            List<List<Integer>> ansList) {
        if (ds.size() == array.length) {
            ansList.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(array[i]);
                recursivePermutationWithSpace(array, ds, freq, ansList);
                ds.removeLast();
                freq[i] = false;
            }
        }
    }
    // #endregion

    // #region Without extra space
    public List<List<Integer>> getPermutationWithoutSpace(int[] array) {
        List<List<Integer>> ansList = new ArrayList<>();

        recursivePermutationWithoutSpace(array, 0, ansList);

        return ansList;
    }

    private void recursivePermutationWithoutSpace(int[] array, int index, List<List<Integer>> ansList) {
        if (index == array.length) {
            List<Integer> ds = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                ds.add(array[i]);
            }

            ansList.add(new ArrayList<>(ds));
        }

        for (int i = index; i < array.length; i++) {
            Array.swap(array, i, index);
            recursivePermutationWithoutSpace(array, index + 1, ansList);
            Array.swap(array, i, index);
        }
    }
    // #endregion

}