package com.upgrad.proman.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.upgrad.proman.service.dao.UserDao;
import com.upgrad.proman.service.entity.RoleEntity;
import com.upgrad.proman.service.entity.UserAuthTokenEntity;
import com.upgrad.proman.service.entity.UserEntity;
import com.upgrad.proman.service.exception.ResourceNotFoundException;
import com.upgrad.proman.service.exception.UnauthorizedException;

@Service
public class UserAdminBusinessService {

	@Autowired
	   private UserDao userDao;
	
	@Autowired
	   private PasswordCryptographyProvider cryptographyProvider;

	public UserEntity getUser(final String userUuid, final String authorizationToken) throws ResourceNotFoundException,
    UnauthorizedException {

UserAuthTokenEntity userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);
RoleEntity role = userAuthTokenEntity.getUser().getRole();
if(role != null && role.getUuid() == 101){
    UserEntity userEntity =  userDao.getUser(userUuid);
    if(userEntity == null){
        throw new ResourceNotFoundException("USR-001", "User not found");
    }
    return userEntity;
}
throw new UnauthorizedException("ATH-002", "you are not authorized to fetch user details");
}
	   
	   @Transactional(propagation = Propagation.REQUIRED)
	   public UserEntity createUser(final UserEntity userEntity){

	          String password = userEntity.getPassword();
	          if(password == null){
	              userEntity.setPassword("proman@123");
	          }
	          String[] encryptedText = cryptographyProvider.encrypt(userEntity.getPassword());
	          userEntity.setSalt(encryptedText[0]);
	          userEntity.setPassword(encryptedText[1]);
	          return userDao.createUser(userEntity);

	      }
}
