package Controller.AdminController;


import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import Controller.Application;
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
                    .antMatchers("/stopViatorDBUpdate", "/updateCategories", "/updateDestinations", "/updateAttractions", "/startViatorDBUpdate","/newAPIClient",
                                             "/startATBDBUpdate","/isViatorDBUpdateTimertaskEnabled","/stopATBDBUpdate","/isATBDBUpdateTimertaskEnabled",
                                             "/stopSunHotDBUpdate","/startSunHotDBUpdate","/isSunHotDBUpdateTimertaskEnabled","/startHotelBedsDBUpdate",
                                             "/stopHotelBedsDBUpdate","/isHotelBedsDBUpdateTimertaskEnabled","/startEventsTravelDBUpdate",
                                             "/stopEventsTravelDBUpdate","/isEventsTravelDBUpdateTimertaskEnabled","/carnectTest",
                                             "/deleteCorruptedProducts","/updatecitycodes","/blankid")
                    .hasRole("ADMIN")
                    .and().formLogin();
            http.csrf().disable();
        }

    }


    public class RestSignatureFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
            SubAgencyBean subAgencyBean = null;
            if(!request.getServletPath().equals("/stopViatorDBUpdate") && !request.getServletPath().equals("/updateCategories")
               && !request.getServletPath().equals("/updateDestinations") && !request.getServletPath().equals("/updateAttractions")
               && !request.getServletPath().equals("/startViatorDBUpdate") && !request.getServletPath().equals("/newAPIClient")
               && !request.getServletPath().equals("/isViatorDBUpdateTimertaskEnabled") && !request.getServletPath().equals("/isATBDBUpdateTimertaskEnabled")
               && !request.getServletPath().equals("/stopATBDBUpdate") && !request.getServletPath().equals("/startATBDBUpdate")
               && !request.getServletPath().equals("/isSunHotDBUpdateTimertaskEnabled") && !request.getServletPath().equals("/startSunHotDBUpdate")
               && !request.getServletPath().equals("/stopHotelBedsDBUpdate") &&  !request.getServletPath().equals("/isHotelBedsDBUpdateTimertaskEnabled")
               && !request.getServletPath().equals("/startHotelBedsDBUpdate") && !request.getServletPath().equals("/stopEventsTravelDBUpdate")
               && !request.getServletPath().equals("/isEventsTravelDBUpdateTimertaskEnabled") && !request.getServletPath().equals("/startEventsTravelDBUpdate")
               && !request.getServletPath().equals("/stopSunHotDBUpdate") && !request.getServletPath().equals("/carnectTest")
               && !request.getServletPath().equals("/deleteCorruptedProducts") && !request.getServletPath().equals("/updatecitycodes")
               && !request.getServletPath().equals("/blankid") && !request.getServletPath().equals("/temp") ) {
                String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + request.getParameter("apiKey");
                String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
                subAgencyBean = SubAgencyDAO.getSubAgentByStoreKey(hashedPassword);
                if (subAgencyBean == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                            "Failed validation of API key.");
                    return;
                }//todo remove blank id
            } //todo check the frequency of request
             //todo make static variable for all the strings at project properties class
            //response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
           //             "The REST Security Server experienced an internal error.");

            if(request.getServletPath().equals("/book") || request.getServletPath().equals("/calculateprice") ||
               request.getServletPath().equals("/cancelBooking") || request.getServletPath().equals("/pastBooking")){
                if(!subAgencyBean.getAgentName().equals("Nafpas")) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                            "This API key is not authorised to request this web service.");
                    return;
                }
            }
            filterChain.doFilter(request, response);

        }
    }

}


