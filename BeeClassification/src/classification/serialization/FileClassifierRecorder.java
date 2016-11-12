package classification.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import classification.classifiers.BeeClassifier;
import classification.classifiers.C45;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author Flávio
 * 
 *         FileClassifierRecorder is an implementation of ClassifierRecorder.
 *         This recorder saves the classifier in a file.
 * 
 */
public class FileClassifierRecorder implements ClassifierRecorder {

	private BeeClassifier bc;
	private String path;

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.serialization.ClassifierRecorder#setBeeClassifier(
	 * classification.classifiers.BeeClassifier)
	 */
	public void setBeeClassifier(BeeClassifier bc) {
		this.bc = bc;
	}

	/**
	 * Method to set the path where the file will be saved.
	 * 
	 * @param path
	 */
	public void setPathToFile(String path) {
		this.path = path;
	}

	/**
	 * Method to save the classifier in a serial file (.ser).
	 */
	public void saveSerialClassifier() {
		FileOutputStream fout;
		ObjectOutputStream oos;
		try {
			fout = new FileOutputStream(path);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(bc);
			oos.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main to visualize the functionalities of the class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BeeClassifier bc = new C45();

		Instances data = null;

		// CSV file reader
		CSVLoader loader = new CSVLoader();

		try {
			// Setting file of the Data.
			loader.setSource(new File("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\dados.csv"));
			data = loader.getDataSet();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("The classifier is training...");
		bc.train(data);
		ClassifierRecorder rec = new FileClassifierRecorder();
		if (rec instanceof FileClassifierRecorder) {
			((FileClassifierRecorder) rec).setPathToFile("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\C45.ser");
			System.out.println("Here I tried to set the path to save the serialization in a ser file");
		}
		rec.setBeeClassifier(bc);
		rec.saveSerialClassifier();
		System.out.println("Look to the path you choosed and you will see the ser file there!");

		// Reading the BeeClassifier serialized
		System.out.println("Now, we're trying to read the serialized file!");
		ClassifierReader reader = new FileClassifierReader();
		((FileClassifierReader) reader).setPath("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\C45.ser");
		reader.readSerialClassifier();
		BeeClassifier newBc = reader.getBeeClassifier();
		System.out.println(newBc.getName());

		/*
		 * Instanciar o experiment para ver se ele retorna o memso valor para o
		 * bc e para o newBc.
		 */
		int a = bc.classify(data.instance(100));
		int b = newBc.classify(data.instance(100));

		System.out.println("bc classifies the 4th instance from trainingset as: " + a);
		System.out.println("newBc classifies the 4th instance from trainingset as: " + b);

	}
}
