package sample;

import java.io.File;
import javax.xml.bind.*;

public class JAXBHelper {

    static public void saveStatement(String filename, Circle object){
        try{
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    static public Circle getStatement(String filename, Circle object){
        try {
            File file = new File(filename);
            System.out.println(object.getClass());
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Circle circle = (Circle) jaxbUnmarshaller.unmarshal(file);
            System.out.println(circle);
            return circle;
        } catch (PropertyException e) {
            e.printStackTrace();
            return null;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }


}
