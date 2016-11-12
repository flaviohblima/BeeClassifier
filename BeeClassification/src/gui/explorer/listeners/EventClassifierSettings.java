package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import classification.ClassifierFactory;
import classification.classifiers.BeeClassifier;
import classification.classifiers.ClassifierParameters;
import weka.classifiers.Classifier;
import weka.gui.GenericObjectEditor;
import weka.gui.PropertyDialog;

public class EventClassifierSettings implements ActionListener {

	private JButton btnSettings;
	private JComboBox<String> comboBoxClassifier;
	private BeeClassifier classifier;
	/** Lets the user configure the classifier. */
	protected GenericObjectEditor m_ClassifierEditor = new GenericObjectEditor();
	/** The currently displayed property dialog, if any */
	private PropertyDialog m_PD;

	public EventClassifierSettings(JButton btnSettings, JComboBox<String> comboBoxClassifier) {
		this.btnSettings = btnSettings;
		this.comboBoxClassifier = comboBoxClassifier;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnSettings) {
			showParametersPage();
		}
	}

	private void showParametersPage() {
		String classifierClassName = comboBoxClassifier.getSelectedItem().toString();
		classifier = intantiateClassifier(classifierClassName);

		m_ClassifierEditor.setClassType(Classifier.class);
		m_ClassifierEditor.setValue(classifier.wekaClassifier());
		showPropertyDialog();
	}

	/**
	 * Displays the property edit dialog for the panel.
	 */
	public void showPropertyDialog() {
		int x = btnSettings.getLocationOnScreen().x;
		int y = btnSettings.getLocationOnScreen().y;
		m_PD = new PropertyDialog((JFrame) null, m_ClassifierEditor, x, y);
		EventSettingsWindow eventSettings = new EventSettingsWindow(classifier);
		m_PD.addWindowListener(eventSettings);
		m_PD.setIconImage((new ImageIcon(System.getProperty("user.dir") + "\\Icon1.png")).getImage());
		m_PD.setVisible(true);
	}

	private BeeClassifier intantiateClassifier(String classifierName) {
		String[] classifiersNames = system.Constants.classifiersNames;
		boolean[] classifiersSelected = system.Parameters.trainingClassifiersArray;
		for (int i = 0; i < classifiersNames.length; i++) {
			if (classifierName.equals(classifiersNames[i])) {
				classifiersSelected[i] = true;
			} else {
				classifiersSelected[i] = false;
			}
		}
		ClassifierParameters[] classifiersParameters = system.Parameters.trainingParameters.clone();
		BeeClassifier[] classifiersArray = new ClassifierFactory(classifiersSelected, classifiersParameters)
				.getClassifiers();
		return classifiersArray[0];
	}

}
