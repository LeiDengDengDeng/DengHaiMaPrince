package demo.dataservice;

import java.util.Date;

import demo.po.ImportListPO;

public interface ImportListDataService {
	
	/**
	 * 插入进货单，包括进货单的每一项
	 * @param importList 要插入的进货单
	 * @return 是否成功
	 */
	public boolean insert(ImportListPO importList);
	
	/**
	 * 获取当天最近编号，格式为JHD-yyyyMMdd-xxxxx
	 * @param date 获取日期
	 * @return 返回最近编号，若当天未有编号，则返回JHD-yyyyMMdd-00000
	 */
	public String getLatestNo(Date date);
}
