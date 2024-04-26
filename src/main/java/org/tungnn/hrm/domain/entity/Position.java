package org.tungnn.hrm.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "position")
    private Set<EmployeePosition> employeePositions = new LinkedHashSet<>();

    protected Position() {}

    public Position(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeePosition> getEmployeePositions() {
        return employeePositions;
    }

    public void setEmployeePositions(Set<EmployeePosition> employeePositions) {
        this.employeePositions = employeePositions;
    }

}