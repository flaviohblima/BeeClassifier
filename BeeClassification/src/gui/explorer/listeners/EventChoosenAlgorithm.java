package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class EventChoosenAlgorithm implements ActionListener {

	private JComboBox<String> comboBoxAlgorithm;
	private String panelName;

	public EventChoosenAlgorithm(JComboBox<String> comboBoxAlgorithm, String panelName) {
		this.comboBoxAlgorithm = comboBoxAlgorithm;
		this.panelName = panelName;
		if (panelName.equals("ClassificationTestPanel")) {
			system.Parameters.testPanelAlgorithmName = system.Constants.algorithmsClasses[0];
		} else if (panelName.equals("ClassifierTrainingPanel")) {
			system.Parameters.trainingPanelAlgorithmName = system.Constants.algorithmsClasses[0];
		}
	}

	public void actionPerformed(ActionEvent events) {
		ComboBoxModel<String> model = comboBoxAlgorithm.getModel();
		String choosen = model.getElementAt(comboBoxAlgorithm.getSelectedIndex());

		if (panelName.equals("ClassificationTestPanel")) {
			system.Parameters.testPanelAlgorithmName = choosen;
		} else if (panelName.equals("ClassifierTrainingPanel")) {
			system.Parameters.trainingPanelAlgorithmName = choosen;
		}
	}
}
