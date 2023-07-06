package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.CategoryDAO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CategoryDAOImplTest {

    @Autowired
    CategoryDAO categoryDAO;
    @Test
    public void select() throws Exception{
        assertTrue(categoryDAO!=null);
        System.out.println("catecoryDAO = "+categoryDAO);
        CategoryDTO categoryDTO = (CategoryDTO) categoryDAO.getCategory(1);
        System.out.println("categoryDTO = "+ categoryDTO);

    }
}