package net.engineeringdigest.journalApp.CompositeDesignPattern.Chess.Models;

public class King extends Piece{
    public King(boolean isWhite) {
        super(isWhite, new KingMoveStrategy(),"KI");
    }
}
