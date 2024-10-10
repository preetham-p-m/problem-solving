package graphs;

public class FloodFill {

    private int[] rows = new int[] { 0, 0, -1, 1 };
    private int[] columns = new int[] { -1, 1, 0, 0 };

    public void dfs(int[][] flood, int r, int c, int color, int pastColor) {
        flood[r][c] = color;

        for (int i = 0; i < 4; i++) {
            int effRow = r + rows[i];
            int effCol = c + columns[i];

            if (effRow >= 0 && effRow < flood.length && effCol >= 0 && effCol < flood[0].length
                    && flood[effRow][effCol] == pastColor) {
                dfs(flood, effRow, effCol, color, pastColor);
            }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pastColor = image[sr][sc];

        if (pastColor != color) {
            dfs(image, sr, sc, color, pastColor);
        }
        return image;
    }
}
