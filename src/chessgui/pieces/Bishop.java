package chessgui.pieces;

import chessgui.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean is_white, String file_path, Board board)
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

        if (Math.abs(this.getX() - destination_x) != Math.abs(this.getY() - destination_y) && (this.getX() + destination_x) != (this.getY() + destination_y))
        {
            return false;
        }

        String direction = "";

        if (destination_x > this.getX() && destination_y > this.getY())
        {
            direction = "right_down";
        }
        if (destination_x > this.getX() && destination_y < this.getY())
        {
            direction = "left_down";
        }
        if (destination_x < this.getX() && destination_y > this.getY())
        {
            direction = "right_up";
        }
        if (destination_x < this.getX() && destination_y < this.getY())
        {
            direction = "left_up";
        }

        // cant jump
        if (direction.equals("right_down"))
        {
            int spaces_to_move = Math.abs(destination_y - this.getY());
            for(int i = 1; i < spaces_to_move; i++)
            {
                Piece p = board.getPiece(this.getX() + i, this.getY() + i);
                if(p != null)
                {
                    return false;
                }
            }
        }
        if (direction.equals("left_down"))
        {
            int spaces_to_move = Math.abs(destination_y - this.getY());
            for(int i = 1; i < spaces_to_move; i++)
            {
                Piece p = board.getPiece(this.getX() + i, this.getY() - i);
                if(p != null)
                {
                    return false;
                }
            }
        }
        if (direction.equals("right_up"))
        {
            int spaces_to_move = Math.abs(destination_x - this.getX());
            for(int i = 1; i < spaces_to_move; i++)
            {
                Piece p = board.getPiece(this.getX() - i, this.getY() + i);
                if(p != null)
                {
                    return false;
                }
            }
        }
        if (direction.equals("left_up"))
        {
            int spaces_to_move = Math.abs(destination_x - this.getX());
            for(int i = 1; i < spaces_to_move; i++)
            {
                Piece p = board.getPiece(this.getX() - i, this.getY() - i);
                if(p != null)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
