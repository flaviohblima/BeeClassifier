package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classification.Experiment;
import classification.TrainingSet;

public class EventEvaluateClassifiers implements ActionListener {

	private JButton btnEvaluateClassifiers;
	private JTextField maxFeatTextField;
	private JTextField foldTextField;
	private JCheckBox chckbxActivate;
	private boolean kFoldChecked, maxFeatChecked;

	public EventEvaluateClassifiers(JButton btnEvaluateClassifiers, JCheckBox chckbxActivate,
			JTextField maxFeatTextField, JTextField foldTextField) {
		this.btnEvaluateClassifiers = btnEvaluateClassifiers;
		this.chckbxActivate = chckbxActivate;
		this.maxFeatTextField = maxFeatTextField;
		this.foldTextField = foldTextField;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnEvaluateClassifiers) {
			checkAndSetKFolds();
			checkAndSetMaxFeat();
			if (checkClassifiers() && kFoldChecked && maxFeatChecked) {
				TrainingSet trainingSet = system.Parameters.originalTrainingSet;
				boolean[] classifiersSelected = system.Parameters.testPanelClassifiersArray.clone();
				boolean useFeatSel = chckbxActivate.isSelected();
				String featureSelector = system.Parameters.testPanelAlgorithmName;
				int maxFeat = system.Parameters.testPanelMaxFeat;

				Experiment experiment = new Experiment(trainingSet, useFeatSel, classifiersSelected, featureSelector,
						maxFeat);
				experiment.runExperiment();
				experiment.ExperimentResults();

			} else if (!checkClassifiers()) {
				JOptionPane.showMessageDialog(system.Parameters.explorer,
						"Problem on Evaluation:\nNone of the classifiers was selected!", "Evaluation Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private boolean checkClassifiers() {
		boolean[] classifiersSelection = system.Parameters.testPanelClassifiersArray;
		boolean checked = false;
		for (int i = 0; i < classifiersSelection.length; i++) {
			if (classifiersSelection[i]) {
				checked = true;
			}
		}
		return checked;
	}

	private void checkAndSetKFolds() {
		kFoldChecked = true;
		/*
		 * 
		 */
		if (isInteger(foldTextField.getText().toString())) {
			/*
			 * 
			 */
			if (Integer.parseInt(foldTextField.getText().toString()) > 0) {
				system.Parameters.kFolds = Integer.parseInt(foldTextField.getText().toString());
				kFoldChecked = true;
			} else {
				kFoldChecked = false;
				JOptionPane.showMessageDialog(system.Parameters.explorer,
						"Problem on Classifier Evaluator:\nInteger k must be greater than 0.",
						"Classifier Evaluator Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (!isInteger(foldTextField.getText().toString())) {
			kFoldChecked = false;
			JOptionPane.showMessageDialog(
					system.Parameters.explorer, "Problem on Classifier Evaluator:\nFor input string \""
							+ foldTextField.getText().toString() + "\".",
					"Classifier Evaluator Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void checkAndSetMaxFeat() {
		maxFeatChecked = true;
		/*
		 * Test if the Feature Selection is Selected
		 */
		if (chckbxActivate.isSelected()) {
			/*
			 * 
			 */
			if (isInteger(maxFeatTextField.getText().toString())) {
				maxFeatChecked = true;
				system.Parameters.testPanelMaxFeat = Integer.parseInt(maxFeatTextField.getText().toString());
				/*
				 * 
				 */
			} else {
				maxFeatChecked = false;
				JOptionPane.showMessageDialog(
						system.Parameters.explorer, "Problem on Feature Selection:\nFor input string \""
								+ maxFeatTextField.getText().toString() + "\".",
						"Feature Selection Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private boolean isInteger(String s) {
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