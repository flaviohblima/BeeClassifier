package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import weka.core.Instances;

public class EventClassify implements ActionListener {

	private JButton btnClassify;

	public EventClassify(JButton btnClassify) {
		this.btnClassify = btnClassify;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnClassify) {
			Instances newInstances = null;
			if (checkClassifier()) {
				if (checkNewCases()) {
					newInstances = system.Parameters.newInstances;
					Instances classifiedInstaces = system.Parameters.predictor.predict(newInstances);
					system.Parameters.classifiedInstaces = classifiedInstaces;
					JOptionPane.showMessageDialog(system.Parameters.explorer, "Success in the Classification!",
							"Classifcation Report", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(system.Parameters.explorer,
							"Problem on Classification:\nNew case(s) was(were) not open!", "Classifcation Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(system.Parameters.explorer,
						"Problem on Classification:\nClassifier was not open!", "Classifcation Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void metodoParaSaberQueAquiTemUmProblema() {
		/**
		 * WE HAVE A PROBLEM HILSTONG!! A BIG ONE!!
		 * 
		 * 
		 * 
		 * 
		 * COMO FAREMOS PARA DESCOBRIR SE O TRAININGSET SETADO INICIALMENTE É
		 * COMPATÍVEL COM O NOVO CASO????
		 * 
		 * 
		 * DEVEMOS COMPARAR TODOS OS ATRIBUTOS???
		 * 
		 * 
		 * COMO SABER SE AS CLASSES DE UM COJUNTO DE INSTANCIAS SÃO IGUAIS ÀS DE
		 * OUTRO CONJUNTO???
		 * 
		 * 
		 * 
		 */
	}

	private boolean checkNewCases() {
		boolean check = false;
		if (system.Parameters.newInstances != null) {
			check = true;
		}
		return check;
	}

	private boolean checkClassifier() {
		boolean check = false;
		if (system.Parameters.predictor.isClassifierSetted()) {
			check = true;
		}
		return check;
	}

}
