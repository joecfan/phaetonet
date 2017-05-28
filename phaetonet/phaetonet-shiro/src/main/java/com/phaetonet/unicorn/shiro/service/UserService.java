package com.phaetonet.unicorn.shiro.service;

import com.phaetonet.unicorn.shiro.entity.User;
import com.phaetonet.unicorn.shiro.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {

	public User getById(int id);

	public User getByUserCode(String userCode);

	public User updateUserLogin(User user, boolean isSucess);

}