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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ssn" , nullable = false , unique = true)
    private String ssn;
    private String name;
    private String family;
    private String major;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    public Student(String ssn, String name, String family, String major, Book book) {
        this.ssn = ssn;
        this.name = name;
        this.family = family;
        this.major = major;
        this.book = book;
    }
    public Student(int id){
        this.id = id;
    }






}
