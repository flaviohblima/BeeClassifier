package classification.featureSelectors;

import weka.attributeSelection.CostSensitiveSubsetEval;
import weka.attributeSelection.RankSearch;

/**
 * 
 * @author Flávio
 *
 *         CostSensitiveSubsetEvaluator extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "CostSensitiveSubsetEval" evaluator and "RankSearch" as search
 *         algorithm.
 */
public class CostSensitiveSubsetEvaluator extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public CostSensitiveSubsetEvaluator() {
		super();
		selection.setEvaluator(new CostSensitiveSubsetEval());
		search = new RankSearch();
		selection.setSearch(search);
	}

}
