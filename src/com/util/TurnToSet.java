package com.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TurnToSet {
	public Set turnListToSet(List list){
		Set set =new HashSet();
		for (Object obj : list) {
			set.add(obj);
		}
		return set;
	}

}
