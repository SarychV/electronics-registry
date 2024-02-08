package ru.isands.elreg.mapper;

import lombok.extern.slf4j.Slf4j;
import ru.isands.elreg.dto.ModelDtoCreate;
import ru.isands.elreg.dto.ModelDtoUpdate;
import ru.isands.elreg.exception.BadConditionException;
import ru.isands.elreg.model.Category;
import ru.isands.elreg.model.*;

@Slf4j
public class ModelMapper {
    public static Model toModel(ModelDtoCreate dto, Category category) {
        TV tv;
        Cleaner cleaner;
        Computer computer;
        Fridge fridge;
        Phone phone;

        switch(category) {
            case TV:
                tv = new TV();
                assignModelParameters(tv, category, dto);
                tv.setTvCategory(dto.getTvCategory());
                tv.setTechnology(dto.getTechnology());
                return tv;
            case CLEANER:
                cleaner = new Cleaner();
                assignModelParameters(cleaner, category, dto);
                cleaner.setContainerVolume(dto.getContainerVolume());
                cleaner.setNumModes(dto.getNumModes());
                return cleaner;
            case COMPUTER:
                computer = new Computer();
                assignModelParameters(computer, category, dto);
                computer.setComputerCategory(dto.getComputerCategory());
                computer.setProcessorType(dto.getProcessorType());
                return computer;
            case FRIDGE:
                fridge = new Fridge();
                assignModelParameters(fridge, category, dto);
                fridge.setNumDoors(dto.getNumDoors());
                fridge.setCompressorType(dto.getCompressorType());
                return fridge;
            case PHONE:
                phone = new Phone();
                assignModelParameters(phone, category, dto);
                phone.setMemory(dto.getMemory());
                phone.setNumCameras(dto.getNumCameras());
                return phone;
            default:
                log.error("Category {} has no handler in ModelMapper.toModel()", category);
                throw new BadConditionException("Can't convert your data. Contact support, please.");
        }
    }

    public static Model toModel(ModelDtoUpdate dto, Model old) {
        Category category = old.getProductCategory();

    }

    static void assignModelParameters(Model model, Category category, ModelDtoCreate dto) {
        model.setProductId(dto.getProductId());
        model.setProductCategory(category);
        model.setName(dto.getName());
        model.setSerialNumber(dto.getSerialNumber());
        model.setColour(dto.getColour());

        Size size = new Size();
        size.setLength(dto.getLength());
        size.setWidth(dto.getWidth());
        size.setHeight(dto.getHeight());

        model.setSize(size);
        model.setPrice(dto.getPrice());
        model.setAvailable(dto.getAvailable());
    }

}
