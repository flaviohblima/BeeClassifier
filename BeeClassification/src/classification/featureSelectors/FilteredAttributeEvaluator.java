package classification.featureSelectors;

import weka.attributeSelection.FilteredAttributeEval;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         FilteredAttributeEvaluator extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "FilteredAttributeEval" evaluator and "Ranker" as search algorithm.
 */
public class FilteredAttributeEvaluator extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public FilteredAttributeEvaluator() {
		super();
		selection.setEvaluator(new FilteredAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}
