package gui.explorer.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.CsvReader;
import weka.core.Instances;

public class EventVisualizeData extends Observable implements ActionListener {

	private JButton btnOpenFile;
	private JTextField pathTextField;
	private JScrollPane tableScrollPane;
	private boolean dataSetOpened;

	public EventVisualizeData(JButton btnOpenFile, JScrollPane tableScrollPane, JTextField pathTextField) {
		this.btnOpenFile = btnOpenFile;
		this.pathTextField = pathTextField;
		this.tableScrollPane = tableScrollPane;
	}

	public void setDataSetOpened(boolean dataSetOpened) {
		synchronized (this) {
			this.dataSetOpened = dataSetOpened;
		}
		setChanged();
		notifyObservers(dataSetOpened);
	}

	public void actionPerformed(ActionEvent event) {
		// Button that do open the file.
		if (event.getSource() == btnOpenFile) {
			openFile();
			setDataSetOpened(true);
		}
	}

	public void openFile() {
		CsvReader reader = new CsvReader(new File(pathTextField.getText().toString()));
		Instances dataInstances = reader.data();

		// Setting originalTrainingSet of Parameters class.
		system.Parameters.originalTrainingSet.setData(dataInstances);

		int a = dataInstances.numInstances();
		int b = dataInstances.numAttributes();

		String[][] data = new String[a][b];
		String[] columnNames = new String[b];

		for (int i = 0; i < b; i++) {
			columnNames[i] = dataInstances.instance(0).attribute(i).name();
		}

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				data[i][j] = dataInstances.instance(i).toString(j);
			}
		}

		JTable table = new JTable(data, columnNames);
		table.setAutoResizeMode(0);
		tableScrollPane.getViewport().add(table);
		table.setToolTipText(tableScrollPane.getToolTipText());

		/*
		 * Editing the system.Parameters.testPanelMaxFeat to 70% of the total
		 * number of Features.
		 */
		Long L = Math.round(0.7 * b);
		system.Parameters.testPanelMaxFeat = Integer.valueOf(L.intValue());
		system.Parameters.trainingPanelMaxFeat = Integer.valueOf(L.intValue());
	}

	public synchronized boolean getDataSetOpened() {
		return dataSetOpened;
	}
}
