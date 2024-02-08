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

    public static Model toModel(ModelDtoUpdate dto, Model saved) {
        Model created;
        TV tv;
        Cleaner cleaner;
        Computer computer;
        Fridge fridge;
        Phone phone;

        Category category = saved.getProductCategory();
        try {
            created = saved.clone();
        } catch (CloneNotSupportedException e) {
            log.error("ModelMapper.toModel(). Model cloning error: model={}", saved);
            throw new BadConditionException("Can't convert your data. Contact support, please.");
        }

        assignModelParameters(created, dto);

        switch (category) {
            case TV:
                tv = (TV) created;
                if (dto.getTvCategory() != null) tv.setTvCategory(dto.getTvCategory());
                if (dto.getTechnology() != null) tv.setTechnology(dto.getTechnology());
                return tv;
            case CLEANER:
                cleaner = (Cleaner) created;
                if (dto.getContainerVolume() != null) cleaner.setContainerVolume(dto.getContainerVolume());
                if (dto.getNumModes() != null) cleaner.setNumModes(dto.getNumModes());
                return cleaner;
            case COMPUTER:
                computer = (Computer) created;
                if (dto.getComputerCategory() != null) computer.setComputerCategory(dto.getComputerCategory());
                if (dto.getProcessorType() != null) computer.setProcessorType(dto.getProcessorType());
                return computer;
            case FRIDGE:
                fridge = (Fridge) created;
                if (dto.getNumDoors() != null) fridge.setNumDoors(dto.getNumDoors());
                if (dto.getCompressorType() != null) fridge.setCompressorType(dto.getCompressorType());
                return fridge;
            case PHONE:
                phone = (Phone) created;
                if (dto.getMemory() != null) phone.setMemory(dto.getMemory());
                if (dto.getNumCameras() != null) phone.setNumCameras(dto.getNumCameras());
                return phone;
            default:
                log.error("Category {} has no handler in ModelMapper.toModel()", category);
                throw new BadConditionException("Can't convert your data. Contact support, please.");
        }
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

    static void assignModelParameters(Model model, ModelDtoUpdate dto) {
        if (dto.getName() != null) model.setName(dto.getName());
        if (dto.getSerialNumber() != null) model.setSerialNumber(dto.getSerialNumber());
        if (dto.getColour() != null) model.setColour(dto.getColour());
        if (dto.getLength() != null) model.getSize().setLength(dto.getLength());
        if (dto.getWidth() != null) model.getSize().setWidth(dto.getWidth());
        if (dto.getHeight() != null) model.getSize().setHeight(dto.getHeight());
        if (dto.getPrice() != null) model.setPrice(dto.getPrice());
        if (dto.getAvailable() != null) model.setAvailable(dto.getAvailable());
    }
}
