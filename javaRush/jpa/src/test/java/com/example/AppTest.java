package com.example;

import com.example.model.Category;
import com.example.model.Topic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    private EntityManager em;

    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void close() {
        if (em.getTransaction().isActive()) em.getTransaction().commit();
        em.getEntityManagerFactory().close();
        em.close();
    }

    @Test
    public void shouldFindWithCriteriaAPI() {
        Category cat = new Category();
        cat.setTitle("Category");
        em.persist(cat);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);

        Root<Category> r = cq.from(Category.class);
        cq.select(r);

        List<Category> resultList = em.createQuery(cq).getResultList();
        for (Category c : resultList) System.out.println(c.getId() + ": " + c.getTitle());

        em.createQuery(cq).getResultList().forEach(x -> System.out.println(x.getId() + ": " + x.getTitle()));

        assertEquals(1, resultList.size());
    }

    @Test
    public void shouldPerformQuery() {
        Category path = new Category();
        path.setTitle("Path");
        em.persist(path);
//        em.flush();
        Category way = new Category();
        way.setTitle("Way");
        em.persist(way);
//        Query query = em.createQuery("SELECT c from Category c WHERE c.title = 'Path'");
        Query query = em.createQuery("SELECT c from Category c");
        List<Category> resultList = query.getResultList();
        for (Category c : resultList) System.out.println(c.getId() + ": " + c.getTitle());
//        assertNotNull(query.getSingleResult());
    }

    @Test
    public void shouldPersistCategoryAndTopics() {
        Category cat = new Category();
        cat.setTitle("Kitty");
        Topic topic = new Topic();
        topic.setTitle("topic");
        topic.setCategory(cat);
        em.persist(cat);
    }

    @Test
    public void shouldFindCategory() {
        Category cat = new Category();
        cat.setTitle("Kitty");
//        System.out.println(cat.getTitle());
        em.persist(cat);
        Category result = em.find(Category.class, 1L);
        assertNotNull(result);
//        System.out.println("result.getTitle(): "+result.getTitle());
    }

    @Test
    public void shouldPersistCategory() {
        Category cat = new Category();
        cat.setTitle("new category");
        // JUnit обеспечит тест свежим EntityManager'ом
        em.persist(cat);
//        em.flush();
    }

/*
    @Test
    public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
*/

/*
    @Test
    public void shouldStartHibernate() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
    }
*/
}
