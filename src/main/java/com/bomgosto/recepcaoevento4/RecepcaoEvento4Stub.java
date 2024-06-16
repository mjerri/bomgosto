// 
// Decompiled by Procyon v0.5.36
// 

package com.bomgosto.recepcaoevento4;

//import org.apache.axis2.databinding.utils.NamedStaxOMBuilder;
import org.apache.axis2.util.StreamWrapper;
import java.util.Vector;
import org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl;
import org.apache.axis2.databinding.utils.Constants;
import java.util.ArrayList;
import javax.xml.namespace.NamespaceContext;
import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.axis2.databinding.utils.BeanUtil;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.axiom.om.OMDataSource;
import org.apache.axis2.databinding.ADBDataSource;
import org.apache.axis2.databinding.ADBBean;
import javax.xml.stream.XMLStreamReader;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.databinding.ADBException;
import org.apache.axiom.om.OMAbstractFactory;
import java.util.Iterator;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.engine.MessageReceiver;
import org.apache.axis2.util.CallbackReceiver;
import org.apache.axis2.util.Utils;
import org.apache.axis2.client.async.AxisCallback;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.client.OperationClient;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.Map;
import org.apache.axis2.client.FaultMapKey;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.AxisFault;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.description.AxisService;
import javax.xml.namespace.QName;
import java.util.HashMap;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.client.Stub;

public class RecepcaoEvento4Stub extends Stub
{
    protected AxisOperation[] _operations;
    private HashMap faultExceptionNameMap;
    private HashMap faultExceptionClassNameMap;
    private HashMap faultMessageMap;
    private static int counter;
    private QName[] opNameArray;
    
    private static synchronized String getUniqueSuffix() {
        if (RecepcaoEvento4Stub.counter > 99999) {
            RecepcaoEvento4Stub.counter = 0;
        }
        ++RecepcaoEvento4Stub.counter;
        return Long.toString(System.currentTimeMillis()) + "_" + RecepcaoEvento4Stub.counter;
    }
    
