package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LogicTest {
    @Test
    public void denyBishopMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        PawnBlack pawnBlack = new PawnBlack(Cell.D2);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        boolean moved = logic.move(Cell.C1,Cell.E3);
        assertFalse(moved);
    }

    @Test
    public void allowBishopMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        PawnBlack pawnBlack = new PawnBlack(Cell.C2);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        boolean moved = logic.move(Cell.C1,Cell.E3);
        assertTrue(moved);
    }
}
