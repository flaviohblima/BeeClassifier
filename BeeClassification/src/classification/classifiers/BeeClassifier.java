package classification.classifiers;

import java.io.Serializable;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author Flávio
 *
 *         Interface to represents all classification algorithms. To add a new
 *         classifier to your possibilities, it is necessary to make it
 *         implements a BeeClassifier and extends a ClassifierStandard. All
 *         classifiers must be serializable because they will be recorded.
 */
public interface BeeClassifier extends Serializable {

	/**
	 * Method that receives the trainingSet and build the classifier based on
	 * it. The Feature selection can be made here.
	 * 
	 * @param data
	 */
	public void train(Instances data);

	/**
	 * Method that receives a newCase (Instance) and classifies it.
	 * 
	 * @param newCase
	 * @return
	 */
	public int classify(Instance newCase);

	/**
	 * Method that receives the parameters settings by the user and applies it
	 * at the classifier.
	 * 
	 * @param parameters
	 */
	public void setParameters(ClassifierParameters parameters);

	/**
	 * Method to return the classifier's name.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Method to return the weka classifier used at BeeClassifier.
	 * 
	 * @return
	 */
	public Classifier wekaClassifier();

}
