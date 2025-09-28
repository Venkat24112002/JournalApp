package net.engineeringdigest.journalApp.CompositeDesignPattern.Chess.Models;

public class KingMoveStrategy implements MoveStrategy{
    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int r = Math.abs(to.getRow() - from.getRow());
        int c = Math.abs(to.getCol() - from.getCol());
        if (r <= 1 && c <= 1) {
            Piece p = from.getPiece();
            return to.isEmpty() || to.getPiece().isWhite() != p.isWhite();
        }
        return false;
    }
}
