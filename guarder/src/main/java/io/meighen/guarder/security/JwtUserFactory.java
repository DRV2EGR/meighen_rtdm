package io.meighen.guarder.security;



import java.util.List;

import io.meighen.guarder.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * The type Jwt user factory.
 */
public class JwtUserFactory {
    /**
     * Create jwt user.
     *
     * @param user the user
     * @return the jwt user
     */
    public static JwtUser create(User user) {
//        if (user.getRole().getName().equals("ROLE_CUSTOMER") ||
//                user.getRole().getName().equals("ROLE_LOADER") ||
//                user.getRole().getName().equals("ROLE_DRIVER")) {
//            SimpleGrantedAuthority simpleGrantedAuthority1 = new SimpleGrantedAuthority(user.getRole().getName());
//            SimpleGrantedAuthority simpleGrantedAuthority2 = new SimpleGrantedAuthority("ROLE_USER");
//        }
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                List.of(
                        new SimpleGrantedAuthority(user.getRole().getName()),
                        new SimpleGrantedAuthority("ROLE_USER")
                )
        );
    }
}