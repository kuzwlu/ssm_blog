package com.xxgc.service;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Catalog;
import com.xxgc.po.CatalogExample;

/**
 * ��Ŀ
 * @author ����
 *
 */
public interface CatalogService {
	
	//��ҳ��ѯcatalog
	public List<Catalog> findByPage(Map<String, Object> map);
	
	//��ѯȫ��catalog
	public List<Catalog> findAll(CatalogExample catalogExample);
	
	//��ѯcatalog����
	public long countByExample(CatalogExample example);
	
	//��ѯcanumber���ֵ
	public int findMaxCanumber();
	
	//���һ������
	public void saveCatalog(Catalog catalog) throws Exception;
	
	//��ѯ��caname��ƥ���һ��catalog
	public Catalog findByName(String caname);
	
	//����caid��ѯcatalog
	public Catalog findByCaid(int caid);
	
	//�༭catalog
	public void updateCatalog(Catalog catalog,Integer caid) throws Exception;
	
	//findCanumber
	public String findCanumber(String canumber);
	
	//����canumber
	public void updateExchange(Map<String, Object> map) throws Exception;
	
	//ɾ��catalog
	public void deleteCatalog(Integer caid) throws Exception;
	
	//ɾ������canumber
	public void deleteUpdate(String canumber);
	
	//����
	public List<Catalog> searchByName(String caname);
}
