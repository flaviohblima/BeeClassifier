package gui;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class CsvReader {
	CSVLoader loader;
	Instances data;
	File file;

	/**
	 * CsvReader constructor.
	 * 
	 * @param file
	 */
	public CsvReader(File file) {
		this.file = file;
		data = null;
	}

	/**
	 * O método "dados" lê um arquivo CSV e retorna uma Instance.
	 * 
	 * @return
	 * @throws IOException
	 */
	public Instances data() {
		// load CSV
		loader = new CSVLoader();
		try {
			loader.setSource(file);
			data = loader.getDataSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
