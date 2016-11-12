package classification.classifiers;

import weka.classifiers.lazy.IBk;

/**
 * 
 * @author Flávio
 *
 *         KNearestNeighbors represents the weka(R) classifier "IBk". It extends
 *         a ClassifierStandard and implements a BeeClassifier.
 */
public class KNearestNeighbors extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = -2592613429575552802L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public KNearestNeighbors() {
		clsfr = new IBk();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "K Nearest Neighbors";
	}
}
