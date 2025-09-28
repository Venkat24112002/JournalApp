package net.engineeringdigest.journalApp.CompositeDesignPattern.Chess.Models;

public interface MoveStrategy {
    boolean canMove(Board board, Cell from, Cell To);
}
