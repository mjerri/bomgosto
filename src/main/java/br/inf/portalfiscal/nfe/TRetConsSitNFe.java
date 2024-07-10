//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v4.0.5 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
//


package br.inf.portalfiscal.nfe;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Tipo Retorno de Pedido de Consulta da Situação Atual da Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TRetConsSitNFe complex type.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TRetConsSitNFe">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         <element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *         <element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         <element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         <element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/>
 *         <element name="dhRecbto" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/>
 *         <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *         <element name="protNFe" type="{http://www.portalfiscal.inf.br/nfe}TProtNFe" minOccurs="0"/>
 *         <element name="retCancNFe" type="{http://www.portalfiscal.inf.br/nfe}TRetCancNFe" minOccurs="0"/>
 *         <element name="procEventoNFe" type="{http://www.portalfiscal.inf.br/nfe}TProcEvento" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsSitNFe" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsSitNFe", propOrder = {
    "tpAmb",
    "verAplic",
    "cStat",
    "xMotivo",
    "cuf",
    "dhRecbto",
    "chNFe",
    "protNFe",
    "retCancNFe",
    "procEventoNFe"
})
public class TRetConsSitNFe {

    /**
     * Identificação do Ambiente:
     *  1 - Produção
     *  2 - Homologação
     * 
     */
    @XmlElement(required = true)
    protected String tpAmb;
    /**
     * Versão do Aplicativo que processou a NF-e
     * 
     */
    @XmlElement(required = true)
    protected String verAplic;
    /**
     * Código do status da mensagem enviada.
     * 
     */
    @XmlElement(required = true)
    protected String cStat;
    /**
     * Descrição literal do status do serviço solicitado.
     * 
     */
    @XmlElement(required = true)
    protected String xMotivo;
    /**
     * código da UF de atendimento
     * 
     */
    @XmlElement(name = "cUF", required = true)
    protected String cuf;
    /**
     * AAAA-MM-DDTHH:MM:SSTZD
     * 
     */
    @XmlElement(required = true)
    protected String dhRecbto;
    /**
     * Chaves de acesso da NF-e consultada
     * 
     */
    @XmlElement(required = true)
    protected String chNFe;
    /**
     * Protocolo de autorização de uso da NF-e
     * 
     */
    protected TProtNFe protNFe;
    /**
     * Protocolo de homologação de cancelamento de uso da NF-e
     * 
     */
    protected TRetCancNFe retCancNFe;
    /**
     * Protocolo de registro de evento da NF-e
     * 
     */
    protected List<TProcEvento> procEventoNFe;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Identificação do Ambiente:
     *  1 - Produção
     *  2 - Homologação
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * Define o valor da propriedade tpAmb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getTpAmb()
     */
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    /**
     * Versão do Aplicativo que processou a NF-e
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Define o valor da propriedade verAplic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getVerAplic()
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Código do status da mensagem enviada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Define o valor da propriedade cStat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getCStat()
     */
    public void setCStat(String value) {
        this.cStat = value;
    }

    /**
     * Descrição literal do status do serviço solicitado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Define o valor da propriedade xMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getXMotivo()
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * código da UF de atendimento
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUF() {
        return cuf;
    }

    /**
     * Define o valor da propriedade cuf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getCUF()
     */
    public void setCUF(String value) {
        this.cuf = value;
    }

    /**
     * AAAA-MM-DDTHH:MM:SSTZD
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhRecbto() {
        return dhRecbto;
    }

    /**
     * Define o valor da propriedade dhRecbto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getDhRecbto()
     */
    public void setDhRecbto(String value) {
        this.dhRecbto = value;
    }

    /**
     * Chaves de acesso da NF-e consultada
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * Define o valor da propriedade chNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getChNFe()
     */
    public void setChNFe(String value) {
        this.chNFe = value;
    }

    /**
     * Protocolo de autorização de uso da NF-e
     * 
     * @return
     *     possible object is
     *     {@link TProtNFe }
     *     
     */
    public TProtNFe getProtNFe() {
        return protNFe;
    }

    /**
     * Define o valor da propriedade protNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TProtNFe }
     *     
     * @see #getProtNFe()
     */
    public void setProtNFe(TProtNFe value) {
        this.protNFe = value;
    }

    /**
     * Protocolo de homologação de cancelamento de uso da NF-e
     * 
     * @return
     *     possible object is
     *     {@link TRetCancNFe }
     *     
     */
    public TRetCancNFe getRetCancNFe() {
        return retCancNFe;
    }

    /**
     * Define o valor da propriedade retCancNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetCancNFe }
     *     
     * @see #getRetCancNFe()
     */
    public void setRetCancNFe(TRetCancNFe value) {
        this.retCancNFe = value;
    }

    /**
     * Protocolo de registro de evento da NF-e
     * 
     * Gets the value of the procEventoNFe property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procEventoNFe property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getProcEventoNFe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProcEvento }
     * </p>
     * 
     * 
     * @return
     *     The value of the procEventoNFe property.
     */
    public List<TProcEvento> getProcEventoNFe() {
        if (procEventoNFe == null) {
            procEventoNFe = new ArrayList<>();
        }
        return this.procEventoNFe;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }

}
