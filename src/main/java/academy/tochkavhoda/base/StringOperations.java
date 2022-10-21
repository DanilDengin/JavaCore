package academy.tochkavhoda.base;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int n = 0;
        for (String x : strings) {
            n += x.length();
        }
        return n;
    }

    public static String getFirstAndLastLetterString(String string) {
        return String.valueOf(string.charAt(0)) + String.valueOf(string.charAt(string.length() - 1));
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        // REVU 2 раза одно и то же делать незачем
        // REVU просто сравнить 2 startsWith
        return string1.startsWith(prefix) && string2.startsWith(prefix);

    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        // REVU аналогично, endsWith
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int j = 0;
        String str = "";
        for (int i = 0; i <= Math.min(string1.length(), string2.length()) - 1; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                break;
            }
            j++;
        }
        if (j == 0) {
            return str;
        }
        return string1.substring(0, j);
    }

    public static String reverse(String string) {
        StringBuilder str = new StringBuilder(string);
        return str.reverse().toString();

    }

    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(string.length() - 1 - i) != string.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return isPalindrome(string.toLowerCase());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        int a = 0;
        String s1 = "";
        if (strings.length == 0) {
            return s1;
        }
        for (String string : strings) {
            if (isPalindromeIgnoreCase(string) && string.length() > a) {
                s1 = string;
                a = string.length();
            }
        }
        return s1;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1.length() - index < length || string2.length() - index < length)
            return false;
        return string1.substring(index, length + index).equals(string2.substring(index, length + index));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String str = string.replace(" ", "");
        return isPalindromeIgnoreCase(str);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringJoiner s1 = new StringJoiner(",");
        if (array.length == 0) {
            return s1.toString();
        } else {
            for (int item : array) {
                s1.add(String.valueOf(item));
            }
        }
        return s1.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringJoiner str = new StringJoiner(",");
        if (array.length == 0) {
            return str.toString();
        } else {
            for (double item : array) {
                DecimalFormat d = new DecimalFormat("#.00");
                str.add(d.format(item));
            }
        }
        return str.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder s1 = new StringBuilder("");
        if (array.length == 0) {
            return s1;
        } else {
            for (int item : array) {
                s1.append(String.valueOf(item)).append(",");
            }
        }
        return s1.delete(s1.length() - 1, s1.length());
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder str = new StringBuilder("");
        if (array.length == 0) {
            return str;
        } else {
            for (double item : array) {
                DecimalFormat d = new DecimalFormat("#.00");
                str.append(d.format(item)).append(",");
            }
        }
        return str.delete(str.length() - 1, str.length());
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder str = new StringBuilder(string);
        int i = 0;
        for (int x : positions) {
            str.deleteCharAt(x - i);
            // REVU i++
            i++;
        }
        return str;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder str = new StringBuilder(string);
        int k = 0;
        for (int i = 0; i < positions.length; i++) {
            str.insert(positions[i] + k, characters[i]);
            k++;
        }
        return str;
    }
}
