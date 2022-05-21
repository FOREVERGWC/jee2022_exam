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
public class CharactersBean {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;
  private String name;
  private String province;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private PerformanceCompaniesBean performanceCompaniesBean;

  @ToString.Exclude
  @ManyToMany(mappedBy = "filmsBean")
  private Set<FilmsBean> films = new HashSet<>();
}
