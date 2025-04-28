package com.Gestion_Note.Note.Repository;

import com.Gestion_Note.Note.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int UserId);
}
