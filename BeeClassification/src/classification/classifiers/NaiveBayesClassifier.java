package classification.classifiers;

import weka.classifiers.bayes.NaiveBayes;

/**
 * 
 * @author Flávio
 *
 *         NaiveBayesClassifier represents the weka(R) classifier "NaiveBayes".
 *         It extends a ClassifierStandard and implements a BeeClassifier.
 */
public class NaiveBayesClassifier extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = 6689763248857973871L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public NaiveBayesClassifier() {
		clsfr = new NaiveBayes();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "Naïve Bayes";
	}
}
