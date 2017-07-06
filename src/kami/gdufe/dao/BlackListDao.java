package kami.gdufe.dao;

public interface BlackListDao {

	Integer findIp(String ip);

	void InsertIp(String ip);

	void insertBlackList(String ip);

	boolean isInBlackList(String ip);
}
