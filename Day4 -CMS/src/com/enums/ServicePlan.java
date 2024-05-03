package com.enums;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);


private int charge;
ServicePlan(int charge){
	this.charge=charge;
	}
@Override
public String toString() {
	return name()+" : "+charge;
}
public int getCharge() {
	return charge;
}


}