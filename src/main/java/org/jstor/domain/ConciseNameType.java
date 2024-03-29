//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.18 at 12:41:40 PM EDT 
//


package org.jstor.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for concise-nameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="concise-nameType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="time-series"/>
 *     &lt;enumeration value="glance"/>
 *     &lt;enumeration value="tabular-digital"/>
 *     &lt;enumeration value="digital-zone"/>
 *     &lt;enumeration value="dwmlByDay"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "concise-nameType")
@XmlEnum
public enum ConciseNameType {

    @XmlEnumValue("time-series")
    TIME_SERIES("time-series"),
    @XmlEnumValue("glance")
    GLANCE("glance"),
    @XmlEnumValue("tabular-digital")
    TABULAR_DIGITAL("tabular-digital"),
    @XmlEnumValue("digital-zone")
    DIGITAL_ZONE("digital-zone"),
    @XmlEnumValue("dwmlByDay")
    DWML_BY_DAY("dwmlByDay");
    private final String value;

    ConciseNameType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConciseNameType fromValue(String v) {
        for (ConciseNameType c: ConciseNameType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
