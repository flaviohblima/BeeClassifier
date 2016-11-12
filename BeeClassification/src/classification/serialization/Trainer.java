package classification.serialization;

import java.io.File;
import java.io.IOException;

import classification.FeatureSelectorFactory;
import classification.TrainingSet;
import classification.classifiers.BeeClassifier;
import classification.classifiers.LogisticClassifier;
import classification.featureSelectors.FeatureSelector;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author Flávio
 *
 *         The class Trainer receives a training set, a Bee classifier and a
 *         Feature Selection algorithm and builds the classifier. The class also
 *         can save the classifier in a file.
 *
 */
public class Trainer {

	private TrainingSet trainingSet;
	private BeeClassifier bc;
	private FeatureSelector featSel;

	/**
	 * The constructor receives and sets the parameters of the class.
	 * 
	 * @param ts
	 * @param bc
	 * @param featSel
	 */
	public Trainer(TrainingSet ts, BeeClassifier bc, FeatureSelector featSel, boolean useFeatSel,
			int maxNumberOfFeatures) {
		this.trainingSet = ts;
		this.bc = bc;
		if (useFeatSel) {
			this.featSel = featSel;
			useFeatureSelection(maxNumberOfFeatures);
		}
	}

	/**
	 * Method to build the classifier base on the trainingSet.
	 */
	public void trainClassifier() {
		bc.train(trainingSet.getData());
	}

	/**
	 * Method that receives a boolean and realizes a feature selection on the
	 * training set.
	 * 
	 * @param maxNumberOfFeatures
	 * 
	 */
	public void useFeatureSelection(int maxNumberOfFeatures) {
		Instances oldData = trainingSet.getData();
		featSel.setMaxNumFeatures(maxNumberOfFeatures);
		trainingSet.setData(featSel.filterData(oldData));
	}

	/**
	 * Method to save the classifier builded in a file named on the path.
	 * 
	 * @param path
	 */
	public void saveClassifier(String path) {
		ClassifierRecorder classifierRecorder;
		classifierRecorder = new FileClassifierRecorder();
		classifierRecorder.setBeeClassifier(bc);
		if (classifierRecorder instanceof FileClassifierRecorder) {
			((FileClassifierRecorder) classifierRecorder).setPathToFile(path);
		}
		classifierRecorder.saveSerialClassifier();
	}

	/**
	 * Main method to visualization of its functionalities.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Instances data = null;

		// CSV file reader
		CSVLoader loader = new CSVLoader();

		try {
			// Setting file of the Data.
			loader.setSource(new File("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\teste.csv"));
			data = loader.getDataSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TrainingSet ts = new TrainingSet();
		ts.setData(data);

		// Instantiating the classifier.
		BeeClassifier bc = new LogisticClassifier();

		FeatureSelector featSel = new FeatureSelectorFactory("ChiSquared").getFeatureSel();
		boolean useFeatSel = true;

		/*
		 * Using the Trainer class.
		 */
		Trainer trainer = new Trainer(ts, bc, featSel, useFeatSel, 80);

		/*
		 * Counting time!
		 */
		System.out.println("Running the training!");
		// Get current time
		long start = System.currentTimeMillis();

		// Training
		trainer.trainClassifier();

		// Get elapsed time in milliseconds
		long elapsedTimeMillis = System.currentTimeMillis() - start;
		// Get elapsed time in minutes
		float elapsedTimeMin = elapsedTimeMillis / (60 * 1000F);

		/*
		 * End of counting time.
		 */

		System.out.println("The training finished in " + elapsedTimeMin + " minutes.");
		trainer.saveClassifier("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\Logistic.ser");
	}
}