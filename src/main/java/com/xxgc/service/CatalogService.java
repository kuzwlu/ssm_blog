package com.xxgc.service;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Catalog;
import com.xxgc.po.CatalogExample;

/**
 * 栏目
 * @author 花怜
 *
 */
public interface CatalogService {
	
	//分页查询catalog
	public List<Catalog> findByPage(Map<String, Object> map);
	
	//查询全部catalog
	public List<Catalog> findAll(CatalogExample catalogExample);
	
	//查询catalog总数
	public long countByExample(CatalogExample example);
	
	//查询canumber最大值
	public int findMaxCanumber();
	
	//添加一条数据
	public void saveCatalog(Catalog catalog) throws Exception;
	
	//查询和caname相匹配的一条catalog
	public Catalog findByName(String caname);
	
	//根据caid查询catalog
	public Catalog findByCaid(int caid);
	
	//编辑catalog
	public void updateCatalog(Catalog catalog,Integer caid) throws Exception;
	
	//findCanumber
	public String findCanumber(String canumber);
	
	//交换canumber
	public void updateExchange(Map<String, Object> map) throws Exception;
	
	//删除catalog
	public void deleteCatalog(Integer caid) throws Exception;
	
	//删除更新canumber
	public void deleteUpdate(String canumber);
	
	//搜索
	public List<Catalog> searchByName(String caname);
}
