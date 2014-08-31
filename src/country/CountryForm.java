package country;

import org.apache.struts.action.ActionForm;

public class CountryForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 170104934871261682L;
	
	private String name="";
	private String code="";
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
