package cn.jee2022.jee2022_exam.dao;

import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceCompaniesDao extends JpaRepository<PerformanceCompaniesBean, Long> {
  //List<PerformanceCompaniesBean> findAllByID();//
}
