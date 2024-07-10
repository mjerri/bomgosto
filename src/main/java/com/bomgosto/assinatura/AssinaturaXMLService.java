package com.bomgosto.assinatura;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.bomgosto.util.XmlUtilsService;

@Service
public class AssinaturaXMLService {
	
	@Autowired
	private XmlUtilsService xmlUtilsService;

	// Assina cada evento dentro do XML de envio de Eventos utlizando Certidicado A3 ou A1
    public String assinarEnvEvento(String xml, KeyStore.PrivateKeyEntry pkEntry) throws MarshalException, XMLSignatureException, Exception {
        Document document = xmlUtilsService.documentFactory(xml);
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName("evento").getLength(); i++) {
            assinarEvento(signatureFactory, transformList, pkEntry.getPrivateKey(), loadCertificate(signatureFactory, pkEntry), document, i);
        }
        return xmlUtilsService.outputXML(document);
    }
    
    public static String assinarEnvEvento2(String xml, KeyStore.PrivateKeyEntry pkEntry) throws MarshalException, XMLSignatureException, Exception {
        Document document = XmlUtilsService.documentFactory2(xml);
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = signatureFactory2(signatureFactory);
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName("evento").getLength(); i++) {
            assinarEvento2(signatureFactory, transformList, pkEntry.getPrivateKey(), loadCertificate2(signatureFactory, pkEntry), document, i);
        }
        return XmlUtilsService.outputXML2(document);
    }

    private void assinarEvento(XMLSignatureFactory fac, ArrayList<Transform> transformList, PrivateKey privateKey, KeyInfo ki, Document document, int indexNFe) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException {
        NodeList elements = document.getElementsByTagName("infEvento");
        org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);
        String id = el.getAttribute("Id");
        el.setIdAttribute("Id", true);
        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
        XMLSignature signature = fac.newXMLSignature(si, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement().getElementsByTagName("evento").item(indexNFe));
        signature.sign(dsc);
    }
    
    private static void assinarEvento2(XMLSignatureFactory fac, ArrayList<Transform> transformList, PrivateKey privateKey, KeyInfo ki, Document document, int indexNFe) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException {
        NodeList elements = document.getElementsByTagName("infEvento");
        org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);
        String id = el.getAttribute("Id");
        el.setIdAttribute("Id", true);
        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
        XMLSignature signature = fac.newXMLSignature(si, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement().getElementsByTagName("evento").item(indexNFe));
        signature.sign(dsc);
    }

    // Assina cada NF-e dentro do XML de Envio de Lote da NF-e utilizando Certificado Digital A3 ou A1
    public String assinarEnviNFe(String xml, KeyStore.PrivateKeyEntry pkEntry) throws Exception {
        Document document = xmlUtilsService.documentFactory(xml);
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);
        for (int i = 0; i < document.getDocumentElement().getElementsByTagName("NFe").getLength(); i++) {
            assinarNFe(signatureFactory, transformList, pkEntry.getPrivateKey(), loadCertificate(signatureFactory, pkEntry), document, i);
        }
        return xmlUtilsService.outputXML(document);
    }

    private void assinarNFe(XMLSignatureFactory fac, ArrayList<Transform> transformList, PrivateKey privateKey, KeyInfo ki, Document document, int indexNFe) throws Exception {
        NodeList elements = document.getElementsByTagName("infNFe");
        org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(indexNFe);
        String id = el.getAttribute("Id");
        el.setIdAttribute("Id", true);
        Reference ref = fac.newReference("#" + id, fac.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
        XMLSignature signature = fac.newXMLSignature(si, ki);
        DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement().getElementsByTagName("NFe").item(indexNFe));
        signature.sign(dsc);
    }

    // Assina o XML de Inutilizacao de sequenciais da NF-e utilizando Certificado Digital A3 ou A1
    public String assinarInutNFe(String xml, KeyStore.PrivateKeyEntry pkEntry) throws Exception {
        return assinarInutilizacao(xml, pkEntry);
    }

    private String assinarInutilizacao(String xml, KeyStore.PrivateKeyEntry pkEntry) throws Exception {
        Document document = xmlUtilsService.documentFactory(xml);
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        ArrayList<Transform> transformList = signatureFactory(signatureFactory);
        NodeList elements = document.getElementsByTagName("infInut");
        org.w3c.dom.Element el = (org.w3c.dom.Element) elements.item(0);
        String id = el.getAttribute("Id");
        el.setIdAttribute("Id", true);
        Reference ref = signatureFactory.newReference("#" + id, signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transformList, null, null);
        SignedInfo si = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
        XMLSignature signature = signatureFactory.newXMLSignature(si, loadCertificate(signatureFactory, pkEntry));
        DOMSignContext dsc = new DOMSignContext(pkEntry.getPrivateKey(), document.getFirstChild());
        signature.sign(dsc);
        return xmlUtilsService.outputXML(document);
    }

    private ArrayList<Transform> signatureFactory(XMLSignatureFactory signatureFactory) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ArrayList<Transform> transformList = new ArrayList<Transform>();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = signatureFactory.newTransform(Transform.ENVELOPED, tps);
        Transform c14NTransform = signatureFactory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);
        return transformList;
    }
    
    private static ArrayList<Transform> signatureFactory2(XMLSignatureFactory signatureFactory) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ArrayList<Transform> transformList = new ArrayList<Transform>();
        TransformParameterSpec tps = null;
        Transform envelopedTransform = signatureFactory.newTransform(Transform.ENVELOPED, tps);
        Transform c14NTransform = signatureFactory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);
        transformList.add(envelopedTransform);
        transformList.add(c14NTransform);
        return transformList;
    }

    private KeyInfo loadCertificate(XMLSignatureFactory signatureFactory, KeyStore.PrivateKeyEntry pkEntry) throws Exception {
        X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
        //System.out.println("SubjectDN: " + cert.getSubjectDN().toString());
        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
        x509Content.add(cert);
        X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
        return keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
    }
    
    private static KeyInfo loadCertificate2(XMLSignatureFactory signatureFactory, KeyStore.PrivateKeyEntry pkEntry) throws Exception {
        X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
        //System.out.println("SubjectDN: " + cert.getSubjectDN().toString());
        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
        x509Content.add(cert);
        X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
        return keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
    }
	
}
