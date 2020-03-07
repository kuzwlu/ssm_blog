package com.xxgc.service;

import java.util.List;
import java.util.Map;


import com.xxgc.po.Manager;
import com.xxgc.po.ManagerExample;

/**
 * ����Ա
 * @author ����
 *
 */

public interface ManagerService {
	
	//��ҳ��ѯmanagerȫ������
	public List<Manager> findByPage(Map<String, Object> map);
	//��ѯmanagerȫ������
	public List<Manager> findAll(ManagerExample managerExample);
	//���һ������
	public void saveManager(Manager manager) throws Exception;
	//ͨ��managername��ѯһ������
	Manager findByName(String managerName);
	//ͨ��managerid��ѯһ����¼
	Manager findByManagerId(int managerid);
	//�޸�manager
	public void updateManager(Manager manager,Integer managerid)throws Exception;
	//ɾ��һ����¼
	public void deleteManager(int managerid) throws Exception;
	//ģ����ѯmanagername
	public List<Manager> searchByName(Map<String, Object> map);
	//���maimage
	public void updateMaimage(Map<String, Object> map)throws Exception;
}
