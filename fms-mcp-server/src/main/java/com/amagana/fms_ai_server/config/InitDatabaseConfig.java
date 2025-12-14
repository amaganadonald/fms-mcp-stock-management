package com.amagana.fms_ai_server.config;

import com.amagana.fms_ai_server.dto.*;
import com.amagana.fms_ai_server.enums.Units;
import com.amagana.fms_ai_server.service.CategoryService;
import com.amagana.fms_ai_server.service.CustomerService;
import com.amagana.fms_ai_server.service.ProductService;
import com.amagana.fms_ai_server.service.SupplierService;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDatabaseConfig  {


    private static final Faker faker = new Faker();

    @Bean
    CommandLineRunner commandLineRunner(CategoryService categoryService, ProductService productService,
                                        SupplierService supplierService, CustomerService customerService) {
        return args -> {
            List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
            List<CategoryRequestDTO> categoryRequestDTOS = InitDatabaseConfig.generateCategories(11);
            for (CategoryRequestDTO categoryRequestDTO: categoryRequestDTOS) {
                categoryResponseDTOS.add(categoryService.addCategory(categoryRequestDTO));
            }
            List<ProductRequestDTO> productRequestDTOS = InitDatabaseConfig.generateProducts(100, categoryResponseDTOS);
            for (ProductRequestDTO productRequestDTO: productRequestDTOS) {
                productService.addProduct(productRequestDTO);
            }
            List<SupplierRequestDTO> supplierRequestDTOS = InitDatabaseConfig.generateSuppliers(30);
            for(SupplierRequestDTO supplierRequestDTO:supplierRequestDTOS) {
                supplierService.addSupplier(supplierRequestDTO);
            }
            List<CustomerRequestDTO> customerRequestDTOS = InitDatabaseConfig.generateClients(250);
            for(CustomerRequestDTO customerRequestDTO:customerRequestDTOS){
                customerService.addCustomer(customerRequestDTO);
            }


        };
    }
    public static List<CategoryRequestDTO> generateCategories(int count) {
        List<CategoryRequestDTO> categories = new ArrayList<>();
        List<String> categoryNames = List.of(
                "Informatique",
                "Téléphonie",
                "Bureautique",
                "Electroménager",
                "Audio Vidéo",
                "Réseaux",
                "Sécurité",
                "Consommables",
                "Vêtements hommes",
                "Vêtements femmes",
                "Vêtements enfants"
        );

        for (int i = 0; i < count; i++) {
            String name = faker.options().nextElement(categoryNames);
            categories.add(
                    new CategoryRequestDTO(
                            name.toUpperCase().replace(" ", "_")+"_"+faker.number().digits(2),
                            name,
                            "Catégorie dédiée aux produits de type " + name.toLowerCase()
                    )
            );
        }
        return categories;
    }

    public static List<ProductRequestDTO> generateProducts(int count, List<CategoryResponseDTO> categories) {
        List<ProductRequestDTO> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CategoryResponseDTO randomCategory =  faker.options().nextElement(categories);
            ProductRequestDTO product = ProductRequestDTO.builder()
                    .reference(faker.code().ean13())
                    .category(randomCategory.id())
                    .name(faker.commerce().productName())
                    .description(faker.lorem().sentence())
                    .purchase_price( BigDecimal.valueOf(faker.number().randomDouble(2, 10, 200)))
                    .selling_price(BigDecimal.valueOf(faker.number().randomDouble(2, 20, 400)))
                    .unit(String.valueOf(faker.options().nextElement(Units.values())))
                    .active(faker.bool().bool())
                    .build();

            products.add(product);
        }
        return products;
    }

    public static List<CustomerRequestDTO> generateClients(int count) {
        List<CustomerRequestDTO> customers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            CustomerRequestDTO customerRequestDTO = CustomerRequestDTO.builder()
                    .code("CUS-" + faker.number().digits(5))
                    .nom(faker.name().fullName())
                    .phone(faker.phoneNumber().cellPhone())
                    .mail(faker.internet().emailAddress())
                    .address(faker.address().fullAddress())
                    .build();
            customers.add(customerRequestDTO);
        }
        return customers;
    }


    public static List<SupplierRequestDTO> generateSuppliers(int count) {
        List<SupplierRequestDTO> suppliers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            SupplierRequestDTO supplier = SupplierRequestDTO.builder()
                    .code("SUP-" + faker.number().digits(5))
                    .name(faker.company().name())
                    .phone(faker.phoneNumber().phoneNumber())
                    .email(faker.internet().emailAddress())
                    .address(faker.address().fullAddress())
                    .active(true)
                    .build();
            suppliers.add(supplier);
        }
        return suppliers;
    }

}
