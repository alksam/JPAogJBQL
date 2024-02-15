package week4.Employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@Getter
@ToString
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department"),
        @NamedQuery(name = "Employee.findByfirstename", query = "SELECT e FROM Employee e WHERE e.firstname = :name")
})
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", length = 20)
    private String firstname;
    @Column(name = "last_name", length = 20)
    private String lastname;
    @Column(name = "email", length = 40)
    private String email;
    @Column(name = "salary" )
    private double salary;
    @Column(name = "department", length = 40)
    private String department;

    public Employee(String firstname, String lastname, String mail, double salary, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = mail;
        this.salary = salary;
        this.department = department;
    }

}
