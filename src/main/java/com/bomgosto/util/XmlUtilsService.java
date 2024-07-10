package com.bomgosto.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class XmlUtilsService {

	public Document documentFactory(String xml) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
        return document;
    }
	
	public static Document documentFactory2(String xml) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
        return document;
    }

    public String outputXML(Document doc) throws TransformerException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(os));
        String xml = os.toString();
        if ((xml != null) && (!"".equals(xml))) {
            xml = xml.replaceAll("\\r\\n", "");
            xml = xml.replaceAll(" standalone=\"no\"", "");
        }
        return xml;
    }

    public String outputXML(Node node) throws TransformerException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(node), new StreamResult(os));
        String xml = os.toString();
        if ((xml != null) && (!"".equals(xml))) {
            xml = xml.replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>", "");
        }
        return xml;
    }
    
    public static String outputXML2(Node node) throws TransformerException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(node), new StreamResult(os));
        String xml = os.toString();
        if ((xml != null) && (!"".equals(xml))) {
            xml = xml.replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>", "");
        }
        return xml;
    }

    public String buildNFeProc(String xmlNFe, String xmlProtNFe, String versao) {
        StringBuilder nfeProc = new StringBuilder();
        nfeProc.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<nfeProc versao=").append(versao).append(" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")
                .append(xmlNFe)
                .append(xmlProtNFe.replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>", "").replaceAll("  xmlns=\"http://www.portalfiscal.inf.br/nfe\"", ""))
                .append("</nfeProc>");
        return nfeProc.toString();
    }
    
    public String buildProcEvento(String xmlEvento, String xmlRetorno, String versao) {
        StringBuilder procEvento = new StringBuilder();
        procEvento.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<procEventoNFe versao=").append(versao).append(" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")
                .append(xmlEvento.replaceFirst(" xmlns=\"http://www.portalfiscal.inf.br/nfe\"", ""))
                .append(xmlRetorno.replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>", "").replaceAll("  xmlns=\"http://www.portalfiscal.inf.br/nfe\"", ""))
                .append("</procEventoNFe>");
        return procEvento.toString();
    }
    
    public  String buildProcInutNFe(String InutNFe, String xmlRetorno, String versao){
        StringBuilder procInut = new StringBuilder();
        procInut.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<procInutNFe versao=").append("\"" + versao + "\"").append(" xmlns=\"http://www.portalfiscal.inf.br/nfe\">")
                .append(InutNFe.replaceFirst(" xmlns=\"http://www.portalfiscal.inf.br/nfe\"", ""))
                .append(xmlRetorno.replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"\\?>", "").replaceAll("  xmlns=\"http://www.portalfiscal.inf.br/nfe\"", "").replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>", ""))
                .append("</procInutNFe>");
        return procInut.toString();
    }

    /**
     * Recebe o xml de retorno da sefaz e retorna String com xml que deve ser
     * anexado dentro da tag NFeProc junto com a anota autorizada
     * @author Jerri Magnanti
     * @param xml String com o xml de retorno da sefaz
     * @param chaveNFe Chave da nota referente ao xml em questao
     * @return Tag protNFe com o protocolo de autorizacao
     */
    public String getProtNFe(String xml, String chaveNFe) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        Document document = documentFactory(xml);
        NodeList nodeListProtNFe = document.getDocumentElement().getElementsByTagName("protNFe");
        NodeList nodeListChNFe = document.getElementsByTagName("chNFe");
        for (int i = 0; i < nodeListProtNFe.getLength(); i++) {
            Element el = (Element) nodeListChNFe.item(i);
            String chaveProtNFe = el.getTextContent();
            if (chaveNFe.contains(chaveProtNFe)) {
                return outputXML(nodeListProtNFe.item(i));
            }
        }
        return null;
    }

    /**
     * Metodo que retorna o xml que representa o arquivo digital do Evento de cancelamento
     * que devera ser mantido pelo emissor e disponibilizado para o destinatario
     * @author Jerri Magnanti
     * @param xml - String com o xml retornado na consulta da nota fiscal
     * @param chaveNFe - Chave de acesso da nota
     * @return String - String com o xml procEventoNFe
     */
    public String getProcEventoNFe(String xml, String chaveNFe) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        Document document = documentFactory(xml);
        NodeList proc = document.getDocumentElement().getElementsByTagName("procEventoNFe");
        NodeList nodeListChNFe = document.getElementsByTagName("chNFe");
        for (int i = 0; i < proc.getLength(); i++) {
            Element el = (Element) nodeListChNFe.item(i);
            String chaveProtNFe = el.getTextContent();
            if (chaveNFe.contains(chaveProtNFe)) {
                return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + outputXML(proc.item(i));
            }
        }
        return null;
    }

    /**
     * Salva um arquivo xml no caminho especificado.
     * @author Jerri Magnanti
     * @param path Local onde o arquivo sera salvo
     * @param fileName Nome do arquivo a ser salvo
     * @param xml Arquivo com o conteudo xml a ser salvo
     */
    public void salvarXML(String path, String fileName, String xml) throws FileNotFoundException, IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Writer f = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + File.separatorChar + fileName), "ISO-8859-1"));
        f.write(xml);
        f.close();
//        OutputStream out = new FileOutputStream(new File(path + File.pathSeparator + fileName));
//        out.write(xml.getBytes());
//        out.close();
    }

    /**
     * Lê um arquivo xml e converte para String
     * @author Jerri Magnanti
     * @param fileXML Caminho onde o arquivo se encontra
     * @return String com o xml convertido
     */
    public String lerXML(String fileXML) throws IOException {
        String linha = "";
        StringBuilder xml = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileXML)));
        while ((linha = in.readLine()) != null) {
            xml.append(linha);
        }
        in.close();
        return xml.toString();
    }
	
}
