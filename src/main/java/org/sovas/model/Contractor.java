package org.sovas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractorId;

    @Column(nullable = false)
    private String contractorName;

    @Column(nullable = false)
    private String technology;

    @Column
    private Byte yearsOfExperience;

    @Column
    private double monthlySalary;

    @ManyToOne
    @JoinColumn(name = "contrId")
    @JsonIgnore
    private Company company;

    public double getAnnualSalary(){ return monthlySalary * 12; }

    // to avoid stack overflow error due to infinite loop
    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + contractorId +
                ", name='" + contractorName + '\'' +
                ", technology='" + technology + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", monthlySalary=" + monthlySalary +
                '}';
    }
}
