package kami.gdufe.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kami.gdufe.dao.BlackListDao;

@Repository
public class BlackListDaoImpl implements BlackListDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 在time时间内，比如10,就是查询10秒内IP的登录次数
	 */
	@Value("${seconds}")
	private String seconds;
	
	/**
	 * 查询time内ip登录次数
	 */
	@Override
	public Integer findIp(String ip) {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM IP_LIST WHERE IP = ? AND TIME > NOW() - INTERVAL ? SECOND", Integer.class, ip, seconds);
	}
	
	/**
	 * 插入登录的IP
	 */
	@Override
	public void InsertIp(String ip) {
		jdbcTemplate.update("INSERT INTO IP_LIST (IP, TIME) VALUES (?, ?)", ip, new Date());
	}
	
	/**
	 * 查询ip是否在黑名单
	 */
	@Override
	public boolean isInBlackList(String ip) {
		Integer blackIp = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM BLACK_LIST WHERE IP = ?", Integer.class, ip);
		if(blackIp != null && blackIp > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 插入黑名单
	 */
	@Override
	public void insertBlackList(String ip) {
		jdbcTemplate.update("INSERT INTO BLACK_LIST (IP) VALUES (?)", ip);
	}
}
