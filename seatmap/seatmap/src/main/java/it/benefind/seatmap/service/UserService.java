package it.benefind.seatmap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.benefind.seatmap.dto.AddEditUserDTO;
import it.benefind.seatmap.dto.UpdateUserDTO;
import it.benefind.seatmap.entity.User;
import it.benefind.seatmap.mapper.UserMapper;
import it.benefind.seatmap.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public User create(AddEditUserDTO user) throws Exception {
		
		if(user.getId() != null) {
			throw new Exception("l'id deve essere null in fase di creazione");
		}
		if(user.getCf() == null) {
			throw new Exception("CF non presente");
		}
		
		return userRepository.save(userMapper.toEntity(user));
	}
	
	public User edit(UpdateUserDTO updateUser) {
		
		User user = userRepository.findById(updateUser.getId())
		        .orElseThrow(() -> new RuntimeException("User non trovato"));
		
		user.setNome(updateUser.getNome());
        user.setCf(updateUser.getCf());
        user.setPassword(updateUser.getPassword());
        
        return userRepository.save(user);
	}
	
	public void delete(Integer id) {
        userRepository.deleteById(id);
	}
}
