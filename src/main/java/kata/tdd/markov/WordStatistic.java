package kata.tdd.markov;

import java.util.Objects;

public class WordStatistic {
    private String word;
    private String followedWord;
    private Double percentage;

    public WordStatistic() {
    }

    public WordStatistic(String word, String followedWord, Double percentage) {
        this.word = word;
        this.followedWord = followedWord;
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordStatistic that = (WordStatistic) o;
        return Objects.equals(word, that.word) &&
                Objects.equals(followedWord, that.followedWord) &&
                Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, followedWord, percentage);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getFollowedWord() {
        return followedWord;
    }

    public void setFollowedWord(String followedWord) {
        this.followedWord = followedWord;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
