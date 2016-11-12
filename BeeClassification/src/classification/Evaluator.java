package classification;

import classification.classifiers.BeeClassifier;
import classification.evaluatorMethod.CrossValidation;
import classification.evaluatorMethod.EvalMethod;
import classification.evaluatorMethod.kFoldCrossValidation;

/**
 * 
 * @author Flávio
 *
 *         The Evaluator class is responsible for evaluate a array of
 *         classifiers, and use a "TrainingSet" data base given.
 *
 */
public class Evaluator {

	private float[] results;
	private EvalMethod evalm;
	public EvaluationResult evalResults;

	/**
	 * Constructor: Receives a TrainingSet and instantiate a evalMethod.
	 */
	public Evaluator(TrainingSet ts) {
		evalm = new EvaluatorFactory(system.Parameters.evaluatorClassName).getEval();
		evalm.setTrainingSet(ts);
		if (evalm instanceof kFoldCrossValidation) {
			// Setting will be made at the user window.
			((kFoldCrossValidation) evalm).setKFolds(system.Parameters.kFolds);
			((CrossValidation) evalm).splitFolds();
		}
	}

	/**
	 * Receives a array of BeeClassifier and evaluate them whit a evaluation
	 * method "eval".
	 */
	public void evaluateClassifiers(BeeClassifier[] classifiers) {
		results = new float[classifiers.length];
		for (int i = 0; i < classifiers.length; i++) {
			results[i] = evalm.evaluate(classifiers[i]);
		}
		evalResults = new EvaluationResult(classifiers, results);
		evalResults.setEvaluatorName(evalm.getName());
	}
}
