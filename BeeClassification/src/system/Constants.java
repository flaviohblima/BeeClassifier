package system;

public class Constants {

	/*
	 * Option of evaluators at the classification test.
	 * 
	 * K Fold Cross-Validation must be the first option.
	 */
	public final static String[] evaluators = { "K Fold Cross-Validation" };
	public final static String[] evaluatorsClasses = { "kFoldCrossValidation" };

	/*
	 * Options of algorithms at the feature selection.
	 */
	public final static String[] algorithmsClasses = { "Correlation", "ChiSquared", "InformationGain",
			"ClassifierSubsetEvaluator", "Consistency", "FilteredAttributeEvaluator", "FilteredSubsetEvaluator",
			"GainRatio", "OneR", "ReliefF", "SVM", "SymmetricalUncert", "Wrapper" };

	/*
	 * Option of algorithms at the classification.
	 */
	public final static String[] classifiersClassesNames = { "C45", "NaiveBayesClassifier", "KNearestNeighbors",
			"LDAClassifier", "SupportVectorMachine", "MultilayerPerceptronClassifier", "LogisticClassifier" };
	public final static String[] classifiersNames = { "C4.5", "Naïve Bayes", "K Nearest Neighbors",
			"Linear Discriminant Analysis", "Support Vector Machine", "Multilayer Perceptron", "Logistic" };

	/*
	 * Standard parameters of classifiers.
	 */
	public final static String[] parametersC45 = { "-C", "0.1", "-M", "3", "", "", "", "", "", "", "", "", "", "" };
	public final static String[] parametersNaiveBayes = { "", "", "" };
	public final static String[] parametersKNN = { "-K", "9", "-W", "0", "-F", "-A",
			"weka.core.neighboursearch.LinearNNSearch -A \"weka.core.EuclideanDistance -R first-last\"", "", "", "",
			"" };
	public final static String[] parametersSVM = { "-C", "4.0", "-L", "0.001", "-P", "1.0E-12", "-N", "0", "-V", "-1",
			"-W", "1", "-K", "weka.classifiers.functions.supportVector.PolyKernel -C 250007 -E 2.0" };
	public final static String[] parametersMP = { "-L", "0.1", "-M", "0.1", "-N", "100", "-V", "0", "-S", "0", "-E",
			"20", "-H", "a", "", "", "", "", "", "", "" };
	public final static String[] parametersLogistic = { "-C", "-R", "1.8E-8", "-M", "200" };

	public Constants() {
	}

}