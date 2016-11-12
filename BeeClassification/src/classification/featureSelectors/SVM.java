package classification.featureSelectors;

import weka.attributeSelection.Ranker;
import weka.attributeSelection.SVMAttributeEval;

/**
 * 
 * @author Flávio
 *
 *         SVM extends the FeatureSelectorBase and implements FeatureSelection.
 *         It is a feature selector that uses "SVMAttributeEval" evaluator and
 *         "Ranker" as search algorithm.
 */
public class SVM extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public SVM() {
		super();
		selection.setEvaluator(new SVMAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}
