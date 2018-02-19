package ru.maksimov.andrey.golos4j.dto.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Актив
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Asset implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static char SYMBOL_DOT = '.';
	private final static char SYMBOL_COMMA = ',';

	public enum AssetSymbolType {
		GOLOS, GBG, VESTS, GESTS, OTHER
	}

	private long amount;
	// Type us uint64_t in the original code.
	private AssetSymbolType symbol;
	private byte precision;

	/**
	 * Create a new asset object by providing all required fields.
	 * 
	 * @param amount
	 *            The amount.
	 * @param symbol
	 *            One type of
	 *            {@link ru.maksimov.andrey.golos4j.dto.param.Asset.AssetSymbolType
	 *            AssetSymbolType}.
	 */
	public Asset(long amount, AssetSymbolType symbol) {
		this.setSymbol(symbol);
		this.setAmount(amount);
	}

	/**
	 * Create a new asset object by providing all required fields.
	 * 
	 * @param amount
	 *            The amount.
	 * @param symbol
	 *            One type of
	 *            {@link ru.maksimov.andrey.golos4j.dto.param.Asset.AssetSymbolType
	 *            AssetSymbolType}.
	 */
	public Asset(double amount, AssetSymbolType symbol) {
		this.setSymbol(symbol);
		this.setAmount(amount);
	}

	/**
	 * Create a new asset object by providing all required fields.
	 * 
	 * @param amount
	 *            The amount format '100,00 GBG'.
	 * @throws BusinessException
	 *             ошибка преобразования страки в автив
	 */
	public Asset(String amount) throws BusinessException {
		String[] array = amount.split(" ");
		if (array.length < 2) {
			throw new BusinessException("Unable parse amount. Wrong format 100,00 GBG");
		}
		this.setSymbol(AssetSymbolType.OTHER);
		for (AssetSymbolType type : AssetSymbolType.values()) {
			if (type.name().equals(array[1].toUpperCase())) {
				this.setSymbol(type);
				break;
			}
		}
		try {
			long longValue = Long.parseLong(array[0]);
			this.setAmount(longValue);
		} catch (NumberFormatException nfe) {
			try {
				String starNumber = array[0].replace(SYMBOL_COMMA, SYMBOL_DOT);
				double doubleValue = Double.parseDouble(starNumber);
				this.setAmount(doubleValue);
			} catch (NumberFormatException nfe2) {
				throw new BusinessException("Unable  parse amount " + nfe2.getMessage(), nfe2);
			}
		}
	}

	public List<Byte> toByteList() {
		List<Byte> list = new ArrayList<Byte>();
		list.addAll(Util.long2ByteArray(amount));
		list.add(Util.byte2LittleEndian(precision));
		String assetSymbol = symbol.name().toUpperCase();
		List<Byte> symbolBytes = Util.arrayByte2List(assetSymbol.getBytes(Util.ENCODING_CHARSET));
		list.addAll(symbolBytes);
		for (int i = assetSymbol.length(); i < 7; i++) {
			list.add((byte) 0);
		}
		return list;
	}

	/**
	 * Get the amount stored in this asset object.
	 * 
	 * @return The amount.
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Transform this asset into its double representation.
	 * 
	 * @return The value of this asset in its double representation.
	 */
	public float toReal() {
		return Float.valueOf(this.amount / (float) Math.pow(10.0, this.getPrecision()));
	}

	/**
	 * Get the precision of this asset object.
	 * 
	 * @return The precision.
	 */
	public Integer getPrecision() {
		return (int) precision;
	}

	/**
	 * Get the symbol for this asset object.
	 * 
	 * @return One type of
	 *         {@link ru.maksimov.andrey.golos4j.dto.param.Asset.AssetSymbolType
	 *         AssetSymbolType}.
	 */
	public AssetSymbolType getSymbol() {
		return symbol;
	}

	/**
	 * Set the amount of this asset.
	 * 
	 * @param amount
	 *            The amount.
	 */
	public void setAmount(long amount) {
		this.amount = (long) (amount * Math.pow(10.0, this.getPrecision()));
		;
	}

	/**
	 * Set the amount of this asset.
	 * 
	 * @param amount
	 *            The amount.
	 */
	public void setAmount(double amount) {
		this.amount = (long) (amount * Math.pow(10.0, this.getPrecision()));
	}

	/**
	 * Set the symbol of this asset.
	 * 
	 * @param symbol
	 *            One type of
	 *            {@link ru.maksimov.andrey.golos4j.dto.param.Asset.AssetSymbolType
	 *            AssetSymbolType}.
	 */
	public void setSymbol(AssetSymbolType symbol) {
		if (symbol.equals(AssetSymbolType.VESTS)) {
			this.precision = 6;
		} else {
			this.precision = 3;
		}

		this.symbol = symbol;
	}

	@Override
	public boolean equals(Object otherAsset) {
		if (this == otherAsset)
			return true;
		if (otherAsset == null || !(otherAsset instanceof Asset))
			return false;
		Asset other = (Asset) otherAsset;
		return (this.getAmount().equals(other.getAmount()) && this.getSymbol().equals(other.getSymbol())
				&& this.getPrecision().equals(other.getPrecision()));
	}

	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31 * hashCode + (this.getAmount() == null ? 0 : this.getAmount().hashCode());
		hashCode = 31 * hashCode + (this.getSymbol() == null ? 0 : this.getSymbol().hashCode());
		hashCode = 31 * hashCode + (this.getPrecision() == null ? 0 : this.getPrecision().hashCode());
		return hashCode;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		String formattedDouble = String.format(Locale.US, "%.3f", toReal());
		str.append(formattedDouble);
		str.append(" ");
		str.append(symbol.name().toUpperCase());
		return str.toString();
	}
}
