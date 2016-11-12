package classification.featureSelectors;

import weka.attributeSelection.RankSearch;
import weka.attributeSelection.WrapperSubsetEval;

/**
 * 
 * @author Flávio
 *
 *         Wrapper extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "WrapperSubsetEval" evaluator and "RankSearch" as search algorithm.
 */
public class Wrapper extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public Wrapper() {
		super();
		selection.setEvaluator(new WrapperSubsetEval());
		search = new RankSearch();
		selection.setSearch(search);
	}

}
