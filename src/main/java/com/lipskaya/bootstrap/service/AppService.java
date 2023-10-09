package com.lipskaya.bootstrap.service;

import com.lipskaya.bootstrap.config.exception.LoginException;
import com.lipskaya.bootstrap.model.Role;
import com.lipskaya.bootstrap.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

public interface AppService extends UserDetailsService {
    List<User> findAllUsers();

    User findUser(Long userId) throws IllegalArgumentException;

    void deleteUser(Long userId);

    Iterable<Role> findAllRoles();

    void authenticateOrLogout(Model model, HttpSession session, LoginException authenticationException, String authenticationName);

    //boolean saveUser(User user, BindingResult bindingResult, Model model);

    void insertUser(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes);

    void updateUser(User user, BindingResult bindingResult, RedirectAttributes redirectAttributes);
}