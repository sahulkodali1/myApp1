package com.myApp1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp1.Model.User;

/**
 * @author SAHUL this is user repository
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

}
