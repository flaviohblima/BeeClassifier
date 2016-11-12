package classification;

import java.io.File;
import java.io.IOException;

import classification.featureSelectors.FeatureSelector;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author Flávio
 *
 *         Feature Selection Factory instantiates the feature selection desired
 *         by the user.
 *
 */
public class FeatureSelectorFactory {

	private FeatureSelector featSel;
	public static String[] options = system.Constants.algorithmsClasses;

	/**
	 * Getting the Feature Selection that was created by
	 * "FeatureSelectionFactory"
	 * 
	 * @return
	 */
	public FeatureSelector getFeatureSel() {
		return featSel;
	}

	/**
	 * Constructor: "FeatureSelectionFactory" receives the evaluator algorithm
	 * name desired by the user, and instantiates the class of algorithm.
	 * 
	 * @param algorithm
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public FeatureSelectorFactory(String algorithm) {

		int i = 0;
		boolean flag = true;
		while (i < options.length && flag) {
			// Compares the name of the evaluator algorithm received by the
			// method and the list of algorithms defined at "options".
			if (algorithm.equals(options[i])) {
				Object o = null;
				try {
					o = Class.forName("classification.featureSelectors." + algorithm).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				featSel = (FeatureSelector) o;
				flag = false;
			}
			i = i + 1;
		}
		if (featSel == null) {
			throw new RuntimeException("The Feature Selection Class is Invalid");
		}
	}

	/**
	 * Main method: simulates some functionalities of the Feature Selection.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Printing every Feature Selectors names by instantiating the classes.
		 */
		String[] algorithm = FeatureSelectorFactory.options;
		for (int i = 0; i < algorithm.length; i++) {
			FeatureSelector featSel = null;
			featSel = new FeatureSelectorFactory(algorithm[i]).getFeatureSel();
			System.out.println(featSel.evaluationAlgorithmName());
		}

		/*
		 * Testing a Feature Selection
		 */
		// Settings of the Feature Selection
		String evalAlgorithm = "ChiSquared";
		int maxNumFeatures = 80;
		FeatureSelector featSel = null;
		Instances data = null;
		// CSV file reader
		CSVLoader loader = new CSVLoader();

		try {
			// Getting a Feature Selection using the name of the evaluation
			// algorithm.
			featSel = new FeatureSelectorFactory(evalAlgorithm).getFeatureSel();
			// Setting file of the Data.
			loader.setSource(new File("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\dados.csv"));
			data = loader.getDataSet();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Setting the Feature Selection
		featSel.setMaxNumFeatures(maxNumFeatures);
		Instances filteredData = featSel.filterData(data);

		// Writing the data in a String.
		StringBuilder sbResult = new StringBuilder();
		for (int i = 0; i < filteredData.numInstances(); i++) {
			sbResult.append(filteredData.instance(i));
			sbResult.append("\n \n");
		}
		// To print the data, uncomment the next line.
		// System.out.println(sbResult + "\n \n");

		// Printing the results of feature selection
		System.out.println(featSel.getFeatSelResults());

	}
}
