package classification.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import classification.classifiers.BeeClassifier;

/**
 * 
 * @author Flávio
 *
 *         FileClassifierReader is an implementation of ClassifierReader. The
 *         class receives a path to a file that must contain a builded
 *         classifier. Then, it must be possible to return the classifier.
 * 
 */
public class FileClassifierReader implements ClassifierReader {

	private String path;
	private BeeClassifier bc;

	/**
	 * Constructor to set the parameters of the class.
	 * 
	 * @param path
	 */
	public FileClassifierReader() {
		bc = null;
	}

	/**
	 * Method to set a path to a file with the BeeClassifier.
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.serialization.ClassifierReader#readSerialClassifier()
	 */
	public void readSerialClassifier() {
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			bc = (BeeClassifier) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("BeeClassifier class not found");
			c.printStackTrace();
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.serialization.ClassifierReader#getBeeClassifier()
	 */
	public BeeClassifier getBeeClassifier() {
		return bc;
	}
}