package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeid;
    @Column(name = "first_name")
    @Size(max = 25, message = "No existe un nombre con más de 20 caracteres , coloque uno real ")
    @NotBlank
    private String firstname;
    @Column(name = "last_name",nullable = false)
    @NotBlank
    private String lastname;
    @Column(nullable = false)
    @Email
    @NotBlank
    @Size(max = 25, message = "Su correo no puede tener mas de 40 caracteres")
    private String email;
    @NotBlank
    @Size(min = 8, message = "Su contraseña no puede tener menos de 8 caracteres")
    private String password;
    @Column(name = "phone_number")
    private String phonenumber;
    @Column(name = "hire_date")
    private Date hiredate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;



    @Positive(message = "Debe ser mayor de 0")
    @Digits(integer = 8, fraction = 2)
    @NotBlank
    private int salary;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;
    private int enabled;



    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs jobid) {
        this.job = jobid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public Employees getManager() {
        return manager;
    }

    public void setManager(Employees manager) {
        this.manager = manager;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments departmentid) {
        this.department = departmentid;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

}
