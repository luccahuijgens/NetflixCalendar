package nl.hu.v1ipass.thirdapp.model;

public class Studio {
private String name;
private String originDate;

public Studio(String name, String originDate) {
	super();
	this.name = name;
	this.originDate = originDate;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getOriginDate() {
	return originDate;
}

public void setOriginDate(String originDate) {
	this.originDate = originDate;
}


}
