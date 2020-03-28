package ru.scadarnull.gomoku;

public enum CellValue {
    COMPUTER('O'),
    HUMAN('X'),
    EMPTY(' ');

    private char value;

    CellValue(char value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
