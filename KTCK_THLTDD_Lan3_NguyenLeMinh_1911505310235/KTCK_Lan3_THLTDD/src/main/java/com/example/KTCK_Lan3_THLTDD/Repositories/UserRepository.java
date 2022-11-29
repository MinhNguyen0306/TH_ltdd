package com.example.KTCK_Lan3_THLTDD.Repositories;

import com.example.KTCK_Lan3_THLTDD.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select email from users where email = :email", nativeQuery = true)
    List<String> checkUserByEmail(@Param("email") String email);

    @Query(value = "select pass from users where email = :email", nativeQuery = true)
    String checkUserPasswordByEmail(@Param("email") String email);

    @Query(value = "select * from users where email = :email", nativeQuery = true)
    User getUserByEmail(@Param("email") String email);
}
