package cn.jee2022.jee2022_exam.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PerformerDto {
  private Integer id;
  @NotBlank(message = "{performer.name.NotBlank}")
  private String name;
  @NotBlank(message = "{performer.province.NotBlank}")
  private String province;
  @NotNull(message = "{performer.companyId.NotNull}")
  private Integer companyId;
}
