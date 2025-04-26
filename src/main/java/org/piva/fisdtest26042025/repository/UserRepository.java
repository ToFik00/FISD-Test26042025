package org.piva.fisdtest26042025.repository;

import org.piva.fisdtest26042025.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByEnabled(boolean enabled);
    Boolean existsByEmail(String email);
}
