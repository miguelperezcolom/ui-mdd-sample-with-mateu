package com.example.demo.platform.brokers;

import com.example.demo.platform.companies.Company;
import com.example.demo.platform.countries.Country;
import com.example.demo.platform.vehicles.Vehicle;
import io.mateu.mdd.shared.annotations.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Broker {

    @Id
    @NotInEditor
    @ColumnWidth(50)
    private String id = UUID.randomUUID().toString();

    @FieldGroup("Main")
    private String name;

    private String email;

    @TextArea
    @NotInList
    private String address;

    @FieldGroup("Extra")
    @ManyToOne
    private Company company;

    @ManyToOne
    @NotInList
    private Country country;

    private boolean salesAgent;

    @FieldGroup("Insured objects")
    @ManyToMany(fetch = FetchType.EAGER)
    @UseChips
    private List<Vehicle> vehicles = new ArrayList<>();



    @Override
    public String toString() {
        return name;
    }
}
