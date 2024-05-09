package cn.jee2022.jee2022_exam;

import cn.jee2022.jee2022_exam.domain.entity.Company;
import cn.jee2022.jee2022_exam.domain.entity.Film;
import cn.jee2022.jee2022_exam.domain.entity.Performer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@Slf4j
@SpringBootTest
public class CharacterFilmCompanyTest {
  @Autowired
  private EntityManager em;

  @Transactional
  @Rollback(value = false)
  @Test
  void init() {
    Company aCompany = new Company("华谊兄弟", "地址A", "Logo A");
    Company bCompany = new Company("光线影业", "地址B", "Logo B");
    Company cCompany = new Company("万达影业", "地址C", "Logo C");
    Company dCompany = new Company("世纪英雄", "地址D", "Logo D");
    Company eCompany = new Company("橙天娱乐", "地址E", "Logo E");
    Company fCompany = new Company("华策影视", "地址E", "Logo E");
    Company gCompany = new Company("爱奇艺影业", "地址E", "Logo E");
    Company hCompany = new Company("慈文传媒", "地址E", "Logo E");
    Company iCompany = new Company("博纳影业", "地址E", "Logo E");
    em.persist(aCompany);
    em.persist(bCompany);
    em.persist(cCompany);
    em.persist(dCompany);
    em.persist(eCompany);
    em.persist(fCompany);
    em.persist(gCompany);
    em.persist(hCompany);
    em.persist(iCompany);

    Performer aaPerformer = new Performer("演员A", "省份A", aCompany);
    Performer abPerformer = new Performer("演员B", "省份B", bCompany);
    Performer acPerformer = new Performer("演员C", "省份C", cCompany);
    Performer adPerformer = new Performer("演员D", "省份D", dCompany);
    Performer aePerformer = new Performer("演员E", "省份E", eCompany);
    Performer bPerformer = new Performer("演员F", "省份F", aCompany);
    Performer bbPerformer = new Performer("演员G", "省份G", bCompany);
    Performer bcPerformer = new Performer("演员H", "省份H", cCompany);

//    aaPerformer.setFilmCompaniesBean(aCompany);
//    abPerformer.setFilmCompaniesBean(aCompany);
//    acPerformer.setFilmCompaniesBean(aCompany);
//    adPerformer.setFilmCompaniesBean(aCompany);
//    aePerformer.setFilmCompaniesBean(aCompany);
//    bPerformer.setFilmCompaniesBean(aCompany);
//    bbPerformer.setFilmCompaniesBean(aCompany);
//    bcPerformer.setFilmCompaniesBean(aCompany);
    em.persist(aaPerformer);
    em.persist(abPerformer);
    em.persist(acPerformer);
    em.persist(adPerformer);
    em.persist(aePerformer);
    em.persist(bPerformer);
    em.persist(bbPerformer);
    em.persist(bcPerformer);

    Film aFilm = new Film("电影A", 2000, "喜剧");
    Film bFilm = new Film("电影B", 2001, "战争剧");
    Film cFilm = new Film("电影C", 2002, "喜剧");
    Film dFilm = new Film("电影D", 2003, "战争剧");
    Film eFilm = new Film("电影E", 2004, "爱情剧");
    Film fFilm = new Film("电影F", 2005, "战争剧");
    Film gFilm = new Film("电影G", 2006, "爱情剧");
    Film hFilm = new Film("电影H", 2007, "战争剧");
    Film iFilm = new Film("电影I", 2008, "战争剧");


    aFilm.addCharacter(aaPerformer);
    aFilm.addCharacter(abPerformer);
    aFilm.addCharacter(acPerformer);
    bFilm.addCharacter(aaPerformer);
    bFilm.addCharacter(abPerformer);
    cFilm.addCharacter(acPerformer);
    dFilm.addCharacter(adPerformer);
    eFilm.addCharacter(aePerformer);
    fFilm.addCharacter(bPerformer);
    gFilm.addCharacter(bbPerformer);
    hFilm.addCharacter(bcPerformer);
    iFilm.addCharacter(bPerformer);

    em.persist(aFilm);
    em.persist(bFilm);
    em.persist(cFilm);
    em.persist(dFilm);
    em.persist(eFilm);
    em.persist(fFilm);
    em.persist(gFilm);
    em.persist(hFilm);
    em.persist(iFilm);
  }
}
