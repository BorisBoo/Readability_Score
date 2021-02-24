package readability;

import java.util.regex.Pattern;

public class CheckText {
    String text;
    static Pattern WORDS_DELIMITER = Pattern.compile("\\PL+");
    static Pattern SENTENCES_DELIMITER = Pattern.compile("[!?.]+");
    static Pattern PATTERN_SYLLABLE = Pattern.compile("([aiouy]|e(?!$))+");
    long wordsCount;
    long sentencesCount;
    int charactersCount;
    long syllablesCount;
    long polysyllables;



    public CheckText(String text) {
        this.text = text;
    }

    static long countSyllables(final String word) {
        return Math.max(1, PATTERN_SYLLABLE.matcher(word).results().count());
    }
    static boolean isPolysyllable(final String word) {
        return countSyllables(word) > 2;
    }


    public void check(){
        charactersCount = text.replaceAll("\\s", "").length();
        wordsCount = WORDS_DELIMITER.splitAsStream(text).count();
        sentencesCount = SENTENCES_DELIMITER.splitAsStream(text).count();
        syllablesCount = WORDS_DELIMITER.splitAsStream(text)
                .mapToLong(CheckText::countSyllables)
                .sum();
        polysyllables = WORDS_DELIMITER.splitAsStream(text)
                .filter(CheckText::isPolysyllable)
                .count();



    }




    @Override
    public String toString() {
        String result = "Words: " + wordsCount + "\n"
                + "Sentences: " + sentencesCount + "\n"
                + "Characters: " + charactersCount + "\n"
                + "Syllables: " + syllablesCount + "\n"
                + "Polysyllables: " + polysyllables + "\n";

        return result;
    }
}
