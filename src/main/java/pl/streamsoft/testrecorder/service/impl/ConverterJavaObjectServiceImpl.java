package pl.streamsoft.testrecorder.service.impl;

import org.springframework.stereotype.Component;
import pl.streamsoft.testrecorder.service.ConverterJavaObjectService;

import java.io.*;
import java.util.Base64;

@Component
public class ConverterJavaObjectServiceImpl implements ConverterJavaObjectService {

    public String convertToStringSerializableObject(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public Object convertFromStringToObject(String object) throws IOException, ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode(object);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));

        Object o  = ois.readObject();
        ois.close();
        return o;
    }
}
