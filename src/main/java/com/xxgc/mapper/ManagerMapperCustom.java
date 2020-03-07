package com.xxgc.mapper;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Manager;

public interface ManagerMapperCustom {

	List<Manager> findByPage(Map<String, Object> map);
	
	void saveManager(Manager manager);
	
	Manager findByName(String managerName);
	
	List<Manager> searchByName(Map<String, Object> map);
	
	void updateMaimage(Map<String, Object> map);
}
