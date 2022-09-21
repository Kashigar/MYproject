package org.hrm.ObjectRepository;

public enum TabNames {
	CORPORATE("CORPORATE"),ADMIN("ADMIN"),EMPLOYEE("EMPLOYEE"),BRANCH("BRANCH");
	
	private String tabName;
	private TabNames(String tabName) {
		this.tabName= tabName;
	}
	
	public String getTabName()
	{
		return tabName.toString();
	}
 
}
