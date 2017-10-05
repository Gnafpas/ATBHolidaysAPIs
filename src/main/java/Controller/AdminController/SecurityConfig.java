package Controller.AdminController;


import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SubAgencyDAO;
import Helper.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by George on 18/07/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Configuration
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth)
                throws Exception {
            auth.inMemoryAuthentication().withUser(ProjectProperties.Adminuser)
                    .password(ProjectProperties.Adminpass).roles("ADMIN");
        }

        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(new RestSignatureFilter(), BasicAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/stopUpdate", "/updateCategories", "/updateDestinations", "/updateAttractions", "/startUpdate","/newAPIClient",
                                             "/updateATBProducts","/isUpdateTimertaskEnabled")
                    .hasRole("ADMIN")
                    .and().formLogin();
            http.csrf().disable();
        }

    }


    public class RestSignatureFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {

            if(!request.getServletPath().equals("/stopUpdate") && !request.getServletPath().equals("/updateCategories")
               && !request.getServletPath().equals("/updateDestinations") && !request.getServletPath().equals("/updateAttractions")
               && !request.getServletPath().equals("/startUpdate") && !request.getServletPath().equals("/newAPIClient")
               && !request.getServletPath().equals("/isUpdateTimertaskEnabled") && !request.getServletPath().equals("/updateATBProducts")) {
                String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + request.getParameter("apiKey");
                String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
                SubAgencyBean subAgencyBean = null;
                subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
                if (subAgencyBean == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                            "Failed validation of API key.");
                    return;
                }
            }//todo check the frequency of request
            //response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
           //             "The REST Security Server experienced an internal error.");
            filterChain.doFilter(request, response);
        }
    }

}


