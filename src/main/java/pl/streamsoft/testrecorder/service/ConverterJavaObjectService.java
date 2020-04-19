package pl.streamsoft.testrecorder.service;

import java.io.IOException;

public interface ConverterJavaObjectService {

    String convertToStringSerializableObject(Object object) throws IOException;

    Object convertFromStringToObject(String object) throws IOException, ClassNotFoundException;

}
