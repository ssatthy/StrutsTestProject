package usersetup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddressAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form, 
			HttpServletRequest request, HttpServletResponse response){
		
		if(getErrors(request)==null||getErrors(request).size()==0){
			return mapping.findForward("success");
		}
		return mapping.getInputForward();
	}

}
