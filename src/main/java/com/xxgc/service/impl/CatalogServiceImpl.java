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
 * 栏目实现
 * @author 花怜
 *
 */
@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Resource
	private CatalogMapper catalogMapper;
	
	@Resource
	private CatalogMapperCustom catalogMapperCustom;
	
	//分页查询catalog
	public List<Catalog> findByPage(Map<String, Object> map) {
		return catalogMapperCustom.findByPage(map);
	}
	
	//查询全部
	public List<Catalog> findAll(CatalogExample catalogExample){
		return catalogMapper.selectByExample(catalogExample);
	}

	//查询catalog总数
	public long countByExample(CatalogExample example) {
		return catalogMapper.countByExample(example);
	}

	//查询canumber最大值
	public int findMaxCanumber() {
		return catalogMapperCustom.findMaxCanumber();
	}

	//添加一条catalog
	public void saveCatalog(Catalog catalog) {
		catalogMapperCustom.saveCatalog(catalog);
	}

	//重复名称
	public Catalog findByName(String caname) {
		return catalogMapperCustom.findByName(caname);
	}
	
	//编辑跳转页面
	public Catalog findByCaid(int caid) {
		return catalogMapper.selectByPrimaryKey(caid);
	}
	
	//编辑栏目
	public void updateCatalog(Catalog catalog ,Integer caid) {
		catalogMapper.updateByPrimaryKeySelective(catalog);
	}

	//查询比canumber大的值
	public String findCanumber(String canumber) {
		return catalogMapperCustom.findCanumber(canumber);
	}

	//上移
	public void updateExchange(Map<String, Object> map) {
		catalogMapperCustom.updateExchange(map);
	}

	//删除栏目
	public void deleteCatalog(Integer caid) throws Exception {
		catalogMapper.deleteByPrimaryKey(caid);
	}

	//搜索
	public List<Catalog> searchByName(String caname) {
		return catalogMapperCustom.searchByName(caname);
	}

	//删除更新canumber
	public void deleteUpdate(String canumber) {
		catalogMapperCustom.delateUpdate(canumber);
	}

}
