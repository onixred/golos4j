package ru.maksimov.andrey.golos4j.example;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;

import ru.maksimov.andrey.golos4j.api.method.GetAccountHistory;
import ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.DynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.dto.transaction.BaseTransactionDto;
import ru.maksimov.andrey.golos4j.util.TransactionUtil;
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
		broadcastTransactionSynchronous();
	}

	public static void getAccountHistory() throws ClientProtocolException, IOException {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = UtilTest.executePost(getAccountHistory, GetAccountHistoryDto.class);
		System.out.println("getAccountHistoryDto: ");
		for (Entry<Integer, AccountHistoryDto> entry : getAccountHistoryDto.getResults().entrySet()) {
			System.out.print("key " + entry.getKey());
			System.out.println(" value " + entry.getValue());
		}
	}

	public static void getDynamicGlobalProperties() throws ClientProtocolException, IOException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = UtilTest.executePost(getDynamicGlobalProperties,
				GetDynamicGlobalPropertiesDto.class);
		System.out.println("getDynamicGlobalPropertiesDto: " + getDynamicGlobalPropertiesDto);
	}

	public static void broadcastTransactionSynchronous() throws ClientProtocolException, IOException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = UtilTest.executePost(getDynamicGlobalProperties,
				GetDynamicGlobalPropertiesDto.class);
		DynamicGlobalPropertiesDto dynamicGlobalPropertiesDto = getDynamicGlobalPropertiesDto.getResults();
		BaseTransactionDto baseTransactionDto = new BaseTransactionDto();

		long headBlockNumber = dynamicGlobalPropertiesDto.getHeadBlockNumber();
		String headBlockId = dynamicGlobalPropertiesDto.getHeadBlockId();
		int refBlockNum = TransactionUtil.getLast2Byte(headBlockNumber);
		baseTransactionDto.setRefBlockNum(refBlockNum);
		long refBlockPrefix = TransactionUtil.getLastByte2Char(headBlockId, 4, 4);
		baseTransactionDto.setRefBlockPrefix(refBlockPrefix);

		// BroadcastTransactionSynchronous broadcastTransactionSynchronous =
		// BroadcastTransactionSynchronous();

		System.out.println("baseTransactionDto: " + baseTransactionDto);
	}
}
