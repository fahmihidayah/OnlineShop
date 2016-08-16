package onlineShop.dao;

import onlineShop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Bartos on 16.08.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query
    List<User> findByAgg(int ss);
}
