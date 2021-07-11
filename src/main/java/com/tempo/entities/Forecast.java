package com.tempo.entities;

public class Forecast {

	public String date;
    public String weekday;
    public int max;
    public int min;
    public String description;
    public String condition;
    
    
    
	@Override
	public String toString() {
		return "Forecast [date=" + date + ", weekday=" + weekday + ", max=" + max + ", min=" + min + ", description="
				+ description + ", condition=" + condition + "]";
	}
    
    
}
