package com.spring.gameloft.jpa.jpql;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

@Entity
@Inheritance
@DiscriminatorValue("P")
public class Project {
    @Id
    protected int id;
    protected String name;
    @ManyToMany
    @CollectionTable(name="project_employee")
    protected Collection<Employee> employees = new ArrayList<Employee>();
    
    public int getId() {
        return id;
    }
    
    public void setId(int projectNo) {
        this.id = projectNo;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String projectName) {
        this.name = projectName;
    }
    
    public Collection<Employee> getEmployees() {
        return employees;
    }
    
    public void addEmployee(Employee employee) {
        if (!getEmployees().contains(employee)) {
            getEmployees().add(employee);
        }
        if (!employee.getProjects().contains(this)) {
            employee.getProjects().add(this);
        }
    }
    
    public String toString() {
        return getClass().getSimpleName() + 
                " no: " + getId() + 
                ", name: " + getName();
    }
}
