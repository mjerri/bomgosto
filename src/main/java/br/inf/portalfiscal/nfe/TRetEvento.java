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
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2000._09.xmldsig_.SignatureType;


/**
 * Tipo retorno do Evento
 * 
 * <p>Classe Java de TRetEvento complex type.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TRetEvento">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="infEvento">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *                   <element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *                   <element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
 *                   <element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *                   <element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *                   <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/>
 *                   <element name="tpEvento" minOccurs="0">
 *                     <simpleType>
 *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         <whiteSpace value="preserve"/>
 *                         <pattern value="[0-9]{6}"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="xEvento" minOccurs="0">
 *                     <simpleType>
 *                       <restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                         <minLength value="5"/>
 *                         <maxLength value="60"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="nSeqEvento" minOccurs="0">
 *                     <simpleType>
 *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         <whiteSpace value="preserve"/>
 *                         <pattern value="[1-9][0-9]{0,1}"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <choice minOccurs="0">
 *                     <element name="CNPJDest" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
 *                     <element name="CPFDest" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                   </choice>
 *                   <element name="emailDest" minOccurs="0">
 *                     <simpleType>
 *                       <restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                         <minLength value="1"/>
 *                         <maxLength value="60"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="dhRegEvento">
 *                     <simpleType>
 *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         <whiteSpace value="preserve"/>
 *                         <pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d-0[1-4]:00"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/>
 *                 </sequence>
 *                 <attribute name="Id">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *                       <pattern value="ID[0-9]{15}"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEvento" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetEvento", propOrder = {
    "infEvento",
    "signature"
})
public class TRetEvento {

    @XmlElement(required = true)
    protected TRetEvento.InfEvento infEvento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade infEvento.
     * 
     * @return
     *     possible object is
     *     {@link TRetEvento.InfEvento }
     *     
     */
    public TRetEvento.InfEvento getInfEvento() {
        return infEvento;
    }

    /**
     * Define o valor da propriedade infEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetEvento.InfEvento }
     *     
     */
    public void setInfEvento(TRetEvento.InfEvento value) {
        this.infEvento = value;
    }

    /**
     * Obtém o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
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


    /**
     * <p>Classe Java de anonymous complex type.</p>
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
     *         <element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
     *         <element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
     *         <element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
     *         <element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
     *         <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/>
     *         <element name="tpEvento" minOccurs="0">
     *           <simpleType>
     *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               <whiteSpace value="preserve"/>
     *               <pattern value="[0-9]{6}"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="xEvento" minOccurs="0">
     *           <simpleType>
     *             <restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
     *               <minLength value="5"/>
     *               <maxLength value="60"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="nSeqEvento" minOccurs="0">
     *           <simpleType>
     *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               <whiteSpace value="preserve"/>
     *               <pattern value="[1-9][0-9]{0,1}"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <choice minOccurs="0">
     *           <element name="CNPJDest" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
     *           <element name="CPFDest" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
     *         </choice>
     *         <element name="emailDest" minOccurs="0">
     *           <simpleType>
     *             <restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
     *               <minLength value="1"/>
     *               <maxLength value="60"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="dhRegEvento">
     *           <simpleType>
     *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               <whiteSpace value="preserve"/>
     *               <pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d-0[1-4]:00"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/>
     *       </sequence>
     *       <attribute name="Id">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}ID">
     *             <pattern value="ID[0-9]{15}"/>
     *           </restriction>
     *         </simpleType>
     *       </attribute>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tpAmb",
        "verAplic",
        "cOrgao",
        "cStat",
        "xMotivo",
        "chNFe",
        "tpEvento",
        "xEvento",
        "nSeqEvento",
        "cnpjDest",
        "cpfDest",
        "emailDest",
        "dhRegEvento",
        "nProt"
    })
    public static class InfEvento {

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
         * Código do órgão de recepção do Evento. Utilizar a Tabela do IBGE extendida, utilizar 91 para identificar o Ambiente Nacional
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
        /**
         * Chave de Acesso NF-e vinculada
         * 
         */
        protected String chNFe;
        /**
         * Tipo do Evento vinculado
         * 
         */
        protected String tpEvento;
        /**
         * Descrição do Evento
         * 
         */
        protected String xEvento;
        /**
         * Seqüencial do evento
         * 
         */
        protected String nSeqEvento;
        /**
         * CNPJ Destinatário
         * 
         */
        @XmlElement(name = "CNPJDest")
        protected String cnpjDest;
        /**
         * CPF Destiantário
         * 
         */
        @XmlElement(name = "CPFDest")
        protected String cpfDest;
        /**
         * email do destinatário
         * 
         */
        protected String emailDest;
        /**
         * Data e Hora de do recebimento do evento ou do registro do evento formato UTC AAAA-MM-DDThh:mm:ssTZD.
         * 
         */
        @XmlElement(required = true)
        protected String dhRegEvento;
        /**
         * Número do protocolo de registro do evento
         * 
         */
        protected String nProt;
        @XmlAttribute(name = "Id")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        protected String id;

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
         * Código do órgão de recepção do Evento. Utilizar a Tabela do IBGE extendida, utilizar 91 para identificar o Ambiente Nacional
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
         * Chave de Acesso NF-e vinculada
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
         * Tipo do Evento vinculado
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTpEvento() {
            return tpEvento;
        }

        /**
         * Define o valor da propriedade tpEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getTpEvento()
         */
        public void setTpEvento(String value) {
            this.tpEvento = value;
        }

        /**
         * Descrição do Evento
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXEvento() {
            return xEvento;
        }

        /**
         * Define o valor da propriedade xEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getXEvento()
         */
        public void setXEvento(String value) {
            this.xEvento = value;
        }

        /**
         * Seqüencial do evento
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNSeqEvento() {
            return nSeqEvento;
        }

        /**
         * Define o valor da propriedade nSeqEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getNSeqEvento()
         */
        public void setNSeqEvento(String value) {
            this.nSeqEvento = value;
        }

        /**
         * CNPJ Destinatário
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCNPJDest() {
            return cnpjDest;
        }

        /**
         * Define o valor da propriedade cnpjDest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getCNPJDest()
         */
        public void setCNPJDest(String value) {
            this.cnpjDest = value;
        }

        /**
         * CPF Destiantário
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCPFDest() {
            return cpfDest;
        }

        /**
         * Define o valor da propriedade cpfDest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getCPFDest()
         */
        public void setCPFDest(String value) {
            this.cpfDest = value;
        }

        /**
         * email do destinatário
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmailDest() {
            return emailDest;
        }

        /**
         * Define o valor da propriedade emailDest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getEmailDest()
         */
        public void setEmailDest(String value) {
            this.emailDest = value;
        }

        /**
         * Data e Hora de do recebimento do evento ou do registro do evento formato UTC AAAA-MM-DDThh:mm:ssTZD.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDhRegEvento() {
            return dhRegEvento;
        }

        /**
         * Define o valor da propriedade dhRegEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getDhRegEvento()
         */
        public void setDhRegEvento(String value) {
            this.dhRegEvento = value;
        }

        /**
         * Número do protocolo de registro do evento
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNProt() {
            return nProt;
        }

        /**
         * Define o valor da propriedade nProt.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getNProt()
         */
        public void setNProt(String value) {
            this.nProt = value;
        }

        /**
         * Obtém o valor da propriedade id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Define o valor da propriedade id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

    }

}
