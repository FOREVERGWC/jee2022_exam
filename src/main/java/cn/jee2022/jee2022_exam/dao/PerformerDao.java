package cn.jee2022.jee2022_exam.dao;

import cn.jee2022.jee2022_exam.domain.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerDao extends JpaRepository<Performer, Integer>, JpaSpecificationExecutor<Performer> {

}
