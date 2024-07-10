package com.bomgosto.assinatura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Service
public class JAXBService {

	public String objectToString(Object obj) throws JAXBException {
		final StringWriter out = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.marshal(obj, new StreamResult(out));
		return out.toString().replaceAll("\n", "").replaceAll("(\\>)(\\s+)([\\<])", "$1$3")
				.replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "")
				.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");
	}
	
	public static String objectToString2(Object obj) throws JAXBException {
		final StringWriter out = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.marshal(obj, new StreamResult(out));
		return out.toString().replaceAll("\n", "").replaceAll("(\\>)(\\s+)([\\<])", "$1$3")
				.replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "")
				.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");
	}

	public Object stringToObject(String xml, Class clazz) throws JAXBException {
		Unmarshaller un = JAXBContext.newInstance(clazz).createUnmarshaller();
		return un.unmarshal(new StringReader(xml));
	}

	public Object toObject(Unmarshaller un, String xml) throws JAXBException {
		return un.unmarshal(new StringReader(xml));
	}

	public String toString(Object obj, Marshaller marshaller) throws JAXBException {
		final StringWriter out = new StringWriter();
		marshaller.marshal(obj, new StreamResult(out));
		return out.toString().replaceAll("\n", "").replaceAll("(\\>)(\\s+)([\\<])", "$1$3")
				.replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "")
				.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");
	}

	public Object xmlFileToObject(Class clazz, String fileXml) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return unmarshaller.unmarshal(new FileInputStream(fileXml));
	}

	public void objectToXmlFile(Object obj, String xmlPath, boolean formatted) throws JAXBException, IOException {
		Writer writer = null;
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		// marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new
		// NameSpacePrefixMapperImpl());
		marshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, formatted);
		writer = new FileWriter(xmlPath);
		marshaller.marshal(obj, writer);
		writer.close();
	}

	public Marshaller createMarshaller(Object obj) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		return marshaller;
	}

	public Unmarshaller createUnmarshaller(Class clazz) throws JAXBException {
		return JAXBContext.newInstance(clazz).createUnmarshaller();
	}

}
