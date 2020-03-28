package ru.scadarnull.gomoku;

public interface GameTable {
    /**
     * Получает клетку по координатам
     * @return клетка
     */
    CellValue getValue(int row, int col);

    /**
     * Устанавливает клетку по координатам
     */
    void setValue(int row, int col, CellValue cellValue);

    /**
     * Перезапускает поле
     */
    void reInit();

    int getSize();

    /**
     *
     * @return Проверяет пустая ячейка или нет
     */
    boolean isCellFree(int row, int col);

    /**
     *
     * @return наличие свободных клеток
     */
    boolean emptyCellExist();
}
