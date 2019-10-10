package lk.codelabs.OAuthServer.OAuthServer.repository;

import lk.codelabs.OAuthServer.OAuthServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String name);

}
