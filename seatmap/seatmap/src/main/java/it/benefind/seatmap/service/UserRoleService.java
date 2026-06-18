package it.benefind.seatmap.service;

import org.springframework.stereotype.Service;

import it.benefind.seatmap.entity.Role;
import it.benefind.seatmap.entity.User;
import it.benefind.seatmap.entity.UserRole;
import it.benefind.seatmap.repository.UserRoleRepository;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole assignRoleToUser(User user, Role role) {

        UserRole userRole = new UserRole();

        userRole.setUser(user);
        userRole.setRole(role);

        return userRoleRepository.save(userRole);
    }
}