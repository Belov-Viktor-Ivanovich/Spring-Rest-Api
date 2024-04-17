package ru.below.springrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.below.springrestapi.models.Person;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PeopleRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByUsername(String userName);
}
