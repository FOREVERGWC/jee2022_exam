package cn.jee2022.jee2022_exam.controller;

import cn.hutool.core.util.StrUtil;
import cn.jee2022.jee2022_exam.dao.FilmDao;
import cn.jee2022.jee2022_exam.domain.R;
import cn.jee2022.jee2022_exam.domain.dto.FilmDto;
import cn.jee2022.jee2022_exam.domain.entity.Company;
import cn.jee2022.jee2022_exam.domain.entity.Film;
import cn.jee2022.jee2022_exam.domain.entity.Performer;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
  @Resource
  private FilmDao filmDao;

  @GetMapping
  public R findAll(@RequestParam Integer pageNo,
                   @RequestParam Integer pageSize,
                   @RequestParam(required = false) Integer id,
                   @RequestParam(required = false) String name,
                   @RequestParam(required = false) Integer year,
                   @RequestParam(required = false) String type,
                   @RequestParam(required = false) Integer companyId) {
    Specification<Film> specification = (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (id != null) {
        predicates.add(criteriaBuilder.equal(root.get("id"), id));
      }
      if (StrUtil.isNotBlank(name)) {
        predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
      }
      if (year != null) {
        predicates.add(criteriaBuilder.equal(root.get("year"), year));
      }
      if (StrUtil.isNotBlank(type)) {
        predicates.add(criteriaBuilder.like(root.get("type"), "%" + type + "%"));
      }
      Join<Film, Company> join = root.join("company", JoinType.INNER);
      if (companyId != null) {
        predicates.add(criteriaBuilder.equal(join.get("id"), companyId));
      }
      Predicate[] pre = new Predicate[predicates.size()];
      return query.where(predicates.toArray(pre)).getRestriction();
    };
    PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.ASC, "id");
    Page<Film> page = filmDao.findAll(specification, pageRequest);
    return R.success().put("page", page);
  }

  @GetMapping("/{id}")
  public R getReferenceById(@PathVariable Integer id) {
    Film film = filmDao.getReferenceById(id);
    return R.success().put("film", film);
  }

  @PostMapping
  public R saveAndFlush(@Valid @RequestBody FilmDto dto) {
    Film film = new Film();
    BeanUtils.copyProperties(dto, film);
    film.setCompany(new Company(dto.getCompanyId()));
    film.setPerformers(dto.getPerformerIds().stream().map(Performer::new).toList());
    filmDao.saveAndFlush(film);
    return R.success();
  }

  @DeleteMapping
  public R delete(@RequestParam List<Integer> ids) {
    filmDao.deleteAllByIdInBatch(ids);
    return R.success();
  }
}
