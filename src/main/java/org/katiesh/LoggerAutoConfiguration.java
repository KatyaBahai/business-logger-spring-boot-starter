package org.katiesh;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class LoggerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(BusinessLogger.class)
    public BusinessLogger businessLogger(
            @Value("${business.log.prefix:[BUSINESS-LOG]}") String prefix) {
        return new BusinessLogger(prefix);
    }

}
