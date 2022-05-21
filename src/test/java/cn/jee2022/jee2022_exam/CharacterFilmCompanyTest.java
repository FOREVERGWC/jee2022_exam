package cn.jee2022.jee2022_exam;

import cn.jee2022.jee2022_exam.bean.CharactersBean;
import cn.jee2022.jee2022_exam.bean.FilmsBean;
import cn.jee2022.jee2022_exam.bean.PerformanceCompaniesBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@SpringBootTest
public class CharacterFilmCompanyTest {
  @Autowired
  EntityManager em;

  @Transactional
  @Rollback(value = false)
  @Test
  void init() {
    PerformanceCompaniesBean aPublisher = new PerformanceCompaniesBean("制片厂A", "地址A", "Logo A");

    CharactersBean aaAuthor = new CharactersBean("演员a-a", "省份A");
    CharactersBean abAuthor = new CharactersBean("演员a-b", "省份B");
    CharactersBean acAuthor = new CharactersBean("演员a-c", "省份C");

    aaAuthor.setPerformanceCompaniesBean(aPublisher);
    abAuthor.setPerformanceCompaniesBean(aPublisher);
    acAuthor.setPerformanceCompaniesBean(aPublisher);

    FilmsBean aBook = new FilmsBean("电影A", 2021, "喜剧");
    aBook.addCharacter(aaAuthor);
    aBook.addCharacter(acAuthor);

    FilmsBean bBook = new FilmsBean("电影B", 2022, "战争剧");
    bBook.addCharacter(aaAuthor);
    bBook.addCharacter(abAuthor);

    PerformanceCompaniesBean bPublisher = new PerformanceCompaniesBean("制片厂B", "地址B", "Logo B");

    CharactersBean bdAuthor = new CharactersBean("演员b-d", "省份D");

    bdAuthor.setPerformanceCompany(bPublisher);

    FilmsBean cBook = new FilmsBean("电影C", 2023, "战争剧");
    cBook.addCharacter(bdAuthor);

    em.persist(aBook);
    em.persist(bBook);
    em.persist(cBook);
  }
}
