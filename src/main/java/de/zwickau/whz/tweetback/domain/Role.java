package de.zwickau.whz.tweetback.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ANONYMOUS, ADMIN, USER;


    @Override
    public String getAuthority() {
        return this.name();
    }
}
