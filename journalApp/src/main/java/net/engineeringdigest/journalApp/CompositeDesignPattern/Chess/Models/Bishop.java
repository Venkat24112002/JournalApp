package net.engineeringdigest.journalApp.CompositeDesignPattern.Chess.Models;

public class Bishop extends Piece{
    public Bishop(boolean isWhite){
        super(isWhite, new BishopMoveStrategy(),"B");
    }
}
