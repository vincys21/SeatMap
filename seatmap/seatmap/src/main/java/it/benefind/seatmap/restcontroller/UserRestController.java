package it.benefind.seatmap.restcontroller;

import it.benefind.seatmap.dto.AddEditUserDTO;
import it.benefind.seatmap.dto.UpdateUserDTO;
import it.benefind.seatmap.entity.User;
import it.benefind.seatmap.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> findAll() { 
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public User create(@RequestBody AddEditUserDTO userDTO) throws Exception {
        return userService.create(userDTO);
    }

    @PutMapping("/edit")
    public User edit(@RequestBody UpdateUserDTO user) {
        return userService.edit(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
