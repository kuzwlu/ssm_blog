package com.xxgc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxgc.mapper.ManagerMapper;
import com.xxgc.mapper.ManagerMapperCustom;
import com.xxgc.po.Manager;
import com.xxgc.po.ManagerExample;
import com.xxgc.service.ManagerService;

/**
 * 管理员实现类
 * @author 花怜
 *
 */

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerMapper managerMapper;
	
	@Autowired
	private ManagerMapperCustom managerMapperCustom;

	//管理员列表（分页）
	public List<Manager> findByPage(Map<String, Object> map) {
		return managerMapperCustom.findByPage(map);
	}
	
	//添加管理员
	public void saveManager(Manager manager) {
		managerMapperCustom.saveManager(manager);
	}

	//查询相同姓名
	public Manager findByName(String managername) {
		return managerMapperCustom.findByName(managername);
	}

	//查询全部数据
	public List<Manager> findAll(ManagerExample managerExample) {
		return managerMapper.selectByExample(managerExample);
	}

	//编辑管理员
	public void updateManager(Manager manager,Integer managerid) throws Exception {
		manager.setManagerid(managerid);
		managerMapper.updateByPrimaryKeyWithBLOBs(manager);
	}
	//通过id查询manager信息
	public Manager findByManagerId(int managerid) {
		return managerMapper.selectByPrimaryKey(managerid);
	}

	//删除一条manager
	public void deleteManager(int managerid) throws Exception {
		managerMapper.deleteByPrimaryKey(managerid);
	}

	//根据managername模糊查询
	public List<Manager> searchByName(Map<String, Object> map) {
		return managerMapperCustom.searchByName(map);
	}

	//添加头像
	public void updateMaimage(Map<String, Object> map) throws Exception {
		managerMapperCustom.updateMaimage(map);
	}
}
