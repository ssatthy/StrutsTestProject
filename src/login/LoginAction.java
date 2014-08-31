package login;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, 
			HttpServletResponse response){
		
		String username = ((LoginForm) form).getUsername();
		String password = ((LoginForm) form).getPassword();
		
		ActionErrors errors= new ActionErrors();
		
		if((username!=null||password!=null)&&username.equals("ssatthy")&&password.equals("ssatthy")){
			request.getSession().setAttribute("authentication",username );
			System.out.println("Successful login");
			return mapping.findForward("success");
		}else {
			ActionMessage error1= new ActionMessage("error.password.mismatch");
			ActionMessages msgs = new ActionMessages();
			msgs.add("password",error1);
			errors.add(msgs);
			saveErrors(request, errors);
			System.out.println("Failed login");
			return  mapping.findForward("error");
		}
		
	}

}
