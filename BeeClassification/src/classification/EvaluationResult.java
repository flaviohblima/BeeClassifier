package classification;

import java.text.DecimalFormat;

import classification.classifiers.BeeClassifier;
import system.Constants;
import system.Parameters;

/**
 * 
 * @author Flávio
 *
 *         EvaluationResult turns the resulting floats from Evaluation of
 *         Classifiers in text and, if the user want to use the floats, this
 *         class offer it too.
 */
public class EvaluationResult {

	private float[] results;
	private BeeClassifier[] classifiers;
	private String evalName;

	/**
	 * Receives a array of floats.
	 * 
	 * @param classifiers
	 * @param results
	 */
	public EvaluationResult(BeeClassifier[] classifiers, float[] results) {
		this.results = results;
		this.classifiers = classifiers;
	}

	/**
	 * Setting the evaluator name.
	 * 
	 * @param simpleName
	 */
	public void setEvaluatorName(String simpleName) {
		evalName = simpleName;
	}

	/**
	 * Return the results in a array of floats.
	 * 
	 * @return
	 */
	public float[] resultsInFloat() {
		return results;
	}

	/**
	 * Return the results in a awesome text.
	 * 
	 * @return
	 */
	public String resultsInText() {
		DecimalFormat df = new DecimalFormat("00.0#");
		String text = evalName;

		// Finding the best classifier.
		float theBest = 0;
		int index = 0;
		for (int i = 0; i < classifiers.length; i++) {
			if (results[i] > theBest) {
				theBest = results[i];
				index = i;
			}
		}

		int spaces = text.length();
		while (spaces < 29) {
			text = text + " ";
			spaces = spaces + 1;
		}
		text = text + " | Successes(%)\n";

		String[] txt = new String[classifiers.length];
		for (int i = 0; i < classifiers.length; i++) {
			String cvClassifier = df.format(results[i]);
			txt[i] = "\n" + classifiers[i].getName();
			spaces = classifiers[i].getName().length();
			while (spaces < 30) {
				txt[i] = txt[i] + " ";
				spaces = spaces + 1;
			}
			txt[i] = txt[i] + "|  " + cvClassifier;
		}

		// Bubble sorting.
		for (int i = 0; i < classifiers.length; i++) {
			for (int j = 0; j < (classifiers.length - 1); j++) {
				int num = Float.compare(results[j + 1], results[j]);
				if (num > 0) {
					String recipient = txt[j];
					txt[j] = txt[j + 1];
					txt[j + 1] = recipient;

					float aux = results[j];
					results[j] = results[j + 1];
					results[j + 1] = aux;
				}
			}
		}

		// Writing the classifiers sorted.
		for (int i = 0; i < classifiers.length; i++) {
			text = text + txt[i];
		}

		String cvTheBest = df.format(theBest);
		text = text + "\n\n" + "Best classifier: " + classifiers[index].getName() + " (" + cvTheBest + "%)";
		return text;
	}

	public static void main(String[] args) {
		boolean[] selectedClassifiers = { true, true, true, true, true, true, true };
		new Constants();
		new Parameters();
		BeeClassifier[] classifiers = new ClassifierFactory(selectedClassifiers,
				system.Parameters.classifiersParameters).getClassifiers();
		float[] results = { 2.0f, 3.0f, 5.0f, 8.0f, 4.0f, 4.5f, 10.0f };

		EvaluationResult evalResults = new EvaluationResult(classifiers, results);
		evalResults.setEvaluatorName("Eval is null");

		System.out.println(evalResults.resultsInText());
	}

}
