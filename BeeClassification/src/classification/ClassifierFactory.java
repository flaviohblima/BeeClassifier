package classification;

import classification.classifiers.BeeClassifier;
import classification.classifiers.ClassifierParameters;
import system.Parameters;

/**
 * 
 * @author Flávio
 * 
 *         Factory of Classifiers makes a array of classifiers that have been
 *         chosen by the user.
 *
 */
public class ClassifierFactory {

	private BeeClassifier[] classifiers;
	/*
	 * "classifiersNames" must be equal to the names of the classes at
	 * classification.classifiers, because they are instantiate here.
	 */
	public static String[] classifiersNames = { "C45", "NaiveBayesClassifier", "KNearestNeighbors", "LDAClassifier",
			"SupportVectorMachine", "MultilayerPerceptronClassifier", "LogisticClassifier" };

	/**
	 * Gets the array of BeeClassifiers.
	 * 
	 * @return
	 */
	public BeeClassifier[] getClassifiers() {
		return classifiers;
	}

	/**
	 * Receives a array of booleans to instantiate the classifiers chosen.
	 * 
	 * @param selectedClassifiers
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public ClassifierFactory(boolean[] selectedClassifiers, ClassifierParameters[] classifiersParameters) {

		int classifierNumber = 0;
		for (int i = 0; i < selectedClassifiers.length; i++) {
			if (selectedClassifiers[i]) {
				classifierNumber++;
			}
		}
		classifiers = new BeeClassifier[classifierNumber];
		int k = 0;
		for (int i = 0; i < selectedClassifiers.length; i++) {
			if (selectedClassifiers[i]) {
				Object o = null;
				try {
					o = Class.forName("classification.classifiers." + classifiersNames[i]).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				classifiers[k] = (BeeClassifier) o;
				classifiers[k].setParameters(classifiersParameters[i]);
				k++;
			}
		}
	}

	/**
	 * Main method to experiment the functionalities of the classifiers.
	 * 
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		boolean[] selectedClassifiers = { true, true, true, false, true, true, true };
		BeeClassifier[] classifierArray = null;
		Parameters parameters = new Parameters();
		parameters.parametersC45.setTextParameters(system.Constants.parametersC45);
		String[] KNNparam = { "-K", "5", "-W", "0", "-I", "-A",
				"weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"", "", "", "",
				"" };
		parameters.parametersKNN.setTextParameters(KNNparam);
		parameters.parametersLogistic.setTextParameters(system.Constants.parametersLogistic);
		parameters.parametersMP.setTextParameters(system.Constants.parametersMP);
		parameters.parametersNaiveBayes.setTextParameters(system.Constants.parametersNaiveBayes);
		parameters.parametersSVM.setTextParameters(system.Constants.parametersSVM);
		classifierArray = new ClassifierFactory(selectedClassifiers, parameters.classifiersParameters).getClassifiers();

		// printing the names of the classifiers.
		for (int i = 0; i < classifierArray.length; i++) {
			System.out.println(classifierArray[i].getName());
			for (int j = 0; j < classifierArray[i].wekaClassifier().getOptions().length; j++) {
				System.out.print(classifierArray[i].wekaClassifier().getOptions()[j] + " , ");
			}
			System.out.println("\n");
		}
	}
}