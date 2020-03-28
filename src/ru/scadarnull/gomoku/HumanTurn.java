package ru.scadarnull.gomoku;

public interface HumanTurn {
    /**
     * Чтобы игрок мог взаимодействовать с игровым полем
     */
    void setGameTable(GameTable gameTable);

    /**
     * делает ход в указанные координаты
     * @return клетку, куда сделал ход
     */
    Cell makeTurn(int row, int col);
}
