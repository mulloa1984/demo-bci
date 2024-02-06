package com.mulloa.demobci.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mulloa.demobci.Model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByUsername(String username); 
}
