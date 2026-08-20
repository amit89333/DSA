class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rs = new int[m];
        int[] cs = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rs[i]++;
                    cs[j]++;
                }
            }
        }

        int sc = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rs[i] == 1 && cs[j] == 1) {
                    sc++;
                }
            }
        }

        return sc;
    }
}