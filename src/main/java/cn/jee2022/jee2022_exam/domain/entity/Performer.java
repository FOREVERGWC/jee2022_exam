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
public class Performer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String province;

  @ManyToOne(fetch = FetchType.LAZY)
  @ToString.Exclude
  @JsonIgnoreProperties(value = {"films", "performers"})
  private Company company;

  @ManyToMany(mappedBy = "performers")
  @ToString.Exclude
  @JsonIgnoreProperties(value = {"company", "performers"})
  private List<Film> films;

  public Performer(Integer id) {
    this.id = id;
  }

  public Performer(String name, String province, Company company) {
    this.name = name;
    this.province = province;
    this.company = company;
  }
}
