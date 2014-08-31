package country;

import java.io.File;

import servletunit.struts.MockStrutsTestCase;

public class SearchCountryActionTest extends MockStrutsTestCase{

	
	public SearchCountryActionTest(String testname){
		super(testname);
	}
	
	@Override
	public void setUp() throws Exception{
		super.setUp();
		setContextDirectory(new File("WebContent"));
	}
	
	public void testSearchByCountry() {
		  setRequestPathInfo("/Search.do");
		  addRequestParameter("code", "FR");
		  actionPerform();
		  verifyNoActionErrors();
		  verifyTilesForward("country","setup.country.details");
		  assertNotNull(request.getAttribute("name"));
		  assertEquals("FR-France", request.getAttribute("name"));
		}

	public void testSeachErrorCode(){
		 setRequestPathInfo("/Search.do");
		  addRequestParameter("code", "SLR");
		  actionPerform();
		  verifyActionErrors(new String [] {"error.setup.country.errorcode"});
		  verifyTilesForward("error","common.error");
		  assertNull(request.getAttribute("name"));
		
	}
}
