package com.example.ribbon.Utils;

import java.util.concurrent.Callable;

public final class MyDelegatingUserContextCallable<V> implements Callable<V> {
    private  Callable<V> delegate;
    private UserContext origionUserContext;

    public MyDelegatingUserContextCallable(Callable<V> delegate, UserContext origionUserContext) {
        this.delegate = delegate;
        this.origionUserContext = origionUserContext;
    }

    @Override
    public V call() throws Exception {
        UserContextHolder.setUserContext(origionUserContext);
        try {
            return delegate.call();
        }finally {
            this.origionUserContext = null;
        }
    }

    public static <V> Callable<V> create(Callable<V> delegate, UserContext userContext){
        return new MyDelegatingUserContextCallable<>(delegate, userContext);
    }
}
