package edu.sm_devguid.ecommerce.backend.infraestructure.rest;

import edu.sm_devguid.ecommerce.backend.application.UserService;
import edu.sm_devguid.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/users")
//http://localhost:8085/api/v1/users
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    //http://localhost:8085/api/v1/users/1
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
