package cn.jee2022.jee2022_exam.controller;

import cn.hutool.core.util.StrUtil;
import cn.jee2022.jee2022_exam.dao.CompanyDao;
import cn.jee2022.jee2022_exam.domain.R;
import cn.jee2022.jee2022_exam.domain.entity.Company;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
  @Resource
  private CompanyDao companyDao;

  @GetMapping
  public R findAll(@RequestParam Integer pageNo,
                   @RequestParam Integer pageSize,
                   @RequestParam(required = false) Integer id,
                   @RequestParam(required = false) String name,
                   @RequestParam(required = false) String address) {
    Specification<Company> specification = (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (id != null) {
        predicates.add(criteriaBuilder.equal(root.get("id"), id));
      }
      if (StrUtil.isNotBlank(name)) {
        predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
      }
      if (StrUtil.isNotBlank(address)) {
        predicates.add(criteriaBuilder.like(root.get("address"), "%" + address + "%"));
      }
      Predicate[] pre = new Predicate[predicates.size()];
      return query.where(predicates.toArray(pre)).getRestriction();
    };
    PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.ASC, "id");
    Page<Company> page = companyDao.findAll(specification, pageRequest);
    return R.success().put("page", page);
  }

  @GetMapping("/{id}")
  public R getReferenceById(@PathVariable Integer id) {
    Company company = companyDao.getReferenceById(id);
    return R.success().put("company", company);
  }

  @PostMapping
  public R saveAndFlush(@RequestBody Company company) {
    companyDao.saveAndFlush(company);
    return R.success();
  }

  @DeleteMapping
  public R delete(@RequestParam List<Integer> ids) {
    companyDao.deleteAllByIdInBatch(ids);
    return R.success();
  }
}
