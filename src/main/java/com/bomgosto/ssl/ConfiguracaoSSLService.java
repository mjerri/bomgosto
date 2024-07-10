package com.bomgosto.ssl;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.httpclient.protocol.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jerri Magnanti
 */
@Service
public class ConfiguracaoSSLService {


	@Autowired
	private KeyStore keyStore;
	
	@Autowired
	private String aliasCertificado;
	
	@Value("${spring.certificado.senha}")
	private String senhaCertificado;
	
	@Value("${spring.bomgosto.cacerts}")
	private String caminhoCacerts;

    public void configurarConexao() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
    	X509Certificate certificate = (X509Certificate) keyStore.getCertificate(aliasCertificado);
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(aliasCertificado, senhaCertificado.toCharArray());
        SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey, caminhoCacerts);
        //socketFactoryDinamico.setFileCacerts(localCacerts);
        Protocol protocol = new Protocol("https", socketFactoryDinamico, 443);
        Protocol.registerProtocol("https", protocol);
    }

}
