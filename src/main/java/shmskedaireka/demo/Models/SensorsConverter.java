package shmskedaireka.demo.Models;

import java.io.IOException;
import java.util.List;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.Type;

public class SensorsConverter implements AttributeConverter<List<Sensor>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Sensor> sensors) {
        try {
            String value = objectMapper.writeValueAsString(sensors);

            return value;
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Sensor> convertToEntityAttribute(String sensorsJSON) {
        try {
            List<Sensor> value = objectMapper.readValue(sensorsJSON, new TypeReference<List<Sensor>>() {
            });

            return value;
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
