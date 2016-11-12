package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventChoosenEvaluator implements ActionListener {

	private JComboBox<String> comboBoxEvaluator;
	private JLabel lblFolds;
	private JTextField foldTextField;
	private String choosen;

	public EventChoosenEvaluator(JComboBox<String> comboBoxEvaluator, JLabel lblFolds, JTextField foldTextField) {
		this.comboBoxEvaluator = comboBoxEvaluator;
		this.lblFolds = lblFolds;
		this.foldTextField = foldTextField;
		choosen = system.Constants.evaluators[0];
		system.Parameters.evaluatorName = choosen;
		setParameterEvaluator();
		kFoldChoosen();
	}

	public void actionPerformed(ActionEvent event) {
		// Just use the comboBox
		ComboBoxModel<String> model = comboBoxEvaluator.getModel();
		choosen = model.getElementAt(comboBoxEvaluator.getSelectedIndex());

		system.Parameters.evaluatorName = choosen;
		setParameterEvaluator();
		kFoldChoosen();
	}

	public void kFoldChoosen() {
		if (choosen.equals(system.Constants.evaluators[0])) {
			lblFolds.setEnabled(true);
			foldTextField.setEnabled(true);
		} else {
			lblFolds.setEnabled(false);
			foldTextField.setEnabled(false);
		}
	}

	public void setParameterEvaluator() {
		for (int i = 0; i < system.Constants.evaluatorsClasses.length; i++) {
			if (choosen.equals(system.Constants.evaluators[i])) {
				system.Parameters.evaluatorClassName = system.Constants.evaluatorsClasses[i];
			}
		}
	}
}