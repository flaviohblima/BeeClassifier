package classification.classifiers;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author Flávio
 *
 *         ClassifierStandard implements all methods of the BeeClassifier
 *         interface. It is a base to all classifiers.
 */
public class ClassifierStandard implements BeeClassifier {

	/**
	 * The clasifiers must be serializable because it is necessary to record
	 * them.
	 */
	private static final long serialVersionUID = -5464730121981967751L;

	Classifier clsfr;

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.classifiers.BeeClassifier#train(weka.core.Instances)
	 */
	public void train(Instances data) {
		// Last attribute becomes a class.
		data.setClassIndex(data.numAttributes() - 1);

		// Building a j48 classifier.
		try {
			clsfr.buildClassifier(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * classification.classifiers.BeeClassifier#classify(weka.core.Instance)
	 */
	public int classify(Instance newCase) {
		int resultClass = 0;
		try {
			resultClass = (int) clsfr.classifyInstance(newCase);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * classification.classifiers.BeeClassifier#setParameters(classification.
	 * ClassifierParameters)
	 */
	public void setParameters(ClassifierParameters parameters) {
		try {
			clsfr.setOptions(parameters.getTextParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.classifiers.BeeClassifier#getName()
	 */
	public String getName() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.classifiers.BeeClassifier#wekaClassifier()
	 */
	public Classifier wekaClassifier() {
		return clsfr;
	}
}
