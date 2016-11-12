package gui.explorer.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyEditor;

import classification.classifiers.BeeClassifier;
//import weka.classifiers.Classifier;
import weka.core.OptionHandler;
import weka.gui.PropertyDialog;

public class EventParametersWindow extends WindowAdapter {

	private String[] options;
	private int index;

	public EventParametersWindow(BeeClassifier classifier) {
		String[] classifiersNames = system.Constants.classifiersNames;
		index = 0;
		for (int i = 0; i < classifiersNames.length; i++) {
			if (classifier.getName().equals(classifiersNames[i])) {
				options = system.Parameters.classifiersParameters[i].getTextParameters().clone();
				index = i;
				setParameters();
			}
		}
	}

	public void windowActivated(WindowEvent event) {
		options = system.Parameters.classifiersParameters[index].getTextParameters().clone();
		setParameters();
	}

	public void windowClosed(WindowEvent event) {
		PropertyEditor pe = ((PropertyDialog) event.getSource()).getEditor();
		Object c = pe.getValue();
		if (c instanceof OptionHandler) {
			options = ((OptionHandler) c).getOptions();
		}
		setParameters();
	}

	public void setParameters() {
		system.Parameters.classifiersParameters[index].setTextParameters(options);

		String a = "";
		for (int i = 0; i < options.length; i++) {
			a = a + options[i] + " , ";
		}
		// System.out.println(a);
	}
}