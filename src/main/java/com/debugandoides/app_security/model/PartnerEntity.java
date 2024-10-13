package com.debugandoides.app_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;

@Entity
@Table(name="partners")
public class PartnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String clientId;
    private String clientName;
    private String clientSecret;
    private String scopes;
    private String grantTypes;
    private String authenticationMethods;
    private String redirectUri;
    private String redirectUriLogout;

    public PartnerEntity() {
    }

    public PartnerEntity(BigInteger id, String clientId, String clientName, String clientSecret, String scopes, String grantTypes, String authenticationMethods, String redirectUri, String redirectUriLogout) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientSecret = clientSecret;
        this.scopes = scopes;
        this.grantTypes = grantTypes;
        this.authenticationMethods = authenticationMethods;
        this.redirectUri = redirectUri;
        this.redirectUriLogout = redirectUriLogout;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getAuthenticationMethods() {
        return authenticationMethods;
    }

    public void setAuthenticationMethods(String authenticationMethods) {
        this.authenticationMethods = authenticationMethods;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getRedirectUriLogout() {
        return redirectUriLogout;
    }

    public void setRedirectUriLogout(String redirectUriLogout) {
        this.redirectUriLogout = redirectUriLogout;
    }
}
