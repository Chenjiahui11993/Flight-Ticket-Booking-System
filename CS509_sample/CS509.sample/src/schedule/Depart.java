package schedule;

import java.lang.reflect.Constructor;

public class Depart {
	String airplane;
	String number;
	String dLocation;
	String aLocation;
	String ftime;
	String dtime;
	String atime;
	String fClass;
	String Cclass;
	String fPrice;
	String cPrice;
	String itime;
	public Depart() {
		// TODO Auto-generated constructor stub
	}
	public Depart(String dLocation, String aLocation, String time, String fClass, String Cclass, String fPrice, String cPrice, String itime ) {
		this.dLocation = dLocation;
		this.aLocation = aLocation;
		this.atime = time;
		this.fClass = fClass;
		this.Cclass = Cclass;
		this.fPrice = fPrice;
		this.cPrice = cPrice;
		this.itime = itime;
	}
	public String getdLocation() {
		return dLocation;
	}
	public void setdLocation(String dLocation) {
		this.dLocation = dLocation;
	}
	public String getaLocation() {
		return aLocation;
	}
	public void setaLocation(String aLocation) {
		this.aLocation = aLocation;
	}
	public void setTime(String time) {
		this.atime = time;
	}
	public String getfClass() {
		return fClass;
	}
	public void setfClass(String fClass) {
		this.fClass = fClass;
	}
	public String getCclass() {
		return Cclass;
	}
	public void setCclass(String cclass) {
		Cclass = cclass;
	}
	public String getfPrice() {
		return fPrice;
	}
	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}
	public String getcPrice() {
		return cPrice;
	}
	public void setcPrice(String cPrice) {
		this.cPrice = cPrice;
	}
	public String getAirplane() {
		return airplane;
	}
	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getItime() {
		return itime;
	}
	public void setItime(String itime) {
		this.itime = itime;
	}

}
