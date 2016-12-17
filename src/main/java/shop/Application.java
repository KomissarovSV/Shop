package shop;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import shop.setup.Data;

@SpringBootApplication(scanBasePackages = "shop")
public class Application{

    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriverClassName;
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @Value("${spring.datasource.password}")
    private String databasePassword;
    @Value("${spring.datasource.username}")
    private String databaseUsername;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        Data data = ctx.getBean(Data.class);
        data.setUp();
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions("/WEB-INF/layout/tiles.xml");
        tiles.setCheckRefresh(true);
        return tiles;
    }

    @Bean
    public ViewResolver viewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean
    public DataSource datasource() {

        DataSource ds = new DataSource();
        ds.setDriverClassName(databaseDriverClassName);
        ds.setUrl(datasourceUrl);
        ds.setUsername(databaseUsername);
        ds.setPassword(databasePassword);

        return ds;
    }
    @Configuration
    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/manage").hasRole("ADMIN")
                    .antMatchers("/history").authenticated()
                    .antMatchers("/order").authenticated()
                    .anyRequest()
                    .permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .failureUrl("/user/login?error=true")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/user/logout")
                    .and()
                    .rememberMe()
                    .and()
                    .csrf().disable();
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery(
                            "select name, password, true " +
                                    "from user_table where name=?")
                    .authoritiesByUsernameQuery(
                            "select user_table.name, role.name from user_table, role, user_table_roles " +
                                    "where user_table.id = user_table_roles.user_table_id " +
                                    "and role.id = user_table_roles.roles_id" +
                                    " and user_table.name=?");
        }

    }

}
