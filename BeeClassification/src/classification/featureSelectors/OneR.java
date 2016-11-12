package classification.featureSelectors;

import weka.attributeSelection.OneRAttributeEval;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         OneR extends the FeatureSelectorBase and implements FeatureSelection.
 *         It is a feature selector that uses "OneRAttributeEval" evaluator and
 *         "Ranker" as search algorithm.
 */
public class OneR extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public OneR() {
		super();
		selection.setEvaluator(new OneRAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}
