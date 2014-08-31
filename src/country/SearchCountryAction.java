package country;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class SearchCountryAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
			HttpServletResponse response){
				
		String code = request.getParameter("code");
		
		ActionErrors errors= new ActionErrors();
		
		// build locale and get details
		Locale locale = null;
		try {
			locale = new Locale.Builder().setRegion(code).build();
			request.setAttribute("name", code +"-"+locale.getDisplayCountry());
			
		} catch (IllformedLocaleException e) {
			ActionMessage error1= new ActionMessage("error.setup.country.errorcode");
			ActionMessages msgs = new ActionMessages();
			msgs.add("code",error1);
			errors.add(msgs);
			saveErrors(request, errors);
			System.out.println("Error in finding country name!");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("country");
	}

}
