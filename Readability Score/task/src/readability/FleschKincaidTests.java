package readability;

public class FleschKincaidTests extends Redability{
    public FleschKincaidTests(CheckText checkText) {
        super(checkText);
    }

    @Override
    public void countScore() {
        this.score = 0.39 * ((double) this.checkText.wordsCount / this.checkText.sentencesCount)
                + 11.8 * ((double) this.checkText.syllablesCount / this.checkText.wordsCount) - 15.59;
    }
}
