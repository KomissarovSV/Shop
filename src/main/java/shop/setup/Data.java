package shop.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.entity.*;
import shop.repository.*;

import java.util.Arrays;
import java.util.List;

@Component
public class Data {

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    AttributeValueRepository attributeValueRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TypeRepository typeRepository;

    public void setUp(){

        Company intel = new Company("Intel");
        Company amd = new Company("AMD");
        Company nvidia = new Company("Nvidia");
        Company radion = new Company("Radion");
        companyRepository.save(Arrays.asList(intel,amd,nvidia,radion));

        Type cpu = new Type("CPU");
        Type motherboard = new Type("Motherboard");
        Type videoCard = new Type("Video card");
        Type type = new Type("Hard Drive");
        typeRepository.save(Arrays.asList(cpu,motherboard,videoCard,type));

        Attribute memorySize = new Attribute("Memory size");
        Attribute coresCount = new Attribute("Cores count");
        Attribute frequency = new Attribute("Frequency");
        Attribute socket = new Attribute("Socket");
        attributeRepository.save(Arrays.asList(memorySize,coresCount,frequency,socket));

        Product geForce960GTS = new Product();
        geForce960GTS.setName("GeForce 960 GTS");
        geForce960GTS.setCost(900D);
        geForce960GTS.setCompany(nvidia);
        geForce960GTS.setDescription("The latest video card from famous company.");
        geForce960GTS.setType(videoCard);
        productRepository.save(Arrays.asList(geForce960GTS));


        AttributeValue att1 = new AttributeValue(geForce960GTS, memorySize, "2 GB");
        AttributeValue att2 = new AttributeValue(geForce960GTS, frequency, "560 GHz");
        attributeValueRepository.save(Arrays.asList(att1,att2));

        Iterable<Product> all = productRepository.findAll();
        for (Product product : all) {
            System.out.println(product.getName());
            System.out.println(product.getCost());
            System.out.println(product.getCompany());
            System.out.println(product.getDescription());
            System.out.println(product.getType().getName());
            List<AttributeValue> attributeValue = product.getAttributeValue();
            for (AttributeValue value : attributeValue) {
                System.out.print(value.getAttribute().getName() + " ");
                System.out.println(value.getValue());
            }
        }

    }
}
