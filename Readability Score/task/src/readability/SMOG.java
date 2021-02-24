package readability;

public class SMOG extends Redability{
    public SMOG(CheckText checkText) {
        super(checkText);
    }

    @Override
    public void countScore() {
        this.score = 1.043 * Math.sqrt(this.checkText.polysyllables
                * ((double) 30 / this.checkText.sentencesCount))
                + 3.1291;
    }
}
