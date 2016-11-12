package classification;

import weka.core.Instances;

/**
 * 
 * @author Flávio
 *
 *         TrainingSet is a class that represents the data used at classifiers
 *         building (training).
 */
public class TrainingSet {

	// Data to be used on classifier training.
	private Instances data;

	/**
	 * Method to get the trainingSet in "Instances" type.
	 * 
	 * @return
	 */
	public Instances getData() {
		return data;
	}

	/**
	 * Method to set the trainingSet. It receives the new data in "Instances"
	 * type.
	 * 
	 * @param data
	 */
	public void setData(Instances data) {
		this.data = data;
	}
}
