package classification.featureSelectors;

import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.RankSearch;

/**
 * 
 * @author Flávio
 *
 *         Correlation extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses "CfsSubsetEval"
 *         evaluator and "RankSearch" as search algorithm.
 */
public class Correlation extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public Correlation() {
		super();
		selection.setEvaluator(new CfsSubsetEval());
		search = new RankSearch();
		selection.setSearch(search);
	}
}
