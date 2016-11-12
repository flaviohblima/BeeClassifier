package classification.serialization;

import classification.classifiers.BeeClassifier;

/**
 * 
 * @author Flávio
 *
 *         ClassifierReader is an interface that represents all classes that
 *         must read a serial classifier. Until now, the only implementation is
 *         a file reader (see FileClassifierReader).
 */
public interface ClassifierReader {

	/**
	 * Read a serial classifier from somewhere.
	 */
	public void readSerialClassifier();

	/**
	 * Method to return the read BeeClassifier.
	 * 
	 * @return BeeClassifier
	 */
	public BeeClassifier getBeeClassifier();
}