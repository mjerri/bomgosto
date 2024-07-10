//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v4.0.5 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
//


package br.inf.portalfiscal.nfe;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Tipo Pedido de Consulta da Situação Atual da Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TConsSitNFe complex type.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TConsSitNFe">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         <element name="xServ">
 *           <simpleType>
 *             <restriction base="{http://www.portalfiscal.inf.br/nfe}TServ">
 *               <enumeration value="CONSULTAR"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *         <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
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
@XmlType(name = "TConsSitNFe", propOrder = {
    "tpAmb",
    "xServ",
    "chNFe"
})
public class TConsSitNFe {

    /**
     * Identificação do Ambiente:
     *  1 - Produção
     *  2 - Homologação
     * 
     */
    @XmlElement(required = true)
    protected String tpAmb;
    /**
     * Serviço Solicitado
     * 
     */
    @XmlElement(required = true)
    protected String xServ;
    /**
     * Chaves de acesso da NF-e, compostas por: UF do emitente, AAMM da emissão da NFe, CNPJ do emitente, modelo, série e número da NF-e e código numérico + DV.
     * 
     */
    @XmlElement(required = true)
    protected String chNFe;
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
     * Serviço Solicitado
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXServ() {
        return xServ;
    }

    /**
     * Define o valor da propriedade xServ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getXServ()
     */
    public void setXServ(String value) {
        this.xServ = value;
    }

    /**
     * Chaves de acesso da NF-e, compostas por: UF do emitente, AAMM da emissão da NFe, CNPJ do emitente, modelo, série e número da NF-e e código numérico + DV.
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
