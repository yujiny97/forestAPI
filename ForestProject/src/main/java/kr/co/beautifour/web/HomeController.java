package kr.co.beautifour.web;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
    BasicDataSource dataSource;
    
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	 @RequestMapping("/dbTest.do")
	    public String dbTest(Model model) {
	        Connection conn = null;
	        Statement st = null;
	        
	        try {
	            conn = dataSource.getConnection();
	            st = conn.createStatement();
	            ResultSet rs = st.executeQuery("select * from Plants;");
	            
	            while(rs.next()) {
	                System.out.println(rs.getString("fskName"));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();    
	            
	        } finally {
	            try {
	                if(st != null) st.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            try {
	                if(conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }                        
	        }
	        
	        return "home";
	    }
	 
}
