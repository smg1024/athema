package com.athema.frame;

import java.util.List;

public interface AthemaMapper<K,V> {
	public void insert(V v) throws Exception;
	public void delete(K k) throws Exception;
	public void update(V v) throws Exception;
	
	public V select(K k) throws Exception;
	public List<V> selectall() throws Exception;
}
