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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2000._09.xmldsig_.SignatureType;


/**
 * Tipo Evento
 * 
 * <p>Classe Java de TEvento complex type.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TEvento">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="infEvento">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
 *                   <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *                   <choice>
 *                     <element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
 *                     <element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                   </choice>
 *                   <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                   <element name="dhEvento" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/>
 *                   <element name="tpEvento">
 *                     <simpleType>
 *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         <whiteSpace value="preserve"/>
 *                         <pattern value="[0-9]{6}"/>
 *                         <enumeration value="110111"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="nSeqEvento">
 *                     <simpleType>
 *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         <whiteSpace value="preserve"/>
 *                         <pattern value="[1-9]|[1][0-9]{0,1}|20"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="verEvento">
 *                     <simpleType>
 *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         <whiteSpace value="preserve"/>
 *                         <enumeration value="1.00"/>
 *                       </restriction>
 *                     </simpleType>
 *                   </element>
 *                   <element name="detEvento">
 *                     <complexType>
 *                       <complexContent>
 *                         <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           <sequence>
 *                             <element name="descEvento">
 *                               <simpleType>
 *                                 <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   <whiteSpace value="preserve"/>
 *                                   <enumeration value="Cancelamento"/>
 *                                 </restriction>
 *                               </simpleType>
 *                             </element>
 *                             <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt"/>
 *                             <element name="xJust" type="{http://www.portalfiscal.inf.br/nfe}TJust"/>
 *                           </sequence>
 *                           <attribute name="versao" use="required">
 *                             <simpleType>
 *                               <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 <whiteSpace value="preserve"/>
 *                                 <enumeration value="1.00"/>
 *                               </restriction>
 *                             </simpleType>
 *                           </attribute>
 *                         </restriction>
 *                       </complexContent>
 *                     </complexType>
 *                   </element>
 *                 </sequence>
 *                 <attribute name="Id" use="required">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *                       <pattern value="ID[0-9]{52}"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/>
 *       </sequence>
 *       <attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEvento" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlRootElement(name = "evento")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infEvento",
    "signature"
})
public class TEvento {

    @XmlElement(required = true)
    protected TEvento.InfEvento infEvento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obtém o valor da propriedade infEvento.
     * 
     * @return
     *     possible object is
     *     {@link TEvento.InfEvento }
     *     
     */
    public TEvento.InfEvento getInfEvento() {
        return infEvento;
    }

    /**
     * Define o valor da propriedade infEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link TEvento.InfEvento }
     *     
     */
    public void setInfEvento(TEvento.InfEvento value) {
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
     *         <element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
     *         <element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
     *         <choice>
     *           <element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
     *           <element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
     *         </choice>
     *         <element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
     *         <element name="dhEvento" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/>
     *         <element name="tpEvento">
     *           <simpleType>
     *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               <whiteSpace value="preserve"/>
     *               <pattern value="[0-9]{6}"/>
     *               <enumeration value="110111"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="nSeqEvento">
     *           <simpleType>
     *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               <whiteSpace value="preserve"/>
     *               <pattern value="[1-9]|[1][0-9]{0,1}|20"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="verEvento">
     *           <simpleType>
     *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               <whiteSpace value="preserve"/>
     *               <enumeration value="1.00"/>
     *             </restriction>
     *           </simpleType>
     *         </element>
     *         <element name="detEvento">
     *           <complexType>
     *             <complexContent>
     *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 <sequence>
     *                   <element name="descEvento">
     *                     <simpleType>
     *                       <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         <whiteSpace value="preserve"/>
     *                         <enumeration value="Cancelamento"/>
     *                       </restriction>
     *                     </simpleType>
     *                   </element>
     *                   <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt"/>
     *                   <element name="xJust" type="{http://www.portalfiscal.inf.br/nfe}TJust"/>
     *                 </sequence>
     *                 <attribute name="versao" use="required">
     *                   <simpleType>
     *                     <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       <whiteSpace value="preserve"/>
     *                       <enumeration value="1.00"/>
     *                     </restriction>
     *                   </simpleType>
     *                 </attribute>
     *               </restriction>
     *             </complexContent>
     *           </complexType>
     *         </element>
     *       </sequence>
     *       <attribute name="Id" use="required">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}ID">
     *             <pattern value="ID[0-9]{52}"/>
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
    @XmlRootElement(name = "infEvento")
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "infEvento", propOrder = {
        "cOrgao",
        "tpAmb",
        "cnpj",
        "cpf",
        "chNFe",
        "dhEvento",
        "tpEvento",
        "nSeqEvento",
        "verEvento",
        "detEvento"
    })
    public static class InfEvento {

        /**
         * Código do órgão de recepção do Evento. Utilizar a Tabela do IBGE extendida, utilizar 91 para identificar o Ambiente Nacional
         * 
         */
        @XmlElement(required = true)
        protected String cOrgao;
        /**
         * Identificação do Ambiente:
         *  1 - Produção
         *  2 - Homologação
         * 
         */
        @XmlElement(required = true)
        protected String tpAmb;
        /**
         * CNPJ
         * 
         */
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        /**
         * CPF
         * 
         */
        @XmlElement(name = "CPF")
        protected String cpf;
        /**
         * Chave de Acesso da NF-e vinculada ao evento
         * 
         */
        @XmlElement(required = true)
        protected String chNFe;
        /**
         * Data e Hora do Evento, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)
         * 
         */
        @XmlElement(required = true)
        protected String dhEvento;
        /**
         * Tipo do Evento
         * 
         */
        @XmlElement(required = true)
        protected String tpEvento;
        /**
         * Seqüencial do evento para o mesmo tipo de evento.  Para maioria dos eventos será 1, nos casos em que possa existir mais de um evento, como é o caso da carta de correção, o autor do evento deve numerar de forma seqüencial.
         * 
         */
        @XmlElement(required = true)
        protected String nSeqEvento;
        /**
         * Versão do Tipo do Evento
         * 
         */
        @XmlElement(required = true)
        protected String verEvento;
        /**
         * Schema XML de validação do evento do cancelamento 1101111
         * 
         */
        @XmlElement(required = true)
        protected TEvento.InfEvento.DetEvento detEvento;
        /**
         * Identificador da TAG a ser assinada, a regra de formação do Id é:
         * “ID” + tpEvento +  chave da NF-e + nSeqEvento
         * 
         */
        @XmlAttribute(name = "Id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        protected String id;

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
         * CNPJ
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCNPJ() {
            return cnpj;
        }

        /**
         * Define o valor da propriedade cnpj.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getCNPJ()
         */
        public void setCNPJ(String value) {
            this.cnpj = value;
        }

        /**
         * CPF
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCPF() {
            return cpf;
        }

        /**
         * Define o valor da propriedade cpf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getCPF()
         */
        public void setCPF(String value) {
            this.cpf = value;
        }

        /**
         * Chave de Acesso da NF-e vinculada ao evento
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
         * Data e Hora do Evento, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDhEvento() {
            return dhEvento;
        }

        /**
         * Define o valor da propriedade dhEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getDhEvento()
         */
        public void setDhEvento(String value) {
            this.dhEvento = value;
        }

        /**
         * Tipo do Evento
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
         * Seqüencial do evento para o mesmo tipo de evento.  Para maioria dos eventos será 1, nos casos em que possa existir mais de um evento, como é o caso da carta de correção, o autor do evento deve numerar de forma seqüencial.
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
         * Versão do Tipo do Evento
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVerEvento() {
            return verEvento;
        }

        /**
         * Define o valor da propriedade verEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         * @see #getVerEvento()
         */
        public void setVerEvento(String value) {
            this.verEvento = value;
        }

        /**
         * Schema XML de validação do evento do cancelamento 1101111
         * 
         * @return
         *     possible object is
         *     {@link TEvento.InfEvento.DetEvento }
         *     
         */
        public TEvento.InfEvento.DetEvento getDetEvento() {
            return detEvento;
        }

        /**
         * Define o valor da propriedade detEvento.
         * 
         * @param value
         *     allowed object is
         *     {@link TEvento.InfEvento.DetEvento }
         *     
         * @see #getDetEvento()
         */
        public void setDetEvento(TEvento.InfEvento.DetEvento value) {
            this.detEvento = value;
        }

        /**
         * Identificador da TAG a ser assinada, a regra de formação do Id é:
         * “ID” + tpEvento +  chave da NF-e + nSeqEvento
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
         * @see #getId()
         */
        public void setId(String value) {
            this.id = value;
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
         *         <element name="descEvento">
         *           <simpleType>
         *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               <whiteSpace value="preserve"/>
         *               <enumeration value="Cancelamento"/>
         *             </restriction>
         *           </simpleType>
         *         </element>
         *         <element name="nProt" type="{http://www.portalfiscal.inf.br/nfe}TProt"/>
         *         <element name="xJust" type="{http://www.portalfiscal.inf.br/nfe}TJust"/>
         *       </sequence>
         *       <attribute name="versao" use="required">
         *         <simpleType>
         *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             <whiteSpace value="preserve"/>
         *             <enumeration value="1.00"/>
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
        @XmlRootElement(name = "detEvento")
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "detEvento", propOrder = {
            "descEvento",
            "nProt",
            "xJust",
            "xCorrecao",
            "xCondUso"
        })
        public static class DetEvento {

            /**
             * Descrição do Evento - “Cancelamento”
             * 
             */
            @XmlElement(required = true)
            protected String descEvento;
            /**
             * Número do Protocolo de Status da NF-e. 1 posição (1 – Secretaria de Fazenda Estadual 2 – Receita Federal); 2 posições ano; 10 seqüencial no ano.
             * 
             */
            @XmlElement(required = true)
            protected String nProt;
            /**
             * Justificativa do cancelamento
             * 
             */
            @XmlElement(required = true)
            protected String xJust;
            /**
             * Correção a ser considerada
             * 
             */
            @XmlElement(required = true)
            protected String xCorrecao;
            /**
             * Texto Fixo com as condições de uso da Carta de Correção
             * 
             */
            @XmlElement(required = true)
            protected String xCondUso;
            @XmlAttribute(name = "versao", required = true)
            protected String versao;

            /**
             * Descrição do Evento - “Cancelamento”
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescEvento() {
                return descEvento;
            }

            /**
             * Define o valor da propriedade descEvento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             * @see #getDescEvento()
             */
            public void setDescEvento(String value) {
                this.descEvento = value;
            }

            /**
             * Número do Protocolo de Status da NF-e. 1 posição (1 – Secretaria de Fazenda Estadual 2 – Receita Federal); 2 posições ano; 10 seqüencial no ano.
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
             * Justificativa do cancelamento
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXJust() {
                return xJust;
            }

            /**
             * Define o valor da propriedade xJust.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             * @see #getXJust()
             */
            public void setXJust(String value) {
                this.xJust = value;
            }
            
            /**
             * Correção a ser considerada
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXCorrecao() {
                return xCorrecao;
            }

            /**
             * Define o valor da propriedade xCorrecao.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             * @see #getXCorrecao()
             */
            public void setXCorrecao(String value) {
                this.xCorrecao = value;
            }

            /**
             * Texto Fixo com as condições de uso da Carta de Correção
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getXCondUso() {
                return xCondUso;
            }

            /**
             * Define o valor da propriedade xCondUso.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             * @see #getXCondUso()
             */
            public void setXCondUso(String value) {
                this.xCondUso = value;
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

    }

}
