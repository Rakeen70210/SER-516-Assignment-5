package View.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import View.DragAndDrop.DragAndDropLabel;

public class RightPanel extends JPanel { // drop target
    private static final long serialVersionUID = 5237869471969999584L;

    ArrayList<DragAndDropLabel> myLabels = new ArrayList<>();

    public RightPanel() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (DragAndDropLabel myLabel : myLabels) { // draw rest components
            int x = (int) myLabel.getDroppedAtX();
            int y = (int) myLabel.getDroppedAtY();

            add(myLabel);
            myLabel.setLocation(new Point(x, y));
            myLabel.setVisible(true);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void addDragAndDropLabel(DragAndDropLabel l) {
        myLabels.add(l);
    }
}
