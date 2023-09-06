package test.utility;

import org.junit.Test;

import utility.Score;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoreTest {

    public Score score;

    public ScoreTest() {
        try {
            this.score = new Score(new File("res/tmp/ScoreTest.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNbDeathTest() {
        assertEquals(3, this.score.getNbDeath());
    }

    @Test
    public void getNbMonsterKillTest() {
        assertEquals(0, this.score.getNbMonsterKills());
    }

    @Test
    public void getNbChestsOpenTest() {
        assertEquals(0, this.score.getNbChestsOpen());
    }

    @Test
    public void getNbRoomFoundTest() {
        assertEquals(0, this.score.getNbRoomFound());
    }

    @Test
    public void getNbEtageTest() {
        assertEquals(0, this.score.getNbEtage());
    }

    @Test
    public void saveTest() {
        try {
            this.score = new Score(new File("res/tmp/ScoreTest.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.score.setNbDeath(1);
        this.score.setNbMonsterKill(2);
        this.score.setNbChestsOpen(3);
        this.score.setNbRoomFound(4);
        this.score.setNbEtage(5);
        this.score.save();
        assertEquals(1, this.score.getNbDeath());
        assertEquals(2, this.score.getNbMonsterKills());
        assertEquals(3, this.score.getNbChestsOpen());
        assertEquals(4, this.score.getNbRoomFound());
        assertEquals(5, this.score.getNbEtage());
    }

    @Test
    public void resetTest() {
        this.score.reset();
        assertEquals(0, this.score.getNbDeath());
        assertEquals(0, this.score.getNbMonsterKills());
        assertEquals(0, this.score.getNbChestsOpen());
        assertEquals(0, this.score.getNbRoomFound());
        assertEquals(0, this.score.getNbEtage());
    }

    @Test
    public void toStringTest() {
        assertEquals("Score [nbDeath=3, nbMonsterKill=11, nbChestsOpen=2, nbRoomFound=0, nbEtage=1]",
                this.score.toString());
    }
}
