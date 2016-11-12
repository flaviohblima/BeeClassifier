package system;

import java.io.Serializable;

import classification.TrainingSet;
import classification.classifiers.ClassifierParameters;
import classification.serialization.InstancePredictor;
import classification.serialization.Trainer;
import gui.explorer.ClassificationTestPanel;
import gui.explorer.ClassifierTrainingPanel;
import gui.explorer.ClassifierUsePanel;
import gui.explorer.DataSetPanel;
import gui.explorer.Explorer;
import weka.core.Instances;

public class Parameters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6835839461265577402L;

	/*
	 * Explorer
	 */
	public static Explorer explorer;

	/*
	 * DataSetPanel parameters.
	 */
	public static TrainingSet originalTrainingSet;
	public static boolean dataSetOpened = false;
	public static DataSetPanel dataSetPanel = new DataSetPanel();

	/*
	 * ClassificationTestPanel parameters.
	 */
	public static String evaluatorClassName = "";
	public static String evaluatorName = "";
	public static int kFolds = 10;
	public static String testPanelAlgorithmName = "";
	public static int testPanelMaxFeat = 0;
	public static boolean[] testPanelClassifiersArray = { false, false, false, false, false, false, false };
	// Parameters
	public static ClassifierParameters parametersC45 = new ClassifierParameters();
	public static ClassifierParameters parametersNaiveBayes = new ClassifierParameters();
	public static ClassifierParameters parametersKNN = new ClassifierParameters();
	public static ClassifierParameters parametersSVM = new ClassifierParameters();
	public static ClassifierParameters parametersMP = new ClassifierParameters();
	public static ClassifierParameters parametersLogistic = new ClassifierParameters();
	public static ClassifierParameters[] classifiersParameters = { parametersC45, parametersNaiveBayes, parametersKNN,
			(ClassifierParameters) null, parametersSVM, parametersMP, parametersLogistic };
	public static ClassificationTestPanel classificationTestPanel = new ClassificationTestPanel();

	/*
	 * ClassifierTrainingPanel parameters.
	 */
	public static String trainingPanelAlgorithmName = "";
	public static int trainingPanelMaxFeat = 0;
	public static String classifierName = "";
	public static String classifierClass = "";
	public static boolean[] trainingClassifiersArray = { false, false, false, false, false, false, false };
	public static Trainer trainer = null;
	public static ClassifierParameters[] trainingParameters = classifiersParameters.clone();
	public static ClassifierTrainingPanel classifierTrainingPanel = new ClassifierTrainingPanel();

	/*
	 * ClassifierUsePanel parameters.
	 */
	public static InstancePredictor predictor;
	public static Instances newInstances;
	public static Instances classifiedInstaces;
	public static ClassifierUsePanel classifierUsePanel = new ClassifierUsePanel();

	public Parameters() {
		originalTrainingSet = new TrainingSet();
		predictor = new InstancePredictor();
		parametersC45.setTextParameters(system.Constants.parametersC45);
		parametersNaiveBayes.setTextParameters(system.Constants.parametersNaiveBayes);
		parametersKNN.setTextParameters(system.Constants.parametersKNN);
		parametersSVM.setTextParameters(system.Constants.parametersSVM);
		parametersMP.setTextParameters(system.Constants.parametersMP);
		parametersLogistic.setTextParameters(system.Constants.parametersLogistic);
	}

	public static String report() {
		String report = "-------------------- Parameters Report --------------------\n\n";
		/*
		 * DataSetPanel parameters.
		 */
		report = report + "----------------------- DataSetPanel ----------------------\n\n";
		if (originalTrainingSet.getData() == null) {
			report = report + "Training Set isn't chosen!\n";
		} else {
			report = report + "Training Set is chosen!\n";
		}

		if (dataSetOpened) {
			report = report + "Training Set was opened!\n";
		} else {
			report = report + "Training Set wasn't opened!\n";
		}

		/*
		 * ClassificationTestPanel parameters.
		 */
		report = report + "\n\n----------------- ClassificationTestPanel -----------------\n\n";
		report = report + "Evaluator class name: " + evaluatorClassName + "\n";
		report = report + "Evaluator name: " + evaluatorName + "\n";
		report = report + "Number of K folds: " + kFolds + "\n";
		report = report + "Algorithm name (Classification Test panel): " + testPanelAlgorithmName + "\n";
		report = report + "Maximum number of features (Classification Test panel): " + testPanelMaxFeat + "\n";

		for (int i = 0; i < testPanelClassifiersArray.length; i++) {
			report = report + system.Constants.classifiersNames[i] + " is selected: " + testPanelClassifiersArray[i]
					+ "\n";
		}

		report = report + "\n" + system.Constants.classifiersNames[0] + " param:\n";
		for (int i = 0; i < parametersC45.getTextParameters().length; i++) {
			report = report + parametersC45.getTextParameters()[i] + " ,";
		}
		report = report + "\n" + system.Constants.classifiersNames[1] + " param:\n";
		for (int i = 0; i < parametersNaiveBayes.getTextParameters().length; i++) {
			report = report + parametersNaiveBayes.getTextParameters()[i] + " ,";
		}
		report = report + "\n" + system.Constants.classifiersNames[2] + " param:\n";
		for (int i = 0; i < parametersKNN.getTextParameters().length; i++) {
			report = report + parametersKNN.getTextParameters()[i] + " ,";
		}
		report = report + "\n" + system.Constants.classifiersNames[4] + " param:\n";
		for (int i = 0; i < parametersSVM.getTextParameters().length; i++) {
			report = report + parametersSVM.getTextParameters()[i] + " ,";
		}
		report = report + "\n" + system.Constants.classifiersNames[5] + " param:\n";
		for (int i = 0; i < parametersMP.getTextParameters().length; i++) {
			report = report + parametersMP.getTextParameters()[i] + " ,";
		}
		report = report + "\n" + system.Constants.classifiersNames[6] + " param:\n";
		for (int i = 0; i < parametersLogistic.getTextParameters().length; i++) {
			report = report + parametersLogistic.getTextParameters()[i] + " ,";
		}

		/*
		 * ClassifierTrainingPanel parameters.
		 */
		report = report + "\n\n----------------- ClassifierTrainingPanel -----------------\n\n";
		report = report + "Algorithm name (Classifier Training panel): " + trainingPanelAlgorithmName + "\n";
		report = report + "Maximum number of features (Classifier Training panel): " + trainingPanelMaxFeat + "\n";
		report = report + "Classifier class: " + classifierClass + "\n";
		report = report + "Classifier name: " + classifierName + "\n";
		if (trainer == null) {
			report = report + "Classifier isn't builded!\n";
		} else {
			report = report + "Classifier is builded!\n";
			for (int i = 0; i < trainingClassifiersArray.length; i++) {
				if (trainingClassifiersArray[i]) {
					report = report + "Classifier selected: " + system.Constants.classifiersNames[i] + "\n";
				}
			}
		}
		return report;
	}
}