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

    @Autowired
    RoleRepository roleRepository;

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
        geForce960GTS.setDescription("The latest video card.");
        geForce960GTS.setType(videoCard);
        AttributeValue att1 = new AttributeValue(memorySize, "2 GB");
        AttributeValue att2 = new AttributeValue(frequency, "560 GHz");
        List<AttributeValue> attributeValues = Arrays.asList(att1, att2);
        geForce960GTS.setAttributeValues(attributeValues);
        productRepository.save(Arrays.asList(geForce960GTS));

        getProduct(intel, cpu, coresCount, frequency);
        getProduct(intel, cpu, coresCount, frequency);
        getProduct(intel, cpu, coresCount, frequency);
        getProduct(intel, cpu, coresCount, frequency);
        getProduct(intel, cpu, coresCount, frequency);
        getProduct(intel, cpu, coresCount, frequency);



        Iterable<Product> all = productRepository.findAll();
        for (Product product : all) {
            System.out.println(product.getName());
            System.out.println(product.getCost());
            System.out.println(product.getCompany());
            System.out.println(product.getDescription());
            System.out.println(product.getType().getName());
            List<AttributeValue> attributeValue = product.getAttributeValues();
            for (AttributeValue value : attributeValue) {
                System.out.print(value.getAttribute().getName() + " ");
                System.out.println(value.getValue());
            }
        }

        Role role_admin = new Role("ROLE_ADMIN");
        Role role_user = new Role("ROLE_USER");
        roleRepository.save(Arrays.asList(role_admin,role_user));

    }

    private void getProduct(Company intel, Type cpu, Attribute coresCount, Attribute frequency) {
        Product intelCPU = new Product();
        intelCPU.setName("Intel CPU i5 5030");
        intelCPU.setCost(500D);
        intelCPU.setCompany(intel);
        intelCPU.setDescription("Coolest CPU");
        intelCPU.setType(cpu);
        AttributeValue intelCPUAtt1 = new AttributeValue(coresCount, "4");
        AttributeValue intelCPUAtt2 = new AttributeValue(frequency, "2000 GHz");
        List<AttributeValue> intelCPUAtt = Arrays.asList(intelCPUAtt1, intelCPUAtt2);
        intelCPU.setAttributeValues(intelCPUAtt);
        productRepository.save(Arrays.asList(intelCPU));
    }
}
