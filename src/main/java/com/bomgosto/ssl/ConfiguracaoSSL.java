package com.bomgosto.ssl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.protocol.Protocol;

/**
 *
 * @author Jerri Magnanti
 */
public class ConfiguracaoSSL {

    private static String senha;
    private static String alias;
    private static KeyStore keyStore;

    public ConfiguracaoSSL(String senhaCert) {
        ConfiguracaoSSL.senha = senhaCert;
    }

    public static ConfiguracaoSSL carregarCertificado(String localCfg, String senhaCert, String tipoCert) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        try {
            char[] pin = senhaCert.toCharArray();
            if (keyStore == null) {
                if (tipoCert.equals("PKCS12")) {
                    keyStore = KeyStore.getInstance(tipoCert);
                    keyStore.load(new FileInputStream(localCfg), pin);
                } else {
                	//TODO-Testar nova implementacao
                    //Provider p = new sun.security.pkcs11.SunPKCS11(localCfg);
                	Provider p = Security.getProvider("SunPKCS11");
                	p = p.configure(localCfg);
                    Security.addProvider(p);
                    keyStore = KeyStore.getInstance(tipoCert, p);
                    keyStore.load(null, pin);
                }
            }
            String aliasCert = "";
            Enumeration<String> aliasesEnum = keyStore.aliases();
            while (aliasesEnum.hasMoreElements()) {
                aliasCert = (String) aliasesEnum.nextElement();
                if (keyStore.isKeyEntry(aliasCert)) {
                    alias = aliasCert;
                }
            }
            return new ConfiguracaoSSL(senhaCert);
        } catch (KeyStoreException ex) {
            Logger.getLogger(ConfiguracaoSSL.class.getName()).log(Level.SEVERE, null, ex);
            throw new KeyStoreException(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracaoSSL.class.getName()).log(Level.SEVERE, null, ex);
            throw new FileNotFoundException(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracaoSSL.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException(ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConfiguracaoSSL.class.getName()).log(Level.SEVERE, null, ex);
            throw new NoSuchAlgorithmException(ex);
        } catch (CertificateException ex) {
            Logger.getLogger(ConfiguracaoSSL.class.getName()).log(Level.SEVERE, null, ex);
            throw new CertificateException(ex);
        }
    }

    public void configurarConexao(String localCacerts) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        try {
            X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, senha.toCharArray());
            SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey, localCacerts);
            //socketFactoryDinamico.setFileCacerts(localCacerts);
            Protocol protocol = new Protocol("https", socketFactoryDinamico, 443);
            Protocol.registerProtocol("https", protocol);

        } catch (KeyStoreException ex) {
            Logger.getLogger(ConfiguracaoSSL.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new KeyStoreException(ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConfiguracaoSSL.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new NoSuchAlgorithmException(ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(ConfiguracaoSSL.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new UnrecoverableKeyException(ex.getMessage());
        }
    }

    public KeyStore.PrivateKeyEntry getPrivateKeyEntry() throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        try {
            return (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias, new KeyStore.PasswordProtection(senha.toCharArray()));

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConfiguracaoSSL.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new NoSuchAlgorithmException(ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(ConfiguracaoSSL.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new UnrecoverableEntryException(ex.getMessage());
        } catch (KeyStoreException ex) {
            Logger.getLogger(ConfiguracaoSSL.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new KeyStoreException(ex);
        }
    }
}
