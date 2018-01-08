package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.maksimov.andrey.golos4j.dto.param.Asset;
import ru.maksimov.andrey.golos4j.dto.param.Asset.AssetSymbolType;
import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for {@link ru.maksimov.andrey.golos4j.dto.param.Asset}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class AssetDeserializer extends JsonDeserializer<Asset> {

	private static final Logger LOG = LogManager.getLogger(AssetDeserializer.class);

	@Override
	public Asset deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec codec = p.getCodec();
		TreeNode node = codec.readTree(p);
		try {
			String str = Util.node2String(node);
			return new Asset(str);
		} catch (BusinessException e) {
			LOG.error("Unable deserialize asset: " + e.getMessage(), e);
		}
		return new Asset(0, AssetSymbolType.GBG);
	}

}
