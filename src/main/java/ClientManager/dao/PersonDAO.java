package ClientManager.dao;

import ClientManager.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Integer> {
}
