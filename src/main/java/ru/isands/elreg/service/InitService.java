package ru.isands.elreg.service;

import org.springframework.stereotype.Service;
import ru.isands.elreg.model.*;
import ru.isands.elreg.repository.ModelRepository;
import ru.isands.elreg.repository.ProductRepository;

import java.math.BigDecimal;

@Service
public class InitService {
    private final ProductRepository productRepository;
    private final ModelRepository modelRepository;
    
    
    public InitService(ProductRepository productRepository, ModelRepository modelRepository) {
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
    }
    
    public void initDatabase() {
        long dexpId = saveProduct("43inch", "Dexp", "China", Category.TV,
                true, true);
        saveTv(dexpId, "Umpa", "123-123","black", 500,100, 500, 
                new BigDecimal("12000.35"),true, "Economy", "LED");
        saveTv(dexpId, "Lumpa", "213-213","white", 500,50, 800,
                new BigDecimal("18000.15"), false, "Economy", "LED");
        long sonyId = saveProduct("Bravia", "Sony", "Japan", Category.TV,
                false, false);
        saveTv(sonyId, "Hara", "421-124","silver", 1500,10, 800,
                new BigDecimal("648903.33"),true, "Business", "IPS");        
        saveTv(sonyId, "Kiri", "412-214","silver", 1500,10, 800,
                new BigDecimal("688889.29"), true, "Business", "IPS");
        long philipsId = saveProduct("BlueSeries", "Philips", "Holland", Category.TV,
                true, false);
        saveTv(philipsId, "Trali", "192-291","red", 500,410, 800,
                new BigDecimal("88889.29"), false, "Business", "ERT");
        saveTv(philipsId, "Vali", "429-924","pink", 500,410, 800,
                new BigDecimal("88889.29"), true, "Business", "ERT");

        long cosmosId = saveProduct("Ural", "RosCosmos", "Russia", Category.CLEANER,
                true, true);
        saveCleaner(cosmosId, "Alpha", "CLN-123","pink", 500,500, 1500,
                new BigDecimal("2000.35"),true, 900, 10);
        saveCleaner(cosmosId, "Gamma", "CLN-213","white", 1500,750, 800,
                new BigDecimal("8000.15"), true, 1200, 15);
        long philclnId = saveProduct("Scrab", "Philips", "Holland", Category.CLEANER,
                true, false);
        saveCleaner(philclnId, "Scrab-28", "CLN-879","silver", 500,500, 500,
                new BigDecimal("52000.35"),false, 900, 2);
        saveCleaner(philclnId, "Scrab-82", "CLN-298","black", 600,750, 300,
                new BigDecimal("23000.15"), true, 1200, 3);
        long xiaId = saveProduct("Mia", "Xia", "China", Category.CLEANER,
                false, true);
        saveCleaner(xiaId, "Bong", "CLN-796","black", 200,300, 400,
                new BigDecimal("5000.35"),true, 900, 3);
        saveCleaner(xiaId, "Kong", "CLN-292","black", 300,450, 500,
                new BigDecimal("8000.15"), true, 1200, 2);

        long lgId = saveProduct("Froze", "LG", "Korea", Category.FRIDGE,
                true, true);
        saveFridge(lgId, "KB", "FRG-123","black", 600,650, 1500,
                new BigDecimal("18000.15"), true, 1, "single");
        saveFridge(lgId, "LB", "FRG-233","black", 600,650, 1800,
                new BigDecimal("28000.00"), true, 2, "double");
        long indesitId = saveProduct("Cold", "Indesit", "Slovenia", Category.FRIDGE,
                true, false);
        saveFridge(indesitId, "IB", "FRG-3","silver", 600,550, 1800,
                new BigDecimal("25000.00"), true, 2, "double");
        saveFridge(indesitId, "LB", "FRG-2","pink", 500,650, 2000,
                new BigDecimal("38000.00"), true, 3, "triple");
        long morozId = saveProduct("Moroz", "Moroz", "Russia", Category.FRIDGE,
                false, true);
        saveFridge(morozId, "Mor-32", "FRG-786","white", 600,650, 2000,
                new BigDecimal("29000.00"), false, 2, "double");
        saveFridge(morozId, "Mor-33", "FRG-732","white", 600,600, 1000,
                new BigDecimal("19000.00"), true, 1, "single");

        long xiangId = saveProduct("Sia", "Xiang", "China", Category.PHONE,
                true, false);
        savePhone(xiangId, "1F", "PHN-567","red", 120,60, 10,
                new BigDecimal("8000.15"), true, 1000, 2);
        savePhone(xiangId, "2L", "PHN-556","red", 120,60, 12,
                new BigDecimal("9000.15"), true, 2000, 2);
        long nokiaId = saveProduct("Interia", "Nokia", "Holland", Category.PHONE,
                true, true);
        savePhone(nokiaId, "AN", "PHN-237","black", 140,50, 8,
                new BigDecimal("18200"), true, 1000, 2);
        savePhone(nokiaId, "BN", "PHN-527","red", 130,65, 10,
                new BigDecimal("13000"), true, 1000, 3);
        long algId = saveProduct("Hiden", "LG", "Korea", Category.PHONE,
                false, false);
        savePhone(algId, "ZF", "PHN-293","pink", 120,60, 10,
                new BigDecimal("3000.87"), true, 1000, 1);
        savePhone(algId, "ZX", "PHN-877","white", 125,55, 12,
                new BigDecimal("4000.46"), false, 1000, 1);

        long ibmId = saveProduct("360", "IBM", "USA", Category.COMPUTER,
                true, false);
        saveComputer(ibmId, "Business", "CMP-360","silver", 800,800, 800,
                new BigDecimal("54000.46"), false, "Business", "Silicon");
        saveComputer(ibmId, "Home", "CMP-361","black", 500,500, 900,
                new BigDecimal("24000.17"), true, "Home", "Xeon");
        long compaqId = saveProduct("Compaq", "Compaq", "Taiwan", Category.COMPUTER,
                true, true);
        saveComputer(compaqId, "Trial", "CMP-712","red", 800,800, 800,
                new BigDecimal("34000"), false, "Scientific", "RISC");
        saveComputer(compaqId, "Dual", "CMP-713","pink", 810,709, 329,
                new BigDecimal("14000"), true, "School", "RISC");
        long appleId = saveProduct("Mac", "Apple", "Russia", Category.COMPUTER,
                true, false);
        saveComputer(appleId, "Book", "CMP-522","black", 710,900, 529,
                new BigDecimal("74000"), true, "Superior", "MISC");
        saveComputer(appleId, "Chief", "CMP-322","black", 610,900, 600,
                new BigDecimal("44000"), false, "Super", "MISC");

    }
    
