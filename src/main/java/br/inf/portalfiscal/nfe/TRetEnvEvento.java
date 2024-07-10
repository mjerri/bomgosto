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
 * Tipo Retorno de Lote de Envio
 * 
 * <p>Classe Java de TRetEnvEvento complex type.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TRetEnvEvento">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idLote">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <whiteSpace value="preserve"/>
 *               <pattern value="[0-9]{1,15}"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *         <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         <element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *         <element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
 *         <element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         <element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         <element name="retEvento" type="{http://www.portalfiscal.inf.br/nfe}TRetEvento" maxOccurs="20" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEnvEvento" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetEnvEvento", propOrder = {
    "idLote",
    "tpAmb",
    "verAplic",
    "cOrgao",
    "cStat",
    "xMotivo",
    "retEvento"
})
public class TRetEnvEvento {

    @XmlElement(required = true)
    protected String idLote;
    /**
     * Identificação do Ambiente:
     *  1 - Produção
     *  2 - Homologação
     * 
     */
    @XmlElement(required = true)
    protected String tpAmb;
    /**
     * Versão do Aplicativo que recebeu o Evento
     * 
     */
    @XmlElement(required = true)
    protected String verAplic;
    /**
     * Código do òrgao que registrou o Evento
     * 
     */
    @XmlElement(required = true)
    protected String cOrgao;
    /**
     * Código do status da registro do Evento
     * 
     */
    @XmlElement(required = true)
    protected String cStat;
    /**
     * Descrição literal do status do registro do Evento
     * 
     */
    @XmlElement(required = true)
    protected String xMotivo;
    protected List<TRetEvento> retEvento;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade idLote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdLote() {
        return idLote;
    }

    /**
     * Define o valor da propriedade idLote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdLote(String value) {
        this.idLote = value;
    }

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
     * Versão do Aplicativo que recebeu o Evento
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
     * Código do òrgao que registrou o Evento
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOrgao() {
        return cOrgao;
    }

    /**
     * Define o valor da propriedade cOrgao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getCOrgao()
     */
    public void setCOrgao(String value) {
        this.cOrgao = value;
    }

    /**
     * Código do status da registro do Evento
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
     * Descrição literal do status do registro do Evento
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
     * Gets the value of the retEvento property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retEvento property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getRetEvento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRetEvento }
     * </p>
     * 
     * 
     * @return
     *     The value of the retEvento property.
     */
    public List<TRetEvento> getRetEvento() {
        if (retEvento == null) {
            retEvento = new ArrayList<>();
        }
        return this.retEvento;
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
