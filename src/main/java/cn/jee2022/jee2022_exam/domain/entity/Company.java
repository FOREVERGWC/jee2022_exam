package cn.jee2022.jee2022_exam.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String address;
  private String logo;

  @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "company")
  @ToString.Exclude
  @JsonIgnoreProperties(value = {"company", "performers"})
  private List<Film> films;

  @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "company")
  @ToString.Exclude
  @JsonIgnoreProperties(value = {"company", "films"})
  private List<Performer> performers;

  public Company(Integer id) {
    this.id = id;
  }

  public Company(String name, String address, String logo) {
    this.name = name;
    this.address = address;
    this.logo = logo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Company company = (Company) o;
    return Objects.equals(id, company.id) && Objects.equals(name, company.name) && Objects.equals(address, company.address) && Objects.equals(logo, company.logo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, logo);
  }
}
