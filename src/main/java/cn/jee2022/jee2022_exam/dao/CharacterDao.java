package cn.jee2022.jee2022_exam.dao;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDao extends JpaRepository<CharactersBean, Long> {
}
