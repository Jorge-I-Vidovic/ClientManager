package ClientManager.dao;

import ClientManager.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person, Integer> {
}
