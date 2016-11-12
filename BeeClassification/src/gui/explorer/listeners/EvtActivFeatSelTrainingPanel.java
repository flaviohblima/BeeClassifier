package gui.explorer.listeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EvtActivFeatSelTrainingPanel implements ItemListener {

	private JCheckBox chckbxActivate;
	private JButton btnResults;
	private JComboBox<String> comboBoxAlgorithm;
	private JLabel lblAlgorithm;
	private JTextField maxFeatTextField;
	private JLabel lblMaxNumberOf;

	public EvtActivFeatSelTrainingPanel(JCheckBox chckbxActivate, JButton btnResults,
			JComboBox<String> comboBoxAlgorithm, JLabel lblAlgorithm, JTextField maxFeatTextField,
			JLabel lblMaxNumberOf) {
		this.chckbxActivate = chckbxActivate;
		this.btnResults = btnResults;
		this.comboBoxAlgorithm = comboBoxAlgorithm;
		this.lblAlgorithm = lblAlgorithm;
		this.maxFeatTextField = maxFeatTextField;
		this.lblMaxNumberOf = lblMaxNumberOf;
		activateFeatSel(false);
	}

	public void itemStateChanged(ItemEvent event) {
		Object source = event.getItemSelectable();

		if (source == chckbxActivate) {
			activateFeatSel(true);
		}

		if (event.getStateChange() == ItemEvent.DESELECTED) {
			if (source == chckbxActivate) {
				activateFeatSel(false);
			}
		}
	}

	private void activateFeatSel(boolean activate) {
		btnResults.setEnabled(activate);
		comboBoxAlgorithm.setEnabled(activate);
		lblAlgorithm.setEnabled(activate);
		maxFeatTextField.setEnabled(activate);
		maxFeatTextField.setText(Integer.toString(system.Parameters.trainingPanelMaxFeat));
		lblMaxNumberOf.setEnabled(activate);
	}
}