package ru.scadarnull.gomoku.impl;

import ru.scadarnull.gomoku.*;

import java.util.LinkedList;
import java.util.Objects;

public class DefaultWinnerChecker implements WinnerChecker {

    private GameTable gameTable;
    private int winCount = DefaultConstant.WIN_COUNT;

    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can`t be null");
        if(gameTable.getSize() < winCount){
            throw new IllegalArgumentException("Size of game table is small: size = " + gameTable.getSize() + ". Required >= " + winCount);
        }
        this.gameTable = gameTable;
    }

    @Override
    public WinnerResult isWinnerFound(CellValue cellValue) {
        Objects.requireNonNull(cellValue, "CellValue can`t be null");
        LinkedList<Cell> result = isWinnerByRow(cellValue);
        if(result != null){
            return new DefaultWinnerResult(result);
        }
        result = isWinnerByCol(cellValue);
        if(result != null){
            return new DefaultWinnerResult(result);
        }
        result = isWinnerByMainDiagonal(cellValue);
        if(result != null){
            return new DefaultWinnerResult(result);
        }
        result = isWinnerByNotMainDiagonal(cellValue);
        if(result != null){
            return new DefaultWinnerResult(result);
        }
        return new DefaultWinnerResult(null);
    }
    protected LinkedList<Cell> isWinnerByRow(CellValue cellValue){
        for (int i = 0; i < gameTable.getSize(); i++) {
            LinkedList<Cell>cells = new LinkedList<>();
            for (int j = 0; j < gameTable.getSize(); j++) {
                if(gameTable.getValue(i, j) == cellValue){
                    cells.add(new Cell(i, j));
                    if(cells.size() == winCount){
                        return cells;
                    }
                }else{
                    cells.clear();
                    if(j > gameTable.getSize() - winCount){
                        break;
                    }
                }
            }
        }
        return null;
    }
    protected LinkedList<Cell> isWinnerByCol(CellValue cellValue){
        for (int i = 0; i < gameTable.getSize(); i++) {
            LinkedList<Cell>cells = new LinkedList<>();
            for (int j = 0; j < gameTable.getSize(); j++) {
                if(gameTable.getValue(j, i) == cellValue){
                    cells.add(new Cell(j, i));
                    if(cells.size() == winCount){
                        return cells;
                    }
                }else{
                    cells.clear();
                    if(j > gameTable.getSize() - winCount){
                        break;
                    }
                }
            }
        }
        return null;
    }

    protected LinkedList<Cell> isWinnerByMainDiagonal(CellValue cellValue){
        int winCountMinus1 = winCount - 1;
        for (int i = 0; i < gameTable.getSize() - winCountMinus1; i++) {
            for (int j = 0; j < gameTable.getSize() - winCountMinus1; j++) {
                LinkedList<Cell>cells = new LinkedList<>();
                for (int k = 0; k < winCount; k++) {
                    if(gameTable.getValue(i + k, j + k) == cellValue){
                        cells.add(new Cell(i + k, j + k));
                        if(cells.size() == winCount){
                            return cells;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return null;
    }

    protected LinkedList<Cell> isWinnerByNotMainDiagonal(CellValue cellValue){
        int winCountMinus1 = winCount - 1;
        for (int i = 0; i < gameTable.getSize() - winCountMinus1; i++) {
            for (int j = winCountMinus1; j < gameTable.getSize(); j++) {
                LinkedList<Cell>cells = new LinkedList<>();
                for (int k = 0; k < winCount; k++) {
                    if(gameTable.getValue(i + k, j - k) == cellValue){
                        cells.add(new Cell(i + k, j - k));
                        if(cells.size() == winCount){
                            return cells;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return null;
    }

    private static class DefaultWinnerResult implements WinnerResult{
        private final LinkedList<Cell> winnerCells;

        private DefaultWinnerResult(LinkedList<Cell> winnerCells) {
            this.winnerCells = winnerCells != null ? new LinkedList<>(winnerCells) : new LinkedList<>();
        }

        @Override
        public boolean winnerExist() {
            return winnerCells.size() > 0;
        }

        @Override
        public LinkedList<Cell> getWinnerCells() {
            return winnerCells;
        }
    }
}
