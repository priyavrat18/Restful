package com.priyavrat.Restful.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.priyavrat.Restful.Entity.User;

@Component
public interface UserDAOService extends JpaRepository<User,Long> {

	

}
