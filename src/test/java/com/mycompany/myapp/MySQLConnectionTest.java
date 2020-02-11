package com.mycompany.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MySQLConnectionTest {
    
 
    @Test
    public void testConnection() throws Exception {
 
        try {
 
            System.out.println("\n >>>>>>>>>> Connection 출력 : " + "\n");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}