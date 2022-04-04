package KMPSearch;

public class KMPSerch {

    int[] next = new int[0];
    public void random(int[] arr, int[] pat) {
        int i = 0, j = 0;
        while (i < arr.length && j < pat.length) {
            if (arr[i] == pat[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pat.length) {
            System.out.println("Pattern found at index " + (i - j));
        } else {
            System.out.println("Pattern not found");
        }
    }
}
