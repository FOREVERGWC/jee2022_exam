package cn.jee2022.jee2022_exam.controller;

import cn.hutool.core.util.StrUtil;
import cn.jee2022.jee2022_exam.dao.PerformerDao;
import cn.jee2022.jee2022_exam.domain.R;
import cn.jee2022.jee2022_exam.domain.dto.PerformerDto;
import cn.jee2022.jee2022_exam.domain.entity.Company;
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
@RequestMapping("/performer")
public class PerformerController {
  @Resource
  private PerformerDao performerDao;

  @GetMapping
  public R findAll(@RequestParam Integer pageNo,
                   @RequestParam Integer pageSize,
                   @RequestParam(required = false) Integer id,
                   @RequestParam(required = false) String name,
                   @RequestParam(required = false) String province,
                   @RequestParam(required = false) Integer companyId) {
    Specification<Performer> specification = (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (id != null) {
        predicates.add(criteriaBuilder.equal(root.get("id"), id));
      }
      if (StrUtil.isNotBlank(name)) {
        predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
      }
      if (StrUtil.isNotBlank(province)) {
        predicates.add(criteriaBuilder.like(root.get("province"), "%" + province + "%"));
      }
      Join<Performer, Company> join = root.join("company", JoinType.INNER);
      if (companyId != null) {
        predicates.add(criteriaBuilder.equal(join.get("id"), companyId));
      }
      Predicate[] pre = new Predicate[predicates.size()];
      return query.where(predicates.toArray(pre)).getRestriction();
    };
    PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.ASC, "id");
    Page<Performer> page = performerDao.findAll(specification, pageRequest);
    return R.success().put("page", page);
  }

  @GetMapping("/{id}")
  public R getReferenceById(@PathVariable Integer id) {
    Performer performer = performerDao.getReferenceById(id);
    return R.success().put("performer", performer);
  }

  @PostMapping
  public R saveAndFlush(@Valid @RequestBody PerformerDto dto) {
    Performer performer = new Performer();
    BeanUtils.copyProperties(dto, performer);
    performer.setCompany(new Company(dto.getCompanyId()));
    performerDao.saveAndFlush(performer);
    return R.success();
  }

  @DeleteMapping
  public R delete(@RequestParam List<Integer> ids) {
    performerDao.deleteAllByIdInBatch(ids);
    return R.success();
  }
}
