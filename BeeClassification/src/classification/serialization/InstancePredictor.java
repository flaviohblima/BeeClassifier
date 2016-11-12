package classification.serialization;

import java.io.File;
import java.io.IOException;

import classification.classifiers.BeeClassifier;
import system.Parameters;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author Flávio
 *
 *         Class to predict the class of new instances with the BeeClassifier.
 *         This BeeClassisfier will be got by a ClassifierReader. The first
 *         version of the program uses a File reader.
 */
public class InstancePredictor {

	private BeeClassifier bc;
	private ClassifierReader reader;

	/**
	 * Constructor sets the path to the file that will be used.
	 * 
	 * @param path
	 */
	public InstancePredictor() {
		reader = new FileClassifierReader();
	}

	/**
	 * Method that indicates if the classifier is setted.
	 * 
	 * @return
	 */
	public boolean isClassifierSetted() {
		boolean setted = false;
		if (bc != null) {
			setted = true;
		}
		return setted;
	}

	/**
	 * Method that reads a file containing a classifier.
	 * 
	 * @param path
	 */
	public void readSerializedClassifier(String path) {
		if (reader instanceof FileClassifierReader) {
			((FileClassifierReader) reader).setPath(path);
		}
		reader.readSerialClassifier();
		bc = reader.getBeeClassifier();
	}

	/**
	 * Method to predict the class of a new set of instances.
	 * 
	 * @param newInstances
	 * @return
	 */
	public Instances predict(Instances newInstances) {
		int[] predictedClasses = new int[newInstances.numInstances()];

		/*
		 * The last field of the data base (last attribute) must be the class.
		 * If the user don't know the class of a new instance, he must create a
		 * vector (newInstance) where the last field exists, but must be null.
		 */
		newInstances.setClassIndex(newInstances.numAttributes() - 1);
		Instances oldData = system.Parameters.originalTrainingSet.getData();

		for (int i = 0; i < newInstances.numInstances(); i++) {
			predictedClasses[i] = bc.classify(newInstances.instance(i));
			String className = oldData.attribute(oldData.numAttributes() - 1).value(predictedClasses[i]);
			newInstances.instance(i).setClassValue(className);
		}
		return newInstances;
	}

	/**
	 * Main method to visualize the functionalities of the class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
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

		new Parameters();
		system.Parameters.originalTrainingSet.setData(data);

		InstancePredictor predictor = new InstancePredictor();

		// The classifier read must have been builded before the next line.
		predictor.readSerializedClassifier("C:\\Users\\Flávio\\Documents\\IC - Classificadores\\C45.ser");

		Instances newInstances = new Instances(data);
		Instances predictedClasses = predictor.predict(newInstances);
		data.setClassIndex(data.numAttributes() - 1);
		int successes = 0;

		for (int i = 0; i < predictedClasses.numInstances(); i++) {
			int classPredicted = (int) predictedClasses.instance(i).classValue();
			int classReal = (int) data.instance(i).classValue();
			if (classPredicted == classReal) {
				successes++;
			}
		}

		// Printing the results.
		System.out.println("Results of classification with a classifier builded, saved, and read.\n");
		System.out.println("Number of instances: " + predictedClasses.numInstances());
		System.out.println("Number of successes in the prediction: " + successes);
		float percent = 100 * ((float) successes / (float) predictedClasses.numInstances());
		System.out.println("Percentual of successes in the prediction: " + percent + "%");
	}
}
