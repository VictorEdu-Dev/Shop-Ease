package com.shopease.util;

import java.util.List;
import java.util.Map;

public interface MappingEntity<K, V> {
	public Map<K, List<V>> getNumberEntity();
}
