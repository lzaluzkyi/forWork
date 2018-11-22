package ua.servise;

import java.util.List;

import ua.entity.UserEntity;

public interface UserService {

    void save(UserEntity entity);

	UserEntity findByEmail(String name);

	List<UserEntity> findAll();

	UserEntity findOne(Integer id);

	void createExsel(Integer id);

	void update(UserEntity entity);

}
