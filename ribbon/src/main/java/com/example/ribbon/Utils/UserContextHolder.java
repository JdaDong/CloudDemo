package com.example.ribbon.Utils;

import org.springframework.util.Assert;

public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext= new ThreadLocal<>();

    public UserContextHolder() {
    }

    public static final UserContext getUserContext(){
        UserContext context  = userContext.get();

        if (null == context){
            context = createEmptyContext();
            setUserContext(context);
        }
        return context;
    }

    public static final void setUserContext(UserContext context){
        Assert.notNull(context, "Only non-null UserContext instances are permitted");
        userContext.set(context);
    }

    public static final UserContext createEmptyContext(){
        return new UserContext();
    }
}
