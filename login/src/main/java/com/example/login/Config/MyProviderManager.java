package com.example.login.Config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

import java.util.List;

public class MyProviderManager extends ProviderManager {
    public MyProviderManager(AuthenticationProvider... providers) {
        super(providers);
    }

    public MyProviderManager(List<AuthenticationProvider> providers) {
        super(providers);
    }

    public MyProviderManager(List<AuthenticationProvider> providers, AuthenticationManager parent) {
        super(providers, parent);
    }

    @Override
    public List<AuthenticationProvider> getProviders() {
        return super.getProviders();
    }
}
