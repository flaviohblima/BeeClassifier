package classification.featureSelectors;

import weka.attributeSelection.FilteredSubsetEval;
import weka.attributeSelection.RankSearch;

/**
 * 
 * @author Flávio
 *
 *         FilteredSubsetEvaluator extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "FilteredSubsetEval" evaluator and "RankSearch" as search algorithm.
 */
public class FilteredSubsetEvaluator extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public FilteredSubsetEvaluator() {
		super();
		selection.setEvaluator(new FilteredSubsetEval());
		search = new RankSearch();
		selection.setSearch(search);
	}
}
