package classification.featureSelectors;

import weka.attributeSelection.Ranker;
import weka.attributeSelection.ReliefFAttributeEval;

/**
 * 
 * @author Flávio
 *
 *         ReliefF extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "ReliefFAttributeEval" evaluator and "Ranker" as search algorithm.
 */
public class ReliefF extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public ReliefF() {
		super();
		selection.setEvaluator(new ReliefFAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}
