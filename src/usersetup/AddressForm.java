package usersetup;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddressForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7996688962028640355L;
	
	private String name=null;
	private String street=null;
	private String city=null;
	private String country=null;
	private int zip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request){
		
		ActionErrors errors = new ActionErrors();
		
		if(this.name==null||this.name.equals("")){
			errors.add("name",new ActionMessage("errors.required","Name"));
		}
		if(this.city==null||this.city.equals("")){
			errors.add("city",new ActionMessage("errors.required","City"));
		}
		if(this.zip==0){
			errors.add("zip",new ActionMessage("errors.required","Zip"));
		}
	
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		this.name=null;
		this.street=null;
		this.country=null;
		this.city=null;
		super.reset(mapping, request);
	}

}
