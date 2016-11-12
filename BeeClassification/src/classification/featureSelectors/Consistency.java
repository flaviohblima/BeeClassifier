package classification.featureSelectors;

import weka.attributeSelection.ConsistencySubsetEval;
import weka.attributeSelection.RankSearch;

/**
 * 
 * @author Flávio
 *
 *         Consistency extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "ConsistencySubsetEval" evaluator and "RankSearch" as search
 *         algorithm.
 */
public class Consistency extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public Consistency() {
		super();
		selection.setEvaluator(new ConsistencySubsetEval());
		search = new RankSearch();
		selection.setSearch(search);
	}
}