    private void populateAxisService() throws AxisFault {
        this._service = new AxisService("RecepcaoEvento4" + getUniqueSuffix());
        this.addAnonymousOperations();
        this._operations = new AxisOperation[1];
        final AxisOperation __operation = (AxisOperation)new OutInAxisOperation();
        __operation.setName(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeRecepcaoEvento"));
        this._service.addOperation(__operation);
        this._operations[0] = __operation;
    }
    
    private void populateFaults() {
    }
    
    public RecepcaoEvento4Stub(final ConfigurationContext configurationContext, final String targetEndpoint) throws AxisFault {
        this(configurationContext, targetEndpoint, false);
    }
    
    public RecepcaoEvento4Stub(final ConfigurationContext configurationContext, final String targetEndpoint, final boolean useSeparateListener) throws AxisFault {
        this.faultExceptionNameMap = new HashMap();
        this.faultExceptionClassNameMap = new HashMap();
        this.faultMessageMap = new HashMap();
        this.opNameArray = null;
        this.populateAxisService();
        this.populateFaults();
        this._serviceClient = new ServiceClient(configurationContext, this._service);
        this._serviceClient.getOptions().setTo(new EndpointReference(targetEndpoint));
        this._serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        this._serviceClient.getOptions().setSoapVersionURI("http://www.w3.org/2003/05/soap-envelope");
    }
    
    public RecepcaoEvento4Stub(final ConfigurationContext configurationContext) throws AxisFault {
        this(configurationContext, "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4");
    }
    
    public RecepcaoEvento4Stub() throws AxisFault {
        this("https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4");
    }
    
    public RecepcaoEvento4Stub(final String targetEndpoint) throws AxisFault {
        this(null, targetEndpoint);
    }
    
    public NfeResultMsg nfeRecepcaoEvento(final NfeDadosMsg nfeDadosMsg0) throws RemoteException {
        MessageContext _messageContext = null;
        try {
            final OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
            _operationClient.getOptions().setAction("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4/nfeRecepcaoEvento");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            this.addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", (Object)"&");
            _messageContext = new MessageContext();
            SOAPEnvelope env = null;
            env = this.toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), nfeDadosMsg0, this.optimizeContent(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeRecepcaoEvento")), new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeRecepcaoEvento"));
            this._serviceClient.addHeadersToEnvelope(env);
            _messageContext.setEnvelope(env);
            _operationClient.addMessageContext(_messageContext);
            _operationClient.execute(true);
            final MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
            final SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            final Object object = this.fromOM(_returnEnv.getBody().getFirstElement(), NfeResultMsg.class, this.getEnvelopeNamespaces(_returnEnv));
            return (NfeResultMsg)object;
        }
        catch (AxisFault f) {
            final OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "nfeRecepcaoEvento"))) {
                    try {
                        final String exceptionClassName = (java.lang.String) this.faultExceptionClassNameMap.get(new FaultMapKey(faultElt.getQName(), "nfeRecepcaoEvento"));
                        final Class exceptionClass = Class.forName(exceptionClassName);
                        final Constructor constructor = exceptionClass.getConstructor(String.class);
                        final Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        final String messageClassName = (java.lang.String) this.faultMessageMap.get(new FaultMapKey(faultElt.getQName(), "nfeRecepcaoEvento"));
                        final Class messageClass = Class.forName(messageClassName);
                        final Object messageObject = this.fromOM(faultElt, messageClass, null);
                        final Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                        m.invoke(ex, messageObject);
                        throw new RemoteException(ex.getMessage(), ex);
                    }
                    catch (ClassCastException e) {
                        throw f;
                    }
                    catch (ClassNotFoundException e2) {
                        throw f;
                    }
                    catch (NoSuchMethodException e3) {
                        throw f;
                    }
                    catch (InvocationTargetException e4) {
                        throw f;
                    }
                    catch (IllegalAccessException e5) {
                        throw f;
                    }
                    catch (InstantiationException e6) {
                        throw f;
                    }
                }
                throw f;
            }
            throw f;
        }
        finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }
    
    public void startnfeRecepcaoEvento(final NfeDadosMsg nfeDadosMsg0, final RecepcaoEvento4CallbackHandler callback) throws RemoteException {
        final OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
        _operationClient.getOptions().setAction("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4/nfeRecepcaoEvento");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
        this.addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", (Object)"&");
        SOAPEnvelope env = null;
        final MessageContext _messageContext = new MessageContext();
        env = this.toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), nfeDadosMsg0, this.optimizeContent(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeRecepcaoEvento")), new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeRecepcaoEvento"));
        this._serviceClient.addHeadersToEnvelope(env);
        _messageContext.setEnvelope(env);
        _operationClient.addMessageContext(_messageContext);
        _operationClient.setCallback((AxisCallback)new AxisCallback() {
            public void onMessage(final MessageContext resultContext) {
                try {
                    final SOAPEnvelope resultEnv = resultContext.getEnvelope();
                    final Object object = RecepcaoEvento4Stub.this.fromOM(resultEnv.getBody().getFirstElement(), NfeResultMsg.class, RecepcaoEvento4Stub.this.getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultnfeRecepcaoEvento((NfeResultMsg)object);
                }
                catch (AxisFault e) {
                    callback.receiveErrornfeRecepcaoEvento((Exception)e);
                }
            }
            
            public void onError(final Exception error) {
                if (error instanceof AxisFault) {
                    final AxisFault f = (AxisFault)error;
                    final OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (RecepcaoEvento4Stub.this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "nfeRecepcaoEvento"))) {
                            try {
                                final String exceptionClassName = (java.lang.String) RecepcaoEvento4Stub.this.faultExceptionClassNameMap.get(new FaultMapKey(faultElt.getQName(), "nfeRecepcaoEvento"));
                                final Class exceptionClass = Class.forName(exceptionClassName);
                                final Constructor constructor = exceptionClass.getConstructor(String.class);
                                final Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                final String messageClassName = (java.lang.String) RecepcaoEvento4Stub.this.faultMessageMap.get(new FaultMapKey(faultElt.getQName(), "nfeRecepcaoEvento"));
                                final Class messageClass = Class.forName(messageClassName);
                                final Object messageObject = RecepcaoEvento4Stub.this.fromOM(faultElt, messageClass, null);
                                final Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                                m.invoke(ex, messageObject);
                                callback.receiveErrornfeRecepcaoEvento(new RemoteException(ex.getMessage(), ex));
                            }
                            catch (ClassCastException e) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                            catch (ClassNotFoundException e2) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                            catch (NoSuchMethodException e3) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                            catch (InvocationTargetException e4) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                            catch (IllegalAccessException e5) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                            catch (InstantiationException e6) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                            catch (AxisFault e7) {
                                callback.receiveErrornfeRecepcaoEvento((Exception)f);
                            }
                        }
                        else {
                            callback.receiveErrornfeRecepcaoEvento((Exception)f);
                        }
                    }
                    else {
                        callback.receiveErrornfeRecepcaoEvento((Exception)f);
                    }
                }
                else {
                    callback.receiveErrornfeRecepcaoEvento(error);
                }
            }
            
            public void onFault(final MessageContext faultContext) {
                final AxisFault fault = Utils.getInboundFaultFromMessageContext(faultContext);
                this.onError((Exception)fault);
            }
            
            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
                catch (AxisFault axisFault) {
                    callback.receiveErrornfeRecepcaoEvento((Exception)axisFault);
                }
            }
        });
        CallbackReceiver _callbackReceiver = null;
        if (this._operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new CallbackReceiver();
            this._operations[0].setMessageReceiver((MessageReceiver)_callbackReceiver);
        }
        _operationClient.execute(false);
    }
    
    private Map getEnvelopeNamespaces(final SOAPEnvelope env) {
        final Map returnMap = new HashMap();
        final Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            final OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }
    
    private boolean optimizeContent(final QName opName) {
        if (this.opNameArray == null) {
            return false;
        }
        for (int i = 0; i < this.opNameArray.length; ++i) {
            if (opName.equals(this.opNameArray[i])) {
                return true;
            }
        }
        return false;
    }
    
    private OMElement toOM(final NfeDadosMsg param, final boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(NfeDadosMsg.MY_QNAME, OMAbstractFactory.getOMFactory());
        }
        catch (ADBException e) {
            throw AxisFault.makeFault((Throwable)e);
        }
    }
    
    private OMElement toOM(final NfeResultMsg param, final boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(NfeResultMsg.MY_QNAME, OMAbstractFactory.getOMFactory());
        }
        catch (ADBException e) {
            throw AxisFault.makeFault((Throwable)e);
        }
    }
    
    private SOAPEnvelope toEnvelope(final SOAPFactory factory, final NfeDadosMsg param, final boolean optimizeContent, final QName methodQName) throws AxisFault {
        try {
            final SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild((OMNode)param.getOMElement(NfeDadosMsg.MY_QNAME, (OMFactory)factory));
            return emptyEnvelope;
        }
        catch (ADBException e) {
            throw AxisFault.makeFault((Throwable)e);
        }
    }
    
    private SOAPEnvelope toEnvelope(final SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }
    
    private Object fromOM(final OMElement param, final Class type, final Map extraNamespaces) throws AxisFault {
        try {
            if (NfeDadosMsg.class.equals(type)) {
                return NfeDadosMsg.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (NfeResultMsg.class.equals(type)) {
                return NfeResultMsg.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        }
        catch (Exception e) {
            throw AxisFault.makeFault((Throwable)e);
        }
        return null;
    }
    
    static {
        RecepcaoEvento4Stub.counter = 0;
    }
    
    public static class ExtensionMapper
    {
        public static Object getTypeObject(final String namespaceURI, final String typeName, final XMLStreamReader reader) throws Exception {
            throw new ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }
    }
    
    public static class NfeResultMsg implements ADBBean
    {
        public static final QName MY_QNAME;
        protected OMElement localExtraElement;
        
        public OMElement getExtraElement() {
            return this.localExtraElement;
        }
        
        public void setExtraElement(final OMElement param) {
            this.localExtraElement = param;
        }
        
        public OMElement getOMElement(final QName parentQName, final OMFactory factory) throws ADBException {
            final OMDataSource dataSource = (OMDataSource)new ADBDataSource((ADBBean)this, NfeResultMsg.MY_QNAME);
            return (OMElement)factory.createOMElement(dataSource, NfeResultMsg.MY_QNAME);
        }
        
        public void serialize(final QName parentQName, final XMLStreamWriter xmlWriter) throws XMLStreamException, ADBException {
            this.serialize(parentQName, xmlWriter, false);
        }
        
        public void serialize(final QName parentQName, final XMLStreamWriter xmlWriter, final boolean serializeType) throws XMLStreamException, ADBException {
            String prefix = null;
            String namespace = null;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            this.writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
            if (serializeType) {
                final String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4");
                if (namespacePrefix != null && namespacePrefix.trim().length() > 0) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":nfeResultMsg", xmlWriter);
                }
                else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "nfeResultMsg", xmlWriter);
                }
            }
            if (this.localExtraElement != null) {
                this.localExtraElement.serialize(xmlWriter);
                xmlWriter.writeEndElement();
                return;
            }
            throw new ADBException("extraElement cannot be null!!");
        }
        
        private static String generatePrefix(final String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }
        
        private void writeStartElement(String prefix, final String namespace, final String localPart, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            final String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if (namespace.length() == 0) {
                    prefix = "";
                }
                else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }
                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        private void writeAttribute(final String prefix, final String namespace, final String attName, final String attValue, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
        
        private void writeAttribute(final String namespace, final String attName, final String attValue, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }
        
        private void writeQNameAttribute(final String namespace, final String attName, final QName qname, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            final String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        
        private void writeQName(final QName qname, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            final String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + ConverterUtil.convertToString(qname));
                }
                else {
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
                }
            }
            else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            }
        }
        
        private void writeQNames(final QName[] qnames, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (qnames != null) {
                final StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;
                for (int i = 0; i < qnames.length; ++i) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if (prefix == null || prefix.length() == 0) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString(qnames[i]));
                        }
                        else {
                            stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                        }
                    }
                    else {
                        stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }
        
        private String registerPrefix(final XMLStreamWriter xmlWriter, final String namespace) throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                final NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    final String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }
        
        public XMLStreamReader getPullParser(final QName qName) throws ADBException {
            final ArrayList elementList = new ArrayList();
            final ArrayList attribList = new ArrayList();
            if (this.localExtraElement != null) {
                elementList.add(Constants.OM_ELEMENT_KEY);
                elementList.add(this.localExtraElement);
                return (XMLStreamReader)new ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            }
            throw new ADBException("extraElement cannot be null!!");
        }
        
        static {
            MY_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeResultMsg", "ns1");
        }
        
        public static class Factory
        {
            public static NfeResultMsg parse(final XMLStreamReader reader) throws Exception {
                final NfeResultMsg object = new NfeResultMsg();
                String nillableValue = null;
                final String prefix = "";
                final String namespaceuri = "";
                try {
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                        while (!reader.isEndElement()) {
                            reader.next();
                        }
                        return null;
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        final String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = ((nsPrefix == null) ? "" : nsPrefix);
                            final String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                            if (!"nfeResultMsg".equals(type)) {
                                final String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (NfeResultMsg)ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }
                        }
                    }
                    final Vector handledAttributes = new Vector();
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (!reader.isStartElement()) {
                        throw new ADBException("Unexpected subelement " + reader.getName());
                    }
                    final QName startQname1 = reader.getName();
                    //final NamedStaxOMBuilder builder1 = new NamedStaxOMBuilder((XMLStreamReader)new StreamWrapper(reader), startQname1);
                    //object.setExtraElement(builder1.getOMElement());
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        throw new ADBException("Unexpected subelement " + reader.getName());
                    }
                }
                catch (XMLStreamException e) {
                    throw new Exception(e);
                }
                return object;
            }
        }
    }
    
    public static class NfeDadosMsg implements ADBBean
    {
        public static final QName MY_QNAME;
        protected OMElement localExtraElement;
        
        public OMElement getExtraElement() {
            return this.localExtraElement;
        }
        
        public void setExtraElement(final OMElement param) {
            this.localExtraElement = param;
        }
        
        public OMElement getOMElement(final QName parentQName, final OMFactory factory) throws ADBException {
            final OMDataSource dataSource = (OMDataSource)new ADBDataSource((ADBBean)this, NfeDadosMsg.MY_QNAME);
            return (OMElement)factory.createOMElement(dataSource, NfeDadosMsg.MY_QNAME);
        }
        
        public void serialize(final QName parentQName, final XMLStreamWriter xmlWriter) throws XMLStreamException, ADBException {
            this.serialize(parentQName, xmlWriter, false);
        }
        
        public void serialize(final QName parentQName, final XMLStreamWriter xmlWriter, final boolean serializeType) throws XMLStreamException, ADBException {
            String prefix = null;
            String namespace = null;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            this.writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
            if (serializeType) {
                final String namespacePrefix = this.registerPrefix(xmlWriter, "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4");
                if (namespacePrefix != null && namespacePrefix.trim().length() > 0) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":nfeDadosMsg", xmlWriter);
                }
                else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "nfeDadosMsg", xmlWriter);
                }
            }
            if (this.localExtraElement != null) {
                this.localExtraElement.serialize(xmlWriter);
                xmlWriter.writeEndElement();
                return;
            }
            throw new ADBException("extraElement cannot be null!!");
        }
        
        private static String generatePrefix(final String namespace) {
            if (namespace.equals("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }
        
        private void writeStartElement(String prefix, final String namespace, final String localPart, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            final String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            }
            else {
                if (namespace.length() == 0) {
                    prefix = "";
                }
                else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }
                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        private void writeAttribute(final String prefix, final String namespace, final String attName, final String attValue, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
        
        private void writeAttribute(final String namespace, final String attName, final String attValue, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            }
            else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }
        
        private void writeQNameAttribute(final String namespace, final String attName, final QName qname, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            final String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            }
            else {
                attributeValue = qname.getLocalPart();
            }
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            }
            else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }
        
        private void writeQName(final QName qname, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            final String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + ConverterUtil.convertToString(qname));
                }
                else {
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
                }
            }
            else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            }
        }
        
        private void writeQNames(final QName[] qnames, final XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (qnames != null) {
                final StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;
                for (int i = 0; i < qnames.length; ++i) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if (prefix == null || prefix.length() == 0) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString(qnames[i]));
                        }
                        else {
                            stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                        }
                    }
                    else {
                        stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }
        
        private String registerPrefix(final XMLStreamWriter xmlWriter, final String namespace) throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                final NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    final String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }
        
        public XMLStreamReader getPullParser(final QName qName) throws ADBException {
            final ArrayList elementList = new ArrayList();
            final ArrayList attribList = new ArrayList();
            if (this.localExtraElement != null) {
                elementList.add(Constants.OM_ELEMENT_KEY);
                elementList.add(this.localExtraElement);
                return (XMLStreamReader)new ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            }
            throw new ADBException("extraElement cannot be null!!");
        }
        
        static {
            MY_QNAME = new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", "nfeDadosMsg", "ns1");
        }
        
        public static class Factory
        {
            public static NfeDadosMsg parse(final XMLStreamReader reader) throws Exception {
                final NfeDadosMsg object = new NfeDadosMsg();
                final String nillableValue = null;
                final String prefix = "";
                final String namespaceuri = "";
                try {
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        final String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = ((nsPrefix == null) ? "" : nsPrefix);
                            final String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                            if (!"nfeDadosMsg".equals(type)) {
                                final String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (NfeDadosMsg)ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }
                        }
                    }
                    final Vector handledAttributes = new Vector();
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (!reader.isStartElement()) {
                        throw new ADBException("Unexpected subelement " + reader.getName());
                    }
                    final QName startQname1 = reader.getName();
                    //final NamedStaxOMBuilder builder1 = new NamedStaxOMBuilder((XMLStreamReader)new StreamWrapper(reader), startQname1);
                    //object.setExtraElement(builder1.getOMElement());
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        throw new ADBException("Unexpected subelement " + reader.getName());
                    }
                }
                catch (XMLStreamException e) {
                    throw new Exception(e);
                }
                return object;
            }
        }
    }
}