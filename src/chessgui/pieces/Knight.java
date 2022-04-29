package chessgui.pieces;

import chessgui.Board;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {

        Piece possiblePiece = board.getPiece(destination_x, destination_y);

        if (possiblePiece != null)
        {
            if (possiblePiece.isWhite() && this.isWhite())
            {
                return false;
            }
            if (possiblePiece.isBlack() && this.isBlack())
            {
                return false;
            }
        }

        if (destination_x == this.getX() - 2 && destination_y == this.getY() - 1){}
        else
        if (destination_x == this.getX() - 2 && destination_y == this.getY() + 1){}
        else
        if (destination_x == this.getX() - 1 && destination_y == this.getY() + 2){}
        else
        if (destination_x == this.getX() - 1 && destination_y == this.getY() - 2){}
        else
        if (destination_x == this.getX() + 1 && destination_y == this.getY() - 2){}
        else
        if (destination_x == this.getX() + 1 && destination_y == this.getY() + 2){}
        else
        if (destination_x == this.getX() + 2 && destination_y == this.getY() - 1){}
        else
        if (destination_x == this.getX() + 2 && destination_y == this.getY() + 1){}
        else
        {
            return false;
        }
        
        return true;
    }
}
