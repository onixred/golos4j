package ru.maksimov.andrey.golos4j.example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
import ru.maksimov.andrey.golos4j.dto.api.BroadcastTransactionSynchronousDto;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.api.GetConfigDto;
import ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
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
		broadcastTransactionSynchronous();
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

	protected static void broadcastTransactionSynchronous() throws Exception {
		int id = 2;
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = getDynamicGlobalProperties();
		DynamicGlobalPropertiesDto dynamicGlobalPropertiesDto = getDynamicGlobalPropertiesDto.getResults();

		BaseTransactionDto baseTransactionDto = new BaseTransactionDto();
		long headBlockNumber = dynamicGlobalPropertiesDto.getHeadBlockNumber();
		String headBlockId = dynamicGlobalPropertiesDto.getHeadBlockId();
		int refBlockNum = TransactionUtil.long2Last2Byte(headBlockNumber);
		refBlockNum = 36029;
		baseTransactionDto.setRefBlockNum(refBlockNum);
		long refBlockPrefix = TransactionUtil.hexString2Long(headBlockId, 4);
		refBlockPrefix = 1164960351;
		baseTransactionDto.setRefBlockPrefix(refBlockPrefix);
		Date time = dynamicGlobalPropertiesDto.getTime();
		Date expiration = Util.addTime(time, BaseTransactionDto.DEFAULT_EXPIRATION_TIME);
		baseTransactionDto.setExpiration(expiration);
		List<BaseOperation> operations = baseTransactionDto.getOperations();
		VoteDto voteDto = new VoteDto();
		operations.add(voteDto);
		voteDto.setAuthor("onixred");
		voteDto.setPermlink("gusi-pod-dozhdyom-skachut-a-ya-pishu-api-dlya-golosa");
		voteDto.setVoter("golos4j");
		voteDto.setWeight(10000);

		GetConfigDto getConfigDto = getConfig();
		ConfigDto configDto = getConfigDto.getResults();
		String chainId = configDto.getSteemitChainId();
		ECKey postingKey = DumpedPrivateKey.fromBase58(null, "!private key!").getKey();
		baseTransactionDto.setSignatures(chainId, postingKey);

		System.out.println("baseTransactionDto.toBytes(): " + Arrays.toString(baseTransactionDto.toBytes().toArray()));
		System.out.println("baseTransactionDto.toBytes(): " + Util.bytes2Hex(baseTransactionDto.toBytes()));
		System.out.println("baseTransactionDto: " + baseTransactionDto);

		BroadcastTransactionSynchronous broadcastTransactionSynchronous = new BroadcastTransactionSynchronous(id,
				baseTransactionDto);
		BroadcastTransactionSynchronousDto broadcastTransactionSynchronousDto = UtilTest
				.executePost(broadcastTransactionSynchronous, BroadcastTransactionSynchronousDto.class);

		System.out.println("broadcastTransactionSynchronousDto result: " + broadcastTransactionSynchronousDto);
	}
}
