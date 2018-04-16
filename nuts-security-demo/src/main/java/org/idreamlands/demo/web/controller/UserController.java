/**
 *
 */
package org.idreamlands.demo.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/me")
    public Object getCurrentUser(Authentication user, HttpServletRequest request) {
        return user;
    }


}
