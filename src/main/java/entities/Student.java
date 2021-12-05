package entities;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "TBL_STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ssn")
    private String ssn;
    private String name;
    private String family;
    private String major;


    public Student(String ssn, String name, String family, String major) {
        this.ssn = ssn;
        this.name = name;
        this.family = family;
        this.major = major;
    }
    public Student(int id){
        this.id = id;
    }






}
