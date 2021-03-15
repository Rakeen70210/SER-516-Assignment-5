package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import View.Panels.RightPanel.Tab;

public class ButtonListener implements MouseListener {
	JButton prevButton, currButton;
	Tab dropPanel;

	public ButtonListener(Tab panel) {
		dropPanel = panel;
		prevButton = null;
		currButton = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		currButton = (JButton) e.getComponent();
		dropPanel.addCurrButton(currButton);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}