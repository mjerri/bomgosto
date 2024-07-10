//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v4.0.5 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
//


package br.inf.portalfiscal.nfe;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2000._09.xmldsig_.SignatureType;


/**
 * Tipo retorno Pedido de Cancelamento da Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TRetCancNFe complex type.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TRetCancNFe">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="infCanc">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *                   <element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *                   <element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *                   <element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *                   <element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/>
 *                   <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/>
 *                   <element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/>
 *                 </sequence>
 *                 <attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerCancNFe" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetCancNFe", propOrder = {
    "infCanc",
    "signature"
})
public class TRetCancNFe {

    /**
     * Dados do Resultado do Pedido de Cancelamento da Nota Fiscal Eletrônica
     * 
     */
    @XmlElement(required = true)
    protected TRetCancNFe.InfCanc infCanc;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Dados do Resultado do Pedido de Cancelamento da Nota Fiscal Eletrônica
     * 
     * @return
     *     possible object is
     *     {@link TRetCancNFe.InfCanc }
     *     
     */
    public TRetCancNFe.InfCanc getInfCanc() {
        return infCanc;
    }

    /**
     * Define o valor da propriedade infCanc.
     * 
     * @param value
     *     allowed object is
     *     {@link TRetCancNFe.InfCanc }
     *     
     * @see #getInfCanc()
     */
    public void setInfCanc(TRetCancNFe.InfCanc value) {
        this.infCanc = value;
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
     *         <element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
     *         <element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
     *         <element name="cUF" type="{http://www.portalfiscal.inf.br/nfe}TCodUfIBGE"/>
     *         <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe" minOccurs="0"/>
     *         <element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt" minOccurs="0"/>
     *       </sequence>
     *       <attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
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
        "cStat",
        "xMotivo",
        "cuf",
        "chNFe",
        "dhRecbto",
        "nProt"
    })
    public static class InfCanc {

        /**
         * Identificação do Ambiente:
         *  1 - Produção
         *  2 - Homologação
         * 
         */
        @XmlElement(required = true)
        protected String tpAmb;
        /**
         * Versão do Aplicativo que processou o pedido de cancelamento
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
         * Chaves de acesso da NF-e, compostas por: UF do emitente, AAMM da emissão da NFe, CNPJ do emitente, modelo, série e número da NF-e e código numérico + DV.
         * 
         */
        protected String chNFe;
        /**
         * Data e hora de recebimento, no formato AAAA-MM-DDTHH:MM:SS. Deve ser preenchida com data e hora da gravação no Banco em caso de Confirmação.
         * 
         */
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dhRecbto;
        /**
         * Número do Protocolo de Status da NF-e. 1 posição (1 – Secretaria de Fazenda Estadual 2 – Receita Federal); 2 - código da UF - 2 posições ano; 10 seqüencial no ano.
         * 
         */
        protected String nProt;
        @XmlAttribute(name = "Id")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
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
         * Versão do Aplicativo que processou o pedido de cancelamento
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
         * Data e hora de recebimento, no formato AAAA-MM-DDTHH:MM:SS. Deve ser preenchida com data e hora da gravação no Banco em caso de Confirmação.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDhRecbto() {
            return dhRecbto;
        }

        /**
         * Define o valor da propriedade dhRecbto.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         * @see #getDhRecbto()
         */
        public void setDhRecbto(XMLGregorianCalendar value) {
            this.dhRecbto = value;
        }

        /**
         * Número do Protocolo de Status da NF-e. 1 posição (1 – Secretaria de Fazenda Estadual 2 – Receita Federal); 2 - código da UF - 2 posições ano; 10 seqüencial no ano.
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
