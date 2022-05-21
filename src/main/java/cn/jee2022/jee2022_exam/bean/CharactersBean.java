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
  private int CompanyId;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private PerformanceCompaniesBean performanceCompaniesBean;

  @ToString.Exclude
  @ManyToMany(mappedBy = "filmsBean")
  private Set<FilmsBean> films = new HashSet<>();

  public CharactersBean(String name, String province, int CompanyId) {
    this.name = name;
    this.province = province;
    this.CompanyId = CompanyId;
  }

  public CharactersBean(String name, String province, PerformanceCompaniesBean performanceCompaniesBean) {
    this.name = name;
    this.province = province;
    this.CompanyId = performanceCompaniesBean.getID();
  }

  public void setPerformanceCompany(PerformanceCompaniesBean performanceCompaniesBean) {
    performanceCompaniesBean.getCharacters().add(this);
    this.performanceCompaniesBean = performanceCompaniesBean;
  }

  public void removePerformanceCompany(PerformanceCompaniesBean performanceCompaniesBean) {
    performanceCompaniesBean.getCharacters().remove(this);
    this.performanceCompaniesBean = null;
  }
}
