package chessgui.pieces;

import chessgui.Board;

public class Pawn extends Piece {

    private boolean has_moved;

    public Pawn(int x, int y, boolean is_white, String file_path, Board board) {
        super(x, y, is_white, file_path, board);
        has_moved = false;
    }

    public void setHasMoved(boolean has_moved) {
        this.has_moved = has_moved;
    }

    public boolean getHasMoved() {
        return has_moved;
    }

    @Override
    public boolean canMove(int destination_x, int destination_y) {

        if (this.getFilePath().equals("Pawn.png")) {

            Piece possiblePiece = board.getPiece(destination_x, destination_y);

            if (possiblePiece != null) {
                if (possiblePiece.isWhite() && this.isWhite()) {
                    return false;
                }
                if (possiblePiece.isBlack() && this.isBlack()) {
                    return false;
                }
            }

            if (this.isWhite()) {
                Piece p = board.getPiece(this.getX(), this.getY() + 1);
                Piece p1 = board.getPiece(this.getX(), this.getY() + 2);
                Piece p3 = board.getPiece(this.getX() + 1, this.getY() + 1);
                Piece p4 = board.getPiece(this.getX() - 1, this.getY() + 1);
                if (destination_x == this.getX() && destination_y == this.getY() + 1 && p == null) {
                } else if (destination_y == 3 && this.getY() == 1 && destination_x == this.getX() && p == null && p1 == null) {
                } else if (destination_x == this.getX() + 1 && destination_y == this.getY() + 1 && p3.isBlack()) {
                } else if (destination_x == this.getX() - 1 && destination_y == this.getY() + 1 && p4.isBlack()) {
                } else {
                    return false;
                }

                if (destination_y == 7) {
                    Piece thePawn = board.getPiece(this.getX(), this.getY());
                    board.White_Pieces.remove(thePawn);
                    board.White_Pieces.add(new Queen(destination_x, 7, true, "Queen.png", board));

                }
            }
                if (this.isBlack()) {
                    Piece p = board.getPiece(this.getX(), this.getY() - 1);
                    Piece p1 = board.getPiece(this.getX(), this.getY() - 2);
                    Piece p3 = board.getPiece(this.getX() + 1, this.getY() - 1);
                    Piece p4 = board.getPiece(this.getX() - 1, this.getY() - 1);
                    if (destination_x == this.getX() && destination_y == this.getY() - 1 && p == null) {
                    } else if (destination_y == 4 && this.getY() == 6 && destination_x == this.getX() && p == null && p1 == null) {
                    } else if (destination_x == this.getX() + 1 && destination_y == this.getY() - 1 && p3.isWhite()) {
                    } else if (destination_x == this.getX() - 1 && destination_y == this.getY() - 1 && p4.isWhite()) {
                    } else {
                        return false;
                    }
                }

                if (destination_y == 0) {
                    Piece thePawn = board.getPiece(this.getX(), this.getY());

                    board.Black_Pieces.remove(thePawn);
                    board.Black_Pieces.add(new Queen(destination_x, 0, false, "Queen.png", board));
                }
            }
        // we could have also used the getHasMoved method from Pawn
        // to check if a pawn has already moved so it cannot move 2 squares from now on
        else if (this.getFilePath().equals("Queen.png")) {
                Piece possiblePiece = board.getPiece(destination_x, destination_y);

                if (possiblePiece != null) {
                    if (possiblePiece.isWhite() && this.isWhite()) {
                        return false;
                    }
                    if (possiblePiece.isBlack() && this.isBlack()) {
                        return false;
                    }
                }

                if (this.getX() == destination_x || this.getY() == destination_y) {
                } else if (Math.abs(this.getX() - destination_x) == Math.abs(this.getY() - destination_y) || (this.getX() + destination_x) == (this.getY() + destination_y)) {
                } else {
                    return false;
                }

                String direction = "";

                if (destination_y > this.getY() && destination_x == this.getX()) {
                    direction = "down";
                }
                if (destination_y < this.getY() && destination_x == this.getX()) {
                    direction = "up";
                }
                if (destination_x > this.getX() && destination_y == this.getY()) {
                    direction = "right";
                }
                if (destination_x < this.getX() && destination_y == this.getY()) {
                    direction = "left";
                }
                if (destination_x > this.getX() && destination_y > this.getY()) {
                    direction = "right_down";
                }
                if (destination_x > this.getX() && destination_y < this.getY()) {
                    direction = "left_down";
                }
                if (destination_x < this.getX() && destination_y > this.getY()) {
                    direction = "right_up";
                }
                if (destination_x < this.getX() && destination_y < this.getY()) {
                    direction = "left_up";
                }

                if (direction.equals("down")) {
                    int spaces_to_move = Math.abs(destination_y - this.getY());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX(), this.getY() + i);
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("up")) {
                    int spaces_to_move = Math.abs(destination_y - this.getY());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX(), this.getY() - i);
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("right")) {
                    int spaces_to_move = Math.abs(destination_x - this.getX());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX() + i, this.getY());
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("left")) {
                    int spaces_to_move = Math.abs(destination_x - this.getX());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX() - i, this.getY());
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("right_down")) {
                    int spaces_to_move = Math.abs(destination_y - this.getY());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX() + i, this.getY() + i);
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("left_down")) {
                    int spaces_to_move = Math.abs(destination_y - this.getY());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX() + i, this.getY() - i);
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("right_up")) {
                    int spaces_to_move = Math.abs(destination_x - this.getX());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX() - i, this.getY() + i);
                        if (p != null) {
                            return false;
                        }
                    }
                }
                if (direction.equals("left_up")) {
                    int spaces_to_move = Math.abs(destination_x - this.getX());
                    for (int i = 1; i < spaces_to_move; i++) {
                        Piece p = board.getPiece(this.getX() - i, this.getY() - i);
                        if (p != null) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }
    }
