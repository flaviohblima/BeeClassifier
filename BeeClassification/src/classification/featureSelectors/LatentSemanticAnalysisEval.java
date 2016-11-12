package classification.featureSelectors;

import weka.attributeSelection.LatentSemanticAnalysis;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         LatentSemanticAnalysisEval extends the FeatureSelectorBase and
 *         implements FeatureSelection. It is a feature selector that uses
 *         "LatentSemanticAnalysis" evaluator and "Ranker" as search algorithm.
 */
public class LatentSemanticAnalysisEval extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public LatentSemanticAnalysisEval() {
		super();
		selection.setEvaluator(new LatentSemanticAnalysis());
		search = new Ranker();
		selection.setSearch(search);
	}

}
