package com.mano;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StartApplicationMainTest {

    @Test
    public void testMain() {
        StartApplication.main(new String[] {});
    }

    @Test
    public void contextLoads() {
        // This will test if the Spring application context loads successfully
    }
}