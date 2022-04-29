package chessgui.pieces;

import chessgui.Board;

public class King extends Piece {

    public King(int x, int y, boolean is_white, String file_path, Board board)
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

        if(Math.abs(this.getX() - destination_x) > 1 || Math.abs(this.getY() - destination_y) > 1)
        {
            return false;
        }

        if(this.isWhite())
        {
            //pawn

            Piece p1 = board.getPiece(destination_x + 1, destination_y + 1);
            Piece p2 = board.getPiece(destination_x - 1, destination_y + 1);
            if(p1 != null)
            {
                if (p1.getFilePath().equals("Pawn.png") && p1.isBlack())
                {
                    return false;
                }
            }
            if(p2 != null)
            {
                if (p2.getFilePath().equals("Pawn.png") && p2.isBlack())
                {
                    return false;
                }
            }

            //rook & queen

                for(int i = destination_y + 1; i < 8; i++)
                {
                    Piece p = board.getPiece(destination_x, i);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack())
                        {
                            if((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isBlack())
                            {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for(int i = destination_y - 1; i >= 0; i--)
                {
                    Piece p = board.getPiece(destination_x, i);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for(int i = destination_x + 1; i < 8; i++)
                {
                    Piece p = board.getPiece(i, destination_y);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for(int i = destination_x - 1; i >= 0; i--)
                {
                    Piece p = board.getPiece(i, destination_y);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                //bishop & queen

                for(int i = 1; i < 8 - destination_x || i < 8 - destination_y; i++)
                {
                    Piece p = board.getPiece(destination_x + i, destination_y + i);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for(int i = 1; i < 8 - destination_x || i <= destination_y; i++)
                {
                    Piece p = board.getPiece(destination_x + i, destination_y - i);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for(int i = 1; i <= destination_x || i <= destination_y; i++)
                {
                    Piece p = board.getPiece(destination_x - i, destination_y - i);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for(int i = 1; i <= destination_x || i < 8 - destination_y; i++)
                {
                    Piece p = board.getPiece(destination_x - i, destination_y + i);
                    if(p != null)
                    {
                        if(!p.getFilePath().equals("King.png") || p.isBlack()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isBlack()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                //knight

            Piece p = board.getPiece(destination_x - 2, destination_y - 1);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isBlack())
                    {
                        return false;
                    }
                }
            p = board.getPiece(destination_x - 2, destination_y + 1);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 2, destination_y - 1);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 2, destination_y + 1);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x - 1, destination_y + 2);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x - 1, destination_y - 2);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 1, destination_y - 2);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 1, destination_y + 2);
            if(p != null)
            {
                if(p.getFilePath().equals("Knight.png") && p.isBlack())
                {
                    return false;
                }
            }

            //king

            p = board.getPiece(destination_x - 1, destination_y - 1);
            if(p != null)
            {
                if(p.getFilePath().equals("King.png") && p.isBlack())
                {
                    return false;
                }
            }
            p = board.getPiece(destination_x - 1, destination_y);
            if(p != null) {

                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
            p = board.getPiece(destination_x - 1, destination_y + 1);
            if(p != null) {
                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
            p = board.getPiece(destination_x, destination_y - 1);
            if(p != null) {
                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
            p = board.getPiece(destination_x, destination_y + 1);
            if(p != null) {
                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 1, destination_y - 1);
            if(p != null) {
                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 1, destination_y);
            if(p != null) {
                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
            p = board.getPiece(destination_x + 1, destination_y + 1);
            if(p != null) {
                if (p.getFilePath().equals("King.png") && p.isBlack()) {
                    return false;
                }
            }
        }
        else
            if(this.isBlack()) {

                //pawn

                Piece p1 = board.getPiece(destination_x + 1, destination_y - 1);
                Piece p2 = board.getPiece(destination_x - 1, destination_y - 1);
                if (p1 != null) {
                    if (p1.getFilePath().equals("Pawn.png") && p1.isWhite()) {
                        return false;
                    }
                }
                if (p2 != null) {
                    if (p2.getFilePath().equals("Pawn.png") && p2.isWhite()) {
                        return false;
                    }
                }

                //rook & queen

                for (int i = destination_y + 1; i < 8; i++) {
                    Piece p = board.getPiece(destination_x, i);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for (int i = destination_y - 1; i >= 0; i--) {
                    Piece p = board.getPiece(destination_x, i);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for (int i = destination_x + 1; i < 8; i++) {
                    Piece p = board.getPiece(i, destination_y);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for (int i = destination_x - 1; i >= 0; i--) {
                    Piece p = board.getPiece(i, destination_y);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Rook.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                //bishop & queen

                for (int i = 1; i < 8 - destination_x || i < 8 - destination_y; i++) {
                    Piece p = board.getPiece(destination_x + i, destination_y + i);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for (int i = 1; i < 8 - destination_x || i <= destination_y; i++) {
                    Piece p = board.getPiece(destination_x + i, destination_y - i);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for (int i = 1; i <= destination_x || i <= destination_y; i++) {
                    Piece p = board.getPiece(destination_x - i, destination_y - i);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                for (int i = 1; i <= destination_x || i < 8 - destination_y; i++) {
                    Piece p = board.getPiece(destination_x - i, destination_y + i);
                    if (p != null) {
                        if(!p.getFilePath().equals("King.png") || p.isWhite()) {
                            if ((p.getFilePath().equals("Bishop.png") || p.getFilePath().equals("Queen.png")) && p.isWhite()) {
                                return false;
                            }
                            break;
                        }
                    }
                }

                //knight

                Piece p = board.getPiece(destination_x - 2, destination_y - 1);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x - 2, destination_y + 1);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 2, destination_y - 1);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 2, destination_y + 1);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x - 1, destination_y + 2);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x - 1, destination_y - 2);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 1, destination_y - 2);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 1, destination_y + 2);
                if(p != null)
                {
                    if(p.getFilePath().equals("Knight.png") && p.isWhite())
                    {
                        return false;
                    }
                }

                //king

                p = board.getPiece(destination_x - 1, destination_y - 1);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x - 1, destination_y);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x - 1, destination_y + 1);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x, destination_y - 1);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x, destination_y + 1);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 1, destination_y - 1);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 1, destination_y);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
                p = board.getPiece(destination_x + 1, destination_y + 1);
                if(p != null) {
                    if (p.getFilePath().equals("King.png") && p.isWhite()) {
                        return false;
                    }
                }
            }
        return true;
    }
}
