package ru.dimaldos.simplereader.booksservicedb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "chapters",
        schema = "bookshelf"
)
@SecondaryTable(
        name = "contents",
        schema = "bookshelf",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotNull
    private int position;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "volume_id",
            nullable = false
    )
    private Volume volume;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(table = "contents", name = "content")
    private JsonNode content;

}
