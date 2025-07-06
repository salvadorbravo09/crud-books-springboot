package com.salvadorbravo.crudbooks.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private Integer idBook;

    @Column(name = "book_title", length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean enabled;

    // Relacion N:1 con Category
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
}
