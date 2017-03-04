package com.gaming.shack.registration;

import java.io.Serializable;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gaming.shack.authentication.dao.IAuthenticationDao;
import com.gaming.shack.authentication.service.IAuthenticationService;
import com.gaming.shack.data.entity.registration.MemberAccount;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@WebAppConfiguration
public class AuthModuleTest {

	@Autowired
	private IAuthenticationDao<Serializable, Serializable> authDAO;
	
	@Autowired
	private IAuthenticationService authService;
	
	//valid record
	
	@Test
	@Transactional
	public void testMemCheckDAO(){
	    //Long id =122334L;
	    String id = "122334";
	    String password = "test";
	    
	    LoginDTO logindt = new LoginDTO();
	    logindt.setId(id);
	    logindt.setPasscode(password);
	    
		try{
			LoginResponse resp = authService.login(logindt);
	  
		System.out.println("resp ============= "+resp.getSessionID());
		}catch(Exception e){
			System.out.println("exception    in   testMemCheckDAO");
			e.printStackTrace();
		}
	}
	
	//invalid password
	@Ignore
	@Test
	@Transactional
	public void testLoginServiceWithWrongPassWord(){
	    //Long id =122334L;
	    String id = "122334";
	    String password = "ranithaaaaaa";
	    
	    LoginDTO logindt = new LoginDTO();
	    logindt.setId(id);
	    logindt.setPasscode(password);
	    
		try{
			LoginResponse resp = authService.login(logindt);
	  
		System.out.println("resp ============= "+resp.getSessionID());
		}catch(Exception e){
			System.out.println("exception    in   testMemCheckDAO");
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	@Transactional
	public void testMemeberAccountByID(){
	    Long memId =122334L;
	    MemberAccount memAcc = null;
		try{
			memAcc = authDAO.findMemberAccount(memId);
		System.out.println("memAcc pass============= "+memAcc);
		}catch(Exception e){
			System.out.println("testMemeberAccountByID =inside exception-------------------- ");
			e.printStackTrace();
		}
	}
	
	
	@Ignore
	@Test
	@Transactional
	public void testUpdateNoOfFailedAttempt(){
	    Long memId =122334L;
	    Long count = 3L;
	    
	    int updated = 0;
		try{
			updated = authDAO.updateNoOfFailedAttempt(count, memId);
		System.out.println("updated pass============= "+updated);
		}catch(Exception e){
			System.out.println("testMemeberAccountByID =inside exception-------------------- ");
			e.printStackTrace();
		}
	}
}
