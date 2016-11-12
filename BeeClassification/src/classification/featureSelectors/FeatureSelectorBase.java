package classification.featureSelectors;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.ASSearch;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.Ranker;
import weka.core.Instances;

/**
 * 
 * @author Flávio
 *
 *         Class father of all Feature Selectors. Implements all methods of
 *         FeatureSelection interface.
 *
 */
public class FeatureSelectorBase implements FeatureSelector {

	protected AttributeSelection selection = null;
	protected ASSearch search;
	protected ASEvaluation evaluator;
	protected String featSelResults;

	/**
	 * Constructor: creates a AttributeSelection.
	 */
	public FeatureSelectorBase() {
		selection = new AttributeSelection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see featureSelectors.FeatureSelection#getEvaluator()
	 */
	public ASEvaluation getEvaluator() {
		return evaluator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see featureSelectors.FeatureSelection#getFeatSelResults()
	 */
	public String getFeatSelResults() {
		return featSelResults;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see featureSelectors.FeatureSelection#filterData(weka.core.Instances)
	 */
	public Instances filterData(Instances oldData) {
		Instances newData = null;
		oldData.setClassIndex(oldData.numAttributes() - 1);
		selection.setXval(false);
		try {
			selection.SelectAttributes(oldData);
			featSelResults = selection.toResultsString();
			newData = selection.reduceDimensionality(oldData);
		} catch (Exception e) {
			//
			//
			// Posso fazer isso??? Dá certo??
			// newData = oldData;
			//
			//
			newData = oldData;
			e.printStackTrace();
		}
		return newData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see featureSelectors.FeatureSelection#setMaxNumFeatures(int)
	 */
	public void setMaxNumFeatures(int maxNumFeatures) {
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Estudar o RankSearch que é usado nos casos em que não é possível
		// usar o Ranker!
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		if (search instanceof Ranker) {
			((Ranker) search).setNumToSelect(maxNumFeatures);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see featureSelectors.FeatureSelection#evaluationAlgorithmName()
	 */
	public String evaluationAlgorithmName() {
		return this.getClass().getSimpleName();
	}
}