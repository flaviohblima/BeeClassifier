package gui.explorer.listeners;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EventValidate implements DocumentListener {

	private JTextField pathToFile;
	private JLabel validateMessage;
	private String extension;
	private JButton btnOpenFile;

	public EventValidate(JTextField pathToFile, JLabel validateMessage, String extension, JButton btnOpenFile) {
		this.pathToFile = pathToFile;
		this.validateMessage = validateMessage;
		this.extension = extension;
		this.btnOpenFile = btnOpenFile;
		this.btnOpenFile.setEnabled(false);
	}

	public void changedUpdate(DocumentEvent event) {
		File file = new File(pathToFile.getText().toString());
		if (file.exists()) {
			String ext = getExtension(file.getName());
			if (extension.equalsIgnoreCase(ext)) {
				validateMessage.setText("Valid file!");
				validateMessage.setFont(new Font("Dialog", Font.PLAIN, 12));
				validateMessage.setForeground(Color.blue);
				btnOpenFile.setEnabled(true);
			} else {
				validateMessage.setText("File isn't " + extension + " type.");
				validateMessage.setFont(new Font("Dialog", Font.BOLD, 12));
				validateMessage.setForeground(Color.red);
				btnOpenFile.setEnabled(false);
			}
		} else if (!file.exists()) {
			validateMessage.setText("Invalid Path!");
			validateMessage.setFont(new Font("Dialog", Font.BOLD, 12));
			validateMessage.setForeground(Color.red);
			btnOpenFile.setEnabled(false);
		}
	}

	public void insertUpdate(DocumentEvent event) {
		changedUpdate(event);
	}

	public void removeUpdate(DocumentEvent event) {
		changedUpdate(event);
	}

	public String getExtension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');
		int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

		if (i > p) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}
}
