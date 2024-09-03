# Print All Permutation

### With Extra Space

TC: O(n! x n)

SC: O(2n)

```
public List<List<Integer>> getPermutationWithSpace(int[] array) {
    List<List<Integer>> ansList = new ArrayList<>();
    List<Integer> ds = new ArrayList<>();
    boolean[] freq = new boolean[array.length];
    recursivePermutation(array, ds, freq, ansList);
    return ansList;
}

private void recursivePermutation(int[] array, List<Integer> ds, boolean[] freq, List<List<Integer>> ansList) {
    if (ds.size() == array.length) {
        ansList.add(new ArrayList<>(ds));
        return;
    }

    for (int i = 0; i < array.length; i++) {
        if (!freq[i]) {
            freq[i] = true;
            ds.add(array[i]);
            recursivePermutation(array, ds, freq, ansList);
            ds.remove(ds.size() - 1);
            freq[i] = false;
        }
    }
}
```

### Without Extra Space

TC: O(n! x n)

SC: O(1)

```
public List<List<Integer>> getPermutationWithoutSpace(int[] array) {
    List<List<Integer>> ansList = new ArrayList<>();

    recursivePermutationWithoutSpace(array, 0, ansList);

    return ansList;
}

private void recursivePermutationWithoutSpace(int[] array, int index, List<List<Integer>> ansList) {
    if (index == array.length) {
        List<Integer> ds = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++) {
            ds.add(array[i]);
        }

        ansList.add(new ArrayList<Integer>(ds));
    }

    for (int i = index; i < array.length; i++) {
        Array.swap(array, i, index);
        recursivePermutationWithoutSpace(array, index + 1, ansList);
        Array.swap(array, i, index);
    }
}
```
