package academy.tochkavhoda.matrix;

import java.util.HashSet;
import java.util.Set;

public class MatrixNonSimilarRows {

    Set<int[]> set;

    public MatrixNonSimilarRows(int[][] matrix){
        set = new HashSet<>();
        Set<Set<Integer>> check = new HashSet<>();
        for (int[] array: matrix) {
            Set<Integer> install = new HashSet<>();
            for (int item : array) {
                install.add(item);
            }
            boolean contains = check.add(install);
            if (contains) {
                set.add(array);
            }
        }
    }

    public Set<int[]> getNonSimilarRows() {
        return set;
    }
}
