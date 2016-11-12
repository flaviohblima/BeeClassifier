package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classification.ClassifierFactory;
import classification.FeatureSelectorFactory;
import classification.TrainingSet;
import classification.classifiers.BeeClassifier;
import classification.classifiers.ClassifierParameters;
import classification.featureSelectors.FeatureSelector;
import classification.serialization.Trainer;

public class EventBuildClassifier implements ActionListener {

	private JButton btnBuildClassifier;
	private JCheckBox chckbxActivate;
	private JTextField maxFeatTextField;
	private boolean maxFeatChecked;

	public EventBuildClassifier(JButton btnBuildClassifier, JCheckBox chckbxActivate, JTextField maxFeatTextField) {
		this.btnBuildClassifier = btnBuildClassifier;
		this.chckbxActivate = chckbxActivate;
		this.maxFeatTextField = maxFeatTextField;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnBuildClassifier) {
			checkAndSetMaxFeat();

			if (maxFeatChecked) {
				BeeClassifier beeClassifier = intantiateClassifier(system.Parameters.classifierClass);
				TrainingSet trainingSet = system.Parameters.originalTrainingSet;

				FeatureSelector featureSelector = new FeatureSelectorFactory(
						system.Parameters.trainingPanelAlgorithmName).getFeatureSel();

				int maxFeat = system.Parameters.trainingPanelMaxFeat;
				boolean useFeatSel = chckbxActivate.isSelected();

				Trainer trainer = new Trainer(trainingSet, beeClassifier, featureSelector, useFeatSel, maxFeat);
				trainer.trainClassifier();
				system.Parameters.trainer = trainer;

				JOptionPane.showMessageDialog(system.Parameters.explorer, "The classifier's building was completed!",
						"Building Classifier Panels", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	private BeeClassifier intantiateClassifier(String classifierClass) {
		String[] classesNames = system.Constants.classifiersClassesNames.clone();
		boolean[] classifiersSelected = system.Parameters.trainingClassifiersArray.clone();
		for (int i = 0; i < classesNames.length; i++) {
			if (classifierClass.equals(classesNames[i])) {
				classifiersSelected[i] = true;
			} else {
				classifiersSelected[i] = false;
			}
		}
		ClassifierParameters[] classifiersParameters = system.Parameters.classifiersParameters.clone();
		BeeClassifier[] classifiersArray = new ClassifierFactory(classifiersSelected, classifiersParameters)
				.getClassifiers();
		return classifiersArray[0];
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
				system.Parameters.testPanelMaxFeat = Integer.parseInt(maxFeatTextField.getText().toString());
				maxFeatChecked = true;
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
