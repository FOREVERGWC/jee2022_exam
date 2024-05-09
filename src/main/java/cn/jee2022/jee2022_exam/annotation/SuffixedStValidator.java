package cn.jee2022.jee2022_exam.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

class SuffixedSt implements ConstraintValidator<SuffixedSt, String>, Annotation {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.endsWith("st");
  }

  @Override
  public Class<? extends Annotation> annotationType() {
    return null;
  }
}
