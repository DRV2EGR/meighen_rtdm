package io.meighen.presenter.controller;

import io.meighen.presenter.entity.User;
import io.meighen.presenter.exception.UserNotFoundExeption;
import io.meighen.presenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BasicPrivateController {
    @Autowired
    UserService userService;

    protected User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }
}
