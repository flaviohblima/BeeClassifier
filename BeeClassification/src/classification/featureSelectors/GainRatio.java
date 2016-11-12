package classification.featureSelectors;

import weka.attributeSelection.GainRatioAttributeEval;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         GainRatio extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "GainRatioAttributeEval" evaluator and "Ranker" as search algorithm.
 */
public class GainRatio extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public GainRatio() {
		super();
		selection.setEvaluator(new GainRatioAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

}
