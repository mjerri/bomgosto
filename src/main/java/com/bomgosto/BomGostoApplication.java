package com.bomgosto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.rmi.RemoteException;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
//import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.axis2.description.AxisBinding;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

import com.bomgosto.assinatura.AssinaturaXMLService;
import com.bomgosto.assinatura.JAXBService;
import com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeResultMsg;
import com.bomgosto.ssl.ConfiguracaoSSLService;
import com.bomgosto.util.XmlUtilsService;
import com.foo.myservice.RecepcaoEvento4Stub;

import br.inf.portalfiscal.nfe.TEnvEvento;
import br.inf.portalfiscal.nfe.TEvento;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument.NfeDadosMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeResultMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.impl.NfeDadosMsgDocumentImpl;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BomGostoApplication {

	@Autowired
	private ConfiguracaoSSLService configuracaoSSLService;

	@Autowired
	private AssinaturaXMLService assinaturaXMLService;

	@Autowired
	private JAXBService jaxbService;

	@Autowired
	private KeyStore.PrivateKeyEntry privateKeyEntry;
	
	@Value("${spring.nfe.wsdl.recepcaoevento}")
	private String wsdlRecepcaoEvento;

	public static void main(String[] args) throws RemoteException, XMLStreamException, XmlException {
		SpringApplication.run(BomGostoApplication.class, args);

		/*
		 * XmlObject xobj = XmlObject.Factory.parse("<teste></teste>"); final OMElement
		 * ome = AXIOMUtil.stringToOM("<teste></teste>");
		 * 
		 * final RecepcaoEvento4Stub stub1 = new RecepcaoEvento4Stub(""); //final
		 * NfeDadosMsgDocumentImpl dadosMsgDocumentImpl = new
		 * NfeDadosMsgDocumentImpl(NfeDadosMsgDocument.type);
		 * //dadosMsgDocumentImpl.setStringValue("<teste></teste>");
		 * 
		 * final NfeDadosMsgDocument dadosMsgDocumentI =
		 * NfeDadosMsgDocument.Factory.newInstance(); final NfeDadosMsg nfeDadosMsg =
		 * NfeDadosMsg.Factory.newInstance();
		 * 
		 * nfeDadosMsg.set(xobj); dadosMsgDocumentI.setNfeDadosMsg(nfeDadosMsg);
		 * 
		 * final NfeResultMsgDocument result =
		 * stub1.nfeRecepcaoEvento(dadosMsgDocumentI);
		 * System.out.println(result.getNfeResultMsg().xmlText());
		 * 
		 * AxisBinding axisBinding = new AxisBinding(); System.out.println("Teste");
		 * System.out.print(axisBinding.toString());
		 * 
		 * final com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeDadosMsg dadosMsg =
		 * new com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeDadosMsg();
		 * dadosMsg.setExtraElement(ome); final
		 * com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub stub = new
		 * com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub(""); final
		 * com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeResultMsg result2 =
		 * stub.nfeRecepcaoEvento(dadosMsg);
		 * System.out.println(result2.getExtraElement().toString());
		 */
	}

	@PostConstruct
	public void testDependencyInjection() throws MarshalException, XMLSignatureException, Exception {
		final TEvento.InfEvento.DetEvento det = new TEvento.InfEvento.DetEvento();
		det.setDescEvento("Carta de Correcao");
		det.setXCorrecao(
				"Produto FARINHA DE MANDIOCA JANGADA 20X1 KG com codigo 001 e NCM 11081900 foi informado errado. O produto correto e FARINHA DE MILHO BOM GOSTO 20X500 G com codigo 198 e NCM 11022000.");
		det.setXCondUso(
				"A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.");
		det.setVersao("1.00");
		final TEvento.InfEvento infEven = new TEvento.InfEvento();
		infEven.setId("ID1101105124053059123300017755001000002568178816533801");
		infEven.setCOrgao("51");
		infEven.setTpAmb("1");
		infEven.setCNPJ("30591233000177");
		infEven.setChNFe("51240530591233000177550010000025681788165338");
		infEven.setDhEvento(new StringBuilder(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(new Date()))
				.insert(22, ":").toString());
		infEven.setTpEvento("110110");
		infEven.setNSeqEvento("1");
		infEven.setVerEvento("1.00");
		infEven.setDetEvento(det);
		final TEvento evenCan = new TEvento();
		evenCan.setInfEvento(infEven);
		evenCan.setVersao("1.00");
		final TEnvEvento envEvento = new TEnvEvento();
		envEvento.setIdLote("1");
		envEvento.setVersao("1.00");
		envEvento.getEvento().add(evenCan);

		configuracaoSSLService.configurarConexao();
		final String xmlEnviNFeAssinado = assinaturaXMLService.assinarEnvEvento(jaxbService.objectToString(envEvento), privateKeyEntry);

		final RecepcaoEvento4Stub stub = new RecepcaoEvento4Stub(wsdlRecepcaoEvento);
		final NfeDadosMsgDocument dadosMsgDocumentI = NfeDadosMsgDocument.Factory.newInstance();
		final NfeDadosMsg nfeDadosMsg = NfeDadosMsg.Factory.newInstance();

		//System.out.println(XmlObject.Factory.parse(xmlEnviNFeAssinado));
		nfeDadosMsg.set(XmlString.Factory.newValue(xmlEnviNFeAssinado));
		dadosMsgDocumentI.setNfeDadosMsg(nfeDadosMsg);
		
		//NfeDadosMsgDocumentImpl dadosMsgDocumentImpl = NfeDadosMsgDocument.Factory.newInstance();
		//NfeDadosMsgDocumentImpl dadosMsgDocumentImpl = (NfeDadosMsgDocumentImpl) NfeDadosMsgDocument.Factory.newInstance();
		//metaDataEntry.setValue(XmlString.Factory.newValue(my_var));
		//dadosMsgDocumentImpl.setStringValue(XmlString.Factory.newValue(xmlEnviNFeAssinado));

		//stub.fromOM(null, getClass())
		final NfeResultMsgDocument result = stub.nfeRecepcaoEvento(dadosMsgDocumentI);
		System.out.println(result.xmlText());
	}

}
