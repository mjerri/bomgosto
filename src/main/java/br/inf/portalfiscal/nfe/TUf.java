//
// Este arquivo foi gerado pela Eclipse Implementation of JAXB, v4.0.5 
// Consulte https://eclipse-ee4j.github.io/jaxb-ri 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
//


package br.inf.portalfiscal.nfe;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Tipo Sigla da UF
 * 
 * <p>Classe Java de TUf.</p>
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.</p>
 * <pre>{@code
 * <simpleType name="TUf">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <whiteSpace value="preserve"/>
 *     <enumeration value="AC"/>
 *     <enumeration value="AL"/>
 *     <enumeration value="AM"/>
 *     <enumeration value="AP"/>
 *     <enumeration value="BA"/>
 *     <enumeration value="CE"/>
 *     <enumeration value="DF"/>
 *     <enumeration value="ES"/>
 *     <enumeration value="GO"/>
 *     <enumeration value="MA"/>
 *     <enumeration value="MG"/>
 *     <enumeration value="MS"/>
 *     <enumeration value="MT"/>
 *     <enumeration value="PA"/>
 *     <enumeration value="PB"/>
 *     <enumeration value="PE"/>
 *     <enumeration value="PI"/>
 *     <enumeration value="PR"/>
 *     <enumeration value="RJ"/>
 *     <enumeration value="RN"/>
 *     <enumeration value="RO"/>
 *     <enumeration value="RR"/>
 *     <enumeration value="RS"/>
 *     <enumeration value="SC"/>
 *     <enumeration value="SE"/>
 *     <enumeration value="SP"/>
 *     <enumeration value="TO"/>
 *     <enumeration value="EX"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "TUf")
@XmlEnum
public enum TUf {

    AC,
    AL,
    AM,
    AP,
    BA,
    CE,
    DF,
    ES,
    GO,
    MA,
    MG,
    MS,
    MT,
    PA,
    PB,
    PE,
    PI,
    PR,
    RJ,
    RN,
    RO,
    RR,
    RS,
    SC,
    SE,
    SP,
    TO,
    EX;

    public String value() {
        return name();
    }

    public static TUf fromValue(String v) {
        return valueOf(v);
    }

}
