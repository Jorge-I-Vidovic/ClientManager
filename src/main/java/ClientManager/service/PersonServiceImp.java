package ClientManager.service;

import ClientManager.dao.PersonDAO;
import ClientManager.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    private PersonDAO pd;

    @Override
    @Transactional(readOnly = true)
    public List<Person> listPersons() {
        return (List<Person>) pd.findAll();
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        pd.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        pd.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return pd.findById(person.getId_persona()).orElse(null);
    }
}
