package ru.scadarnull.gomoku.impl;

import ru.scadarnull.gomoku.Cell;
import ru.scadarnull.gomoku.CellValue;
import ru.scadarnull.gomoku.GameTable;
import ru.scadarnull.gomoku.HumanTurn;

import java.util.Objects;

public class DefaultHumanTurn implements HumanTurn {
    private GameTable gameTable;

    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can`t be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell makeTurn(int row, int col) {
        gameTable.setValue(row, col, CellValue.HUMAN);
        return new Cell(row, col);
    }
}
