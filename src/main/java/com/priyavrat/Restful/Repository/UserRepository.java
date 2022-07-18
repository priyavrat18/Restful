package com.priyavrat.Restful.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.priyavrat.Restful.Entity.User;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {

	

}
