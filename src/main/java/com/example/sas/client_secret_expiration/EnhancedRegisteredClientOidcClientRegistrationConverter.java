package com.example.sas.client_secret_expiration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.oidc.OidcClientRegistration;
import org.springframework.security.oauth2.server.authorization.oidc.converter.RegisteredClientOidcClientRegistrationConverter;
import org.springframework.stereotype.Component;

@Component
public final class EnhancedRegisteredClientOidcClientRegistrationConverter implements
    Converter<RegisteredClient, OidcClientRegistration> {

    private static final RegisteredClientOidcClientRegistrationConverter DEFAULT_CONVERTER =
        new RegisteredClientOidcClientRegistrationConverter();

    @Override
    public OidcClientRegistration convert(RegisteredClient registeredClient) {
        OidcClientRegistration oidcClientRegistration = DEFAULT_CONVERTER.convert(registeredClient);
        OidcClientRegistration.Builder builder = OidcClientRegistration.withClaims(oidcClientRegistration.getClaims());
        if (registeredClient.getClientSecret() != null && registeredClient.getClientSecretExpiresAt() != null) {
            builder.clientSecretExpiresAt(registeredClient.getClientSecretExpiresAt());
        }
        return builder.build();
    }
}