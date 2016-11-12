package classification.featureSelectors;

import weka.attributeSelection.CostSensitiveAttributeEval;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         CostSensitiveAttributeEvaluator extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "CostSensitiveAttributeEval" evaluator and "Ranker" as search
 *         algorithm.
 */
public class CostSensitiveAttributeEvaluator extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public CostSensitiveAttributeEvaluator() {
		super();
		selection.setEvaluator(new CostSensitiveAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}