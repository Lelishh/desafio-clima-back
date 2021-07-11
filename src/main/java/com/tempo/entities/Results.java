package com.tempo.entities;

import java.util.List;

public class Results{
    public int temp;
    public String date;
    public String time;
    public String condition_code;
    public String description;
    public String currently;
    public String cid;
    public String city;
    public String img_id;
    public int humidity;
    public String wind_speedy;
    public String sunrise;
    public String sunset;
    public String condition_slug;
    public String city_name;
    public List<Forecast> forecast;
    public double latitude;
    public double longitude;
    
    
    
	@Override
	public String toString() {
		return "Results [temp=" + temp + ", date=" + date + ", time=" + time + ", condition_code=" + condition_code
				+ ", description=" + description + ", currently=" + currently + ", cid=" + cid + ", city=" + city
				+ ", img_id=" + img_id + ", humidity=" + humidity + ", wind_speedy=" + wind_speedy + ", sunrise="
				+ sunrise + ", sunset=" + sunset + ", condition_slug=" + condition_slug + ", city_name=" + city_name
				+ ", forecast=" + forecast + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
    
    
    
}
