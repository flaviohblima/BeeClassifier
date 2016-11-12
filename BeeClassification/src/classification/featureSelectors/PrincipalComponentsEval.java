package classification.featureSelectors;

import weka.attributeSelection.PrincipalComponents;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         PrincipalComponentsEval extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "PrincipalComponents" evaluator and "Ranker" as search algorithm.
 */
public class PrincipalComponentsEval extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public PrincipalComponentsEval() {
		super();
		selection.setEvaluator(new PrincipalComponents());
		search = new Ranker();
		selection.setSearch(search);
	}

}
