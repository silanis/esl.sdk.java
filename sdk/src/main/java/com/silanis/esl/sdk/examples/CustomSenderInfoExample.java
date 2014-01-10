package com.silanis.esl.sdk.examples;

import com.silanis.esl.sdk.DocumentPackage;
import com.silanis.esl.sdk.DocumentType;
import com.silanis.esl.sdk.PackageId;
import com.silanis.esl.sdk.builder.AccountMemberBuilder;
import com.silanis.esl.sdk.builder.SenderInfoBuilder;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static com.silanis.esl.sdk.builder.DocumentBuilder.newDocumentWithName;
import static com.silanis.esl.sdk.builder.PackageBuilder.newPackageNamed;
import static com.silanis.esl.sdk.builder.SignatureBuilder.signatureFor;
import static com.silanis.esl.sdk.builder.SignerBuilder.newSignerWithEmail;
import static org.joda.time.DateMidnight.now;

public class CustomSenderInfoExample extends SDKSample {

    public String email1;

    public static final String senderFirstName = "Rob";
    public static final String senderSecondName = "Mason";
    public static final String senderTitle = "Chief Vizier";
    public static final String senderCompany = "The Masons";

    public static void main( String... args ) {
        new CustomSenderInfoExample( Props.get() ).run();
    }

    public CustomSenderInfoExample( Properties props ) {
        this( props.getProperty( "api.key" ),
                props.getProperty( "api.url" ),
                props.getProperty( "1.email" ) );
    }

    public CustomSenderInfoExample( String apiKey, String apiUrl, String email1 ) {
        super( apiKey, apiUrl );
        this.email1 = email1;
    }

    public void execute() {

        // Note on the custom sender information:
        //
        // The custom sender information is disregarded if the sender is one of the signers for the process.
        // The custom sender must already be a member of the account
        eslClient.getAccountService().inviteUser(
                AccountMemberBuilder.newAccountMember(email1 )
                        .withFirstName( "firstName" )
                        .withLastName( "lastName" )
                        .withCompany( "company" )
                        .withTitle( "title" )
                        .withLanguage( "language" )
                        .withPhoneNumber( "phoneNumber" )
                        .build() );

        DocumentPackage superDuperPackage = newPackageNamed( "CustomSenderInfoExample " + new SimpleDateFormat( "HH:mm:ss" ).format( new Date() ) )
                .withSenderInfo( SenderInfoBuilder.newSenderInfo(email1)
                        .withName( senderFirstName, senderSecondName )
                        .withTitle( senderTitle )
                        .withCompany( senderCompany ) )
                .describedAs( "This is a package created using the e-SignLive SDK" )
                .expiresAt( now().plusMonths( 1 ).toDate() )
                .withEmailMessage( "This message should be delivered to all signers" )
                .build();

        packageId = eslClient.createPackage( superDuperPackage );
    }
}
