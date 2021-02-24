package readability;

abstract public class Redability {
    CheckText checkText;
    double score;

    public Redability(CheckText checkText) {
        this.checkText = checkText;
        countScore();
    }

    public abstract void countScore();

    String getRedability(){String understandingYearsOld;

        switch ((int)Math.round(score)){

            case 1:
                understandingYearsOld = "6";
                break;
            case 2:
                understandingYearsOld = "7";
                break;
            case 3:
                understandingYearsOld = "9";
                break;
            case 4:
                understandingYearsOld = "10";
                break;
            case 5:
                understandingYearsOld = "11";
                break;
            case 6:
                understandingYearsOld = "12";
                break;
            case 7:
                understandingYearsOld = "13";
                break;
            case 8:
                understandingYearsOld = "14";
                break;
            case 9:
                understandingYearsOld = "15";
                break;
            case 10:
                understandingYearsOld = "16";
                break;
            case 11:
                understandingYearsOld = "17";
                break;
            case 12:
                understandingYearsOld = "18";
                break;
            case 13:
                understandingYearsOld = "24";
                break;
            default:
                if (Math.round(score) >= 14){
                    understandingYearsOld = "24";
                } else {
                    understandingYearsOld = "unknown";
                }
        }
        return understandingYearsOld;
    }

    public double getScore() {
        return score;
    }
}
