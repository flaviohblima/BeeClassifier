package classification.serialization;

import classification.classifiers.BeeClassifier;

/**
 * 
 * @author Flávio
 * 
 *         ClassifierRecorder is an interface that represents all classes that
 *         must save a serial classifier. Until now, the only implementation is
 *         a file recorder (see FileClassifierRecorder).
 */
public interface ClassifierRecorder {

	/**
	 * Method to set the BeeClassifier that the user wants to save.
	 * 
	 * @param bc
	 */
	public void setBeeClassifier(BeeClassifier bc);

	/**
	 * Method to save the classifier setted before.
	 */
	public void saveSerialClassifier();
}