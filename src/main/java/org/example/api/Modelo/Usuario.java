package org.example.api.Modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 15)
    @NotNull
    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "El DNI no es valido")
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9]+@gmail\\.com", message = "El email debe ser de Gmail")
    //@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "El email no es válido.")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 255)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{4,12}$", message = "La contraseña debe tener entre 4 y 12 caracteres alfanuméricos.")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Pattern(regexp = "^(normal|administrador)$", message = "El tipo de usuario solo puede ser: normal o administrador")
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;

    public Usuario() {
    }

    public Usuario(Integer id, String dni, String nombre, String email, String password, String tipo, LocalDate penalizacionHasta) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.penalizacionHasta = penalizacionHasta;
    }
}
