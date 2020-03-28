package ru.scadarnull.gomoku;

public interface WinnerChecker {
    /**
     * Чтобы мог взаимодействовать с игровым полем
     */
    void setGameTable(GameTable gameTable);

    /**
     *
     * Принимает значение ячейки
     * @return объект кто победил
     */
    WinnerResult isWinnerFound(CellValue cellValue);
}
