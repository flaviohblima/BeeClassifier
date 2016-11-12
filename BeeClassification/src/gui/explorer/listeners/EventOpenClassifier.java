package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classification.serialization.InstancePredictor;

public class EventOpenClassifier implements ActionListener {

	private JButton btnOpenClassifierFile;
	private JTextField classifierPathTextField;

	public EventOpenClassifier(JButton btnOpenClassifierFile, JTextField classifierPathTextField) {
		this.btnOpenClassifierFile = btnOpenClassifierFile;
		this.classifierPathTextField = classifierPathTextField;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnOpenClassifierFile) {
			openClassifier(classifierPathTextField.getText().toString());
			JOptionPane.showMessageDialog(system.Parameters.explorer, "Classifier is opened!", "Classifier File",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void openClassifier(String path) {
		system.Parameters.predictor = new InstancePredictor();
		system.Parameters.predictor.readSerializedClassifier(path);
	}
}
