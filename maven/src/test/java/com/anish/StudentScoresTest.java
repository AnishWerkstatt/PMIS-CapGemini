package com.anish;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentScoresTest {

    @Test
    public void shouldCalculateAverage() {
        assertEquals(84.25, StudentScores.average(new int[]{82, 91, 76, 88}), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectEmptyScores() {
        StudentScores.average(new int[]{});
    }
}
