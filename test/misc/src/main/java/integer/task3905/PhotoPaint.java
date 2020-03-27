package integer.task3905;

/**
 *
 */
public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        int[] rows = new int[image.length];
        for (int i = 0; i < image.length; i++) rows[i] = image[i].length;

        if (x < 0 || y < 0 || y > rows.length - 1 || x > rows[y] - 1 ||
                desiredColor == null || desiredColor == image[y][x]) return false;

//        fill(image, image[y][x], desiredColor, x, y);
        paintFill(image, x, y, desiredColor, image[y][x]);
        return true;
    }

    private void fill(Color[][] image, Color original, Color desiredColor, int x, int y) {
        image[y][x] = desiredColor;

        if (x != 0 && image[y][x - 1] == original)
            fill(image, original, desiredColor, x - 1, y);

        if (y != 0 && image[y - 1][x] == original)
            fill(image, original, desiredColor, x, y - 1);

        if (x != image[y].length - 1 && image[y][x + 1] == original)
            fill(image, original, desiredColor, x + 1, y);

        if (y != image.length - 1 && image[y + 1][x] == original)
            fill(image, original, desiredColor, x, y + 1);
    }

    private void paintFill(Color[][] image, int y, int x, Color desiredColor, Color currentColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length) return;

        if (image[y][x] != currentColor) return;
        else image[y][x] = desiredColor;

        paintFill(image, y - 1, x, desiredColor, currentColor);
        paintFill(image, y + 1, x, desiredColor, currentColor);
        paintFill(image, y, x - 1, desiredColor, currentColor);
        paintFill(image, y, x + 1, desiredColor, currentColor);
    }
}
