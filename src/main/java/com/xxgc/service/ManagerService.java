package com.xxgc.service;

import java.util.List;
import java.util.Map;


import com.xxgc.po.Manager;
import com.xxgc.po.ManagerExample;

/**
 * 管理员
 * @author 花怜
 *
 */

public interface ManagerService {
	
	//分页查询manager全部数据
	public List<Manager> findByPage(Map<String, Object> map);
	//查询manager全部数据
	public List<Manager> findAll(ManagerExample managerExample);
	//添加一条数据
	public void saveManager(Manager manager) throws Exception;
	//通过managername查询一条数据
	Manager findByName(String managerName);
	//通过managerid查询一条记录
	Manager findByManagerId(int managerid);
	//修改manager
	public void updateManager(Manager manager,Integer managerid)throws Exception;
	//删除一条记录
	public void deleteManager(int managerid) throws Exception;
	//模糊查询managername
	public List<Manager> searchByName(Map<String, Object> map);
	//添加maimage
	public void updateMaimage(Map<String, Object> map)throws Exception;
}
