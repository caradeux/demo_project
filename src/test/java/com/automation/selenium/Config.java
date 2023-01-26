package com.automation.selenium;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Henry J. Calani A.
 */
@Configuration
@ComponentScan("com.automation.selenium")
@Import({
        com.automation.selenium.Config.class

})
class Config {
}
