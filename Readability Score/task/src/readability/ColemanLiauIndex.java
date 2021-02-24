package readability;

public class ColemanLiauIndex extends Redability{
    public ColemanLiauIndex(CheckText checkText) {
        super(checkText);
    }

    @Override
    public void countScore() {
        double l = 100.*checkText.charactersCount / checkText.wordsCount;
        double s = 100.*checkText.sentencesCount / checkText.wordsCount;
        this.score = 0.0588 * l - 0.296 * s - 15.8;
    }
}
