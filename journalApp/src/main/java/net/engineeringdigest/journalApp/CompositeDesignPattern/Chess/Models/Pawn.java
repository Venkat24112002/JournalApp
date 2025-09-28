package net.engineeringdigest.journalApp.CompositeDesignPattern.Chess.Models;

public class Pawn extends Piece{
    public Pawn(boolean isWhite){
      super(isWhite, new PawnMoveStrategy(),"P");
    }
}
