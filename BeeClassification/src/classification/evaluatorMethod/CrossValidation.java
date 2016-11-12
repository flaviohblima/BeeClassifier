package classification.evaluatorMethod;

import classification.TrainingSet;
import classification.classifiers.BeeClassifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author Flávio
 *
 *         CrossValidation implements the EvalMethod interface. There are more
 *         than one type of Cross Validation, that's why this class is abstract.
 */
public abstract class CrossValidation implements EvalMethod {

	private BeeClassifier bc;
	protected TrainingSet ts;
	protected Instances[] folds;

	/**
	 * Method to break the training set in folds. That occurs to turn possible
	 * the training and testing of the classifier.
	 * 
	 * @param ts
	 */
	public abstract void splitFolds();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * classification.evaluatorMethod.EvalMethod#setTrainingSet(classification.
	 * TrainingSet)
	 */
	public void setTrainingSet(TrainingSet ts) {
		this.ts = ts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.evaluatorMethod.EvalMethod#evaluate(classification.
	 * classifiers.BeeClassifier)
	 */
	public float evaluate(BeeClassifier bc) {
		this.bc = bc;
		return crossValidation();
	}

	/**
	 * Method that implements the Cross Validation Algorithm. It uses the folds
	 * already split. It takes a fold to test after training the classifier with
	 * all others folds. After that, it determines the successes of the
	 * classifier during this tests.
	 * 
	 * @return
	 */
	public float crossValidation() {
		float successK = 0;
		for (int i = 0; i < folds.length; i++) {
			Instances trainingSetK = new Instances(folds[i], 0);
			Instances testSetK = new Instances(folds[i], 0);

			// Making testSetK
			testSetK = folds[i];

			// Making trainingSetK
			for (int j = 0; j < folds.length; j++) {
				int length = folds[j].numInstances();
				if (j != i) {
					for (int l = 0; l < length; l++) {
						trainingSetK.add(folds[j].instance(l));
					}
				}
			}

			// Train the classifier with training set K.
			bc.train(trainingSetK);

			// Successes until Kth training.
			successK = successK + success(testSetK);
		}

		float cv = 100 * successK / folds.length;
		return cv;
	}

	/**
	 * Method that helps the Cross Validation Method. It receives the test fold
	 * and finds the number of successes of the classifier.
	 * 
	 * @param testSetK
	 * @return
	 */
	private float success(Instances testSetK) {
		int successSum = 0;

		// Last attribute becomes a class.
		testSetK.setClassIndex(testSetK.numAttributes() - 1);

		for (int i = 0; i < testSetK.numInstances(); i++) {
			Instance test = testSetK.instance(i);
			int correctClass = (int) testSetK.instance(i).classValue();
			int newClassification = (int) bc.classify(test);
			// System.out.println(correctClass);
			// System.out.println(newClass);

			// Tests the success of a classifier
			if (correctClass == newClassification) {
				successSum++;
			}

			// System.out.println("Class of example "+(i+1)+" : "+ newClass);
		}

		return (float) successSum / testSetK.numInstances();
	}
}
