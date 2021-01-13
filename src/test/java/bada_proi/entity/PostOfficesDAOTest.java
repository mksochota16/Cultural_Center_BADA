package bada_proi.entity;

import bada_proi.ProjectConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostOfficesDAOTest {
    private PostOfficesDAO dao;
    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(ProjectConstants.URL);
        dataSource.setUsername(ProjectConstants.USERNAME);
        dataSource.setPassword(ProjectConstants.PASSWORD);
        dataSource.setDriverClassName(ProjectConstants.DRIVERCLASSNAME);

        dao = new PostOfficesDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<PostOffice> postOfficeList = dao.list();
        System.out.println(postOfficeList);
        assertFalse(postOfficeList.isEmpty());
    }

    @Test
    void save() {
        PostOffice postOffice = new PostOffice(0,"00-000", "Test");
        dao.save(postOffice);

    }

    @Test
    void get() {
        int id = 42;
        PostOffice postOffice = dao.get(id);
        System.out.println(postOffice);
        assertNotNull(postOffice);
    }

    @Test
    void update() {
        PostOffice postOffice = new PostOffice();
        postOffice.setPostOfficeId(42);
        postOffice.setCity("Test update");
        postOffice.setCode("00-004");
        dao.update(postOffice);
    }

    @Test
    void delete() {
    }
}