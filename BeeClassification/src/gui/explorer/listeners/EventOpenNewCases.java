package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.CsvReader;

public class EventOpenNewCases implements ActionListener {

	private JButton btnOpenNewCases;
	private JTextField newCasesPathTextField;

	public EventOpenNewCases(JButton btnOpenNewCases, JTextField newCasesPathTextField) {
		this.btnOpenNewCases = btnOpenNewCases;
		this.newCasesPathTextField = newCasesPathTextField;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnOpenNewCases) {
			openNewCases(newCasesPathTextField.getText().toString());
			JOptionPane.showMessageDialog(system.Parameters.explorer, "New case(s) file was opened!",
					"New Case(s) File", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void openNewCases(String newCasesPath) {
		CsvReader reader = new CsvReader(new File(newCasesPath));
		system.Parameters.newInstances = reader.data();
	}
}
