package classification.classifiers;

/**
 * 
 * @author Flávio
 *
 *         LDAClassifier represents the Dr. Wolfgang Lenhard's classifier LDA.
 *         (For more information, view the class LDA.java at this package). It
 *         extends a ClassifierStandard and implements a BeeClassifier.
 */
public class LDAClassifier extends ClassifierStandard {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = -4385754593615986559L;

	/**
	 * Constructor instantiates the classifier.
	 */
	public LDAClassifier() {
		clsfr = new LDA();
	}

	/**
	 * Defines the classifier Name.
	 */
	public String getName() {
		return "Linear Discriminant Analysis";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.classifiers.ClassifierStandard#setParameters(
	 * classification.classifiers.parameters.ClassifierParameters)
	 */
	@Override
	public void setParameters(ClassifierParameters parameters) {
		/**
		 * LDA classifier hasn't parameters to be setted.
		 */
	}
}
