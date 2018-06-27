package com.beyondbanking.ssh;

import com.beyondbanking.ssh.controllers.LocationController;
import com.beyondbanking.ssh.controllers.SuggestionsApplication;
import com.beyondbanking.ssh.specific.Suggestions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) @SpringBootTest(classes = SuggestionsApplication.class) public class SuggestionsApplicationTests {

    @InjectMocks LocationController locationController;

    @Test public void test() {
        HttpEntity<Suggestions> suggestionsHttpEntity =
            locationController.nearbySearch("52.312662,4.948121", "restaurant", "3");
        Assert.assertNotNull((Suggestions) suggestionsHttpEntity.getBody());
    }


}
