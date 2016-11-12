package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classification.FeatureSelection;

public class EventVisualizeFeatureSelection implements ActionListener {

	private JButton btnResults;
	private JTextField maxFeatTextField;
	private String panelName;

	public EventVisualizeFeatureSelection(JButton btnResults, JTextField maxFeatTextField, String panelName) {
		this.btnResults = btnResults;
		this.maxFeatTextField = maxFeatTextField;
		this.panelName = panelName;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnResults) {
			if (isInteger(maxFeatTextField.getText().toString())) {
				settingParameterMaxFeat(Integer.parseInt(maxFeatTextField.getText().toString()));
				visualizeFeatSel();
			} else {
				JOptionPane.showMessageDialog(
						system.Parameters.explorer, "Problem on Feature Selection:\nFor input string \""
								+ maxFeatTextField.getText().toString() + "\".",
						"Feature Selection Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void visualizeFeatSel() {
		if (panelName.equals("ClassificationTestPanel")) {
			FeatureSelection featureSelection = new FeatureSelection(system.Parameters.testPanelAlgorithmName,
					system.Parameters.originalTrainingSet, system.Parameters.testPanelMaxFeat);
			featureSelection.showResults();
		} else if (panelName.equals("ClassifierTrainingPanel")) {
			FeatureSelection featureSelection = new FeatureSelection(system.Parameters.trainingPanelAlgorithmName,
					system.Parameters.originalTrainingSet, system.Parameters.trainingPanelMaxFeat);
			featureSelection.showResults();
		}

	}

	public void settingParameterMaxFeat(int maxFeat) {
		if (panelName.equals("ClassificationTestPanel")) {
			system.Parameters.testPanelMaxFeat = maxFeat;
		} else if (panelName.equals("ClassifierTrainingPanel")) {
			system.Parameters.trainingPanelMaxFeat = maxFeat;
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

}
