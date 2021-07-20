package com.example.duc.controller.api;

import com.example.duc.entity.HumanEntity;
import com.example.duc.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiAdminController {

    @Autowired
    HumanService humanService;

    //Lay danh sach
    @GetMapping("/human")
    public ResponseEntity<List<HumanEntity>> getAllHuman(@ModelAttribute HumanEntity humanEntity){
        List<HumanEntity> human = humanService.getAllHuman();
        if (human != null){
            return new ResponseEntity<>(human, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //lay 1 danh sach
    @GetMapping("/human/{id}")
    public ResponseEntity<Optional<HumanEntity>> getOneHuman(@PathVariable("id") Integer id ){
        Optional<HumanEntity> human = humanService.findById(id);
        if (human.isPresent()){
            return new ResponseEntity<>(human, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Them 1 product
    @PostMapping("/human")
    public ResponseEntity<HumanEntity> addHuman(@RequestBody HumanEntity humanEntity){
        try {
            humanService.save(humanEntity);
            return new ResponseEntity<>(humanEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Sua danh sach
    @PutMapping("/human/{id}")
    public ResponseEntity<Optional<HumanEntity>> editHuman(@PathVariable("id") Integer id,
                                                             @RequestBody HumanEntity humanEntity)
    {
        Optional<HumanEntity> update =humanService.findById(id);
        if (update.isPresent()){
            HumanEntity human = update.get();
            human.setName(humanEntity.getName());
            human.setEmail(humanEntity.getEmail());
            human.setAddress(humanEntity.getAddress());

            humanService.save(human);
                return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//
    //Xoa danh sach
    @DeleteMapping("/human/{id}")
    public ResponseEntity<Optional<HumanEntity>> deleteHuman(@PathVariable("id") Integer id){
        Optional<HumanEntity> human = humanService.findById(id);
        if (human.isPresent()){
            humanService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
