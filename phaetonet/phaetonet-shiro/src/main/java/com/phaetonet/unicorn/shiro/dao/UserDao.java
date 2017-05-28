package com.phaetonet.unicorn.shiro.dao;


import com.phaetonet.unicorn.shiro.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

	User getById(Integer id);

	User getByUserCode(String userCode);
}