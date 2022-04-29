package chessgui;

/**
 *
 * @author Macean Marius
 * Group 30423
 */
public class ChessGUI {
    
    public BoardFrame boardframe;
    public static void main(String[] args) {
        ChessGUI gui = new ChessGUI();
        gui.boardframe = new BoardFrame();
        gui.boardframe.setVisible(true);
    }
}
