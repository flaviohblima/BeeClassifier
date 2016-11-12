package classification.featureSelectors;

import weka.attributeSelection.ClassifierSubsetEval;
import weka.attributeSelection.RankSearch;

/**
 * 
 * @author Flávio
 *
 *         ClassifierSubsetEvaluator extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "ClassifierSubsetEval" evaluator and "RankSearch" as search
 *         algorithm.
 */
public class ClassifierSubsetEvaluator extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public ClassifierSubsetEvaluator() {
		super();
		selection.setEvaluator(new ClassifierSubsetEval());
		search = new RankSearch();
		selection.setSearch(search);
	}
}
