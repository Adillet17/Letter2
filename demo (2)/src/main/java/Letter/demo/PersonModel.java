package Letter.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull(message = "ФИО не может быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов")
    @Column(name = "name")
    private String name;

    @NotNull(message = "ФИО не может быть пустым")
    @Size(min = 2, max = 100, message = "Фамилия должно быть от 2 до 100 символов")
    @Column(name = "username")
    private String username;

    @Column(name = "photo")
    private String photo;

    @Column(name = "review")
    private String review;

    @Column(name = "letter")
    private String letter;

    @Column(name = "know_how")
    private String know_how;

    public PersonModel(int id, String name, String username, String photo, String review, String letter, String know_how) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.photo = photo;
        this.review = review;
        this.letter = letter;
        this.know_how = know_how;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getKnow_how() {
        return know_how;
    }

    public void setKnow_how(String know_how) {
        this.know_how = know_how;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", photo='" + photo + '\'' +
                ", review='" + review + '\'' +
                ", letter='" + letter + '\'' +
                ", know_how='" + know_how + '\'' +
                '}';
    }
}
