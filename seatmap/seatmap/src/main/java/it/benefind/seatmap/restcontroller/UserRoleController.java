package it.benefind.seatmap.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.benefind.seatmap.entity.Role;
import it.benefind.seatmap.entity.User;
import it.benefind.seatmap.entity.UserRole;
import it.benefind.seatmap.repository.RoleRepository;
import it.benefind.seatmap.repository.UserRepository;
import it.benefind.seatmap.service.UserRoleService;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    private final UserRoleService userRoleService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserRoleController(
            UserRoleService userRoleService,
            UserRepository userRepository,
            RoleRepository roleRepository) {

        this.userRoleService = userRoleService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/assign")
    public UserRole assignRole(
            @RequestParam Integer userId,
            @RequestParam Integer roleId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return userRoleService.assignRoleToUser(user, role);
    }
}