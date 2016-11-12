package classification.evaluatorMethod;

import classification.TrainingSet;
import classification.classifiers.BeeClassifier;

/**
 * 
 * @author Flávio
 *
 *         Interface that represents all algorithms of classifiers evaluation.
 *         It is used at "Experiment" class.
 */
public interface EvalMethod {

	/**
	 * Method to set the TrainingSet that is base to the evaluation. The
	 * training set usually is broken in two pieces: TrainingSet of the
	 * classifier and TestSet.
	 * 
	 * @param ts
	 */
	public void setTrainingSet(TrainingSet ts);

	/**
	 * Method to evaluate a BeeClassifier. Each evalMethod can implements a
	 * different method to evaluate the classifier.
	 * 
	 * @param bc
	 * @return
	 */
	public float evaluate(BeeClassifier bc);

	/**
	 * Method to get the Description of the evaluator.
	 * 
	 * @return
	 */
	public String getName();
}
