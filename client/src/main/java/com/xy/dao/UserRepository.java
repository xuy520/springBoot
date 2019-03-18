package com.xy.dao;

import com.xy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Query("select t from User t where t.name =:name")
    User findByUsername(@Param("name") String name);

}
