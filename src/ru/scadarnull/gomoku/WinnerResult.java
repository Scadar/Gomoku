package ru.scadarnull.gomoku;

import java.util.ArrayList;
import java.util.LinkedList;

public interface WinnerResult {

    /**
     * @return существует ли победитель
     */
    boolean winnerExist();

    /**
     *
     * @return получить множество ячеек
     */
    LinkedList<Cell> getWinnerCells();
}
