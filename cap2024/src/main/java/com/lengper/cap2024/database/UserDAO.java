package com.lengper.cap2024.database;

import com.lengper.cap2024.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email );

}
