package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EventSearch implements ActionListener {

	private JButton btnSearch;
	private JFileChooser fc1;
	private int returnVal;
	private JTextField pathToFile;

	public EventSearch(JButton btnSearch, JTextField pathToFile, String description, String extension) {
		this.btnSearch = btnSearch;
		this.pathToFile = pathToFile;
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extension);
		fc1 = new JFileChooser();
		fc1.setFileFilter(filter);
	}

	public void actionPerformed(ActionEvent event) {
		// Button to search the Data Set
		if (event.getSource() == btnSearch) {
			openTrainingSet();
		}
	}

	public void openTrainingSet() {
		returnVal = fc1.showOpenDialog(system.Parameters.explorer);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file1 = fc1.getSelectedFile();
			pathToFile.setText(file1.getPath());
		}
	}

}
