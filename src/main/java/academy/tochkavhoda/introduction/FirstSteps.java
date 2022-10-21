package academy.tochkavhoda.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public int mul(int[] array) {
        int mul = 1;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                mul = mul * array[i];
            }
        } else {
            return 0;
        }
        return mul;
    }

    public int min(int[] array) {
        if (array.length > 0) {
            int min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        } else {
            return Integer.MAX_VALUE;
        }

    }

    public int max(int[] array) {
        if (array.length > 0) {
            int max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public double average(int[] array) {
        double sum = 0;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
            }
            return sum / array.length;
        } else {
            return sum;
        }
    }

    public boolean isSortedDescendant(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] <= array[i + 1]) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 3);
        }
    }

    public boolean find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int s = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = s;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length - i - 1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        int x = matrix.length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }

    public int max(int[][] matrix) {
        if (matrix.length > 1) {
            int x = matrix.length;
            int max = matrix[0][0];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (max > matrix[i][j]) {
                        continue;
                    } else {
                        max = matrix[i][j];
                    }
                }
            }
            return max;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int diagonalMax(int[][] matrix) {
        int x = matrix.length;
        if (x > 1) {
            int max = matrix[0][0];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (i == j && max >= matrix[i][j]) {
                        continue;
                    }
                    if (i == j && max < matrix[i][j]) {
                        max = matrix[i][j];
                    }
                }
            }
            return max;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] array : matrix) {
            if (!isSortedDescendant(array)) {
                return false;
            }
        }
        return true;
    }


}