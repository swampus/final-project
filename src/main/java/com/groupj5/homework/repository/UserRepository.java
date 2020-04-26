package com.groupj5.homework.repository;

import com.groupj5.homework.model.v1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserPk(String pk);
    User findByUserPkAndStatus(String pk, Integer status);
    User findByEmailAndPassword(String email, String password);
}
