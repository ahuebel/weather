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
 * <p>Java class for time-coordinateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="time-coordinateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UTC"/>
 *     &lt;enumeration value="local"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "time-coordinateType")
@XmlEnum
public enum TimeCoordinateType {

    UTC("UTC"),
    @XmlEnumValue("local")
    LOCAL("local");
    private final String value;

    TimeCoordinateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimeCoordinateType fromValue(String v) {
        for (TimeCoordinateType c: TimeCoordinateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
