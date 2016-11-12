package classification;

import classification.featureSelectors.FeatureSelector;
import weka.core.Instances;

public class FeatureSelection {

	private FeatureSelector featSel;
	private TrainingSet filteredTrainingSet;

	/**
	 * Essa Flag serve para me lembrar de comentar uma classe.
	 */

	private boolean flagDosComentários;

	public FeatureSelection(String featureSelector, TrainingSet trainingSet, int maxNumberOfFeatures) {
		filteredTrainingSet = new TrainingSet();

		featSel = new FeatureSelectorFactory(featureSelector).getFeatureSel();
		run(trainingSet, maxNumberOfFeatures);
	}

	private void run(TrainingSet trainingSet, int maxNumberOfFeatures) {
		featSel.setMaxNumFeatures(maxNumberOfFeatures);
		Instances oldData = trainingSet.getData();
		filteredTrainingSet.setData(featSel.filterData(oldData));
	}

	public void showResults() {
		ResultPresenter resultPresenter = new ScreenPresenter();
		resultPresenter.setText(featSel.getFeatSelResults());
	}

	public TrainingSet getFilteredTrainingSet() {
		return filteredTrainingSet;
	}

}
