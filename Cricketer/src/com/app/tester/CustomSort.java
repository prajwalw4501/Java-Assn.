package com.app.tester;

import java.util.Comparator;

import com.app.core.Cricketer;

public class CustomSort implements Comparator<Cricketer> {

	@Override
	public int compare(Cricketer o1, Cricketer o2) {
		if (o1.getRating() > o2.getRating())
			return 1;
		else if (o1.getRating() < o2.getRating())
			return -1;

		return 0;
	}

}
