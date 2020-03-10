package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopTest {
    @Test
    public void moveUpRight(){
        Cell src = Cell.B2;
        Cell dst = Cell.F6;

        BishopBlack bishopBlack = new BishopBlack(src);
        Cell[] way = bishopBlack.way(src, dst);
        Cell[] expected = new Cell[] {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6};
        assertThat(way, is(expected));
    }

    @Test
    public void moveDownRight(){
        Cell src = Cell.A8;
        Cell dst = Cell.E4;

        BishopBlack bishopBlack = new BishopBlack(src);
        Cell[] way = bishopBlack.way(src, dst);
        Cell[] expected = new Cell[] {Cell.A8, Cell.B7, Cell.C6, Cell.D5, Cell.E4};
        assertThat(way, is(expected));
    }

    @Test
    public void moveUpLeft(){
        Cell src = Cell.E3;
        Cell dst = Cell.C5;

        BishopBlack bishopBlack = new BishopBlack(src);
        Cell[] way = bishopBlack.way(src, dst);
        Cell[] expected = new Cell[] {Cell.E3, Cell.D4, Cell.C5};
        assertThat(way, is(expected));
    }

    @Test
    public void moveDownLeft(){
        Cell src = Cell.B8;
        Cell dst = Cell.C7;

        BishopBlack bishopBlack = new BishopBlack(src);
        Cell[] way = bishopBlack.way(src, dst);
        Cell[] expected = new Cell[] {Cell.B8, Cell.C7};
        assertThat(way, is(expected));
    }

    @Test (expected = IllegalStateException.class)
    public void wrongWay(){
        Cell src = Cell.A1;
        Cell dst = Cell.D3;

        BishopBlack bishopBlack = new BishopBlack(src);
        bishopBlack.way(src, dst);
    }
}
