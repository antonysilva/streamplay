package br.com.streamplay.models;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Created by Antony on 16/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ArticleModelInstrumentdTest {

    @Test
    public void getShortDescription() throws Exception {
        String description = "You can use both folders. Use the first one to test code that use Android framework. Use the second one to test code that are pure java classes. The methods to write tests are almost the same.";

        if (description.length() > 150)
            assertEquals(153, (description.substring(0,149) + "...").length());
        else
            assertEquals(description, "You can use both folders. Use the first one to test code that use Android framework. Use the second one to test code that are pure java classes. The methods to write tests are almost the same.");
    }

}
