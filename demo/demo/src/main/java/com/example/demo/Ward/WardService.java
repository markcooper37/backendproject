package com.example.demo.Ward;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class WardService {

    private  WardService wardService;

    public WardService(com.example.demo.WardService wardService) {
        this.wardService = wardService;
    }
    //add the list of wards
    public List<Ward> getWard() {
        return WardDataAccessService.selectAllWard();
    }


    public void addNewWard(Ward ward) {
        if (WardDataAccessService.selectAllWard().contains(ward)) {
            throw new IllegalStateException("Ward already exists in the database");
    }   else {
            WardDataAccessService.insertWard(ward);
        }

    public void deleteWard(int wardId) {

            boolean found = false;
            for (Ward ward : WardDataAccessService.selectAllWards()) {
                if (ward.getId().equals(wardId)) {
                    found = true;
                    WardDataAccessService.deleteWard(ward);
                }
            }
            if (!found) {
                throw new WardNotFoundException(WardId + " not found");
            }
        }
        }
    }

    public void updateWard(Ward ward) {

        boolean found = false;
        for (Ward w : WardDataAccessService.selectAllWards())) {
                if(?.WardId().equals(ward.getId())) {// ? What to put in Q marks
                found = true;
//                ?.setWard(ward.getWard());
            }
        }
        if (!found) {
            throw new WardNotFoundException(ward.getId() + " not found");
        }
    }

    public Ward getWard(int WardId) {
        return WardDataAccessService.selectAllWard()
                .stream()
                .filter(ward -> ward.getWardId().equals(wardId))
                .findFirst()
                .orElseThrow(() -> new WardNotFoundException(wardId + " not found"));
}
