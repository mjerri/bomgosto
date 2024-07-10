package com.bomgosto.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bomgosto.ssl.ConfiguracaoSSL;

@Configuration
public class BeansConfig {
	
	@Value("${spring.certificado.tipo}")
	private String tipoCertificado;
	
	@Value("${spring.certificado.caminho}")
	private String caminhoCertificado;
	
	@Value("${spring.certificado.senha}")
	private String senhaCertificado;

    //@Bean
    //@Scope("prototype") // Cria uma nova instancia para cada injeção
    //public ConfiguracaoSSL logger(InjectionPoint injectionPoint /*, ApplicationConfig applicationConfig*/) {
        //return new ConfiguracaoSSL();
    	//return null;
    //}
    
    @Bean
    @Scope("singleton")
    public KeyStore keyStore() throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyStoreException {
    	final KeyStore keyStore;
    	char[] pin = senhaCertificado.toCharArray();
    	if ("PKCS12".equals(tipoCertificado)) {
            keyStore = KeyStore.getInstance(tipoCertificado);
            keyStore.load(new FileInputStream(caminhoCertificado), pin);
        } else {
        	//TODO-Testar nova implementacao
            //Provider p = new sun.security.pkcs11.SunPKCS11(localCfg);
        	Provider p = Security.getProvider("SunPKCS11");
        	p = p.configure(caminhoCertificado);
            Security.addProvider(p);
            keyStore = KeyStore.getInstance(tipoCertificado, p);
            keyStore.load(null, pin);
        }
    	return keyStore;
    }
    
    @Bean("aliasCertificado")
    @Scope("singleton")
    public String aliasCertificado() throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyStoreException {
    	String aliasCert = "";
    	final KeyStore keyStore = this.keyStore();
        Enumeration<String> aliasesEnum = keyStore.aliases();
        while (aliasesEnum.hasMoreElements()) {
            aliasCert = (String) aliasesEnum.nextElement();
            if (keyStore.isKeyEntry(aliasCert)) {
                return aliasCert;
            }
        }
        return null;
    }
    
    @Bean
    @Scope("singleton")
    public KeyStore.PrivateKeyEntry privateKeyEntry() throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, CertificateException, FileNotFoundException, IOException {
    	return (KeyStore.PrivateKeyEntry) keyStore().getEntry(aliasCertificado(), new KeyStore.PasswordProtection(senhaCertificado.toCharArray()));
    }

    
}