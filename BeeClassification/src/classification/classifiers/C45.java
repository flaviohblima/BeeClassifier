package classification.classifiers;

import weka.classifiers.trees.J48;

/**
 * 
 * @author Flávio
 *
 *         C45 represents the weka(R) classifier "J48". It extends a
 *         ClassifierStandard and implements a BeeClassifier.
 */
public class C45 extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = -76816982820334815L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public C45() {
		clsfr = new J48();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "C4.5";
	}
}
