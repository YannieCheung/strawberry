package edu.zipcloud.cloudstreetmarket.core.daos;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.zipcloud.cloudstreetmarket.core.entities.Transaction;
import edu.zipcloud.cloudstreetmarket.core.entities.User;

public interface TransactionRepository {
	/**
	 * 查找全部交易
	 * @return
	 */
//	Iterable<Transaction> findAll();
	Page<Transaction> findAll(Pageable pageable);
	/**
	 * 根据用户查找交易
	 * @param user
	 * @return
	 */
	Iterable<Transaction> findByUser(User user);
	/**
	 * 查询从某日起所有的交易
	 * @param from
	 * @return
	 */
	Iterable<Transaction> findRecentTransactions(Date from);
	/**
	 * 查找最近nb次的交易记录
	 * @param nb
	 * @return
	 */
	Iterable<Transaction> findRecentTransactions(int nb);
}
