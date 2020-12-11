package com.jd.blockchain.consensus.client;

import com.jd.blockchain.consensus.ClientCredential;
import com.jd.blockchain.consensus.ClientIncomingSettings;
import com.jd.blockchain.consensus.CredentialInfo;
import com.jd.blockchain.crypto.AsymmetricKeypair;

public interface ClientFactory {

	/**
	 * 创建客户端的认证身份；
	 * 
	 * @param credentialInfo 已有的凭证信息；如果为 null，则方法会产生一个默认凭证；
	 * @param clientKeyPair
	 * @return
	 */
	ClientCredential buildAuthId(CredentialInfo credentialInfo, AsymmetricKeypair clientKeyPair);

	/**
	 * 根据接入配置信息创建客户端的本地连接配置；
	 * 
	 * @param incomingSettings
	 * @return
	 */
	ClientSettings buildClientSettings(ClientIncomingSettings incomingSettings);

//	/**
//	 * 创建共识管理服务的客户端代理；<br>
//	 * 
//	 * 当一个共识网络的节点启动共识服务之后，其中的一些或者全部节点会暴露一个专门的管理服务端口，用于提供客户端接入认证服务和新节点接入认证服务；
//	 * 
//	 * <br>
//	 * 
//	 * 作为客户端，可以选择其中的一个或者多个节点的管理服务端口进行接入认证；<br>
//	 * 
//	 * 不同的共识算法可以自行决定实现不同的连接策略，例如：从参数指定的地址列表中随机挑选一个可成功建立连接的节点，或者同时连接多个以进行客户端交叉验证；
//	 * 
//	 * @param serviceNodes
//	 * @return
//	 */
//	ConsensusManageService createManageServiceClient(String[] serviceNodes);

	/**
	 * 根据共识客户端的配置信息建立一个共识客户端实例；
	 * 
	 * @param settings
	 * @return
	 */
	ConsensusClient setupClient(ClientSettings settings);

}
