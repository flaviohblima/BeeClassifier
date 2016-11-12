package classification.featureSelectors;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;

/**
 * 
 * @author Flávio
 *
 *         InformationGain extends the FeatureSelectorBase and implements
 *         FeatureSelection. It is a feature selector that uses
 *         "InfoGainAttributeEval" evaluator and "RankSearch" as search
 *         algorithm.
 */
public class InformationGain extends FeatureSelectorBase {

	/**
	 * Constructor set all details of this feature selector.
	 */
	public InformationGain() {
		super();
		selection.setEvaluator(new InfoGainAttributeEval());
		search = new Ranker();
		selection.setSearch(search);
	}

	/**
	 * Main to observe the class instantiated.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FeatureSelector featSel = new InformationGain();
		System.out.println(featSel.evaluationAlgorithmName());
	}

}
