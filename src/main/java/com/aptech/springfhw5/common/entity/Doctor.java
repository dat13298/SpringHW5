package com.aptech.springfhw5.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor extends AbstractEntity<Long, Doctor> {

    @NotNull(message = "Firstname not null")
    @Size(min = 1, message = "Firstname must be greater than 1")
    private String name;

    @NotNull(message = "Firstname not null")
    @Size(min = 1, message = "Firstname must be greater than 1")
    private String specialization;

    @Email(message = "Invalid Email")
    @NotNull(message = "Email not null")
    @Column(unique = true)
    private String email;

    @Size(min = 10, max = 12, message = "Phone must be between 10 and 12 character")
    @NotNull(message = "Phone not null")
    private String phone;
}
