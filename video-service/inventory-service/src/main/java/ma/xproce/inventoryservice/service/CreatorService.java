package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService implements CreatorServiceManager{
    @Autowired
    CreatorRepository creatorRepository;
    @Override
    public Creator creatorById(Integer id) {
        return creatorRepository.findById(id).get();
    }
}
