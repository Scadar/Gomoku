package ru.scadarnull.gomoku;

import java.util.ArrayList;

public interface WinnerResult {

    /**
     * @return существует ли победитель
     */
    boolean winnerExist();

    /**
     *
     * @return получить множество ячеек
     */
    ArrayList<Cell> getWinnerCells();
}
