package com.upgrad.proman.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.proman.service.dao.UserDao;
import com.upgrad.proman.service.entity.UserEntity;
import com.upgrad.proman.service.exception.ResourceNotFoundException;

@Service
public class UserAdminBusinessService {

	@Autowired
	   private UserDao userDao;

	   public UserEntity getUser(final String userUuid)  throws ResourceNotFoundException {
		   UserEntity userEntity =  userDao.getUser(userUuid);
	       if(userEntity == null){
	           throw new ResourceNotFoundException("USR-001", "User not found");
	       }
	       return userEntity;
	   }
}
