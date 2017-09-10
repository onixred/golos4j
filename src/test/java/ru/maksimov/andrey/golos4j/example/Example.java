package ru.maksimov.andrey.golos4j.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bitcoinj.core.DumpedPrivateKey;
import org.bitcoinj.core.ECKey;

import ru.maksimov.andrey.golos4j.api.method.BroadcastTransactionSynchronous;
import ru.maksimov.andrey.golos4j.api.method.GetAccountHistory;
import ru.maksimov.andrey.golos4j.api.method.GetConfig;
import ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.ConfigDto;
import ru.maksimov.andrey.golos4j.dto.DynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.api.GetBroadcastTransactionSynchronousDto;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.api.GetConfigDto;
import ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.CommentDto;
import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;
import ru.maksimov.andrey.golos4j.dto.transaction.BaseTransactionDto;
import ru.maksimov.andrey.golos4j.util.TransactionUtil;
import ru.maksimov.andrey.golos4j.util.Util;
import ru.maksimov.andrey.golos4j.util.UtilTest;

/**
 * Класс для примеров работы библиотеки
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Example {

	public static void main(String[] args) throws Throwable {
		// getAccountHistory();
		// getDynamicGlobalProperties();
		// getConfig();
		// broadcastTransactionSynchronousVote();
		broadcastTransactionSynchronousComment();
	}

	protected static GetAccountHistoryDto getAccountHistory() throws Exception {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = UtilTest.executePost(getAccountHistory, GetAccountHistoryDto.class);
		System.out.println("getAccountHistoryDto: ");
		for (Entry<Integer, AccountHistoryDto> entry : getAccountHistoryDto.getResults().entrySet()) {
			System.out.print("key " + entry.getKey());
			System.out.println(" value " + entry.getValue());
		}
		return getAccountHistoryDto;
	}

	protected static GetDynamicGlobalPropertiesDto getDynamicGlobalProperties() throws Exception {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = UtilTest.executePost(getDynamicGlobalProperties,
				GetDynamicGlobalPropertiesDto.class);
		System.out.println("getDynamicGlobalPropertiesDto: " + getDynamicGlobalPropertiesDto);
		return getDynamicGlobalPropertiesDto;
	}

	protected static GetConfigDto getConfig() throws Exception {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = UtilTest.executePost(getConfig, GetConfigDto.class);
		System.out.println("getDynamicGlobalPropertiesDto: " + getConfigDto);
		return getConfigDto;
	}

	protected static void broadcastTransactionSynchronousVote() throws Exception {
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
		voteDto.setAuthor("pro100dasha");
		voteDto.setPermlink("k-nam-prishla-zhara");
		voteDto.setVoter("golos4j");
		voteDto.setWeight(10000);

		GetConfigDto getConfigDto = getConfig();
		ConfigDto configDto = getConfigDto.getResults();
		String chainId = configDto.getSteemitChainId();
		ECKey postingKey = DumpedPrivateKey.fromBase58(null, "5KSR7GpqiCZ5BEaXgMf8U75Sqofzpdnr5eS3F4HqULiMnBMqH3T")
				.getKey();
		baseTransactionDto.setSignatures(chainId, postingKey);

		System.out.println("baseTransactionDto.toBytes(): " + Arrays.toString(baseTransactionDto.toBytes().toArray()));
		System.out.println("baseTransactionDto.toBytes(): " + Util.bytes2Hex(baseTransactionDto.toBytes()));
		System.out.println("baseTransactionDto: " + baseTransactionDto);

		BroadcastTransactionSynchronous broadcastTransactionSynchronous = new BroadcastTransactionSynchronous(id,
				baseTransactionDto);
		GetBroadcastTransactionSynchronousDto broadcastTransactionSynchronousDto = UtilTest
				.executePost(broadcastTransactionSynchronous, GetBroadcastTransactionSynchronousDto.class);

		System.out.println("broadcastTransactionSynchronousDto result: " + broadcastTransactionSynchronousDto);
	}

	protected static void broadcastTransactionSynchronousComment() throws Exception {
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
		String title = "Test post author golos4j привет";
		String permlink = Util.title2Permlink(title);
		String image = "https://imgp.golos.io/0x0/http://s1.iconbird.com/ico/2013/8/429/w512h5121377940192185096settingsstreamline.png ";
		String body = "This is body. \n This is auto post write golos4j! \n "
				+ "(Тест, этот авто пост написан golos4j) \n "
				+ image;

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
		commentDto.setAuthor("golos4j");
		commentDto.setBody(body);
		commentDto.setJsonMetadata(key2value);
		commentDto.setParentAuthor("");
		commentDto.setParentPermlink("rzd-free-seat");
		commentDto.setPermlink(permlink);
		commentDto.setTitle(title);

		GetConfigDto getConfigDto = getConfig();
		ConfigDto configDto = getConfigDto.getResults();
		String chainId = configDto.getSteemitChainId();
		ECKey postingKey = DumpedPrivateKey.fromBase58(null, "5KSR7GpqiCZ5BEaXgMf8U75Sqofzpdnr5eS3F4HqULiMnBMqH3T")
				.getKey();
		baseTransactionDto.setSignatures(chainId, postingKey);

		System.out.println("baseTransactionDto.toBytes(): " + Arrays.toString(baseTransactionDto.toBytes().toArray()));
		System.out.println("baseTransactionDto.toBytes(): " + Util.bytes2Hex(baseTransactionDto.toBytes()));
		System.out.println("baseTransactionDto: " + baseTransactionDto);

		BroadcastTransactionSynchronous broadcastTransactionSynchronous = new BroadcastTransactionSynchronous(id,
				baseTransactionDto);
		GetBroadcastTransactionSynchronousDto broadcastTransactionSynchronousDto = UtilTest
				.executePost(broadcastTransactionSynchronous, GetBroadcastTransactionSynchronousDto.class);

		System.out.println("broadcastTransactionSynchronousDto result: " + broadcastTransactionSynchronousDto);
	}
}
