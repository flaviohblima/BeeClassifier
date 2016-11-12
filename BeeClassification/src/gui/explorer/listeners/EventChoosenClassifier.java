package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class EventChoosenClassifier implements ActionListener {

	private JComboBox<String> comboBoxClassifier;
	private String choosen;

	public EventChoosenClassifier(JComboBox<String> comboBoxClassifier) {
		this.comboBoxClassifier = comboBoxClassifier;

		choosen = system.Constants.classifiersNames[0];
		system.Parameters.classifierName = choosen;
		setParameterClassifier();
	}

	public void actionPerformed(ActionEvent events) {
		ComboBoxModel<String> model = comboBoxClassifier.getModel();
		choosen = model.getElementAt(comboBoxClassifier.getSelectedIndex());

		system.Parameters.classifierName = choosen;
		setParameterClassifier();

		System.out.println(system.Parameters.classifierName);
		System.out.println(system.Parameters.classifierClass);
		System.out.println(system.Parameters.report());

	}

	public void setParameterClassifier() {
		for (int i = 0; i < system.Constants.classifiersNames.length; i++) {
			if (choosen.equals(system.Constants.classifiersNames[i])) {
				system.Parameters.classifierClass = system.Constants.classifiersClassesNames[i];
			}
		}
	}

}
