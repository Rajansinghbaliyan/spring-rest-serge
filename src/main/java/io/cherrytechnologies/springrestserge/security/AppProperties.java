package io.cherrytechnologies.springrestserge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppProperties {

    @Autowired
    private Environment environment;

    private final Map<SecurityConstantsEnum, String> envValue = new HashMap<>();

    Map<SecurityConstantsEnum, String> ENVIRONMENT_VARIABLES = Map
            .of(
                    SecurityConstantsEnum.JWT_EXPIRATION, "jwt.token_expiration",
                    SecurityConstantsEnum.JWT_PREFIX, "jwt.token_prefix",
                    SecurityConstantsEnum.JWT_SECRET, "jwt.token_secret",
                    SecurityConstantsEnum.AUTHENTICATION_HEADER, "authentication.header"
            );


    public Map<SecurityConstantsEnum, String> getEnvValue() {
        ENVIRONMENT_VARIABLES
                .forEach((
                        (securityConstantsEnum, stringValue) ->
                                envValue.put(securityConstantsEnum, environment.getProperty(stringValue))
                ));
        return envValue;
    }
}
