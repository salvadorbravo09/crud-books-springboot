package com.salvadorbravo.crudbooks.repository;

import com.salvadorbravo.crudbooks.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    // Query derivada de Spring Data JPA
    // Metodo para buscar un usuario por su nombre de usuario
    // SELECT * FROM user_info WHERE username = ?
    UserInfo findByUsername(String username);
}
