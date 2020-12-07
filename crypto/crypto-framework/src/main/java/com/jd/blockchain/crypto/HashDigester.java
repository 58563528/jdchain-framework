package com.jd.blockchain.crypto;

import com.jd.blockchain.utils.security.Hasher;

public interface HashDigester extends Hasher{

	/**
	 * 追加要一起计算哈希的数据；
	 * 
	 * @param bytes
	 */
	@Override
	void update(byte[] bytes);

	/**
	 * 追加要一起计算哈希的数据；
	 * 
	 * @param bytes
	 */
	@Override
	void update(byte[] bytes, int offset, int len);

	/**
	 * 完成哈希计算并返回原始的哈希摘要结果；
	 * 
	 * @return
	 */
	@Override
	byte[] complete();

	/**
	 * 完成哈希计算；
	 * 
	 * @return
	 */
	HashDigest completeDigest();
}