package ru.below.springrestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.below.springrestapi.models.Person;
import ru.below.springrestapi.repositories.PeopleRepository;
import ru.below.springrestapi.util.PersonNotFoundExeption;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }
    public Person getPeopleByName(String name) {
        return peopleRepository.findByUsername(name).orElseThrow(PersonNotFoundExeption::new);
    }
    @Transactional
    public void savePeople(Person person) {
        enrichPerson(person);
        peopleRepository.save(person);
    }

    private void enrichPerson(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setCreatedWho("ADMIN");
    }
}
