package alisson.firstSpringSecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Default Welcome";
    }

    @GetMapping("/users")
//    @PreAuthorize("hasAnyRole('MANAGERS','USERS')")
    public String users(){
        return "Authorized user or manager";
    }

    @GetMapping("/managers")
//    @PreAuthorize("hasRole('MANAGERS')")
    public String managers(){
        return "Authorized manager";
    }
}
