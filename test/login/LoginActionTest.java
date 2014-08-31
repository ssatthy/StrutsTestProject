package login;

import servletunit.struts.CactusStrutsTestCase;
import usersetup.AddressForm;

public class LoginActionTest extends CactusStrutsTestCase{

	public LoginActionTest(String testname){
		super(testname);
	}

	@Override
	protected void setUp() throws Exception
	{
	    super.setUp();
	    //setContextDirectory(new File("WebContent"));
	 }

	public void testSuccessfulLogin(){
		setRequestPathInfo("/Login");
		addRequestParameter("username", "ssatthy");
		addRequestParameter("password", "ssatthy");
		actionPerform();
		//verifyForward("success");
		verifyTilesForward("success", "common.home");
		assertEquals("ssatthy", (String)getSession().getAttribute("authentication"));
		verifyNoActionErrors();
		
		// test sequence of actions
		setRequestPathInfo("/Address.do");
		addRequestParameter("name", (String)getSession().getAttribute("authentication"));
		addRequestParameter("street", "Aliyawalai");
		addRequestParameter("city", "Jaffna");
		addRequestParameter("country", "Sri Lanka");
		addRequestParameter("zip", "40000");
		actionPerform();
		verifyTilesForward("success", "common.home");
		verifyNoActionErrors();
		AddressForm form = (AddressForm) getActionForm();
		assertEquals("ssatthy", form.getName());
		
	}
	public void testFailedLogin() {

	    addRequestParameter("username","deryl");
	    addRequestParameter("password","express");
	    setRequestPathInfo("/Login");
	    actionPerform();
	    //verifyForward("error");
	    verifyTilesForward("error", "common.login");
	    verifyActionErrors(new String[] {"error.password.mismatch"});
	    assertNull((String) getSession().getAttribute("authentication"));
	}
}
