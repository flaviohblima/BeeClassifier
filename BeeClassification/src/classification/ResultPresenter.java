package classification;

/**
 * 
 * @author Flávio
 *
 *         An interface ResultPrsenter can be implemented in many ways. We chose
 *         to show only texts on it because the only ResultPresenter until now
 *         is the class ScreenPresenter, where we set only the text.
 * 
 *         Feel free to change it!
 */
public interface ResultPresenter {

	public void setText(String resultsInText);
}
