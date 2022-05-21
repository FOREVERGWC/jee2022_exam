package cn.jee2022.jee2022_exam.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class FilmsBean {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;
  private String name;
  private int year;
  private String type;

  @ManyToOne
  private FilmsBean filmsBean;

  @ToString.Exclude
  @ManyToMany(cascade = CascadeType.PERSIST)
  private Set<CharactersBean> characters = new HashSet<>();
}
