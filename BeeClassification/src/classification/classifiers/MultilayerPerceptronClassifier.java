package classification.classifiers;

import weka.classifiers.functions.MultilayerPerceptron;

/**
 * 
 * @author Flávio
 *
 *         MultilayerPerceptronClassifier represents the weka(R) classifier
 *         "MultilayerPerceptron". It extends a ClassifierStandard and
 *         implements a BeeClassifier.
 */
public class MultilayerPerceptronClassifier extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = 1174484240408664069L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public MultilayerPerceptronClassifier() {
		clsfr = new MultilayerPerceptron();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "Multilayer Perceptron";
	}
}
