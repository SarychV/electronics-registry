package ru.isands.elreg.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.Pair;
import ru.isands.elreg.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category, Sort sort);

    @Query(value = "select new ru.isands.elreg.model.Pair(p.id, m.id) " +
            "from Product as p " +
                "left join Model as m on p.id = m.productId " +
                "left join TV as t on m.id = t.id " +
                "left join Cleaner as cln on m.id = cln.id " +
                "left join Fridge as f on m.id = f.id " +
                "left join Phone as phn on m.id = phn.id " +
                "left join Computer as comp on m.id = comp.id " +
            "where " +
                "(:name is null or p.name ilike %:name% or m.name ilike %:name%) and " +
                "(:colour is null or m.colour ilike %:colour%) and " +
                "(:category is null or p.category in :category) and " +
                "(:priceFrom is null or m.price >= :priceFrom) and " +
                "(:priceTo is null or m.price <= :priceTo) and " +
                "(:tvCategory is null or t.tvCategory ilike %:tvCategory%) and " +
                "(:tvTechnology is null or t.technology ilike %:tvTechnology%) and " +
                "(:clnVFrom is null or cln.containerVolume >= :clnVFrom) and " +
                "(:clnVTo is null or cln.containerVolume <= :clnVTo) and " +
                "(:clnModesFrom is null or cln.numModes >= :clnModesFrom) and " +
                "(:clnModesTo is null or cln.numModes <= :clnModesTo) and " +
                "(:frgDoorsFrom is null or f.numDoors >= :frgDoorsFrom) and " +
                "(:frgDoorsTo is null or f.numDoors <= :frgDoorsTo) and " +
                "(:frgCompressorType is null or f.compressorType ilike %:frgCompressorType%) and " +
                "(:phnMemFrom is null or phn.memory >= :phnMemFrom) and " +
                "(:phnMemTo is null or phn.memory <= :phnMemTo) and " +
                "(:phnCamFrom is null or phn.numCameras >= :phnCamFrom) and " +
                "(:phnCamTo is null or phn.numCameras <= :phnCamTo) and " +
                "(:computerCategory is null or comp.computerCategory ilike %:computerCategory%) and " +
                "(:computerProcType is null or comp.processorType ilike %:computerProcType)")
    List<Pair> search(String name, List<Category> category, String colour, BigDecimal priceFrom,
               BigDecimal priceTo,  String tvCategory, String tvTechnology, Integer clnVFrom, Integer clnVTo,
               Integer clnModesFrom, Integer clnModesTo, Integer frgDoorsFrom, Integer frgDoorsTo,
               String frgCompressorType, Integer phnMemFrom, Integer phnMemTo, Integer phnCamFrom, Integer phnCamTo,
               String computerCategory, String computerProcType);
}
