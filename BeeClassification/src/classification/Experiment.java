package classification;

import java.io.File;
import java.io.IOException;

import javax.swing.JProgressBar;

import classification.classifiers.BeeClassifier;
import classification.classifiers.ClassifierParameters;
import classification.featureSelectors.FeatureSelector;
import system.Constants;
import system.Parameters;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author Flávio
 *
 *         The Experiment class gathers all components necessary to evaluate a
 *         array of classifiers and realize a feature selection on the training
 *         set. After that, also is possible to show in a screen the results in
 *         text.
 */
public class Experiment {

	private FeatureSelector featSel;
	private BeeClassifier[] classifiers;
	private TrainingSet trainingSet;
	private Evaluator evaluator;
	private JProgressBar progressBar;

	/**
	 * Constructor: Receives a TrainingSet to build and realize the evaluation
	 * of all classifiers made in the factory. Besides that, it can make a
	 * feature selection if the boolean useFeatSel were "true".
	 * 
	 * @param trainingSet
	 * @param useFeatSel
	 * @param selectedClassifiers
	 * @param featureSelector
	 * @param maxNumberOfFeatures
	 */
	public Experiment(TrainingSet trainingSet, boolean useFeatSel, boolean[] selectedClassifiers,
			String featureSelector, int maxNumberOfFeatures) {
		this.trainingSet = new TrainingSet();
		this.trainingSet.setData(trainingSet.getData());

		if (useFeatSel) {
			featSel = new FeatureSelectorFactory(featureSelector).getFeatureSel();
			useFeatureSelection(maxNumberOfFeatures);
		}
		ClassifierParameters[] classifiersParameters = system.Parameters.classifiersParameters.clone();
		classifiers = new ClassifierFactory(selectedClassifiers, classifiersParameters).getClassifiers();

		progressBar = new JProgressBar(0, trainingSet.getData().numInstances());
		progressBar.setStringPainted(true);
	}

	/**
	 * Method that applies the evaluator on the classifiers knowing the training
	 * set.
	 */
	public void runExperiment() {
		evaluator = new Evaluator(trainingSet);
		evaluator.evaluateClassifiers(classifiers);
	}

	/**
	 * Call a ResultPresenter to show the results in a frame or something that
	 * is more useful to the user.
	 */
	public void ExperimentResults() {
		/*
		 * Creating a ScreenPresenter. To create other ResultsPresenter, the
		 * better idea is to create a Factory.
		 */
		ResultPresenter presenter = new ScreenPresenter();
		presenter.setText(evaluator.evalResults.resultsInText());

	}

	/**
	 * Method that receives a boolean and realizes a feature selection on the
	 * training set.
	 * 
	 * @param maxNumberOfFeatures
	 */
	public void useFeatureSelection(int maxNumberOfFeatures) {
		Instances oldData = trainingSet.getData();
		featSel.setMaxNumFeatures(maxNumberOfFeatures);
		trainingSet.setData(featSel.filterData(oldData));
	}

	public static void main(String[] args) {
		new Constants();
		new Parameters();
		system.Parameters.evaluatorClassName = system.Constants.evaluatorsClasses[0];
		system.Parameters.kFolds = 10;

		/*
		 * Setting KNN parameters.
		 */
		String[] KNNparam = { "-K", "5", "-W", "0", "-I", "-A",
				"weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"", "", "", "",
				"" };
		// Standard KNN parameters.
		// String[] KNNparam = system.Constants.parametersKNN;

		system.Parameters.parametersKNN.setTextParameters(KNNparam);
		Instances data = null;

		// CSV file reader
		CSVLoader loader = new CSVLoader();

		try {
			// Setting file of the Data.
			loader.setSource(new File("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\dados.csv"));
			data = loader.getDataSet();
		} catch (IOException e) {
			e.printStackTrace();
		}

		TrainingSet ts = new TrainingSet();
		ts.setData(data);

		/*
		 * { "C45", "NaiveBayesClassifier", "KNearestNeighbors",
		 * "LDAClassifier", "SupportVectorMachine",
		 * "MultilayerPerceptronClassifier", "LogisticClassifier" }
		 */
		boolean[] selectedClassifiers = { false, false, true, false, false, false, false };

		String featureSelectorName = "";
		boolean useFeatSel = false;
		Experiment exp = new Experiment(ts, useFeatSel, selectedClassifiers, featureSelectorName, 80);
		exp.runExperiment();
		exp.ExperimentResults();

	}
}