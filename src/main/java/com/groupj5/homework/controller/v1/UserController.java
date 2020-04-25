package com.groupj5.homework.controller.v1;

import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import com.groupj5.homework.service.UService;
import com.groupj5.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rest/User")
public class UserController {

    private final UserService userService;

    @Autowired
    @Qualifier("divi")
    private UService uService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user({id})")
    public UserDTO getUserById(@PathVariable Long id){
        System.out.println("ID:::: " + id);
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
    }

    @GetMapping("/users/pk({pk})")
    public UserDTO updateUser(@PathVariable String pk){
       return userService.findByUserPersonalCode(pk);
    }

    @GetMapping("/users/pk({pk})/status({status})")
    public UserDTO findByUserPkAndStatus(@PathVariable String pk,
                                         @PathVariable Integer status){
        return userService.findByUserPkAndStatus(pk, status);
    }

}
