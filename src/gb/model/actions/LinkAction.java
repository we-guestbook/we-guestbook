package gb.model.actions;


public class LinkAction {

	private static final long serialVersionUID = -2613425890762568273L;
	
	public String welcome(){
	    return "welcome";
	}
	
	public String deleteGuestbookentry()
    {
        return "deleteGuestbookentry";        
    }
	
	public String createGuestbookentry()
    {
        return "createGuestbookentry";        
    }
	
	public String deleteAccount()
    {
        return "deleteAccount";        
    }
	
	public String login()
    {
        return "login";        
    }
	
	public String searchEntry()
    {
        return "searchEntry";        
    }
	
	public String userRegistration()
    {
        return "userRegistration";        
    }
	
	public String viewEntry()
    {
        return "viewEntry";        
    }
}
