package gui;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.CSVSaver;

public class CsvWriter {

	private Instances dataSet;

	public CsvWriter(Instances dataSet) {
		this.dataSet = dataSet;
	}

	public void saveCsvFile(String path) {
		CSVSaver saver = new CSVSaver();
		saver.setInstances(dataSet);
		try {
			saver.setFile(new File(path));
			// saver.setDestination(new File(path));
			saver.writeBatch();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
