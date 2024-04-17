package ru.below.testdto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookEntity {
        @Id
        @GeneratedValue
        private Long id;
        private String bookName;
        @ManyToOne
        private AuthorEntity author;
        private Integer pages;
        private String index;


}
