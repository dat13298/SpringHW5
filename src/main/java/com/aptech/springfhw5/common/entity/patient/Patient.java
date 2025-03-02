package com.aptech.springfhw5.common.entity.patient;

import com.aptech.springfhw5.common.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient extends AbstractEntity<Long, Patient> {

    @NotNull(message = "Firstname not null")
    @Size(min = 1, message = "Firstname must be greater than 1")
    private String firstName;

    @NotNull(message = "Firstname not null")
    @Size(min = 1, message = "Lastname must be greater than 1")
    private String lastName;

    @Email(message = "Invalid Email")
    @NotNull(message = "Email not null")
    @Column(unique = true)
    private String email;

    @Size(min = 10, max = 12, message = "Phone must be between 10 and 12 character")
    @NotNull(message = "Phone not null")
    private String phone;

    @NotNull(message = "Date of birth not null")
    @PastOrPresent(message = "Date of birth must be in the past or present")
    private Date dob;
}
