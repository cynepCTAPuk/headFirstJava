package integer.task3905;

/* 
Залей меня полностью
В процессе разработки новой версии популярного графического редактора возникла необходимость реализовать заливку области картинки определенным цветом.

Реализуй метод paintFill в классе PhotoPaint таким образом, чтобы он возвращал:
- false, если цвет начальной точки (координаты приходят в качестве параметров) совпадает с цветом заливки или если начальные координаты выходят за рамки массива.
- модифицировал входящий массив и возвращал true, если заливка все же может быть выполнена.

Точке с координатами (x, y) соответствует элемент массив с индексом [y][x].

P.S. Если алгоритм работы заливки не очевиден, можешь попрактиковаться в графическом редакторе Paint.
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][]{
                {Color.BLUE, Color.RED, Color.RED},
                {Color.BLUE, Color.GREEN, Color.RED},
                {Color.GREEN, Color.GREEN, Color.RED},
                {Color.BLUE, Color.GREEN, Color.RED}
        };

        printImage(image);
        new PhotoPaint().paintFill(image, 1, 1, Color.YELLOW);
        System.out.println();
        printImage(image);
    }

    private static void printImage(Color[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.printf("%8s", image[i][j]);
            }
            System.out.println();
        }
    }
}
