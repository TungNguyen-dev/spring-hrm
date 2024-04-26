package org.tungnn.hrm.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "company")
    private Set<Department> departments = new LinkedHashSet<>();

    protected Company() {}

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}