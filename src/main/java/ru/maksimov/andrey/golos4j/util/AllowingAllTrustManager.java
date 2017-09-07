package ru.maksimov.andrey.golos4j.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * Экземпляр TrustManager по умолчанию доверяет всем.
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class AllowingAllTrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
