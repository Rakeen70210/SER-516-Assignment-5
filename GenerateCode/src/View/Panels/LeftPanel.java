package View.Panels;

import Model.Icons.*;
import View.DragAndDrop.DragAndDropLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Icons.AtSymbol;
import Model.Icons.DoublePipe;
import Model.Icons.GreaterThan;
import Model.Icons.Hyphen;
import Model.Icons.LParen;
import Model.Icons.LessThan;
import Model.Icons.RParen;
import Model.UserInterfaceItems.*;
import View.DragAndDrop.DragAndDropLabel;

public class LeftPanel extends JPanel { // drag source
	private static final long serialVersionUID = -1827724962934234619L;
	private ArrayList<DragAndDropLabel> labels = new ArrayList<DragAndDropLabel>();

	public static JPanel getNewLabelFromText(String text) {
		DragAndDropLabel newLabel = null;
		JPanel p = new JPanel();
		JButton input1 = new IOButton();
		JButton input2 = new IOButton();
		JButton output1 = new IOButton();
		JButton output2 = new IOButton();
		JButton inputBar = new IOBar();
		JButton outputBar = new IOBar();

		switch (text) {
		case " ( .":
			newLabel = new DragAndDropLabel(new LParen());
			output1.setName("LParenOutput1");
			output1.setNextFocusableComponent(newLabel);
			newLabel.setOutputButton(0, output1);
			p.add(newLabel);
			p.add(output1);
			break;
		case ". ) ":
			newLabel = new DragAndDropLabel(new RParen());
			input1.setName("RParenInput1");
			input1.setNextFocusableComponent(newLabel);
			newLabel.setInputButton(0, input1);
			p.add(input1);
			p.add(newLabel);
			break;
		case ".  <  :":
			newLabel = new DragAndDropLabel(new LessThan());
			output1.setName("LessThanOutput2");
			output2.setName("LessThanOutput1");
			newLabel.setOutputButton(0, output1);
			newLabel.setOutputButton(1, output2);
			input1.setName("LessThanInput1");
			newLabel.setInputButton(0, input1);
			input1.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			output2.setNextFocusableComponent(newLabel);
			p.add(input1);
			p.add(newLabel);
			p.add(output1);
			p.add(output2);
			break;
		case ":  >  .":
			newLabel = new DragAndDropLabel(new GreaterThan());
			input2.setName("GreaterThanInput2");
			output1.setName("GreaterThanOutput1");
			input1.setName("GreaterThanInput1");
			newLabel.setOutputButton(0, output1);
			newLabel.setInputButton(0, input1);
			newLabel.setInputButton(1, input2);
			input1.setNextFocusableComponent(newLabel);
			input2.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			p.add(input2);
			p.add(input1);
			p.add(newLabel);
			p.add(output1);
			break;
		case ".  --  .":
			newLabel = new DragAndDropLabel(new Hyphen());
			output1.setName("HypenOutput1");
			input1.setName("HypenInput1");
			newLabel.setOutputButton(0, output1);
			newLabel.setInputButton(0, input1);
			input1.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			p.add(input1);
			p.add(newLabel);
			p.add(output1);
			break;
		case "  @  ":
			newLabel = new DragAndDropLabel(new AtSymbol());
			output1.setName("AtOutput1");
			input1.setName("AtInput1");
			output2.setName("AtOutput2");
			input2.setName("AtInput2");
			newLabel.setInputButton(0, input1);
			newLabel.setInputButton(1, input2);
			newLabel.setOutputButton(0, output1);
			newLabel.setOutputButton(1, output2);
			input1.setNextFocusableComponent(newLabel);
			input2.setNextFocusableComponent(newLabel);
			output1.setNextFocusableComponent(newLabel);
			output2.setNextFocusableComponent(newLabel);
			p.add(input1);
			p.add(input2);
			p.add(newLabel);
			p.add(output1);
			p.add(output2);
			break;
		case "*  |  |  *":
			newLabel = new DragAndDropLabel(new DoublePipe());
			inputBar.setName("DoublePipeInput");
			outputBar.setName("DoublePipeOutput");
			inputBar.setNextFocusableComponent(newLabel);
			outputBar.setNextFocusableComponent(newLabel);
			newLabel.setInputButton(0, inputBar);
			newLabel.setOutputButton(0, outputBar);
			p.add(inputBar);
			p.add(newLabel);
			p.add(outputBar);			
			break;
		default:
		}

		return p;
	}

	public LeftPanel(DragGestureListener dragGestureListener) {
		super(new GridLayout(7, 0, 5, 5));
		setBorder(BorderFactory.createLineBorder(Color.gray));

		DragSource ds = new DragSource();
		labels.add(new DragAndDropLabel(new LParen()));
		labels.add(new DragAndDropLabel(new RParen()));
		labels.add(new DragAndDropLabel(new LessThan()));
		labels.add(new DragAndDropLabel(new GreaterThan()));
		labels.add(new DragAndDropLabel(new Hyphen()));
		labels.add(new DragAndDropLabel(new AtSymbol()));
		labels.add(new DragAndDropLabel(new DoublePipe()));
		for(DragAndDropLabel label : labels){
			ds.createDefaultDragGestureRecognizer(label, DnDConstants.ACTION_COPY, dragGestureListener);
			this.add(label);
		}


	}

}
