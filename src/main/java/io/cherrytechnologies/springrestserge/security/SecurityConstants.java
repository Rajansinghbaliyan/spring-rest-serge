package io.cherrytechnologies.springrestserge.security;

import io.cherrytechnologies.springrestserge.SpringApplicationContext;

public class SecurityConstants {
    public static String getTokenSecret(){
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBeans("AppProperties");
        return appProperties.getEnvValue().get(SecurityConstantsEnum.JWT_SECRET);
    }

    public static String getJwtPrefix(){
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBeans("AppProperties");
        return appProperties.getEnvValue().get(SecurityConstantsEnum.JWT_PREFIX);
    }

    public static long getTokenExpiration(){
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBeans("AppProperties");
        return Long.parseLong(appProperties.getEnvValue().get(SecurityConstantsEnum.JWT_EXPIRATION));
    }

    public static String getAuthenticationHeader(){
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBeans("AppProperties");
        return appProperties.getEnvValue().get(SecurityConstantsEnum.AUTHENTICATION_HEADER);
    }

}
