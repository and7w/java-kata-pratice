package kata.tdd.markov;

/*
@Input : un texte
1. texte vide = [""]
2. "hommes" = [{word = hommes, followedWord = "", percentage = "100"}]

3. "les hommes" = [{word = les, followedWord = "homme", percentage = "100"},[{word = hommes, followedWord = "", percentage = "100"}]]
4. "les hommes libres les" = "[{word = les, [{followedWord="homme", percentage ="50"},{followedWord="", percentage ="50"}],
                                {word = hommes, [{followedWord="libre", percentage ="100"}],
                                 {word = libres, [{followedWord="les", percentage ="100"}],
                                ]
4. "les hommes libres les" = [{word = les, followedWord = "homme", percentage = "50"},
                                [{word = hommes, followedWord = "libres", percentage = "100"}],
                                [{word = libres, followedWord = "les", percentage = "100"}],
                                [{word = les, followedWord = "", percentage = "50"}]]

5. "les hommes libres  et les hommes fachés" = [{word = les, followedWord = "hommes", percentage = "100"},
                                [{word = hommes, followedWord = "libres", percentage = "50"}],
                                [{word = libres, followedWord = "et", percentage = "100"}],
                                [{word = et, followedWord = "les", percentage = "100"}],
                                [{word = hommes, followedWord = "faches", percentage = "50"}],
                                [{word = faches, followedWord = "", percentage = "100"}]]


 */


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextAnalyserTest {

    @Test
    public void shouldReturnEmptyResultForEmptyText(){
        //given
        TextAnalyser textAnalyser = new TextAnalyser();

        List<WordStatistic> statistics = textAnalyser.analyse("");

        //then
        Assertions.assertThat(statistics).isNotNull();
    }


    @Test
    public void shouldReturnEmptyWordAsFollowedWordAnd100AsPercentage(){
        //given
        TextAnalyser textAnalyser = new TextAnalyser();

        //when
        WordStatistic statistics = textAnalyser.analyse("hommes").get(0);

        //then
        WordStatistic expectedStats = new WordStatistic("hommes", "", 100.0);
        Assertions.assertThat(statistics).isEqualToComparingFieldByField(expectedStats);

    }
    //3. "les hommes" = [{word = les, followedWord = "homme", percentage = "100"},[{word = hommes, followedWord = "", percentage = "100"}]]

    @Test
    public void shouldReturn100ForTwoDistinctWord(){
        //given
        TextAnalyser textAnalyser = new TextAnalyser();

        //when
        List<WordStatistic> statistics = textAnalyser.analyse("les hommes");

        //then
        Assertions.assertThat(statistics.size()).isEqualTo(2);
        WordStatistic expectedStat1s = new WordStatistic("les", "hommes", 100.0);
        WordStatistic expectedStat2s = new WordStatistic("hommes", "", 100.0);
        Assertions.assertThat(statistics.get(0)).isEqualToComparingFieldByField(expectedStat1s);
        Assertions.assertThat(statistics.get(1)).isEqualToComparingFieldByField(expectedStat2s);

    }

    @Test
    public void shouldReturn100ForThreeDistinctWord(){
        //given
        TextAnalyser textAnalyser = new TextAnalyser();

        //when
        List<WordStatistic> statistics = textAnalyser.analyse("les hommes forts");

        //then
        Assertions.assertThat(statistics.size()).isEqualTo(3);
        WordStatistic expectedStat1s = new WordStatistic("les", "hommes", 100.0);
        WordStatistic expectedStat2s = new WordStatistic("hommes", "forts", 100.0);
        WordStatistic expectedStat3s = new WordStatistic("forts", "", 100.0);
        Assertions.assertThat(statistics.get(0)).isEqualToComparingFieldByField(expectedStat1s);
        Assertions.assertThat(statistics.get(1)).isEqualToComparingFieldByField(expectedStat2s);
        Assertions.assertThat(statistics.get(2)).isEqualToComparingFieldByField(expectedStat3s);

    }


    @Test
    public void shouldReturn50ForWordLes(){
        //given
        TextAnalyser textAnalyser = new TextAnalyser();

        //when
        List<WordStatistic> statistics = textAnalyser.analyse("les hommes libres les");

        //then
        Assertions.assertThat(statistics.size()).isEqualTo(4);
        WordStatistic expectedStat1s = new WordStatistic("les", "hommes", 50.0);
        WordStatistic expectedStat2s = new WordStatistic("hommes", "libres", 100.0);
        WordStatistic expectedStat3s = new WordStatistic("libres", "les", 100.0);
        WordStatistic expectedStat4s = new WordStatistic("les", "", 50.0);
        Assertions.assertThat(statistics.get(0)).isEqualToComparingFieldByField(expectedStat1s);
        Assertions.assertThat(statistics.get(1)).isEqualToComparingFieldByField(expectedStat2s);
        Assertions.assertThat(statistics.get(2)).isEqualToComparingFieldByField(expectedStat3s);
        Assertions.assertThat(statistics.get(3)).isEqualToComparingFieldByField(expectedStat4s);

    }

    @Test
    public void shouldReturn50ForWordLesYYY(){
        //given
        TextAnalyser textAnalyser = new TextAnalyser();

        //when
        List<WordStatistic> statistics = textAnalyser.analyse("les hommes libres et les hommes faches");

        //then
        Assertions.assertThat(statistics.size()).isEqualTo(6);
        WordStatistic expectedStat1s = new WordStatistic("les", "hommes", 100.0);
        WordStatistic expectedStat2s = new WordStatistic("hommes", "libres", 50.0);
        WordStatistic expectedStat3s = new WordStatistic("libres", "et", 100.0);
        WordStatistic expectedStat4s = new WordStatistic("et", "les", 100.0);
        WordStatistic expectedStat5s = new WordStatistic("hommes", "faches", 50.0);
        WordStatistic expectedStat6s = new WordStatistic("faches", "", 100.0);

        Assertions.assertThat(statistics.get(0)).isEqualToComparingFieldByField(expectedStat1s);
        Assertions.assertThat(statistics.get(1)).isEqualToComparingFieldByField(expectedStat2s);
        Assertions.assertThat(statistics.get(2)).isEqualToComparingFieldByField(expectedStat3s);
        Assertions.assertThat(statistics.get(3)).isEqualToComparingFieldByField(expectedStat4s);
        Assertions.assertThat(statistics.get(4)).isEqualToComparingFieldByField(expectedStat5s);
        Assertions.assertThat(statistics.get(5)).isEqualToComparingFieldByField(expectedStat6s);

    }





}
