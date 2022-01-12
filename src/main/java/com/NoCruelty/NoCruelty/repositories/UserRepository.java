package com.NoCruelty.NoCruelty.repositories;

import com.NoCruelty.NoCruelty.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    
    Optional<User> findByname(String name);
}
