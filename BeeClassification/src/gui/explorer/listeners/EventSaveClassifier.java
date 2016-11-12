package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EventSaveClassifier implements ActionListener {

	private JButton btnSave;
	private JFileChooser fc;
	private FileNameExtensionFilter filter;

	public EventSaveClassifier(JButton btnSave) {
		this.btnSave = btnSave;
		filter = new FileNameExtensionFilter("SER (*.ser)", "ser");
		fc = new JFileChooser();
		fc.setFileFilter(filter);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSave) {
			int returnVal = fc.showSaveDialog(system.Parameters.explorer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveClassifier(file.getPath(), file.getParent());
			}
		}
	}

	private void saveClassifier(String path, String parent) {
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
			system.Parameters.trainer.saveClassifier(pathToFile);
		} else if (!name.equals("") && ext.equals("")) {
			pathToFile = pathToFile + "\\" + name + "." + extension;
			system.Parameters.trainer.saveClassifier(pathToFile);
		} else if (!ext.equals(extension)) {
			pathToFile = pathToFile + "\\" + name + "." + ext + "." + extension;
			system.Parameters.trainer.saveClassifier(pathToFile);
		} else if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Problem on saving Classifier:\nFile name is null!",
					"Save Classifier Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
