package cn.jee2022.jee2022_exam.bean;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

  public CharactersBean(String name, String province) {
    this.name = name;
    this.province = province;
  }

  public void setPerformanceCompany(PerformanceCompaniesBean performanceCompaniesBean) {
    performanceCompaniesBean.getAuthors().add(this);
    this.performanceCompaniesBean = performanceCompaniesBean;
  }

  public void removePerformanceCompany(PerformanceCompaniesBean performanceCompaniesBean) {
    performanceCompaniesBean.getAuthors().remove(this);
    this.performanceCompaniesBean = null;
  }
}
