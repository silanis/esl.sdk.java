package com.silanis.esl.sdk.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.silanis.esl.sdk.io.Streams.close;

/**
 * Helper class to open the properties file
 */
public class Props {
    public static Properties get() {
        Properties signers = new Properties();
        InputStream in = null;

        try {
            in = Props.class.getClassLoader().getResourceAsStream( "signers.properties" );
            if (in == null) throw new IOException( "Could not find signers.properties" );
            signers.load( in );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in);
        }

        return signers;
    }
}
