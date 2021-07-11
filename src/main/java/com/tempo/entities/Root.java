package com.tempo.entities;

public class Root{
    public String by;
    public boolean valid_key;
    public Results results;
    public int execution_time;
    public boolean from_cache;
    
    
	@Override
	public String toString() {
		return "Root [by=" + by + ", valid_key=" + valid_key + ", results=" + results + ", execution_time="
				+ execution_time + ", from_cache=" + from_cache + "]";
	}
    
    
}
