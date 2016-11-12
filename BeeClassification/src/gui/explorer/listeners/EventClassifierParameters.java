package gui.explorer.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import classification.ClassifierFactory;
import classification.classifiers.BeeClassifier;
import classification.classifiers.ClassifierParameters;
import weka.classifiers.Classifier;
import weka.gui.GenericObjectEditor;
import weka.gui.PropertyDialog;

public class EventClassifierParameters implements MouseListener {

	private boolean pressed;
	private JCheckBox chckbxClassifier;
	private BeeClassifier classifier;
	/** Lets the user configure the classifier. */
	protected GenericObjectEditor m_ClassifierEditor = new GenericObjectEditor();
	/** The currently displayed property dialog, if any */
	private PropertyDialog m_PD;

	/** The property editor */
	// private final PropertyEditor m_Editor = new
	// PropertyEditor(m_ClassifierEditor);

	public EventClassifierParameters(JCheckBox chckbxClassifier) {
		this.chckbxClassifier = chckbxClassifier;
	}

	public void mousePressed(MouseEvent e) {
		chckbxClassifier.getModel().setArmed(true);
		chckbxClassifier.getModel().setPressed(true);
		pressed = true;
	}

	public void mouseReleased(MouseEvent e) {
		chckbxClassifier.getModel().setArmed(false);
		chckbxClassifier.getModel().setPressed(false);

		if (pressed) {
			if (SwingUtilities.isRightMouseButton(e)) {
				showParametersPage();
			}
		}
		pressed = false;
	}

	public void mouseExited(MouseEvent e) {
		pressed = false;
	}

	public void mouseEntered(MouseEvent e) {
		pressed = false;
	}

	public void mouseClicked(MouseEvent e) {
		pressed = false;
	}

	private void showParametersPage() {
		String classifierClassName = chckbxClassifier.getText();
		classifier = intantiateClassifier(classifierClassName);

		m_ClassifierEditor.setClassType(Classifier.class);
		m_ClassifierEditor.setValue(classifier.wekaClassifier());
		showPropertyDialog();
	}

	/**
	 * Displays the property edit dialog for the panel.
	 */
	public void showPropertyDialog() {
		int x = chckbxClassifier.getLocationOnScreen().x;
		int y = chckbxClassifier.getLocationOnScreen().y;
		m_PD = new PropertyDialog((JFrame) null, m_ClassifierEditor, x, y);
		EventParametersWindow eventParameters = new EventParametersWindow(classifier);
		m_PD.addWindowListener(eventParameters);
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
		ClassifierParameters[] classifiersParameters = system.Parameters.classifiersParameters.clone();
		BeeClassifier[] classifiersArray = new ClassifierFactory(classifiersSelected, classifiersParameters)
				.getClassifiers();
		return classifiersArray[0];
	}
}
