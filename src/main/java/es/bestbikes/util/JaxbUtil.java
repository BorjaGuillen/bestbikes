/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.util;

import es.bestbikes.types.TypeJaxb;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jorge
 */
public class JaxbUtil {

    public static Object unmarshall(String xml, TypeJaxb paquete) {
        Object salida = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(paquete.getValue());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            salida = jaxbUnmarshaller.unmarshal(stream);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return salida;
    }

}
