package classification;

import classification.evaluatorMethod.EvalMethod;

public class EvaluatorFactory {

	private EvalMethod eval;
	public static String[] options = system.Constants.evaluatorsClasses;

	/**
	 * Getting the Evaluator that was created by "EvaluatorFactory"
	 * 
	 * @return
	 */
	public EvalMethod getEval() {
		return eval;
	}

	/**
	 * Constructor: "EvaluatorFactory" receives the evaluator algorithm name
	 * desired by the user, and instantiates the class of algorithm.
	 * 
	 * @param algorithm
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public EvaluatorFactory(String algorithm) {

		int i = 0;
		boolean flag = true;
		while (i < options.length && flag) {
			// Compares the name of the evaluator algorithm received by the
			// method and the list of algorithms defined at "options".
			if (algorithm.equals(options[i])) {
				Object o = null;
				try {
					o = Class.forName("classification.evaluatorMethod." + algorithm).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				eval = (EvalMethod) o;
				flag = false;
			}
			i = i + 1;
		}
		if (eval == null) {
			throw new RuntimeException("The Evaluator Class is Invalid");
		}
	}
}
