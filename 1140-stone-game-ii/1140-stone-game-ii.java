class Solution {
    int n;
    int[][][] t;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        t = new int[2][n][n + 1];
        for (int[][] arr : t)
            for (int[] row : arr)
                Arrays.fill(row, -1);

        return solve(piles, 1, 0, 1);
    }

    private int solve(int[] piles, int person, int i, int M) {
        if (i >= n) return 0;
        if (t[person][i][M] != -1) return t[person][i][M];

        int result = (person == 1) ? 0 : Integer.MAX_VALUE;
        int stones = 0;

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];

            if (person == 1) { // Alice wants to maximize
                result = Math.max(result, stones + solve(piles, 0, i + x, Math.max(M, x)));
            } else { // Bob wants to minimize Alice's score
                result = Math.min(result, solve(piles, 1, i + x, Math.max(M, x)));
            }
        }

        return t[person][i][M] = result;
    }
}