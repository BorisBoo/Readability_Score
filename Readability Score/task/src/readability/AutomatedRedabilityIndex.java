package readability;

public class AutomatedRedabilityIndex extends Redability{
    public AutomatedRedabilityIndex(CheckText checkText) {
        super(checkText);
    }

    @Override
    public void countScore() {
        score = 4.71 * ((double) this.checkText.charactersCount / this.checkText.wordsCount)
                + 0.5 * ((double) this.checkText.wordsCount / this.checkText.sentencesCount) - 21.43;
    }
}
