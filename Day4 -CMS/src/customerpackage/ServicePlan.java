package customerpackage;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(1000);


private double charge;
ServicePlan(double charge){
	this.charge=charge;
	}

}

