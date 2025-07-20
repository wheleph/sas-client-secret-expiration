package com.example.sas.client_secret_expiration;

import java.time.Duration;
import java.time.Instant;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.oidc.OidcClientRegistration;
import org.springframework.security.oauth2.server.authorization.oidc.converter.OidcClientRegistrationRegisteredClientConverter;
import org.springframework.stereotype.Component;

@Component
public final class EnhancedOidcClientRegistrationRegisteredClientConverter
    implements Converter<OidcClientRegistration, RegisteredClient> {

    private static final OidcClientRegistrationRegisteredClientConverter DEFAULT_CLIENT_REGISTRATION_CONVERTER =
        new OidcClientRegistrationRegisteredClientConverter();

    @Override
    public RegisteredClient convert(OidcClientRegistration clientRegistration) {
        RegisteredClient registeredClient = DEFAULT_CLIENT_REGISTRATION_CONVERTER.convert(clientRegistration);
        var registeredClientBuilder = RegisteredClient.from(registeredClient);

        var clientSecretExpiresAt = Instant.now().plus(Duration.ofDays(30));
        registeredClientBuilder.clientSecretExpiresAt(clientSecretExpiresAt);

        return registeredClientBuilder.build();
    }
}

