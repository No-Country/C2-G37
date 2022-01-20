package com.NoCruelty.NoCruelty.repositories;

import com.NoCruelty.NoCruelty.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
    Optional<User> findByname(String name);

    public User getById(String id);

    Optional<User> findByUsername(String username);

}
