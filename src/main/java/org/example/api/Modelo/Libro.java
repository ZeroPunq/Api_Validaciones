package org.example.api.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Size(max = 20)
    @Pattern(regexp = "^(978|979)-?\\d{1,5}-?\\d{1,7}-?\\d{1,6}-?\\d$", message = "El ISBN debe ser un código válido de 13 dígitos.")
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Size(max = 200)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El título solo puede contener caracteres alfanuméricos")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 100)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El autor solo puede contener caracteres alfanuméricos")
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }
}
