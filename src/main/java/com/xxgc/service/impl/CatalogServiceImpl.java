package com.xxgc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxgc.mapper.CatalogMapper;
import com.xxgc.mapper.CatalogMapperCustom;
import com.xxgc.po.Catalog;
import com.xxgc.po.CatalogExample;
import com.xxgc.service.CatalogService;

/**
 * ��Ŀʵ��
 * @author ����
 *
 */
@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Resource
	private CatalogMapper catalogMapper;
	
	@Resource
	private CatalogMapperCustom catalogMapperCustom;
	
	//��ҳ��ѯcatalog
	public List<Catalog> findByPage(Map<String, Object> map) {
		return catalogMapperCustom.findByPage(map);
	}
	
	//��ѯȫ��
	public List<Catalog> findAll(CatalogExample catalogExample){
		return catalogMapper.selectByExample(catalogExample);
	}

	//��ѯcatalog����
	public long countByExample(CatalogExample example) {
		return catalogMapper.countByExample(example);
	}

	//��ѯcanumber���ֵ
	public int findMaxCanumber() {
		return catalogMapperCustom.findMaxCanumber();
	}

	//���һ��catalog
	public void saveCatalog(Catalog catalog) {
		catalogMapperCustom.saveCatalog(catalog);
	}

	//�ظ�����
	public Catalog findByName(String caname) {
		return catalogMapperCustom.findByName(caname);
	}
	
	//�༭��תҳ��
	public Catalog findByCaid(int caid) {
		return catalogMapper.selectByPrimaryKey(caid);
	}
	
	//�༭��Ŀ
	public void updateCatalog(Catalog catalog ,Integer caid) {
		catalogMapper.updateByPrimaryKeySelective(catalog);
	}

	//��ѯ��canumber���ֵ
	public String findCanumber(String canumber) {
		return catalogMapperCustom.findCanumber(canumber);
	}

	//����
	public void updateExchange(Map<String, Object> map) {
		catalogMapperCustom.updateExchange(map);
	}

	//ɾ����Ŀ
	public void deleteCatalog(Integer caid) throws Exception {
		catalogMapper.deleteByPrimaryKey(caid);
	}

	//����
	public List<Catalog> searchByName(String caname) {
		return catalogMapperCustom.searchByName(caname);
	}

	//ɾ������canumber
	public void deleteUpdate(String canumber) {
		catalogMapperCustom.delateUpdate(canumber);
	}

}
