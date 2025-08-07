package user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserDto userDto;
    private final UserService userService;

    @Autowired
    public UserController (UserDto userDto, UserService userService){
        this.userDto = userDto;
        this.userService = userService;
    }

    /**@GetMapping("{/id}")
    public UserDto userById(@PathVariable Long id){
        return userService. ;
    }**/

    @GetMapping("{/id}")
    public ResponseEntity<Optional> userById(@PathVariable Long id){
        return userService. ;
    }
}
