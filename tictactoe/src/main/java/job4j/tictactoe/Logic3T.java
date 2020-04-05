package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isWin(Predicate<Figure3T> markBy) {
        return this.fillBy(markBy, 0, 0, 1, 0) ||
                this.fillBy(markBy, 0, 1, 1, 0) ||
                this.fillBy(markBy, 0, 2, 1, 0) ||
                this.fillBy(markBy, 0, 0, 0, 1) ||
                this.fillBy(markBy, 1, 0, 0, 1) ||
                this.fillBy(markBy, 2, 0, 0, 1) ||
                this.fillBy(markBy, 0,0, 1, 1) ||
                this.fillBy(markBy, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerX() {
        return isWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWin(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(figure3T -> !figure3T.hasMarkX() && !figure3T.hasMarkO());
    }
}
