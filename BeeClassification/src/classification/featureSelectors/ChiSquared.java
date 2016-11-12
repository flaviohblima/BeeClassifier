package classification.featureSelectors;

import weka.attributeSelection.ChiSquaredAttributeEval;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         ChiSquared extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "ChiSquaredAttributeEval" evaluator and "Ranker" as search algorithm.
 */
public class ChiSquared extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public ChiSquared() {
		super();
		selection.setEvaluator(new ChiSquaredAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

	/**
	 * Main to observe the class instantiated.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FeatureSelector featSel = new ChiSquared();
		System.out.println(featSel.evaluationAlgorithmName());
	}
}