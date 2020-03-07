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
 * ����Աʵ����
 * @author ����
 *
 */

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerMapper managerMapper;
	
	@Autowired
	private ManagerMapperCustom managerMapperCustom;

	//����Ա�б���ҳ��
	public List<Manager> findByPage(Map<String, Object> map) {
		return managerMapperCustom.findByPage(map);
	}
	
	//��ӹ���Ա
	public void saveManager(Manager manager) {
		managerMapperCustom.saveManager(manager);
	}

	//��ѯ��ͬ����
	public Manager findByName(String managername) {
		return managerMapperCustom.findByName(managername);
	}

	//��ѯȫ������
	public List<Manager> findAll(ManagerExample managerExample) {
		return managerMapper.selectByExample(managerExample);
	}

	//�༭����Ա
	public void updateManager(Manager manager,Integer managerid) throws Exception {
		manager.setManagerid(managerid);
		managerMapper.updateByPrimaryKeyWithBLOBs(manager);
	}
	//ͨ��id��ѯmanager��Ϣ
	public Manager findByManagerId(int managerid) {
		return managerMapper.selectByPrimaryKey(managerid);
	}

	//ɾ��һ��manager
	public void deleteManager(int managerid) throws Exception {
		managerMapper.deleteByPrimaryKey(managerid);
	}

	//����managernameģ����ѯ
	public List<Manager> searchByName(Map<String, Object> map) {
		return managerMapperCustom.searchByName(map);
	}

	//���ͷ��
	public void updateMaimage(Map<String, Object> map) throws Exception {
		managerMapperCustom.updateMaimage(map);
	}
}
