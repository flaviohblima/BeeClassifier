package gui.explorer.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class EventSelectClassifier implements ItemListener {

	private JCheckBox chckbxClassifier;
	private int index;

	public EventSelectClassifier(JCheckBox chckbxClassifier, String classifierClassName) {
		this.chckbxClassifier = chckbxClassifier;
		index = classifierIndex(classifierClassName);
	}

	public void itemStateChanged(ItemEvent event) {
		Object source = event.getItemSelectable();

		if (source == chckbxClassifier) {
			system.Parameters.testPanelClassifiersArray[index] = true;
		}

		if (event.getStateChange() == ItemEvent.DESELECTED) {
			if (source == chckbxClassifier) {
				system.Parameters.testPanelClassifiersArray[index] = false;
			}
		}
	}

	public int classifierIndex(String classifierClassName) {
		String[] classifiers = system.Constants.classifiersClassesNames;
		int classifierIndex = 1000;
		for (int i = 0; i < classifiers.length; i++) {
			if (classifierClassName.equals(classifiers[i])) {
				classifierIndex = i;
			}
		}
		return classifierIndex;
	}

}
