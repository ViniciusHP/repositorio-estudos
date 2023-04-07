package br.com.cod3r.memento.swing.component;

import br.com.cod3r.memento.swing.memory.Memento;

import javax.swing.JTextArea;

public class TextAreaWithMemory extends JTextArea {
	private static final long serialVersionUID = 2393587108160522742L;
	
	public TextAreaWithMemory(int rows, int columns) {
		super(rows, columns);
	}

	public TextareaMemento save() {
		return new TextareaMemento(getText());
	}

	public void restore(TextareaMemento memento) {
		setText(memento.getText());
	}

	public static class TextareaMemento implements Memento {
		private String text;

		public TextareaMemento(String text) {
			this.text = text;
		}
		private String getText() {
			return text;
		}
	}
}
