package wolox.training.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(DatabaseConfig.class);
        webContext.register(WebMvcConfig.class);
        webContext.setServletContext(container);
        ServletRegistration.Dynamic reg=container.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
        reg.setLoadOnStartup(1);
        reg.addMapping("*.action");
        reg.addMapping("/");
        reg.addMapping("/api/books");
        reg.addMapping("/api/users");
    }

}
