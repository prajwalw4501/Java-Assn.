package com.app.utils;

import java.util.HashMap;

import com.app.core.Items;
import com.app.exception.DuplicateItemExcep;

public class ValidationRule {
	public static Items validateItem(String code, HashMap<String, Items> map) throws DuplicateItemExcep {
		Items item = map.get(code);
		if (map.containsKey(code))
			throw new DuplicateItemExcep("Item Already in DS");
		return item;
	}
}