    long saveProduct(String name, String producer, String country, Category category,
                    boolean ordering, boolean installment) {
        Product product = new Product();
        product.setName(name);
        product.setProducer(producer);
        product.setCountry(country);
        product.setCategory(category);
        product.setOnlineOrdering(ordering);
        product.setInstallment(installment);
        product = productRepository.save(product);
        return product.getId();
    }
    
    void setModelParameters(
            Model model,
            Category productCategory,
            String name,
            String serialNumber,
            String colour,
            int length,
            int width,
            int height,
            BigDecimal price,
            Boolean available) {
        model.setProductCategory(productCategory);
        model.setName(name);
        model.setSerialNumber(serialNumber);
        model.setColour(colour);
        Size size = new Size();
        size.setLength(length);
        size.setWidth(width);
        size.setHeight(height);
        model.setPrice(price);
        model.setSize(size);
        model.setAvailable(available);
    }
    
    void saveTv( long productId,
            String name,
            String serialNumber,
            String colour,
            int length,
            int width,
            int height,
            BigDecimal price,
            Boolean available,
            String tvCategory,
            String technology) {
        TV tv = new TV();
        tv.setProductId(productId);
        setModelParameters(tv, Category.TV, name, serialNumber, colour, length, width, height, price, available);
        tv.setTvCategory(tvCategory);
        tv.setTechnology(technology);
        modelRepository.save(tv);
    }

    void saveCleaner( long productId,
                 String name,
                 String serialNumber,
                 String colour,
                 int length,
                 int width,
                 int height,
                 BigDecimal price,
                 Boolean available,
                 int containerVolume,
                 int numModes) {
        Cleaner cleaner = new Cleaner();
        cleaner.setProductId(productId);
        setModelParameters(cleaner, Category.CLEANER, name, serialNumber, colour, length, width, height, 
                price, available);
        cleaner.setContainerVolume(containerVolume);
        cleaner.setNumModes(numModes);
        modelRepository.save(cleaner);
    }

    void saveFridge( long productId,
                      String name,
                      String serialNumber,
                      String colour,
                      int length,
                      int width,
                      int height,
                      BigDecimal price,
                      Boolean available,
                      int numDoors,
                      String compressorType) {
        Fridge fridge = new Fridge();
        fridge.setProductId(productId);
        setModelParameters(fridge, Category.FRIDGE, name, serialNumber, colour, length, width, height, 
                price, available);
        fridge.setNumDoors(numDoors);
        fridge.setCompressorType(compressorType);
        modelRepository.save(fridge);
    }

    void savePhone( long productId,
                     String name,
                     String serialNumber,
                     String colour,
                     int length,
                     int width,
                     int height,
                     BigDecimal price,
                     Boolean available,
                     int memory,
                     int numCameras) {
        Phone phone = new Phone();
        phone.setProductId(productId);
        setModelParameters(phone, Category.PHONE, name, serialNumber, colour, length, width, height, 
                price, available);
        phone.setMemory(memory);
        phone.setNumCameras(numCameras);
        modelRepository.save(phone);
    }

    void saveComputer( long productId,
                    String name,
                    String serialNumber,
                    String colour,
                    int length,
                    int width,
                    int height,
                    BigDecimal price,
                    Boolean available,
                    String computerCategory,
                    String processorType) {
        Computer computer = new Computer();
        computer.setProductId(productId);
        setModelParameters(computer, Category.COMPUTER, name, serialNumber, colour, length, width, height, 
                price, available);
        computer.setComputerCategory(computerCategory);
        computer.setProcessorType(processorType);
        modelRepository.save(computer);
    }
}
