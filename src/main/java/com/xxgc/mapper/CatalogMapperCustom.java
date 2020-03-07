package com.xxgc.mapper;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Catalog;

public interface CatalogMapperCustom {
	List<Catalog> findByPage(Map<String, Object> map);
	
	int findMaxCanumber();
	
	void saveCatalog(Catalog catalog);
	
	Catalog findByName(String caname);
	
	String findCanumber(String canumber);
	
	void updateExchange(Map<String, Object> map);
	
	List<Catalog> searchByName(String caname);
	
	void delateUpdate(String canumber);
}
