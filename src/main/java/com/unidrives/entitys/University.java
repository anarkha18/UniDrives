package com.unidrives.entitys;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "university")
@Data
public class University {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Name is mandatory")
        @Size(min = 4, message = "Name must be at least 4 characters")
        private String name;

        @NotBlank(message = "Location is mandatory")
        @Size(min = 4, message = "Location must be at least 4 characters")
        private String location;

        @NotBlank(message = "University ID is mandatory")
        @Size(min = 4, message = "University ID  must be at least 4 characters")
        @Column(unique = true)
        private String universityId;

        @NotBlank(message = "Type is mandatory")
        private String type;

        @NotBlank(message = "Photo is mandatory")
        private String photo;

}
