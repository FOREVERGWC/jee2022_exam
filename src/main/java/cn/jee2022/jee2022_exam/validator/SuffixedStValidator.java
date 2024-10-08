package cn.jee2022.jee2022_exam.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class SuffixedStValidator implements ConstraintValidator<SuffixedStValidator, String>, Annotation {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.endsWith("st");
  }

  @Override
  public Class<? extends Annotation> annotationType() {
    return null;
  }
}
