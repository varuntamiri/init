package com.technoglitz;


import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ParameterizedTest {

@Parameters

public static Collection<Object[]> data() {

return Arrays.asList(new Object [][]{

/* Sport Nation year totWinners */

{ "basket", "usa", 2002, 5 },

{ "soccer", "argentina", 2003, 2 },
  
{ "tennis", "spain", 2004, 10 },
  
{ "chess", "ireland", 2005, 0 },
  
{ "eatingbananas", "italy", 2006, 20 }

});

}

private final String sport;

private final String nation;

private final int year;

private final int totWinners;

public ParameterizedTest(String sport, String nation, int year, int totWinners) {

this.sport = sport;

this.nation = nation;

this.year = year;

this.totWinners = totWinners;

}

@Test

public void test() {

Assert.assertTrue(isDataCorrect(sport, nation, year, totWinners));

}

private boolean isDataCorrect(String sport2, String nation2, int year2, int totWinners2) {

return true;

}

}