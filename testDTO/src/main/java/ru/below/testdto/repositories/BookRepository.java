package ru.below.testdto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.below.testdto.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
