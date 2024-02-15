package skole;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    @Column( name = "name",length = 50)
    private String name;
    @Column( name = "Description",length = 50)
    private String Description;
    @Column( name = "email",unique = true,length = 50)

    private String email;

    public Student(String name, String description, String email) {
        this.name = name;
        Description = description;
        this.email = email;
    }

}

