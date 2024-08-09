package com.lengper.cap2024.database;

import com.lengper.cap2024.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {

    List<UserRole> findByUser_UserId(Integer userId);

}
