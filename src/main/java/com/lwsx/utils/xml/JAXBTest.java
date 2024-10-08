package com.lwsx.utils.xml;

import com.lwsx.utils.function.StudentInfo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;
import org.acord.schema.data.draft.reusabledatacomponents._1.PolicySynchronizationProcessType;
import org.acord.schema.data.draft.reusabledatacomponents._1.PolicySynchronizationType;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JAXBTest {
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("data/cn/policies/2023-10-07/0626/PolicySynchronization_20230914_INPT029997_ClaimAgainstPolicy.xml");
        validate(file);

        /**
         * xml 转 java object
         */
        JAXBContext jaxbContext = JAXBContext.newInstance(PolicySynchronizationProcessType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        JAXBElement<PolicySynchronizationProcessType> jaxbElement = unmarshaller.unmarshal(new StreamSource(file), PolicySynchronizationProcessType.class);
        List<PolicySynchronizationType> policySynchronizationTypeList = jaxbElement.getValue().getPolicySynchronization();
        PolicySynchronizationType policySynchronizationType = policySynchronizationTypeList.get(0);
        String providerCode = policySynchronizationType.getOrganization().get(0).getExternalIdentifier().get(0).getId();
        System.out.println(providerCode);

        /**
         * xml 转 xsd
         */

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setAge(33);
        studentInfo.setName("lwsx");
        marshaller.marshal(studentInfo, System.out);
    }

    /**
     * xml 格式校验
     *
     * @param file
     */
    private static void validate(File file) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(JAXBTest.class.getResource("/") + "ACORDSchemaWSDL/messages/AMLMessages.xsd");
        Validator validator = null;
        try {
            validator = factory.newSchema(schemaFile).newValidator();
            validator.validate(new StreamSource(file));
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
