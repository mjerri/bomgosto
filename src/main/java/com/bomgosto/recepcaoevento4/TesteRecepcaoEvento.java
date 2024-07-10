// 
// Decompiled by Procyon v0.5.36
// 

package com.bomgosto.recepcaoevento4;

/*import java.util.Iterator;
import org.apache.axiom.om.OMElement;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.totemti.nfe.evento.TProcEvento;
import br.com.totemti.nfe.evento.TRetEvento;
import br.com.totemti.nfe.evento.TRetEnvEvento;
import org.apache.axiom.om.util.AXIOMUtil;
import br.com.totemti.nfe.utils.AssinaXML;
import br.com.totemti.nfe.utils.JAXBUtils;
import br.com.totemti.ssl.ConfiguracaoSSL;
import javax.xml.stream.XMLStreamException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.security.KeyStoreException;
import br.com.totemti.nfe.evento.TEnvEvento;
import java.util.Date;
import java.text.SimpleDateFormat;
import br.com.totemti.nfe.evento.TEvento;*/

public class TesteRecepcaoEvento
{
    /*public static void main(final String[] args) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, XMLStreamException, Exception {
        final String senhaCert = "12341234";
        final String localCfg = "C:\\Users\\junio\\Documents\\A_C_PANTONI_ALIMENTOS_30591233000177_1713668045878688800-senha12341234.pfx";
        final String localCacerts = "C:\\Users\\junio\\Documents\\cacerts-12-03-2024";
        final String tipoCertificado = "PKCS12";
        final String urlWS = "https://nfe.sefaz.mt.gov.br/nfews/v2/services/RecepcaoEvento4?wsdl";
        final TEvento.InfEvento.DetEvento det = new TEvento.InfEvento.DetEvento();
        det.setDescEvento("Carta de Correcao");
        det.setXCorrecao("Produto FARINHA DE MANDIOCA JANGADA 20X1 KG com codigo 001 e NCM 11081900 foi informado errado. O produto correto e FARINHA DE MILHO BOM GOSTO 20X500 G com codigo 198 e NCM 11022000.");
        det.setXCondUso("A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.");
        det.setVersao("1.00");
        final TEvento.InfEvento infEven = new TEvento.InfEvento();
        infEven.setId("ID1101105124053059123300017755001000002568178816533901");
        infEven.setCOrgao("51");
        infEven.setTpAmb("1");
        infEven.setCNPJ("30591233000177");
        infEven.setChNFe("51240530591233000177550010000025681788165339");
        infEven.setDhEvento(new StringBuilder(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(new Date())).insert(22, ":").toString());
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
        System.out.println(cartaCorrecao(envEvento, senhaCert, localCfg, localCacerts, tipoCertificado, urlWS));
    }
    
    public static String cancelarNfe(final TEnvEvento evento, final String senhaCert, final String localCfg, final String localCacerts, final String tipoCertificado, final String urlWS) {
        try {
            final ConfiguracaoSSL con = ConfiguracaoSSL.carregarCertificado(localCfg, senhaCert, tipoCertificado);
            final String xmlEnviNFeAssinado = AssinaXML.assinarEnvEvento(JAXBUtils.objectToString(evento), con.getPrivateKeyEntry());
            con.configurarConexao(localCacerts);
            final OMElement ome = AXIOMUtil.stringToOM(xmlEnviNFeAssinado);
            final RecepcaoEvento4Stub.NfeDadosMsg dadosMsg = new RecepcaoEvento4Stub.NfeDadosMsg();
            dadosMsg.setExtraElement(ome);
            final RecepcaoEvento4Stub stub = new RecepcaoEvento4Stub(urlWS);
            final RecepcaoEvento4Stub.NfeResultMsg result = stub.nfeRecepcaoEvento(dadosMsg);
            System.out.println(result.getExtraElement().toString());
            final TRetEnvEvento ret = (TRetEnvEvento)JAXBUtils.stringToObject(result.getExtraElement().toString(), TRetEnvEvento.class);
            if (ret.getCStat().equals("128")) {
                final TEnvEvento ev = (TEnvEvento)JAXBUtils.stringToObject(xmlEnviNFeAssinado, TEnvEvento.class);
                int i = 0;
                for (final TRetEvento re : ret.getRetEvento()) {
                    if (!re.getInfEvento().getCStat().equals("135")) {
                        return re.getInfEvento().getCStat() + "-" + re.getInfEvento().getXMotivo();
                    }
                    final TProcEvento proc = new TProcEvento();
                    proc.setVersao("1.00");
                    proc.setEvento(ev.getEvento().get(i));
                    proc.setRetEvento(re);
                    ++i;
                }
                return ret.getRetEvento().get(0).getInfEvento().getCStat() + " " + ret.getXMotivo();
            }
            return ret.getCStat() + "-" + ret.getXMotivo();
        }
        catch (Exception ex) {
            Logger.getLogger(TestaAutorizacaoMt.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    public static String cartaCorrecao(final TEnvEvento evento, final String senhaCert, final String localCfg, final String localCacerts, final String tipoCertificado, final String urlWS) {
        try {
            final ConfiguracaoSSL con = ConfiguracaoSSL.carregarCertificado(localCfg, senhaCert, tipoCertificado);
            final String xmlEnviNFeAssinado = AssinaXML.assinarEnvEvento(JAXBUtils.objectToString(evento), con.getPrivateKeyEntry());
            con.configurarConexao(localCacerts);
            final OMElement ome = AXIOMUtil.stringToOM(xmlEnviNFeAssinado);
            final RecepcaoEvento4Stub.NfeDadosMsg dadosMsg = new RecepcaoEvento4Stub.NfeDadosMsg();
            dadosMsg.setExtraElement(ome);
            final RecepcaoEvento4Stub stub = new RecepcaoEvento4Stub(urlWS);
            final RecepcaoEvento4Stub.NfeResultMsg result = stub.nfeRecepcaoEvento(dadosMsg);
            System.out.println(result.getExtraElement().toString());
            final TRetEnvEvento ret = (TRetEnvEvento)JAXBUtils.stringToObject(result.getExtraElement().toString(), TRetEnvEvento.class);
            if (ret.getCStat().equals("128")) {
                final TEnvEvento ev = (TEnvEvento)JAXBUtils.stringToObject(xmlEnviNFeAssinado, TEnvEvento.class);
                int i = 0;
                for (final TRetEvento re : ret.getRetEvento()) {
                    if (!re.getInfEvento().getCStat().equals("135")) {
                        return re.getInfEvento().getCStat() + "-" + re.getInfEvento().getXMotivo();
                    }
                    final TProcEvento proc = new TProcEvento();
                    proc.setVersao("1.00");
                    proc.setEvento(ev.getEvento().get(i));
                    proc.setRetEvento(re);
                    JAXBUtils.objectToXmlFile(proc, "C:\\Users\\junio\\Documents\\NFCeCanc" + proc.getEvento().getInfEvento().getId() + "-nfe.xml", true);
                    ++i;
                }
                System.err.println(result.getExtraElement().toString());
                return ret.getRetEvento().get(0).getInfEvento().getCStat() + " " + ret.getXMotivo();
            }
            System.err.println(result.getExtraElement().toString());
            return ret.getCStat() + "-" + ret.getXMotivo();
        }
        catch (Exception ex) {
            Logger.getLogger(TestaAutorizacaoMt.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }*/
}