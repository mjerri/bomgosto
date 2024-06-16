package com.bomgosto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.rmi.RemoteException;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
//import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.axis2.description.AxisBinding;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;


import com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeResultMsg;
import com.foo.myservice.RecepcaoEvento4Stub;

import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeDadosMsgDocument.NfeDadosMsg;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.NfeResultMsgDocument;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcaoevento4.impl.NfeDadosMsgDocumentImpl;

@SpringBootApplication
public class BomGostoApplication {
	
	public static void main(String[] args) throws RemoteException, XMLStreamException, XmlException {
		SpringApplication.run(BomGostoApplication.class, args);
		
		XmlObject xobj = XmlObject.Factory.parse("<teste></teste>");
		final OMElement ome = AXIOMUtil.stringToOM("<teste></teste>");
		
		final RecepcaoEvento4Stub stub1 = new RecepcaoEvento4Stub("");
		//final NfeDadosMsgDocumentImpl dadosMsgDocumentImpl = new NfeDadosMsgDocumentImpl(NfeDadosMsgDocument.type);
		//dadosMsgDocumentImpl.setStringValue("<teste></teste>");
		
		final NfeDadosMsgDocument dadosMsgDocumentI = NfeDadosMsgDocument.Factory.newInstance();
		final NfeDadosMsg nfeDadosMsg = NfeDadosMsg.Factory.newInstance();
	
		nfeDadosMsg.set(xobj);
		dadosMsgDocumentI.setNfeDadosMsg(nfeDadosMsg);
		
		final NfeResultMsgDocument result = stub1.nfeRecepcaoEvento(dadosMsgDocumentI);
		System.out.println(result.getNfeResultMsg().xmlText());
		
		AxisBinding axisBinding = new AxisBinding();
		System.out.println("Teste");
		System.out.print(axisBinding.toString());
		
        final com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeDadosMsg dadosMsg = new com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeDadosMsg();
        dadosMsg.setExtraElement(ome);
        final com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub stub = new com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub("");
        final com.bomgosto.recepcaoevento4.RecepcaoEvento4Stub.NfeResultMsg result2 = stub.nfeRecepcaoEvento(dadosMsg);
        System.out.println(result2.getExtraElement().toString());
	}

}
