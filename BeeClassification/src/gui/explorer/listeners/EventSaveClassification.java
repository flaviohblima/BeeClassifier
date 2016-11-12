package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.CsvWriter;

public class EventSaveClassification implements ActionListener {

	private JButton btnSave;
	private FileNameExtensionFilter filter;
	private JFileChooser fc;

	public EventSaveClassification(JButton btnSave) {
		this.btnSave = btnSave;
		filter = new FileNameExtensionFilter("CSV (*.csv)", "csv");
		fc = new JFileChooser();
		fc.setFileFilter(filter);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSave) {
			int returnVal = fc.showSaveDialog(system.Parameters.explorer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveCsvFile(file.getPath(), file.getParent());
			}
		}
	}

	private void saveCsvFile(String path, String parent) {
		CsvWriter writer = new CsvWriter(system.Parameters.classifiedInstaces);

		String extension = filter.getExtensions()[0];
		String fileName = path.substring(path.lastIndexOf("\\") + 1, path.length());

		/*
		 * Separando o nome do arquivo, no caso do usuário escrever a extensão.
		 */
		String name = "";
		String ext = "";
		if (fileName.contains(".")) {
			String[] parts = fileName.split("[.]");
			ext = parts[parts.length - 1];
			name = parts[0];
			for (int i = 1; i < (parts.length - 1); i++) {
				name = name + "." + parts[i];
			}
		} else {
			name = fileName;
		}

		/*
		 * Determinando o nome do caminho para o arquivo.
		 */
		String pathToFile = parent;
		if (!name.equals("") && ext.equals(extension)) {
			pathToFile = pathToFile + "\\" + fileName;
			writer.saveCsvFile(pathToFile);
		} else if (!name.equals("") && ext.equals("")) {
			pathToFile = pathToFile + "\\" + name + "." + extension;
			writer.saveCsvFile(pathToFile);
		} else if (!ext.equals(extension)) {
			pathToFile = pathToFile + "\\" + name + "." + ext + "." + extension;
			writer.saveCsvFile(pathToFile);
		} else if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Problem on saving CSV file:\nFile name is null!",
					"Save Classification Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
