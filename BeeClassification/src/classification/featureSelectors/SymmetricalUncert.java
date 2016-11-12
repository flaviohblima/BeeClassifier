package classification.featureSelectors;

import weka.attributeSelection.Ranker;
import weka.attributeSelection.SymmetricalUncertAttributeEval;

/**
 * 
 * @author Flávio
 *
 *         SymmetricalUncert extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "SymmetricalUncertAttributeEval" evaluator and "Ranker" as search
 *         algorithm.
 */
public class SymmetricalUncert extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public SymmetricalUncert() {
		super();
		selection.setEvaluator(new SymmetricalUncertAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}
