package cn.jee2022.jee2022_exam.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
  private Integer id;
  @NotBlank(message = "{film.name.NotBlank}")
  private String name;
  @NotNull(message = "{film.year.NotNull}")
  private Integer year;
  @NotBlank(message = "{film.type.NotBlank}")
  private String type;
  @NotNull(message = "{film.companyId.NotNull}")
  private Integer companyId;
  private List<Integer> performerIds;
}
