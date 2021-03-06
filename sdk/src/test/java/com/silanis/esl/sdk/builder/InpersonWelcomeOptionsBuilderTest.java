package com.silanis.esl.sdk.builder;

import com.silanis.esl.sdk.InpersonWelcomeOptions;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class InpersonWelcomeOptionsBuilderTest {
    @Test
    public void buildWithSpecifiedValues() {
        InpersonWelcomeOptionsBuilder builder = InpersonWelcomeOptionsBuilder.newInpersonWelcomeOptions();
        builder.withTitle();
        builder.withBody();
        builder.withRecipientName();
        builder.withRecipientEmail();
        builder.withRecipientActionRequired();
        builder.withRecipientRole();
        builder.withRecipientStatus();

        InpersonWelcomeOptions result = builder.build();
        assertThat( "build returned a null object", result, is( notNullValue() ) );
        assertTrue( "'title' was not set correctly", result.getTitle());
        assertTrue( "'body' was not set correctly", result.getBody());
        assertTrue( "'recipientName' was not set correctly", result.getRecipientName());
        assertTrue( "'recipientEmail' was not set correctly", result.getRecipientEmail());
        assertTrue( "'recipientActionRequired' was not set correctly", result.getRecipientActionRequired());
        assertTrue( "'recipientRole' was not set correctly", result.getRecipientRole());
        assertTrue( "'recipientStatus' was not set correctly", result.getRecipientStatus());

    }
}
