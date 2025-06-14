Feature: User Login

  Scenario: Successful Login with Valid Credentials 
	 Given User Launch Chrome browser 
	 When User opens URL "https://demo3x.opencartreports.com/admin/index.php?route=common/login" 
	 And User enters Email as "demo" and Password as "demo" 
	 And Click on Login 
	 Then Page Title should be "Dashboard" 
	 When User click on Log out link 
	 Then Page Title should be "Administration" 
	 And close browser 	
	
	
	Scenario Outline: Successful Login with Valid and Invalid Credentials 
	 Given User Launch Chrome browser 
	 When User opens URL "https://demo3x.opencartreports.com/admin/index.php?route=common/login" 
	 And User enters Email as "<email>" and Password as "<password>" 
	 And Click on Login 
	 Then Page Title should be "Dashboard" 
	 When User click on Log out link 
	 Then Page Title should be "Administration" 
	 And close browser 
	 
Examples:
|email|password|
|demo|demo|
|test@gmail.com|demo|