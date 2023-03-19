package br.com.cod3r.composite.swing;

import javax.swing.*;
import java.awt.*;

public class Client {

	public static void main(String[] args) {
		JLabel title = new JLabel("TITLE");
		JLabel label = new JLabel("Label #1");
		JButton button= new JButton("Button #1");

		JPanel panel = new JPanel(new FlowLayout());
		panel.add(label);
		panel.add(button);

		JFrame frame =new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);

		frame.setSize(400,200);
		frame.setVisible(true);
	}
}
