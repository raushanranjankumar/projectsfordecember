package org.javaproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// This class has purpose of creation to deliver the birthday message to the client whenever they have their birthday.
public class Customer {
    private String name;
    private Date dob;
}
