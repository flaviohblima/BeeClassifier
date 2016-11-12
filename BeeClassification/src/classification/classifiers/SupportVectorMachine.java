package classification.classifiers;

import weka.classifiers.functions.SMO;

/**
 * 
 * @author Flávio
 *
 *         SupportVectorMachine represents the weka(R) classifier "SMO". It
 *         extends a ClassifierStandard and implements a BeeClassifier.
 */
public class SupportVectorMachine extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = -8162331830329950728L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public SupportVectorMachine() {
		clsfr = new SMO();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "Support Vector Machine";
	}
}
