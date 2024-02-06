package ru.isands.elreg.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.isands.elreg.model.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    final private ProductRepository repository;
    final private ModelRepository modelRepository;

    @Autowired
    public ProductRepositoryTest(ProductRepository repo, ModelRepository modelRepository) {
        repository = repo;
        this.modelRepository = modelRepository;
    }

    @Test
    // @Commit and @Rollback
    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void whenSaveProduct_thenGetItById() {
        Product initial = generateProduct(Category.TV, "TV: ");
        Product saved;
        Optional<Product> returned;

        System.out.println("New object: " + initial);
        saved = repository.save(initial);
        System.out.println("After save: " + saved);

        long id = saved.getId();

        returned = repository.findById(id);
        System.out.println("From database: " + (returned.isPresent()? returned.get(): " object not found"));
    }

    @Test
    // @Commit and @Rollback
    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void whenSaveTV_thenGetItById() {
        Product prod = generateProduct(Category.TV, "TV_prod: ");
        Product saved;
        TV tvSaved;
        Optional<Model> tvReturned;

        System.out.println("New object: " + prod);
        saved = repository.save(prod);
        System.out.println("After save: " + saved);

        TV tv = generateTV(saved.getId(), "M_tv:");
        
        System.out.println("New object: " + tv);
        tvSaved = modelRepository.save(tv);
        System.out.println("After save: " + tvSaved);

        tvReturned = modelRepository.findById(tvSaved.getId());
        System.out.println("From base: " + (tvReturned.isPresent()? tvReturned.get(): "object not found"));
    }

    @Test
    // @Commit and @Rollback
    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void whenSaveCleaner_thenGetItById() {
        Product prod = generateProduct(Category.CLEANER, "CLN: ");
        Product saved;
        Cleaner clnSaved;
        Optional<Model> clnReturned;

        System.out.println("New object: " + prod);
        saved = repository.save(prod);
        System.out.println("After save: " + saved);

        Cleaner cln = generateCleaner(saved.getId(), "M_cln:");

        System.out.println("New object: " + cln);
        clnSaved = modelRepository.save(cln);
        System.out.println("After save: " + clnSaved);

        clnReturned = modelRepository.findById(clnSaved.getId());
        System.out.println("From base: " + (clnReturned.isPresent()? clnReturned.get(): "object not found"));
    }

    @Test
    // @Commit and @Rollback
    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void whenSaveComputer_thenGetItById() {
        Product prod = generateProduct(Category.COMPUTER, "COMP: ");
        Product saved;
        Computer compSaved;
        Optional<Model> compReturned;

        System.out.println("New object: " + prod);
        saved = repository.save(prod);
        System.out.println("After save: " + saved);

        Computer comp = generateComputer(saved.getId(), "M_comp:");

        System.out.println("New object: " + comp);
        compSaved = modelRepository.save(comp);
        System.out.println("After save: " + compSaved);

        compReturned = modelRepository.findById(compSaved.getId());
        System.out.println("From base: " + (compReturned.isPresent()? compReturned.get(): "object not found"));
    }

    @Test
    // @Commit and @Rollback
    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void whenSaveFridge_thenGetItById() {
        Product prod = generateProduct(Category.FRIDGE, "FRG: ");
        Product saved;
        Fridge frgSaved;
        Optional<Model> frgReturned;

        System.out.println("New object: " + prod);
        saved = repository.save(prod);
        System.out.println("After save: " + saved);

        Fridge frg = generateFridge(saved.getId(), "M_frg:");

        System.out.println("New object: " + frg);
        frgSaved = modelRepository.save(frg);
        System.out.println("After save: " + frgSaved);

        frgReturned = modelRepository.findById(frgSaved.getId());
        System.out.println("From base: " + (frgReturned.isPresent()? frgReturned.get(): "object not found"));
    }

    @Test
    // @Commit and @Rollback
    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void whenSavePhone_thenGetItById() {
        Product prod = generateProduct(Category.PHONE, "PHN: ");
        Product saved;
        Phone phnSaved;
        Optional<Model> phnReturned;

        System.out.println("New object: " + prod);
        saved = repository.save(prod);
        System.out.println("After save: " + saved);

        Phone phn = generatePhone(saved.getId(), "M_phn:");

        System.out.println("New object: " + phn);
        phnSaved = modelRepository.save(phn);
        System.out.println("After save: " + phnSaved);

        phnReturned = modelRepository.findById(phnSaved.getId());
        System.out.println("From base: " + (phnReturned.isPresent()? phnReturned.get(): "object not found"));
    }

    Product generateProduct(Category category, String prefix) {
        Product result = new Product();
        result.setName(prefix + "Name product");
        result.setProducer(prefix + "Producer of product");
        result.setCategory(category);
        result.setCountry(prefix + "Russia");
        return result;
    }

    TV generateTV(long productId, String prefix) {
        TV tv = new TV();
        tv.setProductId(productId);
        tv.setName(prefix + "Name");
        tv.setSerialNumber(prefix + "012");
        tv.setColour("Black");
        tv.setSize(new Size());
        tv.setPrice(new BigDecimal("1234.345"));
        tv.setAvailable(true);
        tv.setCategory(prefix + "unknown");
        tv.setTechnology(prefix + "IPS");
        return tv;
    }
    
    Cleaner generateCleaner(long productId, String prefix) {
        Cleaner model = new Cleaner();
        model.setProductId(productId);
        model.setName(prefix + "Name");
        model.setSerialNumber(prefix + "012");
        model.setColour("Black");
        model.setSize(new Size());
        model.setPrice(new BigDecimal("1234.345"));
        model.setAvailable(true);
        model.setContainerVolume(2000);
        model.setNumModes(3);
        return model;
    }

    Computer generateComputer(long productId, String prefix) {
        Computer model = new Computer();
        model.setProductId(productId);
        model.setName(prefix + "Name");
        model.setSerialNumber(prefix + "012");
        model.setColour("Black");
        model.setSize(new Size());
        model.setPrice(new BigDecimal("1234.345"));
        model.setAvailable(true);
        model.setCategory(prefix + "Category");
        model.setProcessorType(prefix + "Processor Type");
        return model;
    }

    Fridge generateFridge(long productId, String prefix) {
        Fridge model = new Fridge();
        model.setProductId(productId);
        model.setName(prefix + "Name");
        model.setSerialNumber(prefix + "012");
        model.setColour("Silver");
        model.setSize(new Size());
        model.setPrice(new BigDecimal("45000.34"));
        model.setAvailable(true);
        model.setNumDoors(2);
        model.setCompressorType(prefix + "Complex");
        return model;
    }

    Phone generatePhone(long productId, String prefix) {
        Phone model = new Phone();
        model.setProductId(productId);
        model.setName(prefix + "Name");
        model.setSerialNumber(prefix + "012");
        model.setColour("Silver");
        model.setSize(new Size());
        model.setPrice(new BigDecimal("45000.34"));
        model.setAvailable(true);
        model.setMemory(1024);
        model.setNumCameras(2);
        return model;
    }
}
