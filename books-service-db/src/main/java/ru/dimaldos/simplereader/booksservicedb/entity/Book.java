package ru.dimaldos.simplereader.booksservicedb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "books",
        schema = "library"
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @Size(max = 100)
    private String author;

    @Size(max = 1000)
    private String description;

    @Type(TableOfContentsJson.class)
    private TableOfContentsNode content;
}
