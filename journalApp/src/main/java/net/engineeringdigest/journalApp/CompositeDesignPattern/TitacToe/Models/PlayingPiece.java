package net.engineeringdigest.journalApp.CompositeDesignPattern.TitacToe.Models;

public class PlayingPiece {
    public PieceType pieceType;

    public PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
