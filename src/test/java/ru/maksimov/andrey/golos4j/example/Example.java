package ru.maksimov.andrey.golos4j.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;

import ru.maksimov.andrey.golos4j.api.method.BroadcastTransactionSynchronous;
import ru.maksimov.andrey.golos4j.api.method.GetAccountHistory;
import ru.maksimov.andrey.golos4j.api.method.GetConfig;
import ru.maksimov.andrey.golos4j.api.method.GetContent;
import ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.ConfigDto;
import ru.maksimov.andrey.golos4j.dto.DynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.api.GetBroadcastTransactionSynchronousDto;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.api.GetConfigDto;
import ru.maksimov.andrey.golos4j.dto.api.GetContentDto;
import ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.CommentDto;
import ru.maksimov.andrey.golos4j.dto.operation.TransferDto;
import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;
import ru.maksimov.andrey.golos4j.dto.transaction.BaseTransactionDto;
import ru.maksimov.andrey.golos4j.socket.ServiceWebSocket;
import ru.maksimov.andrey.golos4j.util.TransactionUtil;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Класс для примеров работы библиотеки
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Example {

	private static final Logger LOG = LogManager.getLogger(Example.class);

	// private static String URL_NODE = "wss://api.golos.cf";
	private static String WSS_URL_NODE = "wss://ws.golos.io";

	private static String PRIVATE_KEY = "5KSR7GpqiCZ5BEaXgMf8U75Sqofzpdnr5eS3F4HqULiMnBMqH3T";
	private static String PRIVATE_KEY2 = "pass";
	private static String ACCOUNT = "golos4j";

	public static void main(String[] args) throws Throwable {
		// getAccountHistory();
		// getDynamicGlobalProperties();
		// getConfig();
		// getContent();
		 broadcastTransactionSynchronousVote();
		// broadcastTransactionSynchronousComment();
		// broadcastTransactionSynchronousTransfer();
	}

	protected static GetAccountHistoryDto getAccountHistory() throws Exception {
		LOG.info("Start method getAccountHistory");
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "vik", -1, limit);
		GetAccountHistoryDto getAccountHistoryDto = ServiceWebSocket.executePost(getAccountHistory,
				GetAccountHistoryDto.class, WSS_URL_NODE);

		for (Entry<Long, AccountHistoryDto> entry : getAccountHistoryDto.getResults().entrySet()) {
			LOG.info("get result AccountHistoryDto key: " + entry.getKey());
			LOG.info("get result AccountHistoryDto value: " + entry.getValue());
		}
		LOG.info("Finish method getAccountHistory");
		return getAccountHistoryDto;
	}

	protected static GetDynamicGlobalPropertiesDto getDynamicGlobalProperties() throws Exception {
		LOG.info("Start method getDynamicGlobalProperties");
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = ServiceWebSocket
				.executePost(getDynamicGlobalProperties, GetDynamicGlobalPropertiesDto.class, WSS_URL_NODE);
		LOG.info("GetDynamicGlobalPropertiesDto: " + getDynamicGlobalPropertiesDto);
		LOG.info("Finish method getDynamicGlobalProperties");
		return getDynamicGlobalPropertiesDto;
	}

	protected static GetConfigDto getConfig() throws Exception {
		LOG.info("Start method getConfig");
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = ServiceWebSocket.executePost(getConfig, GetConfigDto.class,
				WSS_URL_NODE);
		LOG.info("GetConfigDto: " + getConfigDto);
		LOG.info("Finish method getConfig");
		return getConfigDto;
	}

	protected static GetContentDto getContent() throws Exception {
		LOG.info("Start method getContent");
		int id = 2;
		GetContent getConfig = new GetContent(id, ACCOUNT, "biblioteki-golos4j-0-0-12-reliz-changelog");
		GetContentDto getContentDto = ServiceWebSocket.executePost(getConfig, GetContentDto.class,
				WSS_URL_NODE);
		LOG.info("GetContentDto: " + getContentDto);
		LOG.info("Finish method getContent");
		return getContentDto;
	}

	protected static void broadcastTransactionSynchronousVote() throws Exception {
		LOG.info("Start method broadcastTransactionSynchronousVote");
		int id = 2;
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = getDynamicGlobalProperties();
		DynamicGlobalPropertiesDto dynamicGlobalPropertiesDto = getDynamicGlobalPropertiesDto.getResults();

		BaseTransactionDto baseTransactionDto = new BaseTransactionDto();
		long headBlockNumber = dynamicGlobalPropertiesDto.getHeadBlockNumber();
		String headBlockId = dynamicGlobalPropertiesDto.getHeadBlockId();
		int refBlockNum = TransactionUtil.long2Last2Byte(headBlockNumber);
		baseTransactionDto.setRefBlockNum(refBlockNum);
		long refBlockPrefix = TransactionUtil.hexString2Long(headBlockId, 4);
		baseTransactionDto.setRefBlockPrefix(refBlockPrefix);
		Date time = dynamicGlobalPropertiesDto.getTime();
		Date expiration = Util.addTime(time, BaseTransactionDto.DEFAULT_EXPIRATION_TIME);
		baseTransactionDto.setExpiration(expiration);
		List<BaseOperation> operations = baseTransactionDto.getOperations();
		VoteDto voteDto = new VoteDto();
		operations.add(voteDto);
		voteDto.setAuthor("ferryman");
		voteDto.setPermlink("podborka-novostej-fscp2018-04-01-15-51-36-135");
		voteDto.setVoter(ACCOUNT);
		voteDto.setWeight(10000);

		GetConfigDto getConfigDto = getConfig();
		ConfigDto configDto = getConfigDto.getResults();
		String chainId = configDto.getSteemitChainId();
		ECKey postingKey = DumpedPrivateKey.fromBase58(null, PRIVATE_KEY).getKey();
		baseTransactionDto.setSignatures(chainId, postingKey);

		LOG.info("get baseTransactionDto: " + baseTransactionDto);

		BroadcastTransactionSynchronous broadcastTransactionSynchronous = new BroadcastTransactionSynchronous(id,
				baseTransactionDto);
		GetBroadcastTransactionSynchronousDto broadcastTransactionSynchronousDto = ServiceWebSocket.executePost(broadcastTransactionSynchronous, GetBroadcastTransactionSynchronousDto.class,
				WSS_URL_NODE);

		LOG.info("Get result:" + broadcastTransactionSynchronousDto);
		LOG.info("Finish method broadcastTransactionSynchronousVote");
	}

	protected static void broadcastTransactionSynchronousComment() throws Exception {
		LOG.info("Start method broadcastTransactionSynchronousComment");
		int id = 2;
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = getDynamicGlobalProperties();
		DynamicGlobalPropertiesDto dynamicGlobalPropertiesDto = getDynamicGlobalPropertiesDto.getResults();

		BaseTransactionDto baseTransactionDto = new BaseTransactionDto();
		long headBlockNumber = dynamicGlobalPropertiesDto.getHeadBlockNumber();
		String headBlockId = dynamicGlobalPropertiesDto.getHeadBlockId();
		int refBlockNum = TransactionUtil.long2Last2Byte(headBlockNumber);
		baseTransactionDto.setRefBlockNum(refBlockNum);
		long refBlockPrefix = TransactionUtil.hexString2Long(headBlockId, 4);
		baseTransactionDto.setRefBlockPrefix(refBlockPrefix);
		Date time = dynamicGlobalPropertiesDto.getTime();
		Date expiration = Util.addTime(time, BaseTransactionDto.DEFAULT_EXPIRATION_TIME);
		baseTransactionDto.setExpiration(expiration);
		List<BaseOperation> operations = baseTransactionDto.getOperations();
		CommentDto commentDto = new CommentDto();
		operations.add(commentDto);
		String title = "Test post author " + ACCOUNT + " привет";
		String permlink = Util.title2Permlink(title);
		String image = "https://imgp.golos.io/0x0/http://s1.iconbird.com/ico/2013/8/429/w512h5121377940192185096settingsstreamline.png ";
		String body = "This is body. \n This is auto post write " + ACCOUNT + "! \n " + "(Тест, этот авто пост написан "
				+ ACCOUNT + ") \n " + image;

		Map<String, List<String>> key2value = new HashMap<String, List<String>>();
		List<String> tags = new ArrayList<String>();
		tags.add("ru--programmirovanie");
		tags.add("ru--golos4j");
		tags.add("api");
		List<String> images = new ArrayList<String>();
		images.add(image);

		key2value.put(CommentDto.TAGS_KEY, tags);
		key2value.put(CommentDto.IMAGE_KEY, images);
		// key2value.put(CommentDto.LINKS_KEY, value)
		commentDto.setAuthor(ACCOUNT);
		commentDto.setBody(body);
		commentDto.setJsonMetadata(key2value);
		commentDto.setParentAuthor("");
		commentDto.setParentPermlink("rzd-free-seat");
		commentDto.setPermlink(permlink);
		commentDto.setTitle(title);

		GetConfigDto getConfigDto = getConfig();
		ConfigDto configDto = getConfigDto.getResults();
		String chainId = configDto.getSteemitChainId();
		ECKey postingKey = DumpedPrivateKey.fromBase58(null, PRIVATE_KEY).getKey();
		baseTransactionDto.setSignatures(chainId, postingKey);

		LOG.info("get baseTransactionDto: " + baseTransactionDto);

		BroadcastTransactionSynchronous broadcastTransactionSynchronous = new BroadcastTransactionSynchronous(id,
				baseTransactionDto);
		GetBroadcastTransactionSynchronousDto broadcastTransactionSynchronousDto = ServiceWebSocket.executePost(broadcastTransactionSynchronous, GetBroadcastTransactionSynchronousDto.class,
				WSS_URL_NODE);

		LOG.info("Get result:" + broadcastTransactionSynchronousDto);
		LOG.info("Finish method broadcastTransactionSynchronousComment");
	}

	protected static void broadcastTransactionSynchronousTransfer() throws Exception {
		LOG.info("Start method broadcastTransactionSynchronousTransfer");
		int id = 2;
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = getDynamicGlobalProperties();
		DynamicGlobalPropertiesDto dynamicGlobalPropertiesDto = getDynamicGlobalPropertiesDto.getResults();

		BaseTransactionDto baseTransactionDto = new BaseTransactionDto();
		long headBlockNumber = dynamicGlobalPropertiesDto.getHeadBlockNumber();
		String headBlockId = dynamicGlobalPropertiesDto.getHeadBlockId();
		int refBlockNum = TransactionUtil.long2Last2Byte(headBlockNumber);
		baseTransactionDto.setRefBlockNum(refBlockNum);
		long refBlockPrefix = TransactionUtil.hexString2Long(headBlockId, 4);
		baseTransactionDto.setRefBlockPrefix(refBlockPrefix);
		Date time = dynamicGlobalPropertiesDto.getTime();
		Date expiration = Util.addTime(time, BaseTransactionDto.DEFAULT_EXPIRATION_TIME);
		baseTransactionDto.setExpiration(expiration);
		List<BaseOperation> operations = baseTransactionDto.getOperations();

		TransferDto transferDto = new TransferDto();
		operations.add(transferDto);
		transferDto.setFrom(ACCOUNT);
		transferDto.setTo("onixred");
		transferDto.setAmount("0.005 GOLOS");
		transferDto.setMemo("test log4j");

		GetConfigDto getConfigDto = getConfig();
		ConfigDto configDto = getConfigDto.getResults();
		String chainId = configDto.getSteemitChainId();

		org.bitcoinj.core.ECKey postingKey = org.bitcoinj.core.DumpedPrivateKey.fromBase58(null, PRIVATE_KEY2).getKey();

		baseTransactionDto.setSignatures(chainId, postingKey);

		LOG.info("get baseTransactionDto: " + baseTransactionDto);

		BroadcastTransactionSynchronous broadcastTransactionSynchronous = new BroadcastTransactionSynchronous(id,
				baseTransactionDto);
		GetBroadcastTransactionSynchronousDto broadcastTransactionSynchronousDto = ServiceWebSocket.executePost(broadcastTransactionSynchronous, GetBroadcastTransactionSynchronousDto.class,
				WSS_URL_NODE);

		LOG.info("Get result:" + broadcastTransactionSynchronousDto);
		LOG.info("Finish method broadcastTransactionSynchronousTransfer");
	}
}
