package classification.evaluatorMethod;

import java.util.Random;

import weka.core.Instances;

/**
 * 
 * @author Flávio
 *
 *         kFoldCrossValidation extends the CrossValidation class and implements
 *         the EvalMethod interface. The k fold Cross Validation splits the
 *         training set in equally sized folds, generated randomly.
 */
public class kFoldCrossValidation extends CrossValidation {

	// Number k of folds
	private int k;

	/**
	 * Method to set the number of folds to be used at K Fold Cross Validation.
	 * 
	 * @param k
	 */
	public void setKFolds(int k) {
		this.k = k;
	}

	/**
	 * Method to return k value.
	 * 
	 * @return
	 */
	public int getK() {
		return k;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * classification.evaluatorMethod.CrossValidation#splitFolds(classification.
	 * TrainingSet)
	 */
	public void splitFolds() {
		/*
		 * De onde virá esta seed?
		 */
		int seed = 0;
		Random rnd1 = new Random(seed);
		// n: number of examples
		int n = ts.getData().numInstances();
		// m: number of examples in a fold
		int m = (int) Math.floor(n / k);
		// noFold: number of examples without a fold
		int noFold = n % k;
		// trainingSet: array that contains k folder with instances
		folds = new Instances[k];

		// It prints how many folders have m+1 examples
		// System.out.println("The number of folders that have m+1 examples is:
		// " + noFold);

		// Flags array that indicates which instance wasn't chosen yet.
		int[] flagN = new int[n];

		//
		for (int i = 0; i < k; i++) {
			folds[i] = new Instances(ts.getData(), 0);
			int j = 0;
			while (j < m) {
				int nextPosition = rnd1.nextInt(n);

				if (flagN[nextPosition] == 0) {
					folds[i].add(ts.getData().instance(nextPosition));
					flagN[nextPosition] = 1;
					j++;
				}
			}
		}

		// Includes the instances that weren't chosen yet.
		int i = 0;
		while (i < noFold) {

			int nextPosition = rnd1.nextInt(n);

			if (flagN[nextPosition] == 0) {
				folds[i].add(ts.getData().instance(nextPosition));
				flagN[nextPosition] = 1;
				i++;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see classification.evaluatorMethod.EvalMethod#getName()
	 */
	public String getName() {
		return k + " Fold Cross Validation";
	}
}