package classification.classifiers;

import weka.classifiers.functions.Logistic;

/**
 * 
 * @author Flávio
 *
 *         LogisticClassifier represents the weka(R) classifier "Logistic". It
 *         extends a ClassifierStandard and implements a BeeClassifier.
 */
public class LogisticClassifier extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = 6674655979964254484L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public LogisticClassifier() {
		clsfr = new Logistic();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "Logistic";
	}
}
