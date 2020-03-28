package ru.scadarnull.gomoku;

public interface ComputerTurn {
    /**
     * Чтобы комп мог взаимодействовать с игровым полем
     */
    void setGameTable(GameTable gameTable);

    /**
     * Сделать ход
     * @return объект ячейки, куда сделал ход
     */
    Cell makeTurn();

    /**
     * Сделать перый рандомный ход
     * @return объект ячейки, куда сделал ход
     */
    Cell makeFirstTurn();
}
