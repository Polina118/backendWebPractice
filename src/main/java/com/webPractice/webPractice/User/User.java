package com.webPractice.webPractice.User;

import com.webPractice.webPractice.Appeals.Appeals;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "users")
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Id
    private Integer id;

    private String name;

    private String surname;

    private String role;

    private String email;

    private String password;

    private boolean is_Admin;

    private String icon = "https://avatars.mds.yandex.net/i?id=30ba25c368001a59a73785c51f2bbfcd-4907872-images-thumbs&n=13";

    private String groupName;

    @Column(columnDefinition = "TEXT")
    private String about;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Appeals> appealsList;

    public User(String name, String surname, String role, String email, String password, String groupName) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.password = password;
        this.groupName = groupName;
        this.is_Admin = false;
        this.appealsList = new ArrayList<>();
    }
    public void addAppeal(Appeals appeals){
        this.appealsList.add(appeals);
    }
}
