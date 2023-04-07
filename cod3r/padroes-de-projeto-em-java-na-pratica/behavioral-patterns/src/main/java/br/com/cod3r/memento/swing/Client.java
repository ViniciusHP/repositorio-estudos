package br.com.cod3r.memento.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import br.com.cod3r.memento.swing.component.TextAreaWithMemory;
import br.com.cod3r.memento.swing.component.TextAreaWithMemory.TextareaMemento;
import br.com.cod3r.memento.swing.memory.Caretaker;

public class Client {

	public static void main(String[] args) {
				
		JFrame frame = new JFrame();  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Memento");
		frame.setLayout(new BorderLayout());
		
		JButton previous = new JButton("<<");
		JButton next = new JButton(">>");
		
		frame.add(previous, BorderLayout.WEST);
		frame.add(next, BorderLayout.EAST);
		
		TextAreaWithMemory originator = new TextAreaWithMemory(5, 10);
		JScrollPane scroll = new JScrollPane(originator, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.add(scroll, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(new FlowLayout());
		JComboBox<String> mementosList = new JComboBox<String>();
		JButton save = new JButton("Save");
		bottomPanel.add(mementosList);
		bottomPanel.add(save);
		
		frame.add(bottomPanel, BorderLayout.SOUTH);

		Caretaker caretaker = new Caretaker();
		int currentIndex = 0;

		save.addActionListener(e -> {
			caretaker.add(originator.save());
			int index = caretaker.getHistoryMementos().size();
			mementosList.addItem(String.valueOf(index));
			mementosList.setSelectedIndex(index - 1);
			originator.requestFocusInWindow();
		});

		next.addActionListener(e -> {
			int selectedIndex = mementosList.getSelectedIndex();
			if(selectedIndex < mementosList.getItemCount() - 1) {
				int nextIndex = selectedIndex + 1;
				originator.restore((TextareaMemento) caretaker.get(nextIndex));
				mementosList.setSelectedIndex(nextIndex);
				originator.requestFocusInWindow();
			}
		});

		previous.addActionListener(e -> {
			int selectedIndex = mementosList.getSelectedIndex();
			if(selectedIndex > 0) {
				int previousIndex = selectedIndex - 1;
				originator.restore((TextareaMemento) caretaker.get(previousIndex));
				mementosList.setSelectedIndex(previousIndex);
				originator.requestFocusInWindow();
			}
		});

		mementosList.addItemListener(i -> {
			originator.restore((TextareaMemento) caretaker.get(mementosList.getSelectedIndex()));
			originator.requestFocusInWindow();
		});
		
		frame.setSize(400,200);  
		frame.setVisible(true);
	}
}
