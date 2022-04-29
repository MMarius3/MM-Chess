package chessgui;

import java.awt.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
    Component component;
    public JLabel labelWhite;
    public JLabel labelBlack;
    public BoardFrame()
    {
        labelWhite = new JLabel("white's turn");
        labelBlack = new JLabel("black's turn");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(new Color(231, 181, 181));
        labelWhite.setFont(new Font("Courier", Font.ITALIC,21));
        labelWhite.setHorizontalAlignment(JLabel.CENTER);
        labelWhite.setVerticalAlignment(JLabel.CENTER);
        panel.add(labelWhite);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess");
        this.setResizable(true);
        component = new Board();
        this.add(component, BorderLayout.CENTER);
        this.add(panel, BorderLayout.AFTER_LAST_LINE);
        
        this.setLocation(200, 50);
        this.pack();
        this.setVisible(true);
    }
}
