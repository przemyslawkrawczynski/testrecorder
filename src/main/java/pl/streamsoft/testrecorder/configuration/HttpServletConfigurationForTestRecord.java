package pl.streamsoft.testrecorder.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.streamsoft.testrecorder.interceptor.TestRecordInterceptors;

@Configuration
public class HttpServletConfigurationForTestRecord extends WebMvcConfigurationSupport {

    TestRecordInterceptors testRecordInterceptor;

    @Autowired
    public HttpServletConfigurationForTestRecord(TestRecordInterceptors testRecordInterceptor) {
        this.testRecordInterceptor = testRecordInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testRecordInterceptor);
    }
}