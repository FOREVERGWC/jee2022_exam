package cn.jee2022.jee2022_exam.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Film {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Integer year;
  private String type;

  @ManyToOne(fetch = FetchType.LAZY)
  @ToString.Exclude
  @JsonIgnoreProperties(value = {"films", "performers"})
  private Company company;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @ToString.Exclude
  @JsonIgnoreProperties(value = {"company", "films"})
  private List<Performer> performers;

  public Film(String name, int year, String type) {
    this.name = name;
    this.year = year;
    this.type = type;
  }

  public void addCharacter(Performer character) {
//    character.getFilms().add(this);
//    characters.add(character);
  }
}
