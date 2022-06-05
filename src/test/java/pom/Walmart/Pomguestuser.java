package pom.Walmart;

import org.openqa.selenium.support.PageFactory;

import walmart.basepackage.Walmartbasepackage;

public class Pomguestuser extends Walmartbasepackage {
	

	
public Pomguestuser() {
	PageFactory.initElements(getdriver(), this);
}
	
	
	
}
