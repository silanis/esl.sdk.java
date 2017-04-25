package com.silanis.esl.sdk.builder;

import com.silanis.esl.sdk.ExternalSigningAuth;
import com.silanis.esl.sdk.internal.Asserts;

/**
 * This feature is not yet completed.
 * It is NOT recommended to be used it right now, because we expect some changes in model.
 */

public class ExternalSigningAuthBuilder {

    private String providerKey;
    private String identityInfo;

    private ExternalSigningAuthBuilder(String providerKey) {
        this.providerKey = providerKey;
    }

    public static ExternalSigningAuthBuilder forProvider(String providerKey) {
        return new ExternalSigningAuthBuilder(providerKey);
    }

    public ExternalSigningAuthBuilder withIdentityInfo(String identityInfo) {
        this.identityInfo = identityInfo;
        return this;
    }

    public ExternalSigningAuth build() {
        Asserts.notNullOrEmpty(providerKey,"providerKey");
        ExternalSigningAuth externalSigningAuth = new ExternalSigningAuth(this.providerKey);
        externalSigningAuth.setIdentityInfo(this.identityInfo);
        return externalSigningAuth;
    }

}
