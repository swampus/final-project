package com.groupj5.homework.controller.v1;

import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user({id})")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO userDTO){

        userService.createUser(userDTO);
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
