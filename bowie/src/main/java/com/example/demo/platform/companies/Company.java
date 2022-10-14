package com.example.demo.platform.companies;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Company {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String email;

    private String address;

    @Override
    public String toString() {
        return name;
    }
}
