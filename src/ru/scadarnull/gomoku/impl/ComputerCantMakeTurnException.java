package ru.scadarnull.gomoku.impl;

public class ComputerCantMakeTurnException extends IllegalStateException{
    public ComputerCantMakeTurnException(String message) {
        super(message);
    }
}
